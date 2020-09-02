package com.nt.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonInfo;
import com.nt.utility.HibernateUtil;

public class InsertDateTest {

	public static void main(String[] args) {
		Session ses=null;
		PersonInfo info=null;
		Transaction tx=null;
		boolean flag=false;
		  //get Session
		ses=HibernateUtil.getSession();
		//prepare Entity object
		 info=new PersonInfo();
		    info.setPname("rakesh");  info.setPaddrs("hyd");
     		 info.setDob(new  java.util.Date(90,11,23,12,5,45));  // year(1900+),month,day,hours,min,sec
			 info.setDoj(new java.util.Date());
			 info.setDom(new java.util.Date(118,10,12));
		 
		try {
			//begin Tx
			tx=ses.beginTransaction();
			    ses.save(info);
			   flag=true; 
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//perform TxMgmt
			  if(flag) {
				  tx.commit();
				  System.out.println("Object is saved");
			  }
			  else {
				  tx.rollback();
				  System.out.println("Object is not saved");
			  }
			  //close objs
			  HibernateUtil.closeSession(ses);
			  HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
