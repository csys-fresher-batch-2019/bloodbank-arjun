package com.chainsys.bloodbankapp.dao.implementation;

import java.sql.Statement;

import com.chainsys.bloodbankapp.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BloodGroupUadateInfo {
	public String BloodGroup() throws Exception
	{
		Connection con = ConnectionUtil.getConnection();
		String sql = "select email from blood_bank_app where blood_group is null";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String email = "";
		String sub = "";
		String msg = "";
		boolean valid = false;
		while(rs.next())
		{
			msg = "This mail Intimates you to update your blood group details in Company";
			email = rs.getString("email");
			sub = "Update your Blood group details";
			System.out.println(email);
			valid = SendMailSSL.send("payrollmavenproject@gmail.com","Pass1234*", email,sub,msg);
		}
		if(valid)
			return "Mail Sent Successfully";
		else
			return "Mail Was not Sent";
	}
	public String BloodDonar(String bg) throws Exception
	{
		Connection con = ConnectionUtil.getConnection();
		String sql = "select email from blood_bank_app where blood_group = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, bg);
		ResultSet rs = stmt.executeQuery();
		String email = "";
		String sub = "";
		String msg = "";
		boolean valid = false;
		while(rs.next())
		{
			email = rs.getString("email");
			sub = "A blood bank need your blood to save someone's life";
			msg = "If you are willing to donate your blood \n ";
			valid = SendMailSSL.send("payrollmavenproject@gmail.com","Pass1234*", email,sub,msg);			
		}
		if(valid)
			return "Mail Sent Successfully";
		else
			return "Mail Was not Sent";

	}

}
