package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFilterTest_JPAQBC {

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
			//parepare and execute JPAQBC
			CriteriaBuilder ctBuilder=ses.getCriteriaBuilder();
			CriteriaQuery<BankAccount> ctQuery=ctBuilder.createQuery(BankAccount.class);
			Root<BankAccount>  root=ctQuery.from(BankAccount.class);
			ctQuery.select(root);
			Query query=ses.createQuery(ctQuery);
			List<BankAccount> list=query.list();
			list.forEach(System.out::println);
			//disable filter
			ses.disableFilter("FILTER_BANKACCOUNT_STATUS");
			//parepare and execute JPAQBC
			CriteriaQuery<BankAccount> ctQuery1=ctBuilder.createQuery(BankAccount.class);
			Root<BankAccount>  root1=ctQuery1.from(BankAccount.class);
			ctQuery1.select(root1);
			Query query1=ses.createQuery(ctQuery1);
			List<BankAccount> list1=query1.list();
			list1.forEach(System.out::println);
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close HB objs
			 HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
