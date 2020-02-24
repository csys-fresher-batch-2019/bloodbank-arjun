package com.chainsys.bloodbankapp.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
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
		BloodBankDAOImp obj = new BloodBankDAOImp();
		obj.countInCity(bg,city);
	}
	

}
