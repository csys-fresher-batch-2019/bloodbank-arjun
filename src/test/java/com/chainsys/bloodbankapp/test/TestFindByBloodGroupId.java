package com.chainsys.bloodbankapp.test;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class TestFindByBloodGroupId {

	private static final Logger logger = Logger.getInstance(ConnectionUtil.class);
	
	public static void main(String[] args) throws Exception {
		
		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		int list = bloodDonars.findByBloodGroupId("O+ve");
		
			logger.info(list);
		
	}

}
