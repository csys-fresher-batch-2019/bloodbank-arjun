package com.chainsys.bloodbankapp;

import java.util.List;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestListBloodDonar {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws DbException {

		BloodGroupDAOImp bloodDonars = new BloodGroupDAOImp();
		List<User> list = bloodDonars.findByBloodGroup("A+ve");
		for (User bloodGroup : list) {
			logger.info(bloodGroup);
		}
	}

}
