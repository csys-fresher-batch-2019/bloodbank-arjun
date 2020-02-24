package com.chainsys.bloodbankapp.model;

import org.junit.Assert;
import org.junit.Test;

public class BloodGroupTest {

	@Test
	public void testaValidModel() {
		BloodGroup blood = new BloodGroup();
		blood.setUserId(5);
		blood.setUserName("Arjun Kumar");
		blood.setEmail("arjun798@gmail.com");
		blood.setBloodsGroup("B+ve");
		blood.setActive(true);
		blood.setCity("madurai");

		Assert.assertEquals(5, blood.getUserId());
		Assert.assertEquals("Arjun Kumar", blood.getUserName());
		Assert.assertEquals("arjun798@gmail.com", blood.getEmail());
		Assert.assertEquals("B+ve", blood.getBloodsGroup());
		Assert.assertEquals(true, blood.isActive());
		Assert.assertEquals("madurai",blood.getCity());

	}
}
