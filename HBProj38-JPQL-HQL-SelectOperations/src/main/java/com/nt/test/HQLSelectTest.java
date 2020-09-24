package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Query<InsurancePolicy> query=null;
		List<InsurancePolicy> list=null;
	     //get SEssion  ob
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction(); //dummy
			//prepare Query object
			query=ses.createQuery("FROM  com.nt.entity.InsurancePolicy");
			//execute query
			list=query.getResultList();
			//process the result
			/*list.forEach(policy->{     //java 8 for Each method with Lamda expression
				System.out.println(policy);
			});*/
			list.forEach(System.out::println);   // java 8 forEach method + Method reference
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
