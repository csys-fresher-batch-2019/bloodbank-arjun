package com.chainsys.bloodbankapp.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class MailMessageFormat {
	private static final Logger LOG = Logger.getInstance(MailMessageFormat.class);

	public String BloodDonar(String bg) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select user_id,user_name,email from blood_app where blood_group_id=(select blood_group_id from bloodGroupDetails where blood_group = ? )";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, bg);
		ResultSet rs = stmt.executeQuery();
		con.close();
		String email = "";
		String sub = "";
		String msg = "";
		boolean valid = false;
		while (rs.next()) {
			email = rs.getString("email");
			LOG.debug(email);
			sub = "A blood bank need your blood to save someone's life";
			msg = "If you are willing to donate your blood \n ";
			valid = SendMailSSL.send("bloodbank808@gmail.com", "bloodbank123", email, sub, msg);
		}
		if (valid)
			return "Mail Sent Successfully";
		else
			return "Mail Was not Sent";
	}

}
