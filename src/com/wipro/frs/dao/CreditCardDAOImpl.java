package com.wipro.frs.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.frs.bean.CreditCardBean;

@Repository
public class CreditCardDAOImpl implements CreditCardDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean updateCreditCard(String creditCardNumber, double balance) {
		// TODO Auto-generated method stub
		
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("update CreditCardBean as c set  c.CreditBalance=? where c.CreditCardNumber=?");
		qry.setParameter(0, balance);
		qry.setParameter(1, creditCardNumber);
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
	public double validateCreditCard(CreditCardBean bean, String userid) {
		// TODO Auto-generated method stub
		System.out.println("inside validate credit card "+ bean + "userid id" +userid);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query qry= session.createQuery("from CreditCardBean as c where c.CreditCardNumber=? and c.ValidFrom=? and c.ValidTo=? and c.UserId=? ");
		double balance=-1;
		//qry.setParameter(0, bean.getCreditBalance());
		qry.setParameter(0, bean.getCreditCardNumber());
		qry.setParameter(1, bean.getValidFrom());
		qry.setParameter(2, bean.getValidTo());
		qry.setParameter(3, userid);
	
		List<CreditCardBean> l=qry.list();
		Iterator it=l.iterator();
		if(it.hasNext()){
			CreditCardBean cbean=(CreditCardBean) it.next();
			balance=cbean.getCreditBalance();
		}
		return balance;	}
	
	

}
