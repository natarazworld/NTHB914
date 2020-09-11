package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=ses.get(InsurancePolicy.class,9001L);
			//verify
			if(policy==null)
				System.out.println("Record not found");
			else {
				System.out.println("Record found  and displayed");
				System.out.println(policy);
			}
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objs 
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
