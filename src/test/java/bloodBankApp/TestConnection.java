package bloodBankApp;

import java.sql.Connection;

import com.chainsys.bloodBankApp.exception.DbException;
import com.chainsys.bloodBankApp.utile.ConnectionUtile;

public class TestConnection {

	public static void main(String[] args) throws DbException {
		
		Connection con=ConnectionUtile.getConnection();
		System.out.println(con);

	}

}
