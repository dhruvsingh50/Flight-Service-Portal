package com.wipro.frs.dao;
import java.util.ArrayList;

import com.wipro.frs.bean.ProfileBean;
public interface CustomerDAO {
	
	String createCustomer(ProfileBean profileBean);
	int deleteCustomer(ArrayList<String> cust);
	boolean updateCustomer(ProfileBean profileBean);
	ProfileBean findByID(String id);
	ArrayList<ProfileBean> findAll();



}
