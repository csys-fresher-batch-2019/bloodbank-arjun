package com.chainsys.bloodBankApp.Service;

import java.util.ArrayList;

import com.chainsys.bloodBankApp.dao.BloodGroupDAO;
import com.chainsys.bloodBankApp.implementation.BloodBankDAOImp;
import com.chainsys.bloodBankApp.model.BloodGroup;

public class BloodBankAppService {
	private BloodGroupDAO bloodBankDAO=new BloodBankDAOImp();
	
	ArrayList<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception{
		return bloodBankDAO.selectEmpBlood(bloodGroup);
	}

}
