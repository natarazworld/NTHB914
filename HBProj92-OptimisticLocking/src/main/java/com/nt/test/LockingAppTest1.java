package com.nt.test;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LockingAppTest1 {

	public static void main(String[] args) {
		// get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			tx=ses.beginTransaction();
		  //Load object
			InsurancePolicy policy=ses.get(InsurancePolicy.class,9001L);
			System.out.println(policy);
			  Thread.sleep(30000); // In This sleep time , run the second App
			//modify the object
			  policy.setTenure(30);
			  flag=true;
		}//try
		catch(HibernateException he) {
			 flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			//perform TxMgmt
			if(flag) {
				tx.commit();
				System.out.println("Object updated");
			}
			else {
				tx.rollback();
				System.out.println("Object not updated");
			}
			HibernateUtil.closeSession(ses);	
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
