package com.chainsys.bloodbankapp;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestDeleteRecords {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException {

		Scanner sc = new Scanner(System.in);
		logger.info("Enter user id : ");
		int userId = sc.nextInt();
		BloodGroupDAOImp mail = new BloodGroupDAOImp();
		boolean status = mail.deleteEmployeeRecord(userId);
		if (status) {
			logger.info("Successfully Updated");
		} else {
			logger.info("Updatation Failed");
		}
		sc.close();
	}

}
