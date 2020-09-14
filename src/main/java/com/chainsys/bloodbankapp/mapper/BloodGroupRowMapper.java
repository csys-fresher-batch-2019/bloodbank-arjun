package com.chainsys.bloodbankapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.bloodbankapp.model.BloodApp;

public class BloodGroupRowMapper implements RowMapper<BloodApp> {

	public BloodApp mapRow(ResultSet rs, int row) throws SQLException {
		BloodApp bloodApp = new BloodApp();

		bloodApp.setUserId(rs.getInt("user_id"));
		bloodApp.setUserName(rs.getString("user_name"));
		bloodApp.setEmail(rs.getString("email"));
		bloodApp.setBloodGroup(rs.getString("blood_group"));
		bloodApp.setActive(rs.getBoolean("active"));
		bloodApp.setCity(rs.getString("city"));

		return bloodApp;
	}
}
