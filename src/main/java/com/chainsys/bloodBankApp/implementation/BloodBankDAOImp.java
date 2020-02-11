package com.chainsys.bloodbankapp.implementation;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.chainsys.bloodbankapp.dao.BloodGroupDAO;
import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.model.BloodGroup;
import com.chainsys.bloodbankapp.utile.ConnectionUtile;
import com.chainsys.bloodbankapp.logger.Logger;
public class BloodBankDAOImp implements BloodGroupDAO {

	public ArrayList<BloodGroup> selectEmpBlood(String bloodGroup) throws DbException {
		
		Logger logger = new Logger();
		String sql="select * from blood_bank_app where blood_group=?";
		ArrayList<BloodGroup> list = new ArrayList<BloodGroup>();
		
		try(Connection com= ConnectionUtile.getConnection();
				PreparedStatement ps=com.prepareStatement(sql);){
			ps.setString(1,bloodGroup);
			System.out.println(sql);
			try(ResultSet rs= ps.executeQuery();)
			{
			
			
			while(rs.next())
			{
				BloodGroup b=new BloodGroup();
				b.setEmpId(rs.getInt("emp_id"));
				b.setEmpName(rs.getString("emp_name"));
				b.setEmail(rs.getString("email"));
				b.setBloodGroup(rs.getString("blood_group"));
				b.setActive(rs.getBoolean("active"));
				
			list.add(b);
			}
			}
		}
			catch(SQLException e) {
				logger.info("SQL Error Message");
				throw new DbException("ErrorMessages.PREPARE_FAILURE");
			}
		return list;	
	}

}
