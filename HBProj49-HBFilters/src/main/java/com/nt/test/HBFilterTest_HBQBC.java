package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class HBFilterTest_HBQBC {

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
			//parepare and execute HBQBC
			Criteria criteria=ses.createCriteria(BankAccount.class);
			List<BankAccount> list=criteria.list();
			list.forEach(System.out::println);
			//disable filter
			ses.disableFilter("FILTER_BANKACCOUNT_STATUS");
			//parepare and execute HBQBC
			Criteria criteria1=ses.createCriteria(BankAccount.class);
			List<BankAccount> list1=criteria1.list();
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
