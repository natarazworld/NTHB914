package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SelectTestAfterSoftDeletion {

	public static void main(String[] args) {
		Session ses=null;
		//get SEssion 
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			Query query=ses.createQuery("from BankAccount");
			List<BankAccount> list=query.getResultList();
			list.forEach(System.out::println);
		}
		catch(HibernateException he) {
			
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
