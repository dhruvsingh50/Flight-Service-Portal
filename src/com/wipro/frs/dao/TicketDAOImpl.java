package com.wipro.frs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;

@Repository
public class TicketDAOImpl implements TicketDAO {
	@Autowired
	private  SessionFactory sessionFactory;
	
	
	
	@Override
	public Map<ReservationBean, List<PassengerBean>> viewTicket(String reservationId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(reservationId);
		Map<ReservationBean, List<PassengerBean>> m1 = new HashMap<>();
		PassengerBean passengerBean=new PassengerBean();
		
		ReservationBean reservationBean=new ReservationBean();
		
		String sql1="from PassengerBean p where p.reservationID=? ";
		Query qry= session.createQuery(sql1);
		qry.setParameter(0, reservationId);
		List<PassengerBean> l1= qry.list();
		Iterator it=l1.iterator();
		PassengerBean pb = null;
		while(it.hasNext()){
			Object obj = (Object) it.next();
			pb = (PassengerBean) obj;
			System.out.println("dfdfdf"+pb);
		}
		
		System.out.println("print from ticket dao"+l1);
	
		
		String sql2="from ReservationBean as r where r.reservationID=?";
		Query qry2= session.createQuery(sql2);
		qry2.setParameter(0, reservationId);
		
		List<ReservationBean> l2=qry2.list();
		Iterator itr2=l2.iterator();
		if(itr2.hasNext()){
			reservationBean=(ReservationBean) itr2.next();
			m1.put(reservationBean, l1);
		}
	
		
		
		
		/*System.out.println(m1.get(reservationBean).getName());
		System.out.println(m1.get(reservationBean).getSeatNo());
		System.out.println(m1.get(reservationBean).getAge());*/
		return m1;
	}

	@Override
	public Map<ReservationBean, PassengerBean> printTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
