package com.chainsys.bloodbankapp.dao;

import java.util.ArrayList;

import com.chainsys.bloodbankapp.model.BloodGroup;

public interface BloodGroupDAO {

	ArrayList<BloodGroup> selectEmpBlood(String bloodGroup) throws Exception;
}
