package com.nt.test;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class SecondLevelCacheTest {

	public static void main(String[] args) {
		InsurancePolicy policy=null;
		//get SEssionFactory object
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=factory.openSession();
		try {
			//Load object
			policy=ses.get(InsurancePolicy.class,9001L);  //gets from DB and keeps in L2 and L1 cache
			System.out.println(policy);
			System.out.println("........................");
			policy=ses.get(InsurancePolicy.class,9001L);  //gets from  L1 cache
			System.out.println(policy);
			System.out.println("........................");
			ses.evict(policy);  // removes from L1 cache
			policy=ses.get(InsurancePolicy.class,9001L);  //gets from  L2 cache and keeps L1 cache
			System.out.println(policy);
			System.out.println("........................");
			ses.clear(); // removes from L1 cache
			try {
				Thread.sleep(20000);  // removes from L2 cache (idletime out)
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			policy=ses.get(InsurancePolicy.class,9001L);   //gets from DB and keeps in L2 and L1 cache
			System.out.println(policy);
			ses.clear();
			Cache cache=factory.getCache();
			System.out.println(".......................");
			policy=ses.get(InsurancePolicy.class,9001L);   //gets from DB and keeps in L2 and L1 cache
			System.out.println(policy);
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
