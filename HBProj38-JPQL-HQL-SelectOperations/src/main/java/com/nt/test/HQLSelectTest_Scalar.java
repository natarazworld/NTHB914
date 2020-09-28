package com.nt.test;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class HQLSelectTest_Scalar {

	public static void main(String[] args) {
		// get SEssion ob
		Session ses = HibernateUtil.getSession();
		
		  //=================== HQL SELECT SCALAR Query that gives  multiple specifi col values========
		/*	try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query query=ses.createQuery("SELECT policyId,policyName,tenure FROM  com.nt.entity.InsurancePolicy WHERE policyName like :initLetters  ");
				//set values to query params
				query.setParameter("initLetters","J__");
				//execute HQL query
				List<Object[]> list=query.getResultList();
				//process result
				list.forEach(row->{
					for(Object obj:row) {
						System.out.print(obj+"   ");
					}//for
					System.out.println();
				});
		  }		//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}*/
		
		/*//  =================== HQL SELECT SCALAR Query that gives  single specific col value========
					try {
						Transaction tx=ses.beginTransaction(); //dummy
						//prepare Query object
						Query query=ses.createQuery("SELECT policyId FROM  com.nt.entity.InsurancePolicy WHERE tenure>=:max");
						//set quer param value
						query.setParameter("max",25);
						//execute Query
						List<Long> list=query.getResultList();
						//process result
						list.forEach(System.out::println);
					}//try
						catch(HibernateException he) {
							he.printStackTrace();
						}
						finally {
							HibernateUtil.closeSessionFactory();
						}
		*/
		
		// =================== HQL SELECT SCALAR Query that gives  single specific col value using iterate()========
		/*			try {
						Transaction tx=ses.beginTransaction(); //dummy
						//prepare Query object
						Query query=ses.createQuery("SELECT policyId FROM  com.nt.entity.InsurancePolicy WHERE tenure>=:max");
						//set quer param value
						query.setParameter("max",15);
						//execute Query
						Iterator<Long> it=query.iterate();
						//process result
						while(it.hasNext()) {
							System.out.println(it.next());
						}
					}//try
						catch(HibernateException he) {
							he.printStackTrace();
						}
						finally {
							HibernateUtil.closeSessionFactory();
						}*/
		
		
	}// main
}// class
