package com.wipro.frs.util;

import com.wipro.frs.bean.CredentialsBean;

public interface Authentication {
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userId);
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
	
	
}
