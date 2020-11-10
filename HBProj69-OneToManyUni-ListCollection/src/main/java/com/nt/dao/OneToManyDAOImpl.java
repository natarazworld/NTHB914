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
				  //child objs
				PhoneNumber ph1=new PhoneNumber(7999999L,"residence","airtel");
				PhoneNumber ph2=new PhoneNumber(68888888L,"officee","vi");
				List<PhoneNumber> phonesList=List.of(ph1, ph2);
				  //parent obj
				 UserInfo user=new UserInfo("suresh","hyd");
				 //set childs to parent
				 user.setPhones(phonesList);
				
				Transaction tx=null;
				boolean flag=false;
				try {
					//begin Tx
					if(!ses.getTransaction().isActive())
						 tx=ses.beginTransaction();
					//save objs
					  ses.save(user);
					//ses.persist(user);
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
	public void deleteOneChildFromCollectionOfChildsBelogingToAParent() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//Load  parent object
			UserInfo user=ses.get(UserInfo.class,2);
			//get All childs of a Parent 
			List<PhoneNumber> childs=user.getPhones();
			//delete  specific child element through index from the list colleciton
			  childs.remove(0);
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
				System.out.println("one child from collection of childs is deleted");
			}
			else {
				tx.rollback();
				System.out.println("one child from collection of childs is not deleted");
			}
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}

	
}//class
