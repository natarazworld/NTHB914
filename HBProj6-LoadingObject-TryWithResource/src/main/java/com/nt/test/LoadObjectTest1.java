package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest1 {

	public static void main(String[] args) {
		
		 //with java 8 syntax
		try(SessionFactory factory=HibernateUtil.getSessionFactory();
				         Session ses=factory.openSession()){
			
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
		
	}
}
