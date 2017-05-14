package com.wipro.frs.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ProfileBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.service.Administrator;
import com.wipro.frs.service.Customer;

@Controller
public class Controller1 {
	ArrayList<String> routeids=new ArrayList<>();
	ArrayList<String> scheduleids= new ArrayList<>();
	
	
	@Autowired
	private Administrator administrator;
	@Autowired
	private Customer customer;
	
	
	
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
	}
	
	
	
	@RequestMapping(value="Register",method=RequestMethod.GET)
	public ModelAndView addNewUser(@ModelAttribute("ProfileBean") ProfileBean profileBean)
	{
		String str=customer.register(profileBean);
		if(str != null){
		return new ModelAndView("thankYou","str",str);
		}
		else
		return new ModelAndView("Register");
	}
	
	@RequestMapping(value="Res",method=RequestMethod.GET)
	public ModelAndView showAllrRoute()
	{
		ArrayList<RouteBean> result=administrator.viewByAllRoute();
		return new ModelAndView("reserveticket","route",result);
	}
	
	@RequestMapping(value="AddSchedule",method=RequestMethod.GET)
	public ModelAndView showAl(HttpServletRequest request)
	{
		ArrayList<RouteBean> rbean=administrator.viewByAllRoute();
		ArrayList<FlightBean> fbean=administrator.viewByAllFlights();
		System.out.println(rbean);
		System.out.println(fbean);
		HttpSession session=request.getSession();
		session.setAttribute("rbean", rbean);
		session.setAttribute("fbean", fbean);
		return new ModelAndView("addSchedule");
	}
	
	@RequestMapping(value="FindFlight",method=RequestMethod.POST)
	public ModelAndView findFlight(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.setAttribute("noOfSeats",request.getParameter("noOfSeats"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String date1 =request.getParameter("journeyDate");
		System.out.println(date1);
		DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date date = null;
		try {
			date = sdf.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(date);
		ReservationBean reservation = new ReservationBean();
		reservation.setJourneyDate(date);
		reservation.setReservationType(request.getParameter("reservationType"));
		reservation.setNoOfSeats(Integer.parseInt(request.getParameter("noOfSeats")));
		reservation.setBookingDate(new Date());
		session.setAttribute("reservation", reservation);
		//session.setAttribute("userID", "12");
		List<ScheduleBean> schedulelist = customer.viewScheduleByRoute(source, destination, date);
		if (!schedulelist.isEmpty()) {
			session.setAttribute("schedulelist", schedulelist);
			return new ModelAndView("FindFlight","slist",schedulelist);
		} else {
			
			session.setAttribute("message", "No flights available");
			return new ModelAndView("FindFlight");

		}
	
	}
	
	@RequestMapping(value="Book",method=RequestMethod.POST)
	public ModelAndView book(HttpServletRequest request)
	{
		HttpSession session = request.getSession();

		System.out.println("Reached Booking");
		ReservationBean reservationBean = (ReservationBean) session.getAttribute("reservation");
		String scheduleID = request.getParameter("scheduleID");
		String routeID = request.getParameter("routeID");
		session.setAttribute("scheduleID", scheduleID);
		session.setAttribute("routeID", routeID);
		System.out.println("routeID in servlet->" + routeID);
		RouteBean bean = administrator.viewByRouteId(routeID);
		System.out.println("RouteBean ->" + bean);
	
		Double totalFare = bean.getFare() * bean.getDistance() * reservationBean.getNoOfSeats();
		System.out.println(totalFare);
		session.setAttribute("fare", totalFare);
		String userID = (String) session.getAttribute("UserId");
		System.out.println("Printing userid from book got from session" +userID);
		reservationBean.setScheduleID(scheduleID);
		reservationBean.setTotalFare(totalFare);
		reservationBean.setUserID(userID);
		System.out.println("Printing reservation bean userid from book" +reservationBean.getUserID());
		reservationBean.setBookingStatus(1);
		session.setAttribute("reservation", reservationBean);
		System.out.println("End Booking");
		return new ModelAndView("Passenger");
	}
	
	
	@RequestMapping(value="AddPassenger",method=RequestMethod.POST)
	public ModelAndView AddPassenger(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		System.out.println("Reached Reservation Submit");
		ReservationBean reservationbean = (ReservationBean) session.getAttribute("reservation");
		System.out.println("reservationBean---->>>" + reservationbean);
		PassengerBean passenger = new PassengerBean();
		//session.setAttribute("reservationbean", reservationbean);
		List<PassengerBean> list = new ArrayList<PassengerBean>();
		String names[] = request.getParameterValues("name");
		String ages[] = request.getParameterValues("age");
		for (int i = 0; i < names.length; i++) {
			passenger = new PassengerBean();
			System.out.println("Name->" + names[i]);
			passenger.setName(names[i]);
			System.out.println("Age" + ages[i]);
			passenger.setAge(Integer.parseInt(ages[i]));
			System.out.println("Gender" + request.getParameter("gender" + (i + 1)));
			passenger.setGender(request.getParameter("gender" + (i + 1)));
			list.add(passenger);
		}
		session.setAttribute("list", list);
		System.out.println("End Reservation Submit result->");
		/*String routeID = (String) session.getAttribute("routeID");
		String scheduleId = (String) session.getAttribute("scheduleID");
		ScheduleDAO dao = new ScheduleDAOImpl();
		ScheduleBean bean = dao.flightID(routeID, scheduleId);
		// String FlightToBook = bean.getFlightID();
		double fare = customer.getTotalFare(routeID);
		System.out.println("total fare=" + fare);
		session.setAttribute("fare", fare);*/
		return new ModelAndView("Payment");
	}
	
	
	@RequestMapping(value="Pay",method=RequestMethod.POST)
	public ModelAndView pay(@ModelAttribute("CreditCardBean") CreditCardBean creditCardBean,ReservationBean reservationBean,HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("UserId");
		double amount=(double) session.getAttribute("fare");
		System.out.println("Printing userid from pay in controller"+userID);
		System.out.println("amount is" +amount);
		double balance=customer.validateCreditCard(creditCardBean, userID);
		if (balance < 0) {
			System.out.println("INVALID DETAILS");
			//URL = "paymentDetails.jsp";
		} else if (balance < amount) {
			System.out.println("Insufficient Balance");
			//URL = "paymentDetails.jsp";
		} else {
			balance = balance - amount;
			System.out.println("Creditcard Number :" + creditCardBean.getCreditCardNumber());
			System.out.println("New balance to be updated : " + balance);
			boolean res;
			res = customer.updateCreditCard(creditCardBean.getCreditCardNumber(), balance);
			if (res) {
				System.out.println("Balance Updated");
				 reservationBean = (ReservationBean) session.getAttribute("reservation");
				@SuppressWarnings("unchecked")
				ArrayList<PassengerBean> list = (ArrayList<PassengerBean>) session.getAttribute("list");
				String count = customer.reserveTicket(reservationBean, list);
				Map<ReservationBean, List<PassengerBean>> m1 = new HashMap<>();
				 
				m1=customer.viewTicket(reservationBean.getReservationID());
				return new ModelAndView("ViewTicket","ticket",m1);
				//return new ModelAndView("redirect:/details.jsp");
			}
		}
		return new ModelAndView("redirect:/PaymentFailed.jsp");
	}
	
	@RequestMapping(value="CreateRoute",method=RequestMethod.GET)
	public ModelAndView CreateRoute(@ModelAttribute("RouteBean") RouteBean routeBean,BindingResult result)
	{
		    String str=administrator.addRoute(routeBean);
		    if(str.equalsIgnoreCase("success")){
		    	return new ModelAndView("addRoute","message","ROUTE ADDED");
		    }
		    else
		    	return new ModelAndView("addRoute","message","ROUTE NOT ADDED");
		    
	}
	
	@RequestMapping(value="CancelTicket",method=RequestMethod.POST)
	public ModelAndView CancelTicket(@ModelAttribute("ReservationBean") ReservationBean reservationBean,HttpServletRequest request)
	{
		//PassengerBean pbean=null;
		//pbean.setReservationID(reservationBean.getReservationID());
		//HttpSession session=request.getSession();
		//session.setAttribute("ide",request.getAttribute("Reservationid"));
		boolean str=customer.cancelTicket(request.getParameter("Reservationid"));
		    if(str){
		    	return new ModelAndView("CancelTicket","message","TICKET CANCELLED");
		    }
		    else
		    	return new ModelAndView("CancelTicket","message","TICKET NOT CANCELLED");
		    
	}
	
	
	@RequestMapping(value="Login",method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("CredentialsBean") CredentialsBean credentialsBean,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String str=customer.Login(credentialsBean);
		System.out.println(str);
		
		if(str.equalsIgnoreCase("a")){
			session.setAttribute("UserId", credentialsBean.getUserID());
			session.setAttribute("UserType", credentialsBean.getUserType());
			return new ModelAndView("redirect:/adminhome.jsp");
			
		}
		else if(str.equalsIgnoreCase("c")){
			session.setAttribute("UserId", credentialsBean.getUserID());
			session.setAttribute("UserType", credentialsBean.getUserType());
			return new ModelAndView("redirect:/customerhome.jsp");
		}
		else {
			return new ModelAndView("redirect:/loginpage.jsp");
		}
		
		    
	}
	
	@RequestMapping(value="Logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request){
		System.out.println("inside logout");
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("UserId");
		boolean status= customer.logout(userId);
		if(status){
		session.invalidate();
		return new ModelAndView("logout");
		}
		return null;
	}
	
	
	
	@RequestMapping(value="addFlight",method=RequestMethod.POST)
	public ModelAndView AddFlight(@ModelAttribute("FlightBean") FlightBean flightBean,BindingResult result)
	{
		    String str=administrator.addFlight(flightBean);
		    if(str.equalsIgnoreCase("success")){
		    	return new ModelAndView("addFlight","message","FLIGHT ADDED");
		    }
		    else
		    	return new ModelAndView("addFlight","message","FLIGHT NOT ADDED");
		    
	}
	
	

	@RequestMapping(value="viewticket",method=RequestMethod.POST)
	public ModelAndView ViewTicket(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		//String id=(String) session.getAttribute("reservationId");
		Map<ReservationBean, List<PassengerBean>> m1 = new HashMap<>();
	 
		m1=customer.viewTicket(request.getParameter("rid"));
		/*Iterator itr= m1.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<ReservationBean, PassengerBean> pair= (Entry<ReservationBean, PassengerBean>)itr.next();
			System.out.println(pair.getKey().getReservationType()+" "+pair.getKey().getTotalFare() );
			System.out.println(pair.getValue().getName()+" "+pair.getValue().getGender());
		}*/
		
		return new ModelAndView("ViewTicket","ticket",m1);
	}


	@RequestMapping(value="printticket",method=RequestMethod.GET)
	public ModelAndView printTicket(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		//String id=(String) session.getAttribute("reservationId");
		Map<ReservationBean, List<PassengerBean>> m1 = new HashMap<>();
	 
		m1=customer.viewTicket(request.getParameter("rid"));
		/*Iterator itr= m1.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<ReservationBean, PassengerBean> pair= (Entry<ReservationBean, PassengerBean>)itr.next();
			System.out.println(pair.getKey().getReservationType()+" "+pair.getKey().getTotalFare() );
			System.out.println(pair.getValue().getName()+" "+pair.getValue().getGender());
		}*/
		
		return new ModelAndView("pdfView","ticket",m1);
	}


	@RequestMapping(value="DeleteFlight",method=RequestMethod.POST)
	public ModelAndView DeleteFlight(@ModelAttribute("FlightBean") FlightBean flightBean,BindingResult result){
		ArrayList flightids=new ArrayList<>();
		flightids.add(flightBean.getFlightID());
		int status=administrator.removeFlight(flightids);//// return result of flight ids deleteion////
		if(status ==1){
			return new ModelAndView("deleteFlight","message","FLIGHT DELETED");
	    }
	    else
	    	return new ModelAndView("deleteFlight","message","FLIGHT NOT DELETED");
	}
	
	
	
	@RequestMapping(value="changePassword",method=RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("CredentialsBean") CredentialsBean credentialsBean,HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		String userid=(String) session.getAttribute("UserId");
		String str=customer.changePassword(credentialsBean,req.getParameter("password"),userid);
		System.out.println(str);
		if(str.equalsIgnoreCase("Success")){
			return new ModelAndView("redirect:/loginpage.jsp");
		}
		else{
			return new ModelAndView("redirect:/ChangePassword.jsp");
		}
		
		    
	}
	
	
	@RequestMapping(value="Index",method=RequestMethod.GET)
	public ModelAndView Index(@ModelAttribute("CredentialsBean") CredentialsBean credentialsBean,HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		session.setAttribute("UserId",credentialsBean.getUserID());
		String str=customer.Login(credentialsBean);
		
		if(str.equalsIgnoreCase("a")){
			return new ModelAndView("redirect:/ChangePassword.jsp");
		}
		else{
			return new ModelAndView("redirect:/Index.jsp");
		}
		    
	}
	
	@RequestMapping(value="DeleteRoute",method=RequestMethod.POST)
	public ModelAndView DeleteRoute(@ModelAttribute("RouteBean") RouteBean routeBean,BindingResult result){
		routeids.add(routeBean.getRouteID());
		int status=administrator.removeRoute(routeids);//// return result of route ids deleteion////
		if(status ==1){
			return new ModelAndView("deleteRoute","message","ROUTE DELETED");
	    }
	    else
	    	return new ModelAndView("deleteRoute","message","ROUTE NOT DELETED");
		}
	
	
	@RequestMapping(value="DeleteSchedule",method=RequestMethod.POST)
	public ModelAndView DeleteSchedule(@ModelAttribute("ScheduleBean") ScheduleBean scheduleBean,BindingResult result){
		scheduleids.add(scheduleBean.getScheduleID());
		int status=administrator.removeSchedule(scheduleids);//// return result of schedule ids deleteion////
		if(status ==1){
			return new ModelAndView("deleteSchedule","message","SCHEDULE DELETED");
	    }
	    else
	    	return new ModelAndView("deleteSchedule","message","SCHEDULE NOT DELETED");
		}
	
	@RequestMapping(value="EditFlightmain",method=RequestMethod.POST)
	public ModelAndView editandsaveflights(@ModelAttribute("FlightBean")FlightBean flightBean){
		boolean status=administrator.modifyFlight(flightBean);
		String message="";
		if(status==true){
			System.out.println("printing from controller" );
			ArrayList<FlightBean> flightlists = new ArrayList<FlightBean>();
			flightlists=administrator.viewByAllFlights();
			Iterator<FlightBean> itr=  flightlists.iterator();
			if(itr.hasNext()==false){
				 message="No Flights currently available";
				return new ModelAndView("EditFlightMain","message",message);
			}
			
			else {
			while(itr.hasNext()){
				FlightBean flbean= new FlightBean();
				flbean= itr.next();
				System.out.println(flbean.getFlightID());
				System.out.println(flbean.getFlightName());
				System.out.println(flbean.getReservationCapacity());
				System.out.println(flbean.getSeatingCapacity());
			}
			
			return new ModelAndView("EditFlightMain","al",flightlists);
			}
		}
		else{
			 message="Something goes very wrong, please try later..";
			return new ModelAndView("EditFlightMain","message",message);
		}
	}
	
	@RequestMapping(value="modifyflight",method=RequestMethod.POST)
	public ModelAndView updateFlight(@ModelAttribute("FlightBean")FlightBean flightBean,HttpServletRequest req){
		
		System.out.println("Printing from modify flight in controller");
		System.out.println("--------------------------------------");
		String fid= flightBean.getFlightID();
		flightBean=administrator.viewByFlightId(fid);
		return new ModelAndView("EditFlight","flightBean",flightBean);
		
	}
	
	@RequestMapping(value="viewallFlight",method=RequestMethod.GET)
	public ModelAndView viewallFlight(){
		String msg="messgaghe";
		System.out.println("printing from controller" );
		ArrayList<FlightBean> flightlists = new ArrayList<FlightBean>();
		flightlists=administrator.viewByAllFlights();
		Iterator<FlightBean> itr=  flightlists.iterator();
		if(itr.hasNext()==false){
			String message="No Flights currently available";
			return new ModelAndView("ViewFlightt","message",message);
		}
		
		else {
		while(itr.hasNext()){
			FlightBean flbean= new FlightBean();
			flbean= itr.next();
			System.out.println(flbean.getFlightID());
			System.out.println(flbean.getFlightName());
			System.out.println(flbean.getReservationCapacity());
			System.out.println(flbean.getSeatingCapacity());
		}
		
		return new ModelAndView("ViewFlightt","al",flightlists);
		}
	}
	
	@RequestMapping(value="viewallFlightt",method=RequestMethod.GET)
	public ModelAndView viewallFlightt(){
		String msg="messgaghe";
		System.out.println("printing from controller" );
		ArrayList<FlightBean> flightlists = new ArrayList<FlightBean>();
		flightlists=administrator.viewByAllFlights();
		Iterator<FlightBean> itr=  flightlists.iterator();
		if(itr.hasNext()==false){
			String message="No Flights currently available";
			return new ModelAndView("ViewFlight","message",message);
		}
		
		else {
		while(itr.hasNext()){
			FlightBean flbean= new FlightBean();
			flbean= itr.next();
			System.out.println(flbean.getFlightID());
			System.out.println(flbean.getFlightName());
			System.out.println(flbean.getReservationCapacity());
			System.out.println(flbean.getSeatingCapacity());
		}
		
		return new ModelAndView("ViewFlight","al",flightlists);
		}
	}
	
	
	@RequestMapping(value="ViewRoute",method=RequestMethod.GET)
	public ModelAndView viewallRoute(){
		String msg="messgaghe";
		System.out.println("printing from controller" );
		ArrayList<RouteBean> routelists = new ArrayList<RouteBean>();
		routelists=administrator.viewByAllRoute();
		Iterator<RouteBean> itr=  routelists.iterator();
		if(itr.hasNext()==false){
			String message="No Routes currently available";
			return new ModelAndView("ViewRoute","message",message);
		}
		
		else {
		while(itr.hasNext()){
			RouteBean rbean= new RouteBean();
			rbean= itr.next();
			System.out.println(rbean.getRouteID());
			System.out.println(rbean.getSource());
			System.out.println(rbean.getDestination());
			System.out.println(rbean.getDistance());
			System.out.println(rbean.getFare());
		}
		
		return new ModelAndView("ViewRoute","al",routelists);
		}
	}
	
	
	@RequestMapping(value="ViewRoutee",method=RequestMethod.GET)
	public ModelAndView viewallRoutee(){
		String msg="messgaghe";
		System.out.println("printing from controller" );
		ArrayList<RouteBean> routelists = new ArrayList<RouteBean>();
		routelists=administrator.viewByAllRoute();
		Iterator<RouteBean> itr=  routelists.iterator();
		if(itr.hasNext()==false){
			String message="No Routes currently available";
			return new ModelAndView("ViewRoutee","message",message);
		}
		
		else {
		while(itr.hasNext()){
			RouteBean rbean= new RouteBean();
			rbean= itr.next();
			System.out.println(rbean.getRouteID());
			System.out.println(rbean.getSource());
			System.out.println(rbean.getDestination());
			System.out.println(rbean.getDistance());
			System.out.println(rbean.getFare());
		}
		
		return new ModelAndView("ViewRoutee","al",routelists);
		}
	}
	@RequestMapping(value="modifyroute",method=RequestMethod.POST)
	public ModelAndView updateRoute(@ModelAttribute("RouteBean")RouteBean routeBean,HttpServletRequest req){
		String rid= routeBean.getRouteID();
		routeBean= administrator.viewByRouteId(rid);
		return new ModelAndView("EditRoute","RouteBean",routeBean);
	}
	
	@RequestMapping(value="EditRoutemain",method=RequestMethod.POST)
	public ModelAndView editandsaveroutes(@ModelAttribute("RouteBean")RouteBean routeBean){
		boolean status= administrator.modifyRoute(routeBean);
		String message="";
		if(status==true){
			System.out.println("printing from controller" );
			ArrayList<RouteBean> routelists = new ArrayList<RouteBean>();
			routelists=administrator.viewByAllRoute();
			Iterator<RouteBean> itr=  routelists.iterator();
			if(itr.hasNext()==false){
				message="No Routes currently available";
				return new ModelAndView("ViewRoute","message",message);
			}
			
			else {
			while(itr.hasNext()){
				RouteBean rbean= new RouteBean();
				rbean= itr.next();
				System.out.println(rbean.getRouteID());
				System.out.println(rbean.getSource());
				System.out.println(rbean.getDestination());
				System.out.println(rbean.getDistance());
				System.out.println(rbean.getFare());
			}
			
			return new ModelAndView("ViewRoute","al",routelists);
			}
		}
		
		else{
			 message="Something goes very wrong, please try later..";
			return new ModelAndView("ViewRoute","message",message);
		}
	}
	
	@RequestMapping(value="viewallschedules",method=RequestMethod.GET)
	public ModelAndView viewallschedules(){
		String msg="messgaghe";
		System.out.println("printing from controller" );
		ArrayList<ScheduleBean> scheduleslists = new ArrayList<ScheduleBean>();
		scheduleslists=administrator.viewByAllSchedule();
		Iterator<ScheduleBean> itr=  scheduleslists.iterator();
		if(itr.hasNext()==false){
			String message="No Schedules currently available";
			return new ModelAndView("ViewSchedule","message",message);
		}
		
		else {
		while(itr.hasNext()){
			ScheduleBean sbean= new ScheduleBean();
			sbean= itr.next();
			System.out.println(sbean.getScheduleID());
			System.out.println(sbean.getFlightID());
			System.out.println(sbean.getRouteID());
			System.out.println(sbean.getTravelDuration());
			System.out.println(sbean.getAvailableDays());
			System.out.println(sbean.getDepartureTime().toString());
		}
		
		return new ModelAndView("ViewSchedule","al",scheduleslists);
		}
		
	}
	
	
	@RequestMapping(value="viewallschedulese",method=RequestMethod.GET)
	public ModelAndView viewallschedulese(){
		String msg="messgaghe";
		System.out.println("printing from controller" );
		ArrayList<ScheduleBean> scheduleslists = new ArrayList<ScheduleBean>();
		scheduleslists=administrator.viewByAllSchedule();
		Iterator<ScheduleBean> itr=  scheduleslists.iterator();
		if(itr.hasNext()==false){
			String message="No Schedules currently available";
			return new ModelAndView("ViewSchedulee","message",message);
		}
		
		else {
		while(itr.hasNext()){
			ScheduleBean sbean= new ScheduleBean();
			sbean= itr.next();
			System.out.println(sbean.getScheduleID());
			System.out.println(sbean.getFlightID());
			System.out.println(sbean.getRouteID());
			System.out.println(sbean.getTravelDuration());
			System.out.println(sbean.getAvailableDays());
			System.out.println(sbean.getDepartureTime().toString());
		}
		
		return new ModelAndView("ViewSchedulee","al",scheduleslists);
		}
		
	}
	
	@RequestMapping(value="modifyschedule",method=RequestMethod.POST)
	public ModelAndView updateschedules(@ModelAttribute("ScheduleBean")ScheduleBean scheduleBean,HttpServletRequest req){
		String sid= scheduleBean.getScheduleID();
		scheduleBean= administrator.viewByScheduleId(sid); 
		return new ModelAndView("EditSchedule","ScheduleBean",scheduleBean);
	}
	
	
	@RequestMapping(value="EditSchedulemain",method=RequestMethod.POST)
	public ModelAndView editandsaveschedules(@ModelAttribute("ScheduleBean")ScheduleBean scheduleBean){
		boolean status= administrator.modifySchedule(scheduleBean);
		String message="No Schedules currently available";
		if(status=true){
			ArrayList<ScheduleBean> scheduleslists = new ArrayList<ScheduleBean>();
			scheduleslists=administrator.viewByAllSchedule();
			Iterator<ScheduleBean> itr=  scheduleslists.iterator();
			if(itr.hasNext()==false){
				 message="No Schedules currently available";
				return new ModelAndView("Error","message",message);
			}
			
			else {
			while(itr.hasNext()){
				ScheduleBean sbean= new ScheduleBean();
				sbean= itr.next();
				System.out.println(sbean.getScheduleID());
				System.out.println(sbean.getFlightID());
				System.out.println(sbean.getRouteID());
				System.out.println(sbean.getTravelDuration());
				System.out.println(sbean.getAvailableDays());
				System.out.println(sbean.getDepartureTime().toString());
			}
			
			return new ModelAndView("ViewSchedule","al",scheduleslists);
			}
				
		}
		
		
		else 
			return new ModelAndView("Error","message",message);
	}
	
	
}

	

