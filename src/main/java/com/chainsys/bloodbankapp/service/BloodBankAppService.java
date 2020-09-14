package com.chainsys.bloodbankapp.service;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.model.UserDetail;
import com.chainsys.bloodbankapp.validation.Validation;

//directly we cannot call DAO ,with the help of service calling DAO-safety purpose
//eg:class repesentative
public class BloodBankAppService {

	// private Logger log = Logger.getInstance(Logger.class);

	private BloodGroupDAO bloodBankDAO = new BloodGroupDAOImp();

	Validation validation = new Validation();

	public List<User> findByBloodGroup(String bloodGroup) throws DbException {
		// log.info("BloodGroup:"+bloodGroup);
		return bloodBankDAO.findByBloodGroup(bloodGroup);
	}

	public int addEmployeeDetails(User user) throws ValidatorException, DbException {
		// log.debug("Register:"+a);
		validation.validateUserRegisterForm(user);
		return bloodBankDAO.addEmployeeDetails(user);
	}

	public boolean updateDonateStatus(boolean active, String email) throws DbException {
		return bloodBankDAO.updateDonateStatus(active, email);
	}

	public boolean updateEmail(int userId, String email) throws Exception {
		Validation.userIdValidation(userId);
		Validation.emailValidation(email);
		boolean result = false;	//to check defaultly executed or not
		try {
			result = bloodBankDAO.updateEmail(userId, email);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return result;
	}

	public boolean updateBloodGroup(int userId, String bloodGroup) throws DbException {
		return bloodBankDAO.updateBloodGroup(userId, bloodGroup);
	}

	public boolean deleteEmployeeRecord(int userId) throws Exception {
		return bloodBankDAO.deleteEmployeeRecord(userId);
	}

	public int findByBloodGroupId(String bloodGroup) throws Exception {
		return bloodBankDAO.findByBloodGroupId(bloodGroup);
	}

	public int countInCity(String bloodGroup, String city) throws DbException, SQLException {
		return bloodBankDAO.countInCity(bloodGroup, city);
	}

	public List<User> findByUserDetails(String bloodGroup, String city) throws DbException {
		return bloodBankDAO.findByUserDetails(bloodGroup, city);
	}

	public boolean updateCity(int userId, String city) throws DbException {
		return bloodBankDAO.updateCity(userId, city);
	}
}

// directly we cannot call DAO ,with the help of service calling DAO-safety
// purpose