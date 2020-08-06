package com.nt.test;





import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class RefreshingObject {
	
	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//Load object for partial moidification of the object
	    account=ses.get(BankAccount.class,1001L);
	     if(account!=null) {
			System.out.println(account);
			
			System.out.println("modify 1001 record in DB table  from SQL prompt/developer");
			try {
			 Thread.sleep(40000);   //modify db table record using SQL prompt or SQL developer
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			ses.refresh(account);  //Db table row  to Entity object sync
			System.out.println(account);
	     }
	     else {
	    	 System.out.println("record /object not found");
	     }
		}//try
		catch(HibernateException  he) {
			he.printStackTrace();
		}
		finally {
			//close objs
			 HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
		
	}//main

}//class
