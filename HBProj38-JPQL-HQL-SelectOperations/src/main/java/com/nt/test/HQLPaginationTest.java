package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class HQLPaginationTest {

	public static void main(String[] args) {
		// get SEssion ob
		Session ses = HibernateUtil.getSession();
		Transaction tx=null;
		 try {
			 //begin Tx (dummy)
			 tx=ses.beginTransaction();
			 //prepare Query object
			 Query query=ses.createQuery("FROM com.nt.entity.InsurancePolicy");
			 //pagination settings
			 query.setFirstResult(6);  //page start Position
			 query.setMaxResults(2);  // page size
			 //execute Query
			 List<InsurancePolicy>  list=query.getResultList();
			 //process the reuslts
			 list.forEach(System.out::println);
			 
		 }
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}
		
		
	}// main
}// class
