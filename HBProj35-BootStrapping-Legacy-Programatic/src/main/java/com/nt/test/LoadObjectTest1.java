package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=ses.load(InsurancePolicy.class,3001L);
			if(policy==null)
				System.out.println("record not found");
			else
			   System.out.println(policy);
		}//try
		catch(HibernateException he) {
			System.out.println("record not found---");
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
