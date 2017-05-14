 package com.wipro.frs.service;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.frs.bean.CredentialsBean;

import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ProfileBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.dao.CredentialsDAO;
import com.wipro.frs.dao.CreditCardDAO;
import com.wipro.frs.dao.FlightDAO;
import com.wipro.frs.dao.PassengerDAO;
import com.wipro.frs.dao.ReservationDAO;
import com.wipro.frs.dao.ScheduleDAO;
import com.wipro.frs.dao.RouteDAO;
import com.wipro.frs.dao.ProfileDAO;
import com.wipro.frs.dao.TicketDAO;


@Service
public class CustomerImpl implements Customer{
	
	@Autowired
	private FlightDAO flightDAO;
	@Autowired
	private ReservationDAO reservationdao;
	
	@Autowired
	private PassengerDAO passengerdao;
	
	@Autowired
	private ScheduleDAO scheduledao;
	
	@Autowired
	private RouteDAO routedao;
	
	@Autowired
	private CredentialsDAO credentialsDAO;
	
	@Autowired
	private CreditCardDAO creditcarddao;
	
	@Autowired
	private ProfileDAO profileDAO;
	
	@Autowired
	private TicketDAO ticketDAO;
	
	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source,
			String destination, Date date) {
		System.out.println("inside viewschedule");
		System.out.println(source);
		DateFormat format2 = new SimpleDateFormat("EEEE");
		String day = format2.format(date);
		List<ScheduleBean> list = new ArrayList<ScheduleBean>();
		List<ScheduleBean> listSchedule = scheduledao.checkday(day);
		
		List<String> listRoute = routedao.findRouteID(source, destination);
		
		Iterator<String> iteratorRoute = listRoute.iterator();
		System.out.println("schedule size is"+listSchedule.size());
		
		System.out.println("route size is"+listRoute.size()+"-->"+listRoute);
		while (iteratorRoute.hasNext()) {
			String routeID = iteratorRoute.next();
			Iterator<ScheduleBean> iterateSchedule = listSchedule.iterator();
			while (iterateSchedule.hasNext()) {
				System.out.println("inside routeiterator"+routeID);
				//ScheduleBean bean = new ScheduleBean();
				ScheduleBean bean = iterateSchedule.next();
				
				if (routeID.equalsIgnoreCase(bean.getRouteID())) {
					list.add(bean);
					System.out.println("matching"+routeID);
				}
				else{
					System.out.println("not matching"+routeID);
				}
			}
		}
		System.out.println("End viewScheduleByRoute(param1,param2,param3) list->" + list);
		return (ArrayList<ScheduleBean>) list;
	}
@Override
	public String reserveTicket(ReservationBean reservationBean,
			ArrayList<PassengerBean> passengers) {
		String reservationID=reservationBean.getScheduleID().substring(0, 4).toUpperCase()
				+ reservationdao.GetReservartionSeq();
		reservationBean.setReservationID(reservationID);
		String mes1=reservationdao.CreateReservation(reservationBean);
		PassengerBean bean = null;
		if(mes1.equalsIgnoreCase("success")){
			Iterator<PassengerBean> it=passengers.iterator();
			while(it.hasNext()){
				bean=it.next();
				bean.setReservationID(reservationID);
				mes1=passengerdao.createPassenger(bean);
				
			}
		}
		return mes1;
	}

	@Override
	public boolean cancelTicket(String reservationId) {
		// TODO Auto-generated method stub
		int p=reservationdao.cancelTicket(reservationId);
		if(p>0){
		while(p>0){
			passengerdao.deletePassenger(reservationId);
			
		
			
			
			p--;
			return true;
		}
		}
		return false;
	}

	@Override
	public Map<ReservationBean, List<PassengerBean>> viewTicket(String reservationId) {
		// TODO Auto-generated method stub
		Map<ReservationBean, List<PassengerBean>> m1 = new HashMap<>();
	
		m1=ticketDAO.viewTicket(reservationId);
		/*Iterator itr= m1.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<ReservationBean, PassengerBean> pair= (Entry<ReservationBean, PassengerBean>)itr.next();
			System.out.println(pair.getKey().getReservationType()+" "+pair.getKey().getTotalFare() );
			System.out.println(pair.getValue().getName()+" "+pair.getValue().getGender());
		}*/
		return m1;
	}

	@Override
	public Map<ReservationBean, PassengerBean> printTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTotalFare(String routeid) {
		// TODO Auto-generated method stub
		System.out.println("The route id is given:" + routeid);
		
		double totalFare = 0;
		
		RouteBean rbean = routedao.FindByRouteId(routeid);
		if (rbean != null) {
			totalFare = rbean.getDistance() * rbean.getFare();
		}
		System.out.println("Total fare of given id is: " + totalFare);
		return totalFare;
	}

	@Override
	public String Login(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		String str=credentialsDAO.login(credentialsBean);
		return str;
		
	}
	@Override
	public boolean updateCreditCard(String creditCardNumber, double balance) {
		
		boolean status=creditcarddao.updateCreditCard(creditCardNumber, balance);
		return status;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean,
			String newpassword,String userid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String str=credentialsDAO.changePassword(credentialsBean,newpassword,userid);
						if(str.equalsIgnoreCase("SUCCESS")){
							return "SUCCESS";
						}
						else{
							return "FAILURE";
						}
	}
	
	@Override
	public String AddSeat(FlightBean flightBean, int noOfSeat) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public String SubSeat(FlightBean flightBean, int noOfSeat) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	public double validateCreditCard(CreditCardBean bean, String userID) {
		// TODO Auto-generated method stub
		double bal= creditcarddao.validateCreditCard(bean, userID);
		return bal;
	}
	
	
	@Override
	public String register(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		
		int rid=profileDAO.rseqgen();
		System.out.println("first name is "+profileBean.getFirstName());
		String userID=profileBean.getFirstName().substring(0, 2).toUpperCase()+rid;
		
		profileBean.setUserID(userID);
		CredentialsBean credentialsBean=new CredentialsBean();
		credentialsBean.setUserid(userID);
		credentialsBean.setPassword(profileBean.getPassword());
		credentialsBean.setUserType("C");
		credentialsBean.setLoginStatus(0);
		System.out.println("inside register");
		System.out.println(credentialsBean.getUserID()+" "+credentialsBean.getPassword()+" "+credentialsBean.getUserType()+" "+credentialsBean.getLoginStatus());
		String result=credentialsDAO.createCredentials(credentialsBean);
		if(result.equalsIgnoreCase("success")){
			String status2=profileDAO.createProfile(profileBean);
			if(status2 !=null){
				return status2;
			}
			else
				return null;
		}
		else
		return null;
		
	}
	@Override
	public boolean logout(String UserId) {
		// TODO Auto-generated method stub
		boolean str=credentialsDAO.logout(UserId);
		
		
		return str;
	}
}
