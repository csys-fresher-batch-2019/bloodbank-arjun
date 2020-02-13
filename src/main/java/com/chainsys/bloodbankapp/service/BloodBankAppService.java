package com.chainsys.bloodbankapp.service;

import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.Logger;

public class BloodBankAppService {
	
	private Logger log  =Logger.getInstance(Logger.class);
	
	private BloodGroupDAO bloodBankDAO = new BloodBankDAOImp();

	public List<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception {
		log.info(" BloodGroup : "+ bloodGroup);
		return bloodBankDAO.findByBloodGroup(bloodGroup);
	}

	public void updateDonateStatus(String email, boolean status) throws Exception {

		BloodGroup emp = bloodBankDAO.findByEmail(email);
		if ( emp.isActive() && status ) {
			throw new Exception("Already Employee is Active");
		}
		
		if ( !emp.isActive() && !status ) {
			throw new Exception("Already Employee is InActive");
		}

		emp.setActive(status);
		bloodBankDAO.updateDonateStatus(emp);

	}
	
	public void updateEmail(BloodGroup a) throws Exception{
		bloodBankDAO.updateEmail(a);
		
	}
	
	public void deleteEmployeeRecord(BloodGroup a) throws Exception{
		bloodBankDAO.deleteEmployeeRecord(a);
	}

}

// directly we cannot call DAO ,with the help of service calling DAO-safety purpose