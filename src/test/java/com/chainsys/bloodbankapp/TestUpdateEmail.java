package com.chainsys.bloodbankapp;

import java.util.Scanner;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.service.BloodBankAppService;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestUpdateEmail {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter user id : ");
		int userId = sc.nextInt();
		logger.info("Enter email id: ");
		String mail = sc.next();
		BloodBankAppService ob = new BloodBankAppService();
		boolean status;
		try {
			status = ob.updateEmail(userId, mail);
			if (status) {
				logger.info("Successfully Updated");
			} else {
				logger.info("Updatation Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
