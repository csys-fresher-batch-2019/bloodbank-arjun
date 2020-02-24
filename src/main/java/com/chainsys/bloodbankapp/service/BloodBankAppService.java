package com.chainsys.bloodbankapp.service;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.implementation.BloodBankDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.Logger;
//directly we cannot call DAO ,with the help of service calling DAO-safety purpose
//eg:class repesentative
public class BloodBankAppService {
	
	private Logger log  =Logger.getInstance(Logger.class);
	
	private BloodGroupDAO bloodBankDAO = new BloodBankDAOImp();

	public List<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception {
		log.info(" BloodGroup : "+ bloodGroup);
		return bloodBankDAO.findByBloodGroup(bloodGroup);
	}

	/*public void updateDonateStatus(String email, boolean status) throws Exception {

		BloodGroup emp = bloodBankDAO.findByEmail(email);
		if ( emp.isActive() && status ) {
			throw new Exception("Already Employee is Active");
		}
		
		if ( !emp.isActive() && !status ) {
			throw new Exception("Already Employee is InActive");
		}

		emp.setActive(status);
		bloodBankDAO.updateDonateStatus(emp);

	}*/
	
	public List<BloodGroup> findByBloodGroup(String bloodGroup) throws DbException{
		return bloodBankDAO.findByBloodGroup(bloodGroup);		
	}
	
	public int addEmployeeDetails(BloodGroup a) throws DbException {
		return bloodBankDAO.addEmployeeDetails(a);
	}
	
	public boolean updateDonateStatus(boolean active,String email) throws DbException {
		return bloodBankDAO.updateDonateStatus(active, email);
	}
	
	public void updateEmail(BloodGroup a) throws Exception{
		bloodBankDAO.updateEmail(a.getUserId(),a.getEmail());
	}
	
	public boolean updateBloodGroup(int userId,String bloodGroup) throws DbException {
		return bloodBankDAO.updateBloodGroup(userId,bloodGroup);
	}
	
	public void deleteEmployeeRecord(BloodGroup a) throws Exception{
		bloodBankDAO.deleteEmployeeRecord(a);
	}
	
	public int findByBloodGroupId(String bloodsGroup) throws Exception {
		return bloodBankDAO.findByBloodGroupId(bloodsGroup);
	}

	public int countInCity(String bloodGroup, String city) throws DbException, SQLException {
		return bloodBankDAO.countInCity(bloodGroup,city);
	}
	
	public List<BloodGroup> findByUserDetails(String bloodGroup, String city) throws DbException {
		return bloodBankDAO.findByUserDetails(bloodGroup,city);
	}
	
	public boolean updateCity(int userId,String city) throws DbException {
		return bloodBankDAO.updateCity(userId,city);
	}
}

// directly we cannot call DAO ,with the help of service calling DAO-safety purpose