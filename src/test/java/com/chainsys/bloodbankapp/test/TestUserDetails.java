package com.chainsys.bloodbankapp.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class TestUserDetails {

	public static void main(String[] args) throws DbException {
		
		Scanner sc = new Scanner(System.in);
		BloodBankDAOImp met = new BloodBankDAOImp();
		System.out.println("Enter Blood Group");
		String bg = sc.next();
		System.out.println("Enter city");
		String city = sc.next();
		ArrayList<BloodGroup> out = new ArrayList<BloodGroup>();
		out = (ArrayList<BloodGroup>) met.findByUserDetails(bg, city);
		for(BloodGroup in : out) {
			System.out.println(in);
		}

	}

}
