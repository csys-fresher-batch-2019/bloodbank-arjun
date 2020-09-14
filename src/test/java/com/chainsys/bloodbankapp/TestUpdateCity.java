package com.chainsys.bloodbankapp;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestUpdateCity {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException {

		Scanner sc = new Scanner(System.in);
		logger.info("Enter userId:");
		int userId = sc.nextInt();
		logger.info("Enter city:");
		String city = sc.next();
		BloodGroupDAOImp obj = new BloodGroupDAOImp();
		obj.updateCity(userId, city);
		sc.close();
	}

}
