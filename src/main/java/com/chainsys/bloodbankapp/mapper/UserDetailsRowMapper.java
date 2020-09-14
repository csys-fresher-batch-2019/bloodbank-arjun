package com.chainsys.bloodbankapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.model.UserDetail;

public class UserDetailsRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet row, int size) throws SQLException {

		User userDetails = new User();

		userDetails.setUserId(row.getInt("id"));
		userDetails.setUserName(row.getString("name"));
		userDetails.setEmail(row.getString("email"));
		userDetails.setCity(row.getString("city"));

		return userDetails;
	}
}
