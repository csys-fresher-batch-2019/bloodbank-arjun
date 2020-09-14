package com.chainsys.bloodbankapp;

import java.util.Scanner;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.service.BloodBankAppService;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestAddBloodDonars {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws ValidatorException, DbException {

		// BloodBankDAOImp imp=new BloodBankDAOImp();
		BloodBankAppService service = new BloodBankAppService();
		User model = new User();

		Scanner sc = new Scanner(System.in);
		logger.info("Enter UserName :");
		String userName = sc.nextLine();
		logger.info("Enter Gender :");
		String gender = sc.next();
		logger.info("Enter Age :");
		int age = sc.nextInt();
		logger.info("Enter Email :");
		String email = sc.next();
		logger.info("Enter City :");
		String city = sc.next();
		logger.info("Enter Mobile Number :");
		Long mobileNumber = sc.nextLong();
		logger.info("Enter Password :");
		String password = sc.next();
		logger.info("Enter BloodGroupId :");
		int bloodGroupId = sc.nextInt();
		// getting input as String
		// changing String into int .Finally,the scanner input is int
		model.setUserName(userName);
		model.setGender(gender);
		model.setAge(age);
		model.setEmail(email);
		
		/*BloodGroup bg = new BloodGroup();
		bg.setBloodGroup(bloodGroupId);
		bloodApp.setBloodGroup(bg);
		*/
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(bloodGroupId);
		
		model.setBloodGroup(bg);
		model.setCity(city);
		model.setMobileNumber(mobileNumber);
		model.setPassword(password);
		service.addEmployeeDetails(model);
		logger.info("Completed");
		sc.close();
	}
}

// if bgId="",then we get 'NumberFormatException'(i.e.,)getting input as empty
// string then changing it into Integer(Integer.parseInt(bgId))
