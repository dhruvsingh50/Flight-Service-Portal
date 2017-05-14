package com.wipro.frs.util;

import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.ProfileBean;

public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(ProfileBean profileBean);
	
}
