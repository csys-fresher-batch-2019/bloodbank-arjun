package com.chainsys.bloodbankapp;

//package com.chainsys.bloodbankapp.dao.implementation;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupDAOImp;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.model.UserDetail;
import com.chainsys.bloodbankapp.service.BloodBankAppService;

public class BloodGroupDAOImpTest {

	BloodGroupDAOImp imp = new BloodGroupDAOImp();
	BloodBankAppService service = new BloodBankAppService();

	@Test
	@Ignore
	public void testFindByBloodGroup() throws DbException {
		String BloodGroup = "A+ve";
		User a1 = new User();
		List<User> expected = new ArrayList<User>();
		a1.setUserId(1);
		a1.setUserName("ARJUN");
		a1.setEmail("arjunae798@gmail.com");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroup("A+ve");
		a1.setBloodGroup(bg);
		a1.setActive(true);
		a1.setCity("Madurai");
		expected.add(a1);
		List<User> actual = imp.findByBloodGroup(BloodGroup);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testAddEmployeeDetails() throws DbException, ValidatorException {
		User a = new User();
		a.setUserName("Rathna");
		a.setEmail("kumarrat199@gmail.com");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(4);
		a.setBloodGroup(bg);
		a.setCity("Madurai");
		int expected = 1;
		int actual = service.addEmployeeDetails(a);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateDonateStatus() throws DbException {
		boolean activeStatus = false;
		String email = "arjunae798@gmail.com";
		boolean expected = true;
		boolean actual = imp.updateDonateStatus(activeStatus, email);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateEmail() throws ValidatorException {
		String updateEmail = "kumarrathn@gmail.com";
		int userId = 1;
		boolean expected = true;
		try {
			boolean actual = service.updateEmail(userId, updateEmail);
			assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException("Email Id Already Exists");
		}
	}

	@Test
	@Ignore
	public void testUpdateBloodGroup() throws DbException {
		String updateBloodGroup = "B+ve";
		int userId = 1;
		boolean expected = true;
		boolean actual = imp.updateBloodGroup(userId, updateBloodGroup);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testDeleteEmployeeRecord() throws DbException {
		int deleteWithUserId = 4;
		boolean expected = true;
		boolean actual = imp.deleteEmployeeRecord(deleteWithUserId);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testFindByBloodGroupId() throws Exception {

		String bloodGroup = "A-ve";
		int expected = 2; // expected=return of what you want like bloodGroup="A+ve",the BGId=1
		int actual = imp.findByBloodGroupId(bloodGroup);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testCountInCity() throws DbException, SQLException {

		String bloodGroup = "A+ve";
		String city = "Madurai";
		int expected = 1;
		int actual = imp.countInCity(bloodGroup, city);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testFindByUserDetails() throws DbException {

		String bloodGroup = "A+ve";
		String city = "Madurai";
		UserDetail a = new UserDetail();
		a.setUserId(1);
		a.setUserName("ARJUN");
		a.setEmail("arjunae798@gmail.com");
		a.setCity("Madurai");
		List<UserDetail> expected = new ArrayList<UserDetail>();
		expected.add(a);
		List<User> actual = imp.findByUserDetails(bloodGroup, city);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateCity() throws DbException {

		String updateCity = "Madurai";
		int userId = 1;
		boolean expected = true;
		boolean actual = imp.updateCity(userId, updateCity);
		assertEquals(expected, actual);
	}
}
