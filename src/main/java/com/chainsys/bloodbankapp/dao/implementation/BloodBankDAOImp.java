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

		String sql = "select emp_id,emp_name,email,blood_group,active from blood_bank_app where blood_group=?";
		List<BloodGroup> list = new ArrayList<>();

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

}
