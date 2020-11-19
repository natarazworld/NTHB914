package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void loadDataUsingParentToChildHQLJoins() {
		
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//execute HQL query
			 // Query query=ses.createQuery("select u.userId,u.username,u.addrs,ph.regNo,ph.phone,ph.type,ph.provider from  UserInfo u inner join u.phones ph");
			 // Query query=ses.createQuery("select u.userId,u.username,u.addrs,ph.regNo,ph.phone,ph.type,ph.provider from  UserInfo u left join u.phones ph");
			 // Query query=ses.createQuery("select u.userId,u.username,u.addrs,ph.regNo,ph.phone,ph.type,ph.provider from  UserInfo u right join u.phones ph");
			Query query=ses.createQuery("select u.userId,u.username,u.addrs,ph.regNo,ph.phone,ph.type,ph.provider from  UserInfo u full join u.phones ph");
			  
			  List<Object[]> list=query.getResultList();
			  list.forEach(row->{
				  for(Object val:row)
					  System.out.print(val+"  ");
				  System.out.println();
			  });
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSessionFactory();
		}
		
	}//method

	@Override
	public void loadDataUsingChildToParentHQLJoins() {
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//execute HQL query
			//Query query=ses.createQuery("select ph.regNo,ph.phone,ph.type,ph.provider,u.userId,u.username,u.addrs from  PhoneNumber ph inner join  ph.user u");
			//Query query=ses.createQuery("select ph.regNo,ph.phone,ph.type,ph.provider,u.userId,u.username,u.addrs from  PhoneNumber ph left join  ph.user u");
			//Query query=ses.createQuery("select ph.regNo,ph.phone,ph.type,ph.provider,u.userId,u.username,u.addrs from  PhoneNumber ph right join  ph.user u");
			Query query=ses.createQuery("select ph.regNo,ph.phone,ph.type,ph.provider,u.userId,u.username,u.addrs from  PhoneNumber ph full join  ph.user u");

			  
			  List<Object[]> list=query.getResultList();
			  list.forEach(row->{
				  for(Object val:row)
					  System.out.print(val+"  ");
				  System.out.println();
			  });
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSessionFactory();
		}
		
	}

}//class
