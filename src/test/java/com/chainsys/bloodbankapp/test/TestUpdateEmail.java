package com.chainsys.bloodbankapp.test;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestUpdateEmail {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {
		
		logger.info("Enter user id : ");
		Scanner sc = new Scanner(System.in);
		int userId = sc.nextInt();
		logger.info("Enter email id: ");
		String mail=sc.next();
		BloodBankDAOImp mail2=new BloodBankDAOImp();
		boolean status = mail2.updateEmail(userId,mail);
		if (status) {
			logger.info("Successfully Updated");
		} else {
			logger.info("Updatation Failed");
		}
		
	}

}
