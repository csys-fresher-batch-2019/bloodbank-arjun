package com.chainsys.bloodbankapp.test;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.*;

public class TestUpdateBloodDonars {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException {

		BloodBankDAOImp imp = new BloodBankDAOImp();
		BloodGroup model = new BloodGroup();

		Scanner sc = new Scanner(System.in);

		logger.info("FEATURE: Employee Ready To Donate/Not");
		logger.info("----------------------------------");

		logger.info("Enter email : ");
		String email = sc.next();
		logger.info("Enter Active or Not(true/false) :");
		boolean active = sc.nextBoolean();

		model.setEmail(email);
		model.setActive(active);

		boolean status = imp.updateDonateStatus(model);
		if (status) {
			logger.info("Successfully Updated");
		} else {
			logger.info("Updatation Failed");
		}
sc.close();
	}

}