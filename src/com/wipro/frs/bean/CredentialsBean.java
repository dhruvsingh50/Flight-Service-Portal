package com.wipro.frs.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;



@Entity
@Table(name="FRS_TBL_USER_CREDENTIALS")
public class CredentialsBean {
	@Id
	@Column
	String Userid;
	@Column
	String password;
	@Column
	String userType;
	@Column
	int loginStatus;
	
	
	public String getUserID() {
		return Userid;
	}
	public void setUserid(String userID) {
		this.Userid = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	

}
