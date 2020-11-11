package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
				PhoneNumber ph1=new PhoneNumber(7989999L,"residence","airtel");
				PhoneNumber ph2=new PhoneNumber(66868888L,"officee","jio");
			    PhoneNumber phonesArray[]=new PhoneNumber[] {ph1,ph2};
				  //parent obj
				 UserInfo user=new UserInfo("mahesh","hyd");
				 //set childs to parent
				 user.setPhones(phonesArray);
				
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
			UserInfo user=ses.get(UserInfo.class,1);
			//get All childs of a Parent 
			PhoneNumber[] childs=user.getPhones();
			System.out.println(childs.length);
			//delete  specific child element through index from the list colleciton
			  childs[1]=null;
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
