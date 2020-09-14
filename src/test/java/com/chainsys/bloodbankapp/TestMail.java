package com.chainsys.bloodbankapp;

import com.chainsys.bloodbankapp.dao.implementation.MailMessageFormat;
import com.chainsys.bloodbankapp.util.Logger;

public class TestMail {
	private static Logger log = Logger.getInstance(Logger.class);

	public static void main(String[] args) throws Exception {
		MailMessageFormat b = new MailMessageFormat();
		log.debug(b.BloodDonar("B+ve"));
	}
}
