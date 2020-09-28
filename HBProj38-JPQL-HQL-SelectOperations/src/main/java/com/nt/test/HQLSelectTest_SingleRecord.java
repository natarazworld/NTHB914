package com.nt.test;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest_SingleRecord {

	public static void main(String[] args) {
		// get SEssion ob
		Session ses = HibernateUtil.getSession();
		
		 //=================== HQL SELECT Entity Query that gives  single record=====
		/*	try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query query=ses.createQuery("FROM  com.nt.entity.InsurancePolicy WHERE policyId=:id");
				//set param value
				query.setParameter("id",9007L);
				//execute Query
				List<InsurancePolicy> list=query.getResultList();
				System.out.println(list.size());
				if(!list.isEmpty()) {
				   InsurancePolicy policy=list.get(0);
				System.out.println(policy);
				}
				else {
					System.out.println("record not found");
				}
				
			}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
				finally {
					HibernateUtil.closeSessionFactory();
				}
			*/
		
		/*		 //=================== HQL SELECT Scalar Query(multiple specific col values) that gives  single record=====
					try {
						Transaction tx=ses.beginTransaction(); //dummy
						//prepare Query object
						Query query=ses.createQuery("SELECT  policyId,policyName FROM  com.nt.entity.InsurancePolicy WHERE policyId=:id");
						//set param value
						query.setParameter("id",9001L);
						//execute Query
						List<Object[]> list=query.getResultList();
						System.out.println(list.size());
						if(!list.isEmpty()) {
						   Object row[]=list.get(0);
						System.out.println(row[0]+"  "+row[1]);
						}
						else {
							System.out.println("record not found");
						}
						
					}//try
						catch(HibernateException he) {
							he.printStackTrace();
						}
						finally {
							HibernateUtil.closeSessionFactory();
						}
					
		*/			
		
		/* //=================== HQL SELECT Scalar Query(aggraget function) that gives  single record=====
			try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query query=ses.createQuery("SELECT  COUNT(*) FROM com.nt.entity.InsurancePolicy");
				//execute Query
				List<?> list=query.getResultList();
				if(!list.isEmpty()) {
				   Long count=(Long) list.get(0);
			      System.out.println("records count::"+count);
				}
			}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
				finally {
					HibernateUtil.closeSessionFactory();
				}*/
		
		 //=================== HQL SELECT Scalar Query(aggraget function) that gives  single record=====
		try {
			Transaction tx=ses.beginTransaction(); //dummy
			//prepare Query object
			Query query=ses.createQuery("  FROM com.nt.entity.InsurancePolicy WHERE policyId=:id");
			//set query param value
			query.setParameter("id",9010L);
			//execute Query
			/*InsurancePolicy policy=(InsurancePolicy)query.uniqueResult();
			if(policy!=null)
				System.out.println(policy);
			else
				System.out.println("record not found");*/
			Optional<InsurancePolicy>opt=query.uniqueResultOptional();
			if(opt.isPresent()) {
				InsurancePolicy policy=opt.get();
				   System.out.println(policy);
				   }
			else {
				System.out.println("record not found");
			}
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}
		
	}// main
}// class
