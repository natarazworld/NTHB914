package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest1 {

	public static void main(String[] args) {
		 InsurancePolicy policy=null;
		 Transaction tx=null;
		 boolean flag=false;
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=factory.openSession();
		//with java 9 syntax
		try(factory;ses){
			  policy=new InsurancePolicy();
			  policy.setPolicyName("JA");
			  policy.setCompany("LIC");
			  policy.setPolicyType("life");
			  policy.setTenure(20);
			  try {
				  //save object
			  tx=ses.beginTransaction();
			     ses.save(policy);
			      flag=true;
			  }//try
			  catch(HibernateException he) {
				  flag=false;
				  he.printStackTrace();
			  }
			  finally {
				  if(flag) {
					  tx.commit();
					  System.out.println("object is saved");
				  }
				  else {
					  tx.rollback();
					  System.out.println("object is not saved");
				  }
			  }
			
		}//try wit resource
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
