package com.chainsys.bloodbankapp.test;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.dao.implementation.*;

public class TestListBloodDonars {

	public static void main(String[] args) throws DbException {
		
		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		bloodDonars.selectEmpBlood("B+ve");
	}

}
