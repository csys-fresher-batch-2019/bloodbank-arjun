package com.chainsys.bloodbankapp;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestCountOfUser {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException, SQLException {

		Scanner sc = new Scanner(System.in);

		logger.info("Enter blood group");
		String bg = sc.next();
		logger.info("Enter city");
		String city = sc.next();
		BloodGroupDAOImp obj = new BloodGroupDAOImp();
		int count = obj.countInCity(bg, city);
		System.out.println(count);
		sc.close();
	}

}
