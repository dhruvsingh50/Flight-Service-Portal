package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.ProfileBean;

public interface ProfileDAO {
	
	//String register(ProfileBean profileBean);

	public String createProfile(ProfileBean pbean);
	public int deleteProfile(ArrayList<String> arlProfile);
	public boolean updateProfile(ProfileBean pbean);
	public ProfileBean findByID(String userID);
	public ArrayList<ProfileBean> findAll();
	int rseqgen();
	
	
}
