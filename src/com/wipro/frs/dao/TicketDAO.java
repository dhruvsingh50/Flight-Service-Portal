package com.wipro.frs.dao;

import java.util.List;
import java.util.Map;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;

public interface TicketDAO {

	Map<ReservationBean,List<PassengerBean>> viewTicket(String reservationId);
	Map<ReservationBean,PassengerBean> printTicket(String reservationId);
}
