package com.chainsys.bloodbankapp.model;

import org.junit.Assert;
import org.junit.Test;

public class BloodGroupTest {

	@Test
	public void testaValidModel() {
		BloodGroup blood = new BloodGroup();
		blood.setUserId(5);
		blood.setUserName("ARUN");
		blood.setEmail("arjun798@gmail.com");
		blood.setBloodsGroup("A+ve");
		blood.setActive(true);
		blood.setCity("madurai");

		Assert.assertEquals(1, blood.getUserId());
		Assert.assertEquals("ARUN", blood.getUserName());
		Assert.assertEquals("arjun798@gmail.com", blood.getEmail());
		Assert.assertEquals("A+ve", blood.getBloodsGroup());
		Assert.assertEquals(true, blood.isActive());
		Assert.assertEquals("madurai",blood.getCity());

	}
}
