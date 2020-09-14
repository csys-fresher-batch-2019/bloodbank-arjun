package com.chainsys.bloodbankapp;

import java.sql.Connection;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestConnection {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException {

		Connection con = ConnectionUtil.getConnection();
		logger.debug(con);

	}

}
