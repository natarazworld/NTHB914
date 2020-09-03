package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileCustomer;
import com.nt.utility.HibernateUtil;

public class VersionInsertionTest {

	public static void main(String[] args) {
		Session ses=null;
		MobileCustomer customer=null;
		Transaction tx=null;
		boolean flag=false;
		Integer idVal=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		customer=new MobileCustomer();
		customer.setCname("suresh"); customer.setMobileNo(8888888888L);
		customer.setCallerTune("DIL Pukare");
		try {
			//begin Tx
			 tx=ses.beginTransaction();
			    idVal=(Integer)ses.save(customer);
			    System.out.println("generated id Value::"+idVal);
			 flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("object is saved, Object version::"+customer.getVersionCount());
				
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class

