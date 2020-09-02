package com.nt.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonInfo;
import com.nt.utility.HibernateUtil;

public class RetrieveDateTest {

	public static void main(String[] args) {
		Session ses=null;
		PersonInfo info=null;
		
		  //get Session
		ses=HibernateUtil.getSession();
		try {
		  info=ses.get(PersonInfo.class, 30);
		  if(info!=null) {
			  System.out.println(info);
		  }
		  else {
			  System.out.println("record not found");
		  }
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			  //close objs
			  HibernateUtil.closeSession(ses);
			  HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
