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
		
		logger.info("Enter employee id : ");
		Scanner sc = new Scanner(System.in);
		int employeeId = sc.nextInt();
		logger.info("Enter email id: ");
		String mail=sc.next();
		BloodGroup mail1=new BloodGroup();
		mail1.setEmpId(employeeId);
		mail1.setEmail(mail);
		BloodBankDAOImp mail2=new BloodBankDAOImp();
		boolean status = mail2.updateEmail(mail1);
		if (status) {
			logger.info("Successfully Updated");
		} else {
			logger.info("Updatation Failed");
		}
		
	}

}
