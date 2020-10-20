package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeletionTest1 {

	public static void main(String[] args) {
		Session ses=null;
		//get SEssion 
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=true;
		int count=0;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			Query query=ses.createQuery("update BankAccount set status='closed' where acno=:no");
			query.setParameter("no", 4567);
			//execute query
			count=query.executeUpdate();
		}
		catch(HibernateException he) {
            he.printStackTrace();
            flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("record deleted (soft deletion)");
			}
			else {
				tx.rollback();
				System.out.println("record not deleted");
			}
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
