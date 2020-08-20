package com.nt.thread.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MultiThreadedGeneratorsTest {

	public static void main(String[] args) throws Exception{
		Session ses1=null,ses2=null,ses3=null;
		Product prod=null,prod1=null,prod2=null,prod3=null;
		Transaction tx=null;
		Integer idVal=0,idVal1=0;
		boolean flag=false;
		//get Session
		ses1=HibernateUtil.getSession();
		ses2=HibernateUtil.getSession();
		ses3=HibernateUtil.getSession();
		  //create Entity  object to save with Db s/w
		prod1=new Product();
		 prod1.setPname("chair1");
		 prod1.setPrice(40000.0f);
		 prod1.setQty(80.0f);
		 
			prod2=new Product();
			 prod2.setPname("chair2");
			 prod2.setPrice(40000.0f);
			 prod2.setQty(80.0f);
			 
				prod3=new Product();
				 prod3.setPname("chair3");
				 prod3.setPrice(40000.0f);
				 prod3.setQty(80.0f);
		
		 
		 MyRequest req1=new MyRequest(ses1, prod1);
		 MyRequest req2=new MyRequest(ses2, prod2);
		 MyRequest req3=new MyRequest(ses3, prod3);
		 Thread t1=new Thread(req1);
		 t1.setName("t1");
		 Thread t2=new Thread(req2);
		 t2.setName("t2");
		 Thread t3=new Thread(req3);
		 t3.setName("t3");
		 t1.start(); t2.start();t3.start();
		 
			    Thread.sleep(60000);
	    //close  session object
	    HibernateUtil.closeSession(ses1);
	    HibernateUtil.closeSession(ses2);
	    HibernateUtil.closeSession(ses3);
	    //close SessionFactroy
	 		    HibernateUtil.closeSessionFactory();
	
		  

	}//main
}//class
