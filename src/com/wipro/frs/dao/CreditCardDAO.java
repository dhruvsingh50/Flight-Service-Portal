package com.wipro.frs.dao;

import com.wipro.frs.bean.CreditCardBean;



	public interface CreditCardDAO {

		
		
		boolean updateCreditCard(String creditCardNumber, double balance);
		
		
		double validateCreditCard (CreditCardBean bean, String userid);
		
	}


