package com.chainsys.bloodbankapp.dao;

import java.util.List;

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
	
	int addEmployeeDetails(BloodGroup a) throws DbException;
	
	boolean updateDonateStatus(BloodGroup a) throws DbException;
	
	public BloodGroup findByEmail(String email) throws DbException;
	
	public boolean updateEmail(BloodGroup a) throws DbException;
	
	public boolean updateBloodGroup(BloodGroup a) throws DbException;
	
	public boolean deleteEmployeeRecord(BloodGroup a) throws DbException;
	
	public List<BloodGroup> findNullBloodRecords() throws DbException;
}
