package com.chainsys.bloodbankapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.model.User;

public class UserBloodGroupRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int row) throws SQLException {
		User bloodApp = new User();

		bloodApp.setUserId(rs.getInt("id"));
		bloodApp.setUserName(rs.getString("name"));
		bloodApp.setGender(rs.getString("gender"));
		bloodApp.setAge(rs.getInt("age"));
		bloodApp.setEmail(rs.getString("email"));
		BloodGroup bg = new BloodGroup();
		bg.setBloodGroupId(rs.getInt("bg_id"));
		bg.setBloodGroup(rs.getString("blood_group_name"));
		bloodApp.setBloodGroup(bg);
		//bloodApp.setActive(rs.getBoolean("active"));
		bloodApp.setCity(rs.getString("city"));
		bloodApp.setMobileNumber(rs.getLong("mobile_number"));
		bloodApp.setPassword(rs.getString("password"));

		return bloodApp;
	}
}
