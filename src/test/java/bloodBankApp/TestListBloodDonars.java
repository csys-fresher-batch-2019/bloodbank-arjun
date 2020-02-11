package bloodbankapp;

import com.chainsys.bloodbankapp.exception.DbException;
import com.chainsys.bloodbankapp.implementation.BloodBankDAOImp;

public class TestListBloodDonars {

	public static void main(String[] args) throws DbException {
		
		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		bloodDonars.selectEmpBlood("B+ve");
	}

}
