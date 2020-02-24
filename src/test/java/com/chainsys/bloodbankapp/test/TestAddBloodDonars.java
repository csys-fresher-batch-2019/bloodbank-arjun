package com.chainsys.bloodbankapp.test;

import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestAddBloodDonars {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {

		BloodBankDAOImp imp=new BloodBankDAOImp();
		BloodGroup model=new BloodGroup();
		
		Scanner sc = new Scanner(System.in);
		logger.info("Enter EmpName :");
		String userName=sc.nextLine();
		logger.info("Enter Email :");
		String email=sc.nextLine();
		logger.info("Enter BloodGroupId :");
		int bloodGroupId=sc.nextInt();
		logger.info("Enter City :");
		String city=sc.next();
		
		model.setUserName(userName);
		model.setEmail(email);
		model.setBloodGroupId(bloodGroupId);
		model.setCity(city);
		
		imp.addEmployeeDetails(model);	
	}
}
