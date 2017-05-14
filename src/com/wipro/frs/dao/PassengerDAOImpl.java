package com.wipro.frs.dao;
import com.wipro.frs.bean.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import com.wipro.frs.bean.PassengerBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PassengerDAOImpl implements PassengerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public PassengerBean viewPassenger(String reservationId) {
		// TODO Auto-generated method stub
		PassengerBean pb = null;
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  Query query=session.createQuery("from PassengerBean as p where p.reservationId=?");
		  query.setParameter(0, reservationId);
		  List<PassengerBean> l=query.list();
		  Iterator it=l.iterator();
		  if(it.hasNext()){
			  pb=(PassengerBean) it.next();
			  
		  }
		  return pb;
		  
	}

	@Override
	public String createPassenger(PassengerBean passengerBean) {
		// TODO Auto-generated method
		//Session session =DBUtil.getdbcon();
		int s=1;
		passengerBean.setSeatNo(s);
		s++;
		Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  Query query=session.createSQLQuery("insert into FRS_TBL_Passenger (RESERVATIONID,NAME,GENDER,AGE,SEATNO) values(?,?,?,?,?)");
		  query.setParameter(0, passengerBean.getReservationID());
		  query.setParameter(1, passengerBean.getName());
		  query.setParameter(2, passengerBean.getGender());
		  query.setParameter(3, passengerBean.getAge());
		  query.setParameter(4, passengerBean.getSeatNo());
		  
		  int i=query.executeUpdate();
		  session.getTransaction().commit();
		  //int i=(Integer) session.save(passengerBean);
		  if(i==1){
			  return "success";
		  }
		  else{
			  return "failure";
		  }
	}

	@Override
	public int deletePassenger(String reservationId) {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("DELETE FROM PassengerBean  WHERE reservationId=?");
		query.setParameter(0,reservationId);
		int i=query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		  if(i==1){
			  return 1;
		  }
		  else{
			  return 0;
		  }
	}

	@Override
	public ArrayList<PassengerBean> FindAll() {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  Query query=session.createQuery("from PassengerBean as p");
		  ArrayList<PassengerBean> l=(ArrayList<PassengerBean>) query.list();
		 return l;
	}

}
