package com.wipro.frs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRS_TBL_CreditCard")

public class CreditCardBean {
	@Id
	@Column
	private String UserId;
	
	@Column
	private  double CreditBalance;
	@Column
	private  String CreditCardNumber;
	@Column
	private  String ValidFrom;
	@Column
	private  String ValidTo;
	
	
	public  double getCreditBalance() {
		return CreditBalance;
	}
	public  void setCreditBalance(double creditBalance) {
		CreditBalance = creditBalance;
	}
	public  String getCreditCardNumber() {
		return CreditCardNumber;
	}
	public  void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public  String getValidFrom() {
		return ValidFrom;
	}
	public  void setValidFrom(String validFrom) {
		ValidFrom = validFrom;
	}
	public  String getValidTo() {
		return ValidTo;
	}
	public  void setValidTo(String validTo) {
		ValidTo = validTo;
	}
	
}