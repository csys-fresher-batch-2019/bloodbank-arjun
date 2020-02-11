package com.chainsys.bloodBankApp.dao;

import java.util.ArrayList;

import com.chainsys.bloodBankApp.model.BloodGroup;

public interface BloodGroupDAO {

	ArrayList<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception;
}
