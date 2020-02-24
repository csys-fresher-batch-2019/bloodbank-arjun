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

		String sql = "select user_id,user_name,email,blood_group,active,city from blood_app ba inner join bloodGroup bg on bg.blood_group_id=ba.blood_group_id and blood_group=? and active=1";
		System.out.println(sql);
		List<BloodGroup> list = new ArrayList<BloodGroup>();

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1, bloodGroup);
			LOG.info(sql);
			LOG.info("dao-" + bloodGroup);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					BloodGroup b = new BloodGroup();
					b.setUserId(rs.getInt("user_id"));
					b.setUserName(rs.getString("user_name"));
					b.setEmail(rs.getString("email"));
					b.setBloodsGroup(rs.getString("blood_group"));
					b.setActive(rs.getBoolean("active"));
					b.setCity(rs.getString("city"));

					list.add(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return list;
	}

	@Override
	public int addEmployeeDetails(BloodGroup a) throws DbException {

		String sql = "insert into blood_app(user_id,user_name,email,blood_group_id,city) values(employee_id_seq.nextval,?,?,?,?)";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {

			ps.setString(1, a.getUserName());
			ps.setString(2, a.getEmail());
			ps.setInt(3, a.getBloodGroupId());
			ps.setString(4,a.getCity());

			LOG.info(sql);

			int row = ps.executeUpdate();
			LOG.info(row);
			return row;
		} catch (SQLException e) {
			LOG.info("SQL Error Message");
			e.printStackTrace();
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
	}

	@Override
	public boolean updateDonateStatus(boolean active,String email) throws DbException {

		int rows ;
		String sql = "update blood_app set active=? where email=?";
		try (Connection com = ConnectionUtil.getConnection();
				PreparedStatement ps = com.prepareStatement(sql);) {

			ps.setBoolean(1,active);
			ps.setString(2,email);
		//	ps.setBoolean(3,active);

			LOG.info(sql);

			rows = ps.executeUpdate();
			LOG.info(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		
		}return rows == 1 ? true : false;
		
	}

	@Override
	public boolean updateEmail(int userId,String email) throws DbException {

		int rows = 0;
		
		String sql = "update blood_app set email=? where user_id=?";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {

			ps.setString(1,email);
			ps.setInt(2,userId);

			LOG.info(sql);

			rows = ps.executeUpdate();
			LOG.info(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows == 1 ? true : false;
	}

	@Override
	public boolean updateBloodGroup(int userId,String bloodGroup) throws DbException {

		int rows = 0;

		//String sql1 = "select blood_group from blood_app where user_id=?";

		String sql = "update blood_app set blood_group_id = (select blood_group_id from bloodGroupDetails where blood_group = ?) where user_id = ?";


		try (Connection com = ConnectionUtil.getConnection();
				PreparedStatement pst = com.prepareStatement(sql);) {

			pst.setString(1, bloodGroup);
			pst.setInt(2,userId);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		
		return rows == 1 ? true : false;
	}

	@Override
	public boolean deleteEmployeeRecord(BloodGroup a) throws DbException {

		int rows = 0;
		String sql = "delete from blood_app where user_id=?";

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {

			ps.setInt(1, a.getUserId());

			LOG.info(sql);

			rows = ps.executeUpdate();
			LOG.info(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows == 1 ? true : false;
	}

	/*public List<BloodGroup> findNullBloodRecords() throws DbException {

		String sql = "select user_id,user_name,email from blood_app where blood_group is null";
		List<BloodGroup> list = new ArrayList<BloodGroup>();

		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			LOG.info(sql);
			try (ResultSet rs = ps.executeQuery();) {

				while (rs.next()) {
					BloodGroup b = new BloodGroup();
					b.setUserId(rs.getInt("user_id"));
					b.setUserName(rs.getString("user_name"));
					b.setEmail(rs.getString("email"));
					list.add(b);
				}
			}
		} catch (SQLException e) {
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return list;
	}*/

	/*public BloodGroup findByEmail(String email) throws DbException {

		String sql = "select user_id,user_name,email,blood_group,active from blood_bank_app where email=?";
		BloodGroup b = null;
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1, email);
			// LOG.info(sql);
			try (ResultSet rs = ps.executeQuery();) {

				if (rs.next()) {
					b = new BloodGroup();
					b.setUserId(rs.getInt("user_id"));
					b.setUserName(rs.getString("user_name"));
					b.setEmail(rs.getString("email"));
					b.setBloodsGroup(rs.getString("blood_group"));
					b.setActive(rs.getBoolean("active"));

				}
			}
		} catch (SQLException e) {
			LOG.info("SQL Error Message" + e.getMessage());
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return b;
	}*/

	@Override
	public int findByBloodGroupId(String bloodsGroup) throws Exception {
		
		int id=0;
			String sql = "select blood_group_id from bloodGroupDetails where blood_group=?";
			System.out.println(bloodsGroup);
			
			try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
				LOG.info(sql);
				ps.setString(1,bloodsGroup);
				try (ResultSet rs = ps.executeQuery();) {

					if (rs.next()) {
					id=rs.getInt(1);
					}
				}
			} catch (SQLException e) {
				LOG.info("SQL Error Message");
				throw new DbException("ErrorMessages.PREPARE_FAILURE");
			}
			return id;
		}

	@Override
	public int countInCity(String bloodGroup, String city) throws DbException, SQLException {
		
		String sql="select count(user_id) from blood_app where blood_group_id=(select blood_group_id from bloodGroupDetails where blood_group =? ) and city=?";
		System.out.println(sql);
		int count = 0;
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1,bloodGroup);
			ps.setString(2,city);
        try(ResultSet row =ps.executeQuery();){
        if(row.next()) {
        	count = row.getInt(1);
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        LOG.info(count);
		return count;
	}
	}	

	@Override
	public List<BloodGroup> findByUserDetails(String bloodGroup, String city) throws DbException {
		
		String sql="select user_id,user_name,email,city from blood_app where blood_group_id=(select blood_group_id from bloodGroupDetails where blood_group = ? ) and city=? group by user_id,user_name,email,city";
		ArrayList<BloodGroup> res = new ArrayList<BloodGroup>();
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			ps.setString(1,bloodGroup);
			ps.setString(2,city);
        try(ResultSet row =ps.executeQuery();){
        while(row.next()) {
        	BloodGroup obj = new BloodGroup();
        	obj.setUserId(row.getInt("user_id"));
        	obj.setUserName(row.getString("user_name"));
        	obj.setEmail(row.getString("email"));
        	obj.setCity(row.getString("city"));
        	res.add(obj);
        }
        } }catch(Exception e) {
        	e.printStackTrace();}
        
		return res;
	}

	@Override
	public boolean updateCity(int userId,String city) throws DbException {
		
		int rows=0;
		String sql="update blood_app set city=? where user_id=?";
		try (Connection com = ConnectionUtil.getConnection(); PreparedStatement ps = com.prepareStatement(sql);) {
			
			ps.setString(1,city);
			ps.setInt(2,userId);

			LOG.info(sql);

			rows = ps.executeUpdate();
			LOG.info(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("SQL Error Message");
			throw new DbException("ErrorMessages.PREPARE_FAILURE");
		}
		return rows == 1 ? true : false;

	}
	
}
