package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class AnnoIneritenceMappingSelectTest {

	public static void main(String[] args) {
	//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
       //begin Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			
			//use Super class Payment
			Query<Payment> query1=ses.createQuery("from com.nt.entity.Payment");
			List<Payment> list1=query1.getResultList();
			list1.forEach(System.out::println);
			System.out.println("======================");
			//use Sub class1 CardPayment
			Query<CardPayment> query2=ses.createQuery("from com.nt.entity.CardPayment");
			List<CardPayment> list2=query2.getResultList();
			list2.forEach(System.out::println);
			System.out.println("======================");
			//use Sub class2 ChequePayment
			Query<ChequePayment> query3=ses.createQuery("from com.nt.entity.ChequePayment");
			List<ChequePayment> list3=query3.getResultList();
			list3.forEach(System.out::println);
	}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
