package com.nt.test;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class QueryCacheTest {

	public static void main(String[] args) {
		//get SEssionFactory object
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=factory.openSession();
		try {
			Query query=ses.createQuery("from InsurancePolicy");
			query.setCacheable(true);
			query.setCacheRegion("reg1");
			List<InsurancePolicy> list=query.getResultList(); //collects from DB and keeps in query cache of Ll2 cache
			list.forEach(policy->{
				System.out.println(policy);
			});
			System.out.println("--------------------------");
			 list=query.getResultList();  //collects from query cache .
			list.forEach(policy->{
				System.out.println(policy);
			});
			Cache cache=factory.getCache();
			cache.evictQueryRegion("reg1");   //removes the  entties from  query cache region "reg1"
			System.out.println("--------------------------");
			 list=query.getResultList();  //collects from DB and keeps in query cache of Ll2 cache
			list.forEach(policy->{
				System.out.println(policy);
			});

			
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
	}//main
}//class
