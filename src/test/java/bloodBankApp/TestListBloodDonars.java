package bloodBankApp;

import com.chainsys.bloodBankApp.exception.DbException;
import com.chainsys.bloodBankApp.implementation.BloodBankDAOImp;

public class TestListBloodDonars {

	public static void main(String[] args) throws DbException {
		
		BloodBankDAOImp bloodDonars=new BloodBankDAOImp();
		bloodDonars.selectEmpBlood("B+ve");
	}

}
