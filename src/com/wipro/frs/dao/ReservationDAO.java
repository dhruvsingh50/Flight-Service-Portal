package com.wipro.frs.dao;

import com.wipro.frs.bean.ReservationBean;

public interface ReservationDAO 
{
	String CreateReservation(ReservationBean resevationBean);
	int GetReservartionSeq();
	public int cancelTicket (String reservationId);
}
