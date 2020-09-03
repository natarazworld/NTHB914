package com.nt.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class ObjectCreationTimeStampTest {

	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare object
		account=new BankAccount();
		account.setHolderName("suresh"); account.setType("savings");
		account.setBalance(90000.0); account.setOpeningDate(LocalDateTime.now());
		try {
			tx=ses.beginTransaction();
			  ses.save(account);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
				System.out.println("Account is opened on::"+account.getOpeningDate());
				System.out.println("Account is opened on::"+account.getLastUpdated());
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close hibernate objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
