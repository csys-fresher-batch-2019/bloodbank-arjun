package com.chainsys.bloodbankapp;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.exception.ValidatorException;
import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.model.UserDetail;
import com.chainsys.bloodbankapp.service.BloodBankAppService;

public class BloodBankAppServiceTest {

	BloodBankAppService service = new BloodBankAppService();

	// @Test @Ignore
	/*
	 * public void test() {
	 * 
	 * BloodBankDAOImp bloodDonars=new BloodBankDAOImp(); try { List<BloodGroup>
	 * list = bloodDonars.findByBloodGroup("B+ve"); } catch (DbException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 */
	@Test
	@Ignore
	public void testFindByBloodGroup() throws DbException {
		// fail("Not yet implemented");
		String BloodGroup = "A+ve";

		User a = new User();
		// BloodGroup b=new BloodGroup();
		List<User> expected = new ArrayList<User>();

		a.setUserId(1);
		a.setUserName("ARJUN");
		a.setGender("M");
		a.setAge(18);
		a.setEmail("arjunae798@gmail.com");
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroup("A+ve");
		a.setBloodGroup(bg);
		a.setActive(true);
		a.setCity("Madurai");
		//a.setMobileNumber(9090909090);
		a.setPassword("arjun");

		/*
		 * b.setUserId(2); b.setUserName("KESAVAN");
		 * b.setEmail("kesavanp555@gmail.com"); b.setBloodsGroup("B+ve");
		 * b.setActive(true); b.setCity("Coimbatore");
		 */

		expected.add(a);
		// expected.add(b);

		List<User> actual = service.findByBloodGroup(BloodGroup);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testAddEmployeeDetails() throws DbException, ValidatorException {

		User a = new User();
		a.setUserName("Sujitha");
		a.setEmail("sujitha@gmail.com");
		BloodGroup bg =new BloodGroup();
		bg.setBloodGroupId(3);
		a.setBloodGroup(bg);
		a.setCity("Chennai");

		int expected = 1;
		int actual = service.addEmployeeDetails(a);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateDonateStatus() throws DbException {

		boolean activeStatus = true;
		String email = "arjunae798@gmail.com";

		boolean expected = true;
		boolean actual = service.updateDonateStatus(activeStatus, email);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateEmail() throws Exception {

		int userId = 1;
		String updateEmail = "arjunae798@gmail.com";

		boolean expected = true;
		boolean actual = service.updateEmail(userId, updateEmail);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateBloodGroup() throws DbException {

		String updateBloodGroup = "A+ve";
		int userId = 1;

		boolean expected = true;
		boolean actual = service.updateBloodGroup(userId, updateBloodGroup);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testDeleteEmployeeRecord() throws Exception {
		int deleteWithUserId = 5;

		boolean expected = true;
		boolean actual = service.deleteEmployeeRecord(deleteWithUserId);
		assertEquals(expected, actual);
	}

	@Test
	
	public void testFindByBloodGroupId() throws Exception {

		String bloodGroup = "A-ve";
		int expected = 2; // expected=return of what you want like bloodGroup="A+ve",the BGId=1
		int actual = service.findByBloodGroupId(bloodGroup);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testCountInCity() throws DbException, SQLException {

		String bloodGroup = "A+ve";
		String city = "Madurai";
		int expected = 1;
		int actual = service.countInCity(bloodGroup, city);
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
		List<User> actual = service.findByUserDetails(bloodGroup, city);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testUpdateCity() throws DbException {

		String updateCity = "Chennai";
		int userId = 5;
		boolean expected = true;
		boolean actual = service.updateCity(userId, updateCity);
		assertEquals(expected, actual);
	}

}
