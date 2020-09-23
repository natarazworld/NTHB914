package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=(InsurancePolicy) ses.get(InsurancePolicy.class,9001L);
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
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
