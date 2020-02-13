package com.chainsys.bloodbankapp.test;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestUpdateBloodGroup {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {
		
		Scanner sc = new Scanner(System.in);
		logger.info("Enter employee id : ");
		int employeeId = sc.nextInt();
		logger.info("Enter blood group(Ex:A+ve): ");
		String blood=sc.next();
		BloodGroup mail1=new BloodGroup();
		mail1.setEmpId(employeeId);
		mail1.setBloodGroup(blood);
		BloodBankDAOImp mail2=new BloodBankDAOImp();
		boolean status = mail2.updateBloodGroup(mail1);
		if (status) {
			logger.info("Successfully Updated");
		} else {
			logger.info("Updatation Failed");
		}
		
	}

}
