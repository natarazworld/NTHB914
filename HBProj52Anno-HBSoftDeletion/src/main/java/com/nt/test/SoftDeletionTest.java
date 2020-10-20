package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeletionTest {

	public static void main(String[] args) {
		Session ses=null;
		//get SEssion 
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			   //delete object
			   BankAccount  account=new BankAccount();
			   account.setAcno(1547);
			   ses.delete(account);
			   flag=true;
		}
		catch(HibernateException he) {
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Account closed (soft deletion)");
			}
			else {
				tx.rollback();
				System.out.println("Account not closed");
			}
				
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
