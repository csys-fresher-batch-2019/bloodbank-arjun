package com.chainsys.bloodbankapp.model;

import org.junit.Assert;
import org.junit.Test;

public class BloodGroupTest {

	@Test
	public void testaValidModel() {
		BloodGroup blood = new BloodGroup();
		blood.setEmpId(1);
		blood.setEmpName("ARJUN");
		blood.setEmail("arjun@gmail.com");
		blood.setBloodGroup("B+ve");
		blood.setActive(true);

		Assert.assertEquals(1, blood.getEmpId());
		Assert.assertEquals("ARJUN", blood.getEmpName());
		Assert.assertEquals("arjun@gmail.com", blood.getEmail());
		Assert.assertEquals("B+ve", blood.getBloodGroup());
		Assert.assertEquals(true, blood.isActive());

	}
}
