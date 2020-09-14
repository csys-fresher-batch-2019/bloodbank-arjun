package com.chainsys.bloodbankapp.dao;

import java.sql.SQLException;
import java.util.List;
//import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodApp;
import com.chainsys.bloodbankapp.model.User;
import com.chainsys.bloodbankapp.model.UserDetail;

public interface BloodGroupDAO {

	List<User> findByBloodGroup(String bloodGroup) throws DbException;

	int addEmployeeDetails(User a) throws DbException;

	public int findByBloodGroupId(String bloodGroup) throws Exception;

	public boolean updateDonateStatus(boolean active, String email) throws DbException;

	public boolean updateEmail(int userId, String email) throws DbException;

	public boolean updateBloodGroup(int userId, String bloodGroup) throws DbException;

	public boolean deleteEmployeeRecord(int userId) throws DbException;

	public int countInCity(String bloodGroup, String city) throws DbException, SQLException;

	List<User> findByUserDetails(String bloodGroup, String city) throws DbException;

	public boolean updateCity(int userId, String city) throws DbException;

	public boolean findByEmail(String email) throws DbException;

	public boolean findByUserId(int userId) throws DbException;
}
