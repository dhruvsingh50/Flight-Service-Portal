package com.wipro.frs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
@Repository
public class FlightDAOImpl implements FlightDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String createFlight(FlightBean flightBean) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query qry= session.createSQLQuery("Insert into FRS_TBL_Flight values(?,?,?,?)");
		
		
		qry.setParameter(0, flightBean.getFlightID());
		qry.setParameter(1, flightBean.getFlightName());
		qry.setParameter(2, flightBean.getSeatingCapacity());
		qry.setParameter(3, flightBean.getReservationCapacity());
		int i = qry.executeUpdate();
		session.getTransaction().commit();
		session.close();
		if(i>=1){
			return "success";
		}
		else 
		return "false";
	}
	
	/*public int fseqgen(){
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createSQLQuery("select FRS_SEQ_FLIGHT_ID.nextval as fidseq");
		
		 return ((Integer) qry.uniqueResult()).intValue();
		 
		
	}*/

	@Override
	public boolean updateFlight(FlightBean flightBean) {
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("update FlightBean set flightName=?,seatingCapacity=?,reservationCapacity=? where flightID=?");
		qry.setParameter(0, flightBean.getFlightName());
		qry.setParameter(1, flightBean.getSeatingCapacity());
		qry.setParameter(2, flightBean.getReservationCapacity());
		qry.setParameter(3, flightBean.getFlightID());
		int i = qry.executeUpdate();
		session.getTransaction().commit();
		session.close();
		if(i>=1){
			return true;
		}
		else
		return false;
	}

	@Override
	public int deleteFlight(ArrayList<String> flightId) {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		int i=1;
		session.beginTransaction();
		Iterator<String> itr= flightId.iterator();
		while(itr.hasNext()){
		Query qry= session.createQuery("Delete FlightBean where flightID=? ");
		qry.setParameter(0, itr.next());
		i=qry.executeUpdate();
		}
		session.getTransaction().commit();
		session.close();
		return i;
	}

	@Override
	public FlightBean FindByFlightId(String flightId) {
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		FlightBean flightBean=null;
		session.beginTransaction();
		Query qry= session.createQuery("from FlightBean where flightID=?");
		qry.setParameter(0, flightId);
		List<FlightBean> l1=qry.list();
		Iterator itr=l1.iterator();
		if(itr.hasNext()){
			flightBean=(FlightBean) itr.next();
		}
		session.getTransaction().commit();
		session.close();
		return flightBean;
	}

	@Override
	public ArrayList<FlightBean> FindAllFlights() {
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		FlightBean flightBean=null;
		session.beginTransaction();
		Query qry= session.createQuery("from FlightBean");
		ArrayList<FlightBean> al= (ArrayList<FlightBean>) qry.list();
		return al;
	}

	@Override
	public ArrayList<PassengerBean> viewPassengerByFlight(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fseqgen() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int no=0;
		BigDecimal bg=null;
		Query qry= session.createSQLQuery("select FRS_SEQ_FLIGHT_ID.nextval as ridseq from dual");
		List li=qry.list();
		Iterator it=li.iterator();
		if(it.hasNext()){
			bg=(BigDecimal) it.next();
		}
		no=bg.intValueExact();
		System.out.println(no);
	 return no;
	}

}
