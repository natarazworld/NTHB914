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
		// get SEssion ob
		Session ses = HibernateUtil.getSession();
		/*	try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				//query=ses.createQuery("FROM  com.nt.entity.InsurancePolicy   ip");
				Query<InsurancePolicy> query=ses.createQuery("SELECT  ip FROM  com.nt.entity.InsurancePolicy   ip");
				//execute query
				List<InsurancePolicy>list=query.getResultList();
				//process the result
					list.forEach(policy->{     //java 8 for Each method with Lamda expression
						System.out.println(policy);
					});
			//	list.forEach(System.out::println);   // java 8 forEach method + Method reference
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			} */
		// =================== Executing HQL Select Entity Query using iterate()
		// =======================
		/*	try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query<InsurancePolicy> query=ses.createQuery("FROM  com.nt.entity.InsurancePolicy ");
				//execute HQL query
				Iterator<InsurancePolicy> it=query.iterate();  //retuns ListBO refered by Iterator object
				//process Result
				while(it.hasNext()) {
					InsurancePolicy policy=it.next();
					System.out.println(policy);
				}
				
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}*/
		// =======================HQL SElect Entity query with JPA style positional		Params ==================
		/*	try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query<InsurancePolicy> query=ses.createQuery("FROM com.nt.entity.InsurancePolicy WHERE policyId>=?2 AND policyId<=?3 ");
				//set query param values
				query.setInteger(1,9001);
				query.setInteger(2, 9003);  deprecated from 5.2 
				query.setParameter(2,6000L);
				query.setParameter(3, 10000L);
				//execute the query
				List<InsurancePolicy> list=query.getResultList();
				//process the collection
				list.forEach(System.out::println);
			}
			catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
		*/
		
		// =======================HQL SElect Entity query with Named	Params ==================
			try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query<InsurancePolicy> query=ses.createQuery("FROM com.nt.entity.InsurancePolicy WHERE company IN(:org1,:org2,'BAJAJ')");
				//set values to named params
				query.setParameter("org1","LIC");
				query.setParameter("org2","TATA");
				//execute query
				List<InsurancePolicy> list=query.getResultList();
				//proess reuslt
				list.forEach(System.out::println);
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}
		
		
	}// main
}// class
