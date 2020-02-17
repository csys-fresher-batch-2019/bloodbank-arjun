package com.chainsys.bloodbankapp.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;


/**
 * This BloodGroup is used for XYZ BloodBank. 
 * @author arju2383
 *
 */
public interface BloodGroupDAO {

	/**
	 * This method is used for rfinding the blood group.
	 * @param bloodGroup
	 * @return List of BG
	 * @throws DbException
	 */
	List<BloodGroup> findByBloodGroup(String bloodGroup) throws DbException;
	
	@SqlQuery("select emp_id,emp_name,email,blood_group,active from blood_bank_app where blood_group=? and active =1")
	int addEmployeeDetails(BloodGroup a) throws DbException;
	
	@SqlUpdate("update blood_bank_app set active=? where email=? and active != ?")
	boolean updateDonateStatus(BloodGroup a) throws DbException;
	
	@SqlQuery("select emp_id,emp_name,email,blood_group,active from blood_bank_app where email=?")
	public BloodGroup findByEmail(String email) throws DbException;

	@SqlUpdate("update blood_bank_app set email=? where emp_id=?")
	public boolean updateEmail(BloodGroup a) throws DbException;
	
	public boolean updateBloodGroup(BloodGroup a) throws DbException;
	
	@SqlUpdate("delete from blood_bank_app where emp_id=?")
	public boolean deleteEmployeeRecord(BloodGroup a) throws DbException;
	
	@SqlQuery("select emp_id,emp_name,email from blood_bank_app where blood_group is null")
	public List<BloodGroup> findNullBloodRecords() throws DbException;
}
