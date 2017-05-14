package com.wipro.frs.dao;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.ScheduleBean;
@Repository
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String CreateReservation(ReservationBean resevationBean) {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  Query query=session.createSQLQuery("insert into  FRS_TBL_Reservation values(?,?,?,?,?,?,?,?,?)");
		  query.setParameter(0, resevationBean.getReservationID());
		  query.setParameter(1, resevationBean.getUserID());
		  query.setParameter(2, resevationBean.getScheduleID());
		  query.setParameter(3, resevationBean.getReservationType());
		  query.setParameter(4, resevationBean.getBookingDate());
		  query.setParameter(5, resevationBean.getJourneyDate());
		  query.setParameter(6, resevationBean.getNoOfSeats());
		  query.setParameter(7, resevationBean.getTotalFare());
		  query.setParameter(8, resevationBean.getBookingStatus());
		  int i=query.executeUpdate();
		 session.getTransaction().commit();
		 
		  if(i==1){
			  return "success";
		  }
		  else{
			  
			  return "failure";
		  }
	}

	@Override
	public int GetReservartionSeq() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int no=0;
		BigDecimal bg=null;
		Query qry= session.createSQLQuery("select FRS_SEQ_RESERVATION_ID.nextval as ridseq from dual");
		List li=qry.list();
		Iterator it=li.iterator();
		if(it.hasNext()){
			bg=(BigDecimal) it.next();
		}
		no=bg.intValueExact();
		System.out.println(no);
	 return no;
	}

	@Override
	public int cancelTicket(String reservationId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query q=session.createQuery(" FROM ReservationBean  WHERE reservationId=?");
		q.setString(0, reservationId);
		Object o = q.uniqueResult();
		ReservationBean rb =(ReservationBean)o;
		if(rb==null)
			return 0;
		else{
		int seats =rb.getNoOfSeats();
		System.out.println("seats reserved :"+ seats);
		String sid=rb.getScheduleID();
		System.out.println("sid is :"+sid);
		Query query1=session.createQuery("FROM ScheduleBean  WHERE scheduleId=?");	
		query1.setString(0, sid);
		Object o1 = query1.uniqueResult();
		ScheduleBean sb =(ScheduleBean)o1;
		String fid=sb.getFlightID();
		System.out.println("fid is "+fid);
		
		Query query2=session.createQuery("FROM FlightBean  WHERE flightId=?");
		query2.setString(0, fid);
		System.out.println("jsdfhkj: "+fid);
		Object o2 = query2.uniqueResult();
		FlightBean fb =(FlightBean)o2;
		System.out.println(fb);
		int rc=fb.getReservationCapacity();
		
		System.out.println("old reservation capacity: "+rc);
		int tseat=rc+seats;
		fb.setReservationCapacity(tseat);
		
		session.update(fb);
		Query qry= session.createQuery("from PassengerBean where Reservationid=?");
		qry.setParameter(0, reservationId);
		List l=qry.list();
		Iterator<PassengerBean> iterator = l.iterator();
		int i=l.size();
				Query query6= session.createQuery("DELETE FROM ReservationBean as r WHERE r.reservationID=?");
				query6.setParameter(0, reservationId);
				query6.executeUpdate();
	
			
		
		session.getTransaction().commit();
		session.close();
		return i;
		}
		
	}

}
