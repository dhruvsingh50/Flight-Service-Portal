package com.wipro.frs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.frs.bean.*;


@Repository("profileDAO")
public class ProfileDAOImpl implements ProfileDAO {
	
	
   @Autowired 
   private SessionFactory sessionFactory;
   
   public String createProfile(ProfileBean pBean) 
   
	   
   {

		Session session=sessionFactory.openSession();
       session.beginTransaction();
      
       try{
           session.save(pBean);
		    session.getTransaction().commit();
		    return pBean.getUserID();
          }
		catch(HibernateException e)
		   {
			System.out.println(e);
			return null;
	   	   }
       finally{
		    session.close();
              }
	
	  }

	public String deleteProfile(String userId) 
	  {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		ProfileBean pb = (ProfileBean) session.load(ProfileBean.class, userId);
		session.delete(pb);
		session.getTransaction().commit();
		pb=(ProfileBean) session.get(ProfileBean.class, userId);
		session.close();
		
		if(pb == null)
		  {
			return "Success";
		  }
		else
		  {
			return "Failure";
		  }
	  }

	public boolean updateProfile(ProfileBean pbean)
	  {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		try{
			session.update(pbean);
			session.getTransaction().commit();
			
			return true;
		  }
		catch(HibernateException e)
		{
       	return false;
	    }
		 finally{
			session.close();
		 }
	  }
	public ProfileBean findByID(String userID) 
	 {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		
		
		return null;
	 }

	public ArrayList<ProfileBean> findAll() {
		
		return null;
	}

	@Override
	public int deleteProfile(ArrayList<String> arlProfile) {
		
		return 0;
	}

	@Override
	public int rseqgen() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int no=0;
		BigDecimal bg=null;
		Query qry= session.createSQLQuery("select FRS_SEQ_USER_ID.nextval as ridseq from dual");
		List li=qry.list();
		Iterator it=li.iterator();
		if(it.hasNext()){
			bg=(BigDecimal) it.next();
		}
		no=bg.intValueExact();
	 return no;
	}
	
}
