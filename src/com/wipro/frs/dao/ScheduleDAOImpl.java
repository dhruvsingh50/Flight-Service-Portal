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

import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{
	@Autowired
	private  SessionFactory sessionFactory;
	

	@Override
	public String createSchedule(ScheduleBean scheduleBean) {
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createSQLQuery("Insert into FRS_TBL_SCHEDULE values(?,?,?,?,?,?)");	
		qry.setParameter(0, scheduleBean.getScheduleID());
		qry.setParameter(1, scheduleBean.getFlightID());
		qry.setParameter(2, scheduleBean.getRouteID());
		qry.setParameter(3, scheduleBean.getTravelDuration());
		qry.setParameter(4, scheduleBean.getAvailableDays());
		qry.setParameter(5, scheduleBean.getDepartureTime());
		int i = qry.executeUpdate();
		session.getTransaction().commit();
		session.close();
		if(i>=1){
			return "success";
		}
		else 
			return "failure";
		
    

}

	@Override
	public int sseqgen(){
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int no=0;
		BigDecimal bg=null;
		Query qry= session.createSQLQuery("select FRS_SEQ_SCHEDULE_ID.nextval as ridseq from dual");
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
	public boolean updateSchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry = session.createQuery("update ScheduleBean as s set s.flightID=?,s.routeID=?,s.travelDuration=?,s.availableDays=?,s.departureTime=? where s.scheduleID=?");
		qry.setParameter(0, scheduleBean.getScheduleID());
		qry.setParameter(1, scheduleBean.getFlightID());
		qry.setParameter(2, scheduleBean.getRouteID());
		qry.setParameter(3, scheduleBean.getTravelDuration());
		qry.setParameter(4, scheduleBean.getAvailableDays());
		qry.setParameter(5, scheduleBean.getDepartureTime());
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
	public int deleteSchedule(ArrayList<String> scheduleId) {
		// TODO Auto-generated method stub
		
	int i=0;
	//Session session =DBUtil.getdbcon();
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Iterator<String> itr=scheduleId.iterator();
	while(itr.hasNext()){
	Query qry = session.createQuery("Delete ScheduleBean as s where s.scheduleID=?");
	qry.setParameter(0, itr.next());
	i=qry.executeUpdate();
	}
	session.getTransaction().commit();
	session.close();
	return i;
	
	}

	@Override
	public ScheduleBean FindByScheduleId(String scheduleId) {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		ScheduleBean scheduleBean=null;
		session.beginTransaction();
		Query qry= session.createQuery("from ScheduleBean as s where s.scheduleID=?");
		qry.setParameter(0, scheduleId);
		List<ScheduleBean> li= qry.list();
		Iterator<ScheduleBean> it= li.iterator();
		if(it.hasNext()){
			scheduleBean= it.next();
		}
		session.getTransaction().commit();
		session.close();
		return scheduleBean;
	}

	@Override
	public ArrayList<ScheduleBean> FindAllSchedules() {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("from ScheduleBean");
		ArrayList<ScheduleBean> al= (ArrayList<ScheduleBean>) qry.list();
		session.getTransaction().commit();
		session.close();
		return al;
	}

	@Override
	public List<ScheduleBean> checkday(String day) {
		System.out.println("inside checkday");
		System.out.println(day);
		ScheduleBean schedule =new ScheduleBean();
		List<ScheduleBean> list = new ArrayList<ScheduleBean>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("from ScheduleBean as s where s.availableDays=?");
		qry.setParameter(0, day);
		List<ScheduleBean> li= qry.list();
		Iterator<ScheduleBean> it= li.iterator();
		while(it.hasNext()){
			schedule= it.next();
			list.add(schedule);
		}
		session.getTransaction().commit();
		session.close();
		System.out.println("end of check day "+list);
		return list;
	}
}