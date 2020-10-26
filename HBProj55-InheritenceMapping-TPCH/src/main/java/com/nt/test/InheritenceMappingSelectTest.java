package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingSelectTest {

	public static void main(String[] args) {
	    //get Session
		Session ses=HibernateUtil.getSession();
	    Transaction tx=null;
	    try {
	    	if(!ses.getTransaction().isActive())
	    		 tx=ses.beginTransaction();
	    	// Getting Records using super class..
	    	System.out.println("Using  super class (Person)");
	    	Query<Person> query1=ses.createQuery("from Person");
	    	List<Person> list1=query1.getResultList();
	    	list1.forEach(System.out::println);
	    	System.out.println(".........................................");
	    	// Getting Records using subclass1..
	    	System.out.println("Using  sub class1 (Employee)");
	    	Query<Employee> query2=ses.createQuery("from Employee");
	    	List<Employee> list2=query2.getResultList();
	    	list2.forEach(System.out::println);
	    	System.out.println(".........................................");
	    	// Getting Records using subclass2..
	    	System.out.println("Using  sub class2 (Student)");
	    	Query<Student> query3=ses.createQuery("from Student");
	    	List<Student> list3=query3.getResultList();
	    	list3.forEach(System.out::println);
	    	
	    }
	    catch(HibernateException he) {
	    	he.printStackTrace();
	    }
	    finally {
	    		//close Session factory
	    	HibernateUtil.closeSessionFactory();
	    }//finally

	}//main
}//class
