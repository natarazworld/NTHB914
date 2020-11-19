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
	public void saveDataUsingParent() {
		//get Session
				Session ses=HibernateUtil.getSession();
				//prepare objects
				  //parent obj
				 UserInfo user=new UserInfo("anil","vizag");
				  //child objs
				PhoneNumber ph1=new PhoneNumber(6799999L,"personal","airtel");
				PhoneNumber ph2=new PhoneNumber(6878888L,"office","vi");
				 //set parent to childs
				 ph1.setUser(user);
				 ph2.setUser(user);
				 //set childs to parent
				Set<PhoneNumber> phonesSet=Set.of(ph1,ph2);
				user.setPhones(phonesSet);
				Transaction tx=null;
				boolean flag=false;
				try {
					//begin Tx
					if(!ses.getTransaction().isActive())
						 tx=ses.beginTransaction();
					//save objs
					ses.save(user);
					  flag=true;
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				finally {
					//Tx Mgmt
					if(flag) {
						tx.commit();
						System.out.println("parent to child objs are saved");
					}
					else {
						tx.rollback();
						System.out.println("parent to child objs are not saved");
					}
						//close session factory
					HibernateUtil.closeSessionFactory();
				}//finally

	}//method

	@Override
	public void saveDataUsingChilds() {
		//get Session
		Session ses=HibernateUtil.getSession();
		//prepare objects
		  //parent obj
		 UserInfo user=new UserInfo("jani","mumbai");
		  //child objs
		PhoneNumber ph1=new PhoneNumber(16799999L,"personal","airtel");
		PhoneNumber ph2=new PhoneNumber(2378888L,"office","vi");
		 //set parent to childs
		 ph1.setUser(user);
		 ph2.setUser(user);
		 //set childs to parent
		Set<PhoneNumber> phonesSet=Set.of(ph1,ph2);
		user.setPhones(phonesSet);
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//save objs
			ses.save(ph1);ses.save(ph2);
			  flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			//Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println("parent to child objs are saved");
			}
			else {
				tx.rollback();
				System.out.println("parent to child objs are not saved");
			}
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}

	@Override
	public void loadDataUsingParent() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load parent object
		  Query query=ses.createQuery("from UserInfo");
			List<UserInfo> list=query.getResultList();
			list.forEach(user->{
				System.out.println("parent::"+user.getUserId()+"  "+user.getUsername()+"  "+user.getAddrs());
				//get associated childs of a parent
				Set<PhoneNumber> childs=user.getPhones();
				System.out.println(childs.isEmpty());
				childs.forEach(ph->	System.out.println("child :"+ph));
			});
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
	
	}//method
	
	@Override
	public void loadDataUsingChild() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//execute QBC logic 
			Query query=ses.createQuery("from PhoneNumber");
			List<PhoneNumber> list=query.getResultList();
			list.forEach(ph->{
				System.out.println("child::"+ph);
				UserInfo user=ph.getUser();
				System.out.println("Parent ::"+user);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//method
}//class
