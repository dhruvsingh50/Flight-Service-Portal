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
public class RouteDAOImpl implements RouteDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public String createRoute(RouteBean routeBean) {

		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createSQLQuery("Insert into FRS_TBL_ROUTE values(?,?,?,?,?)");
		qry.setParameter(0, routeBean.getRouteID());
		qry.setParameter(1, routeBean.getSource());
		qry.setParameter(2, routeBean.getDestination());
		qry.setParameter(3, routeBean.getDistance());
		qry.setParameter(4, routeBean.getFare());
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
	public int rseqgen(){
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int no=0;
		BigDecimal bg=null;
		Query qry= session.createSQLQuery("select FRS_SEQ_ROUTE_ID.nextval as ridseq from dual");
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
	public boolean updateRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry = session.createQuery("update RouteBean set source=?,destination=?,distance=?,fare=? where routeID=?");
		qry.setParameter(0, routeBean.getSource());
		qry.setParameter(1, routeBean.getDestination());
		qry.setParameter(2, routeBean.getDistance());
		qry.setParameter(3, routeBean.getFare());
		qry.setParameter(4, routeBean.getRouteID());
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
	public int deleteRoute(ArrayList<String> routeId) {
		// TODO Auto-generated method stub
		int i=1;
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Iterator<String> itr=routeId.iterator();
		while(itr.hasNext()){
		Query qry = session.createQuery("Delete RouteBean where routeID=?");
		qry.setParameter(0, itr.next());
		i=qry.executeUpdate();
		}
		session.getTransaction().commit();
		session.close();
		return i;
	}

	@Override
	public RouteBean FindByRouteId(String routeId) {
		// TODO Auto-generated method stub
	//	Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		RouteBean routeBean=null;
		session.beginTransaction();
		Query qry= session.createQuery("from RouteBean where routeID=?");
		qry.setParameter(0, routeId);
		List<RouteBean> li= qry.list();
		Iterator<RouteBean> it= li.iterator();
		if(it.hasNext()){
			routeBean= it.next();
		}
		session.getTransaction().commit();
		session.close();
		return routeBean;
	}

	@Override
	public ArrayList<RouteBean> FindAllRoutes() {
		// TODO Auto-generated method stub
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("from RouteBean");
		ArrayList<RouteBean> al= (ArrayList<RouteBean>) qry.list();
		session.getTransaction().commit();
		session.close();
		return al;
	}
	@Override
	public List<String> findRouteID(String source, String destination) {
		System.out.println("inside find routrID"+ source +" "+destination);
		RouteBean route = null;
		List<String> list = new ArrayList<>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("from RouteBean as s where s.source=? and s.destination=?");
		qry.setParameter(0, source);
		qry.setParameter(1, destination);

		List<RouteBean> li= qry.list();
		Iterator<RouteBean> it= li.iterator();
		while(it.hasNext()){
			route= it.next();
			list.add(route.getRouteID());
		}
		session.getTransaction().commit();
		session.close();
		System.out.println("end of findroutr" +list);
		return list;
	}

}
