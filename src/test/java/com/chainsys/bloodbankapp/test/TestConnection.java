package com.chainsys.bloodbankapp.test;

import java.sql.Connection;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.util.ConnectionUtil;

public class TestConnection {

	public static void main(String[] args) throws DbException {
		
		Connection con=ConnectionUtil.getConnection();
		System.out.println(con);

	}

}
