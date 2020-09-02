package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileCustomer;
import com.nt.utility.HibernateUtil;

public class VersionModifyTest {

	public static void main(String[] args) {
		Session ses=null;
		MobileCustomer customer=null;
		Transaction tx=null;
		boolean flag=false;
			
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 tx=ses.beginTransaction();	
	    //Load object 
		customer=ses.get(MobileCustomer.class,6);
		if(customer!=null) {
			 System.out.println(customer);
			 customer.setCallerTune("DIL DIL");
			 flag=true;
		}
		else
			System.out.println("record not found");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("object is modified");
				 System.out.println("Object is modified for :: "+customer.getVersionCount()+" times");
			}
			else {
				tx.rollback();
				System.out.println("Object is not modified");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class

