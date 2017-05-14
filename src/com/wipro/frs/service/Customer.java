package com.wipro.frs.service;
import com.wipro.frs.bean.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;


public interface Customer {
	ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date);
	String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers);
	boolean cancelTicket(String reservationId);
	Map<ReservationBean,List<PassengerBean>> viewTicket(String reservationId);
	Map<ReservationBean,PassengerBean> printTicket(String reservationId);
	double getTotalFare (String routeid);
	String Login(CredentialsBean credentialsBean);
	boolean logout(String UserId);
	double validateCreditCard(CreditCardBean bean, String userID);
	boolean updateCreditCard(String creditCardNumber, double balance);
	String changePassword(CredentialsBean credentialsBean, String newpassword,
			String userid);
	public String AddSeat(FlightBean flightBean,int noOfSeat);
	public String SubSeat(FlightBean flightBean, int noOfSeat);
	public String register(ProfileBean profileBean);
}
