package com.chainsys.bloodbankapp.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.util.ConnectionUtil;
import com.chainsys.bloodbankapp.util.Logger;

public class BloodBankDAOImp implements BloodGroupDAO {

	private static final Logger LOG = Logger.getInstance(BloodBankDAOImp.class);

	public List<BloodGroup> findByBloodGroup(String bloodGroup) throws DbException {

		String sql = "select emp_id,emp_name,email,blood_group,active from blood_bank_app where blood_group=? and active =1";
		List<BloodGroup> list = new ArrayList<BloodGroup>();

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1, bloodGroup);
			LOG.info(sql);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					BloodGroup b = new BloodGroup();
					b.setEmpId(rs.getInt("emp_id"));
					b.setEmpName(rs.getString("emp_name"));
					b.setEmail(rs.getString("email"));
					b.setBloodGroup(rs.getString("blood_group"));
					b.setActive(rs.getBoolean("active"));

					list.add(b);
				}
			}
		} catch (SQLException e) {
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return list;
	}


	@Override
	public int addEmployeeDetails(BloodGroup a) throws DbException {

		String sql="insert into blood_bank_app(emp_id,emp_name,email,blood_group) values(employee_id_seq.nextval,?,?,?)";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);){

			ps.setString(1,a.getEmpName());
			ps.setString(2,a.getEmail());
			ps.setString(3,a.getBloodGroup());

			LOG.info(sql);

			int row=ps.executeUpdate();
			LOG.info(row);
			return row;
		}
		catch (SQLException e) {
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}

	}

	@Override
	public boolean updateDonateStatus(BloodGroup a) throws DbException {

		int rows = 0;
		String sql="update blood_bank_app set active=? where email=? and active != ?";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);){


			ps.setBoolean(1,a.isActive());
			ps.setString(2,a.getEmail());
			ps.setBoolean(3,a.isActive());

			LOG.info(sql);

			rows=ps.executeUpdate();
			LOG.info(rows);
		}
		catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows ==1 ? true:false;
	}

	@Override
	public boolean updateEmail(BloodGroup a) throws DbException {

		int rows = 0;
		String sql="update blood_bank_app set email=? where emp_id=?";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);){


			ps.setString(1,a.getEmail());
			ps.setInt(2,a.getEmpId());

			LOG.info(sql);

			rows=ps.executeUpdate();
			LOG.info(rows);
		}
		catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows ==1 ? true:false;
	}

	@Override
	public boolean updateBloodGroup(BloodGroup a) throws DbException {

		int rows = 0;

		String sql1="select blood_group from blood_bank_app where emp_id=?";

		String sql="update blood_bank_app set blood_group=? where emp_id=? ";

		String bloodGroup="";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);
				PreparedStatement pst = com.prepareStatement(sql1)){

			pst.setInt(1, a.getEmpId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				bloodGroup=rs.getString("blood_group");
			}

			if(bloodGroup==null) {
				ps.setString(1,a.getBloodGroup());
				ps.setInt(2,a.getEmpId());

				LOG.info(sql);

				rows=ps.executeUpdate();
				LOG.info(rows);
			}
			else {
				rows=0;
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows ==1 ? true:false;
	}

	@Override
	public boolean deleteEmployeeRecord(BloodGroup a) throws DbException {

		int rows = 0;
		String sql="delete from blood_bank_app where emp_id=?";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);){


			ps.setInt(1,a.getEmpId());

			LOG.info(sql);

			rows=ps.executeUpdate();
			LOG.info(rows);
		}
		catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows ==1 ? true:false;
	}

	public List<BloodGroup> findNullBloodRecords() throws DbException {

		String sql = "select emp_id,emp_name,email from blood_bank_app where blood_group is null";
		List<BloodGroup> list = new ArrayList<BloodGroup>();

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			LOG.info(sql);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					BloodGroup b = new BloodGroup();
					b.setEmpId(rs.getInt("emp_id"));
					b.setEmpName(rs.getString("emp_name"));
					b.setEmail(rs.getString("email"));
					list.add(b);
				}
			}
		} catch (SQLException e) {
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return list;
	}


	public BloodGroup findByEmail(String email) throws DbException {

		String sql = "select emp_id,emp_name,email,blood_group,active from blood_bank_app where email=?";
		BloodGroup b =  null;
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1, email);
			//LOG.info(sql);
			try (ResultSet rs = ps.executeQuery();) {

				if (rs.next()) {
					b = new BloodGroup();
					b.setEmpId(rs.getInt("emp_id"));
					b.setEmpName(rs.getString("emp_name"));
					b.setEmail(rs.getString("email"));
					b.setBloodGroup(rs.getString("blood_group"));
					b.setActive(rs.getBoolean("active"));

				}
			}
		} catch (SQLException e) {
			LOG.info("SQL Error Message"+ e.getMessage());
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return b;
	}

}
