package com.chainsys.bloodbankapp.test;

import com.chainsys.bloodbankapp.dao.implementation.BloodGroupUadateInfo;
import com.chainsys.bloodbankapp.util.Logger;

public class TestMail {
	private static Logger log  =Logger.getInstance(Logger.class);

public static void main(String[] args) throws Exception {
	BloodGroupUadateInfo b = new BloodGroupUadateInfo();
	//log.info(b.BloodGroup());
	log.debug(b.BloodDonar("B+ve"));
}
}
