package com.chainsys.bloodbankapp.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.chainsys.bloodbankapp.exception.DbException;

public class ConnectionUtilTest {

	@Test @Ignore
	public void testValidConnection() {
		try {
			Connection con=ConnectionUtil.getConnection();
			//Assert.assertNotNull(con);
		} catch (DbException e) {
			e.printStackTrace();
		}
		

	}

}
