package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class DeletingObjectTest2 {
	
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
			//Load object
			proj=ses.get(Project.class,82L);
			if(proj!=null) {
			//delete object
		     ses.delete(proj);
             flag=true;	
			}
			else {
				System.out.println("record not found to delete");
				flag=false;
				return;
			}
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
