package com.chainsys.bloodbankapp;

import java.util.List;
import java.util.Scanner;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.User;

public class TestUserDetails {

	public static void main(String[] args) throws DbException {

		Scanner sc = new Scanner(System.in);
		BloodGroupDAOImp met = new BloodGroupDAOImp();
		System.out.println("Enter Blood Group");
		String bg = sc.next();
		System.out.println("Enter city");
		String city = sc.next();
		List<User> out = met.findByUserDetails(bg, city);
		for (User in : out) {
			System.out.println(in);
		}
		sc.close();
	}

}
