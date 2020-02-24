package com.chainsys.bloodbankapp.test;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestDeleteRecords {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {
		
		Scanner sc = new Scanner(System.in);
		logger.info("Enter user id : ");
		int employeeId = sc.nextInt();
		BloodGroup mail1=new BloodGroup();
		mail1.setUserId(employeeId);
		BloodBankDAOImp mail2=new BloodBankDAOImp();
		boolean status = mail2.deleteEmployeeRecord(mail1);
		if (status) {
			logger.info("Successfully Updated");
		} else {
			logger.info("Updatation Failed");
		}
		
	}

}
