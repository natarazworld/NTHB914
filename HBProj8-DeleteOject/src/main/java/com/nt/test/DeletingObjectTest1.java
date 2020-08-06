package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class DeletingObjectTest1 {
	
	public static void main(String[] args) {
		Session ses=null;
		Project proj=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
		     proj=new Project();
		     proj.setProjId(81);
		     ses.delete(proj);
             flag=true;	
	    }//try
		catch(HibernateException  he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("Object deleted");
			 }
			 else {
				 tx.rollback();
				 System.out.println("object not deleted");
			 }
				 
			//close objs
			 HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
		
	}//main

}//class
