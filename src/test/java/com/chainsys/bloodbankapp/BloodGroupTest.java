package com.chainsys.bloodbankapp;

import org.junit.Assert;
import org.junit.Test;

import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.BloodGroup;

public class BloodGroupTest {

	@Test
	public void testaValidModel() {
		BloodApp blood = new BloodApp();
		BloodGroup a = new BloodGroup();
		blood.setUserId(1);
		blood.setUserName("ARJUN");
		blood.setEmail("arjun798@gmail.com");
		a.setBloodGroup("A+ve");
		blood.setActive(true);
		blood.setCity("Madurai");

		Assert.assertEquals(1, blood.getUserId());
		Assert.assertEquals("ARJUN", blood.getUserName());
		Assert.assertEquals("arjun798@gmail.com", blood.getEmail());
		Assert.assertEquals("A+ve", a.getBloodGroup());
		Assert.assertEquals(true, blood.isActive());
		Assert.assertEquals("Madurai", blood.getCity());

	}
}
