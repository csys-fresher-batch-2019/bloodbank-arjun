package com.chainsys.bloodbankapp.service;

import java.util.ArrayList;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodBankAppService {
	private BloodGroupDAO bloodBankDAO=new BloodBankDAOImp();
	
	ArrayList<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception{
		return bloodBankDAO.selectEmpBlood(bloodGroup);
	}

}
