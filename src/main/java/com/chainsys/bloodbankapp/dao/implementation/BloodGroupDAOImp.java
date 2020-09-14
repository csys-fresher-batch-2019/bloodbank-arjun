package com.chainsys.bloodbankapp.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.mapper.UserBloodGroupRowMapper;
import com.chainsys.bloodbankapp.mapper.UserDetailsRowMapper;
import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.model.UserDetail;
import com.chainsys.bloodbankapp.util.ConnectionTemplate;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class BloodGroupDAOImp implements BloodGroupDAO {

	DriverManagerDataSource dataSource = ConnectionTemplate.getDataSource();
	JdbcTemplate jdbcTemplate = ConnectionTemplate.getJdbcTemplate();

	private static final Logger LOG = Logger.getInstance(BloodGroupDAOImp.class);

	public List<User> findByBloodGroup(String bloodGroup) throws DbException {

		List<User> bloodList = new ArrayList<User>();
		String sql = "select ba.id,ba.name,gender,age,email,ba.bg_id,bg.name as blood_group_name,city,mobile_number,password from donor_details ba inner join blood_group bg on bg.id=ba.bg_id and bg.name=? and active=1";
		UserBloodGroupRowMapper rowMapper = new UserBloodGroupRowMapper();
		bloodList = (List<User>) jdbcTemplate.query(sql, rowMapper, bloodGroup);
		return bloodList;
	}

	@Override
	public int addEmployeeDetails(User a) throws DbException {

		String sql = "insert into donor_details(id,name,gender,age,email,bg_id,city,mobile_number,password) values(donor_id_seq.nextval,?,?,?,?,?,?,?,?)";
		int row = jdbcTemplate.update(sql, a.getUserName(), a.getGender(), a.getAge(), a.getEmail(), a.getBloodGroup().getBloodGroupId(), a.getCity(), a.getMobileNumber(), a.getPassword());
		return row;
	}

	@Override
	public boolean updateDonateStatus(boolean active, String email) throws DbException {
		String sql = "update donor_details set active=? where email=?"; // not working in jdbc template
		int row = jdbcTemplate.update(sql, active, email);
		if (row == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateEmail(int userId, String email) throws DbException {	
		String sql = "update donor_details set email=? where id=?";
		int row = jdbcTemplate.update(sql, email, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBloodGroup(int userId, String bloodGroup) throws DbException {
		String sql = "update donor_details set bg_id = (select blood_group.id from blood_group where blood_group.name =?) where id = ?";
		int row = jdbcTemplate.update(sql, bloodGroup, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteEmployeeRecord(int userId) throws DbException {
		String sql = "delete from donor_details where id=?";
		int row = jdbcTemplate.update(sql, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	@Override
	public int findByBloodGroupId(String bloodGroup) throws Exception {
		// In sql,it will show empty records if the input data are incorrect so using
		// try/catch Exception here
		int id = 0;
		String sql = "select id from blood_group where name=?";
		try {
			id = jdbcTemplate.queryForObject(sql, Integer.class, bloodGroup);	//to return a single value(int,string,..)
		} catch (EmptyResultDataAccessException e) {
			LOG.debug("No Record Found ");
			LOG.error(e);
		}
		return id;
	}

	@Override
	public int countInCity(String bloodGroup, String city) throws DbException, SQLException { 
		// In sql,it will show 0 if the input data are incorrect so no need to do
		// Exception
		String sql = "select count(id) from donor_details where bg_id=(select blood_group.id from blood_group where blood_group.name =? ) and city=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, bloodGroup, city);
		return count;
	}

	@Override
	public List<User> findByUserDetails(String bloodGroup, String city) throws DbException { //doubt

		List<User> userDetailList = new ArrayList<>();
		String sql = "select id,name,email,city from donor_details where bg_id=(select blood_group.id from blood_group where blood_group.name =? ) and city=?";
		UserDetailsRowMapper rowMapper = new UserDetailsRowMapper();
		userDetailList = (List<User>) jdbcTemplate.query(sql, rowMapper, bloodGroup, city);
		return userDetailList;
	}

	@Override
	public boolean updateCity(int userId, String city) throws DbException {
		String sql = "update donor_details set city=? where id=?";
		int row = jdbcTemplate.update(sql, city, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean findByEmail(String email) throws DbException {
		boolean out = false;
		String sql = "select email from donor_details where email=?";
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					out = true;
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return out;
	}

	@Override
	public boolean findByUserId(int userId) throws DbException {
		boolean out = false;
		String sql = "select 1 from donor_details where id=?";
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					out = true;
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return out;
	}
}