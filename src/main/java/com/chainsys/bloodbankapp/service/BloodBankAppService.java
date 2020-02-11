package com.chainsys.bloodbankapp.service;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodBankAppService {
	private BloodGroupDAO bloodBankDAO=new BloodBankDAOImp();
	
	public List<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception{
		return bloodBankDAO.findByBloodGroup(bloodGroup);
	}

}
