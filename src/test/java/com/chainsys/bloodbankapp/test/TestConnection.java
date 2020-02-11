package com.chainsys.bloodbankapp.test;

import java.sql.Connection;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.utile.ConnectionUtile;

public class TestConnection {

	public static void main(String[] args) throws DbException {
		
		Connection con=ConnectionUtile.getConnection();
		System.out.println(con);

	}

}
