package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Address;
import com.nt.entity.StudentInfo;
import com.nt.utility.HibernateUtil;

public class ComponentMappingSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Address addrs1=null, addrs2=null;
		StudentInfo info1=null,info2=null;
		//get Session
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			   /// Load objects
			   Query<StudentInfo> query=ses.createQuery("from  com.nt.entity.StudentInfo where addrs.streetName=:street ");
			   query.setParameter("street","RK Street");
			   List<StudentInfo> list=query.getResultList();
			   list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
