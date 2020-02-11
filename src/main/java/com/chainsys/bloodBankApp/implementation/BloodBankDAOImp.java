package com.chainsys.bloodBankApp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.chainsys.bloodBankApp.dao.BloodGroupDAO;
import com.chainsys.bloodBankApp.exception.DbException;
import com.chainsys.bloodBankApp.model.BloodGroup;
import com.chainsys.bloodBankApp.utile.ConnectionUtile;

public class BloodBankDAOImp implements BloodGroupDAO {

	public ArrayList<BloodGroup> selectEmpBlood(String bloodGroup) throws DbException {
		
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
				e.printStackTrace();
				throw new DbException("ErrorMessages.PREPARE_FAILURE");
			}
		return list;	
	}

}
