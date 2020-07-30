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
			policy=ses.load(InsurancePolicy.class,9001L);
			System.out.println(policy.getClass()+"   "+policy.getClass().getSuperclass());
			 System.out.println(policy.getPolicyId());
			 System.out.println(policy.getCompany());
			 System.out.println(policy.getTenure());
			 System.out.println(policy.getClass()+"   "+policy.getClass().getSuperclass());
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
