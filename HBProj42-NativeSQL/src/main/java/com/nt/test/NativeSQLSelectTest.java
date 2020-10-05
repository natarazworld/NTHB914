package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class NativeSQLSelectTest {

	public static void main(String[] args) {
		// get HB Session obj
		Session ses=HibernateUtil.getSession();
		
		//===============Executing Native SQL Entity Query with out mapping it to entity class ============== 
		/*Transaction tx=null;
		try {
			//get/create Tx
			if(!ses.getTransaction().isActive())
				  tx=ses.beginTransaction();
			//create SQL Queyr object
			NativeQuery<Object[]> squery=ses.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?");
			  //set query param values
			squery.setParameter(1,25);
			squery.setParameter(2,35);
			//exsecute Query
			List<Object[]> list=squery.getResultList();
			//process results
			list.forEach(row->{
				for(Object o:row) {
					System.out.print(o+"   ");
				}
				System.out.println();
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
		}//finally
		*/	

		/*//===============Executing Native SQL Entity Query by mapping it to entity class ============== 
		Transaction tx=null;
		try {
			//get/create Tx
			if(!ses.getTransaction().isActive())
				  tx=ses.beginTransaction();
			//create SQL Queyr object
			NativeQuery<InsurancePolicy> squery=ses.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>=?1 AND TENURE<=?2");
			  //set query param values
			squery.setParameter(1,25);
			squery.setParameter(2,35);
			//map results with Entity class
			squery.addEntity(InsurancePolicy.class);
			//exsecute Query
				List<InsurancePolicy> list=squery.getResultList();
				//process results
				list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}//finally
		*/		

		//===============Executing Native SQL Scalar Query selecting specific multiple col values ======= 
		Transaction tx=null;
		try {
			//get/create Tx
			if(!ses.getTransaction().isActive())
				  tx=ses.beginTransaction();
			//create SQL Queyr object
			NativeQuery<Object[]> squery=
					 ses.createSQLQuery("SELECT POLICYID,POLICYNAME FROM INSURANCEPOLICY WHERE COMPANY IN(:comp1,:comp2)");
			  //set query param values
			squery.setParameter("comp1","LIC");
			squery.setParameter("comp2","TATA");
			//map results with Hibernate datypes
              squery.addScalar("POLICYID",StandardBasicTypes.INTEGER);
              squery.addScalar("POLICYNAME",StandardBasicTypes.STRING);
			//exsecute Query
				List<Object[]> list=squery.getResultList();
				//process results
				list.forEach(row->{
					for(Object o:row) {
						System.out.print(o+"   "+o.getClass());
					}
					System.out.println();
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
		}//finally
	
	}//main
}//class
