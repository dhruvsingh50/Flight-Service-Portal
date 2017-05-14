package com.wipro.frs.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.dao.*;
@Service
public class AdministratorImpl implements Administrator {
	
	@Autowired
	private RouteDAO routeDAO;
	@Autowired
	private FlightDAO flightDAO;
	@Autowired
	private ScheduleDAO scheduleDAO;
	@Autowired
	private PassengerDAO passengerDAO;
     
    
	@Override
	public String addFlight(FlightBean flightBean) {
		// TODO Auto-generated method stub
		
		int fid=flightDAO.fseqgen();
		String Flight_id= flightBean.getFlightName().substring(0, 2).toUpperCase()+fid;
		flightBean.setFlightID(Flight_id);
		String status=flightDAO.createFlight(flightBean);
		return status;
	}

	@Override
	public boolean modifyFlight(FlightBean flightBean) {
		// TODO Auto-generated method stub
		boolean status=flightDAO.updateFlight(flightBean);
		return status;
	}

	@Override
	public int removeFlight(ArrayList<String> flightID) {
		// TODO Auto-generated method stub
		int status=flightDAO.deleteFlight(flightID);
		return status;
	}

	@Override
	public String addSchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		ScheduleDAOImpl sdao=new ScheduleDAOImpl();
		int sid=sdao.sseqgen();
		String Schedule_id= scheduleBean.getScheduleID().substring(0, 2)+sid;
		scheduleBean.setScheduleID(Schedule_id);
		String status1=sdao.createSchedule(scheduleBean);
		return status1;
		
		
		
		
	}

	@Override
	public boolean modifySchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		boolean status1=scheduleDAO.updateSchedule(scheduleBean);
		return status1;
	}

	@Override
	public int removeSchedule(ArrayList<String> scheduleID) {
		// TODO Auto-generated method stub
		
		int status1=scheduleDAO.deleteSchedule(scheduleID);
		return status1;
	}

	@Override
	public String addRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		
		int rid=routeDAO.rseqgen();
		System.out.println(rid);
		String Route_id= routeBean.getSource().substring(0, 2).toUpperCase()+routeBean.getDestination().substring(0, 2).toUpperCase()+rid;
		routeBean.setRouteID(Route_id);
		String status2=routeDAO.createRoute(routeBean);
		return status2;
		
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		boolean status2=routeDAO.updateRoute(routeBean);
		return status2;
	
	}

	@Override
	public int removeRoute(ArrayList<String> routeID) {
		// TODO Auto-generated method stub
		int status2=routeDAO.deleteRoute(routeID);
		return status2;
	}

	@Override
	public FlightBean viewByFlightId(String flightId) {
		// TODO Auto-generated method stub
		FlightBean fbean = flightDAO.FindByFlightId(flightId);
		return fbean;	}

	@Override
	public RouteBean viewByRouteId(String routeId) {
		// TODO Auto-generated method stub
		RouteBean rbean = routeDAO.FindByRouteId(routeId);
		return rbean;	}
     
	
	@Override
	public ArrayList<FlightBean> viewByAllFlights() {
		// TODO Auto-generated method stub
		ArrayList<FlightBean> al = flightDAO.FindAllFlights();
		return al;
	}
    
	
	@Override
	public ArrayList<RouteBean> viewByAllRoute() {
		// TODO Auto-generated method stub
		ArrayList<RouteBean> al = routeDAO.FindAllRoutes();
		return al;
	}

	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule() {
		// TODO Auto-generated method stub
		ArrayList<ScheduleBean> al = scheduleDAO.FindAllSchedules();
		return al;
	}

	@Override
	public ScheduleBean viewByScheduleId(String scheduleId) {
		// TODO Auto-generated method stub
		ScheduleBean sbean = scheduleDAO.FindByScheduleId(scheduleId);
		return sbean;
	}

	@Override
	public ArrayList<PassengerBean> viewPassengersByFlight(String scheduleId) {
		// TODO Auto-generated method stub
		ArrayList<PassengerBean> al = passengerDAO.FindAll();
		return al;
	}

}
