package com.chainsys.bloodbankapp.test;

import java.util.List;

import org.junit.Test;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestListBloodDonar {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {
		
		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		List<BloodGroup> list = bloodDonars.findByBloodGroup("O+ve");
		for (BloodGroup bloodGroup : list) {
			logger.info(bloodGroup);
		}
	}

}
