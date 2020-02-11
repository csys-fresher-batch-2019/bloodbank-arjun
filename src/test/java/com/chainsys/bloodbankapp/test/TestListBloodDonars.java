package com.chainsys.bloodbankapp.test;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

import java.util.List;

import com.chainsys.bloodbankapp.dao.implementation.*;

public class TestListBloodDonars {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {
		
		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		List<BloodGroup> list = bloodDonars.findByBloodGroup("B+ve");
		for (BloodGroup bloodGroup : list) {
			logger.info(bloodGroup);
		}
	}

}
