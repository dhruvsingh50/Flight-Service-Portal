package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.PassengerBean;

public interface PassengerDAO {

	PassengerBean viewPassenger(String reservationId);
	
	String createPassenger(PassengerBean passengerBean);	
	
	int deletePassenger(String reservationId);
	
	ArrayList<PassengerBean> FindAll();
	
}
