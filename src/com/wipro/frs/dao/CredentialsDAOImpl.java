package com.wipro.frs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.FlightBean;
@Repository
public class CredentialsDAOImpl implements CredentialsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String createCredentials(CredentialsBean credentialsBean) {
		 
		Session session= sessionFactory.openSession();
		session.beginTransaction();	
		System.out.println("inside create credentials");
		System.out.println(credentialsBean.getUserID()+" "+credentialsBean.getPassword()+" "+credentialsBean.getUserType()+" "+credentialsBean.getLoginStatus());
		try{
			 session.save(credentialsBean);
			    session.getTransaction().commit();
			    return "success";
		}
		catch(HibernateException e)
		   {
			System.out.println(e);
			return "failure";
	   	   }
    finally{
		    session.close();
           }
	
		
	}
	
	@Override
	public boolean updateCredentials (CredentialsBean credentialsBean) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("update CredentialsBean set Password=?,Usertype=?,Loginstatus where Userid=?");
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
	public int deleteCredentials (String userID) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("DELETE FROM CredentialsBean as c WHERE c.Userid=?");
		query.setParameter(0, userID);
		int i=query.executeUpdate();
		((Transaction) session).commit();
		  if(i==1){
			  return 1;
		  }
		  else{
			  return 0;
		  }
	}

	@Override
	public String findSequenceID () {
		String result = "NULLUSERID";
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createSQLQuery("Select from FRS_SEQ_USER_ID.nextval from dual");
		return result;
	}
	
	@Override
	public ArrayList<CredentialsBean> FindAll() {
		//Session session =DBUtil.getdbcon();
		Session session=sessionFactory.openSession();
		CredentialsBean credentialsBean=null;
		session.beginTransaction();
		Query qry= session.createQuery("from CredentialsBean");
		ArrayList<CredentialsBean> al= (ArrayList<CredentialsBean>) qry.list();
		return al;
	}
	@Override
	public CredentialsBean findByID (String id) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	CredentialsBean cb;
	Query qry= session.createQuery("from CredentialsBean where ");
	return null;
	
		
		
	}

	@Override
	public String login(CredentialsBean credentialsBean) {
		
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		String hql = "from CredentialsBean where userID=? and password=? ";
		Query query = s.createQuery(hql);
		query.setString(0, credentialsBean.getUserID());
		
		query.setString(1, credentialsBean.getPassword());
		CredentialsBean cb =(CredentialsBean)query.uniqueResult();
		if(cb==null)
		{
			s.close();
			return "fail";
		}
		else
		{
			
				cb.setLoginStatus(1);
				s.update(cb);
				s.getTransaction().commit();
				s.close();
				return cb.getUserType();
			
		}
	}
	@Override
	public boolean logout(String userId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//CredentialsBean cb =(CredentialsBean)session.load(CredentialsBean.class, userId);
		//cb.setLoginStatus(0);
		//session.update(cb);
		Query qry= session.createQuery("update CredentialsBean set loginStatus=? where Userid=?");
		qry.setParameter(0, 0);
		qry.setParameter(1, userId);
		qry.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	@Override
	public String changePassword(CredentialsBean credentialsBean,
			String newPassword,String userid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String hql = "from CredentialsBean where userID=?";
		Query query = session.createQuery(hql);
		query.setString(0,userid);
		List l=query.list();
		Iterator it=l.iterator();
		if(it.hasNext()){
				Query qry= session.createQuery("update CredentialsBean set Password=? where Userid=?");
				qry.setParameter(0, credentialsBean.getPassword());
				qry.setParameter(1, userid);
				qry.executeUpdate();
				session.getTransaction().commit();
			}
		if(credentialsBean.getPassword().equals(newPassword))
		{
			session.close();
			return "SUCCESS";
		}
		else
		{
			session.close();
			return "FAILURE";
		}
	}
	
}

	

