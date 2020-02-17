package com.chainsys.bloodbankapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import com.chainsys.bloodbankapp.exception.DbException;

public class ConnectionUtil {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static Connection getConnection() throws DbException {

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		}catch(ClassNotFoundException e) {
			logger.info("Connection Error Message");
		}
		catch(SQLException e) {
			logger.info("SQL Error Message");
		}
		return connection;
	}
	public static Jdbi getJdbi()  {
		Jdbi jdbi=null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (DbException e) {
			throw new RuntimeException(e);
		}
		return jdbi;
	}
}
