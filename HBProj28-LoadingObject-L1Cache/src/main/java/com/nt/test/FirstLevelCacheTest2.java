package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null,policy1=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=ses.get(InsurancePolicy.class,9001L); //gets from DB and puts in L1 cache
			System.out.println("1"+policy);
			System.out.println("............................");
			policy1=ses.get(InsurancePolicy.class,9001L);  //gets from L1 cache
			System.out.println("2"+policy1);
			System.out.println("...................................");
			ses.evict(policy);   //removes from L1 cache
			policy1=ses.get(InsurancePolicy.class,9001L);  //gets from DB  and puts in L1 cache
			System.out.println("3"+policy1);
			System.out.println(".............................");
			policy1=ses.get(InsurancePolicy.class,9001L);  //gets from L1 cache
			System.out.println("4"+ policy1);
			ses.clear();  //removes  all object from L1 cache
			policy1=ses.get(InsurancePolicy.class,9001L);  //gets from DB and puts in L1 cache
			System.out.println("5"+policy1);
			
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
