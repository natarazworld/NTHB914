package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest2 {

	public static void main(String[] args) {
		
		 
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=factory.openSession();
		//with java 9 syntax
		try(factory;ses){
				  //Load object 
				  InsurancePolicy policy=ses.get(InsurancePolicy.class,9001L);
				  if(policy==null)
					  System.out.println("record not found");
				  else
					  System.out.println(policy);
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}//main
}//class
