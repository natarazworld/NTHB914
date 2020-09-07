package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest1 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null,policy1=null;
		Transaction tx=null;
		boolean flag=false;
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
				tx=ses.beginTransaction();
				   policy.setTenure(11);
				   ses.update(policy);
				   policy.setTenure(31);
				   policy.setPolicyType("home");
				   ses.update(policy);
				   flag=true;
			}
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
			 //Tx Mgmt
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
	}
}
