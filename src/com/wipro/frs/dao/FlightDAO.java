package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ScheduleBean;

public interface FlightDAO {

	int fseqgen();
	
	String createFlight(FlightBean flightBean);

	boolean updateFlight(FlightBean flightBean);

	int deleteFlight(ArrayList<String> flightId);
	
	FlightBean FindByFlightId(String flightId);
	
	ArrayList<FlightBean> FindAllFlights();
	
	ArrayList<PassengerBean> viewPassengerByFlight(String scheduleId);
	
}
