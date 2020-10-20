package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFilterTest_HQL {

	public static void main(String[] args) {
	//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
			   tx=ses.beginTransaction();
			//enable filter
			Filter  filter1=ses.enableFilter("FILTER_BANKACCOUNT_STATUS");
			//set filter param values
			filter1.setParameter("accountType1","blocked");
			filter1.setParameter("accountType2","closed");
			//parepare and execute HQL
			Query query=ses.createQuery("FROM BankAccount  WHERE balance>=:amt");
			query.setParameter("amt", 20000f);
			List<BankAccount> list=query.getResultList();
			list.forEach(System.out::println);
			//disable filter
			ses.disableFilter("FILTER_BANKACCOUNT_STATUS");
			//parepare and execute HQL
			Query query1=ses.createQuery("FROM BankAccount  WHERE balance>=:amt");
			query1.setParameter("amt", 20000f);
			List<BankAccount> list1=query1.getResultList();
			list1.forEach(System.out::println);

			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close HB objs
			 HibernateUtil.closeSessionFactory();
		}

	}

}
