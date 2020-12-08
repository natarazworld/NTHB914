package com.nt.test;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LockingAppTest2 {

	public static void main(String[] args) {
		// get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			tx=ses.beginTransaction();
		  //Load object
			InsurancePolicy policy=ses.get(InsurancePolicy.class,9001L,LockMode.UPGRADE_NOWAIT);
			System.out.println(policy);
			//modify the object
			  policy.setTenure(24);
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
