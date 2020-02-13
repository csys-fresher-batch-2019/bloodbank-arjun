package com.chainsys.bloodbankapp.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodBankAppServiceTest {

	@Test @Ignore
	public void test() {

		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		try {
			List<BloodGroup> list = bloodDonars.findByBloodGroup("B+ve");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
