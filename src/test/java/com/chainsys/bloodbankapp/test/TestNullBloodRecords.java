package com.chainsys.bloodbankapp.test;

import java.util.List;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestNullBloodRecords {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws DbException {
		BloodBankDAOImp imp=new BloodBankDAOImp();
		List<BloodGroup> list = imp.findNullBloodRecords();
		for (BloodGroup bloodGroup : list) {
			logger.info(bloodGroup);
		}
	}

}
