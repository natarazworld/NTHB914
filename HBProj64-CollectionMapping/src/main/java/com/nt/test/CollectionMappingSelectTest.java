package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class CollectionMappingSelectTest {

	public static void main(String[] args) {
		//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//execute HQL Query
			Query query=ses.createQuery("from com.nt.entity.Employee");
			List<Employee> list=query.getResultList();
			list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
				//close SEssionFactory
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main

}//class
