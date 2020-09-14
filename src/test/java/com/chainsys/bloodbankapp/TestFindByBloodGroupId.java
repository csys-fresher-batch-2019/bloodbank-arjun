package com.chainsys.bloodbankapp;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestFindByBloodGroupId {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);

	public static void main(String[] args) throws Exception {

		BloodGroupDAOImp bloodDonars = new BloodGroupDAOImp();
		int list = bloodDonars.findByBloodGroupId("O+ve");

		logger.info(list);

	}

}
