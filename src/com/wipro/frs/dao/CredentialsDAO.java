package com.wipro.frs.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.frs.bean.CredentialsBean;

public interface CredentialsDAO {

	
	String login(CredentialsBean credentialsBean);
	

	
	boolean logout(String userId);
	
	

	String createCredentials(CredentialsBean credentialsBean);
	
	
	
	
	boolean updateCredentials(CredentialsBean credentials);



	int deleteCredentials(String userID);



	String findSequenceID();



	ArrayList<CredentialsBean> FindAll();



	CredentialsBean findByID(String id);
	
	public String changePassword(CredentialsBean credentialsBean,String newPassword,String userid);
	
	
	
}
