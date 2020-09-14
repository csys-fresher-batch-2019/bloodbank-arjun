package com.chainsys.bloodbankapp.validation;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.User;

public class Validation {

	private static BloodGroupDAO dao = new BloodGroupDAOImp();
	// private static Logger log = Logger.getInstance(Logger.class);

	public static void emailValidation(String email) throws ValidatorException, DbException {
		boolean obj = dao.findByEmail(email);
		if (obj) {
			throw new ValidatorException("Email already exist");
		}
	}

	public static void userIdValidation(int userId) throws DbException, ValidatorException {
		boolean obj = dao.findByUserId(userId);
		if (!obj) {
			throw new ValidatorException("UserId not exist");
		}
	}

	public void validateUserRegisterForm(User u) throws ValidatorException  {
		if (u.getUserName() == null || "".equals(u.getUserName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		boolean obj;
		try {
			obj = dao.findByEmail(u.getEmail());
			if (obj) {
				throw new ValidatorException("Email already exist");
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
		if (u.getEmail() == null || "".equals(u.getEmail().trim())) {
			throw new ValidatorException("Email cannot be blank/empty");
		}
		if ((u.getBloodGroup().getBloodGroupId() <= 0 )) {
			throw new ValidatorException("BloodGroupId cannot be zero");
		}
		if (u.getCity() == null || "".equals(u.getCity().trim())) {
			throw new ValidatorException("City name cannot be blank/empty");
		}
	}
}
