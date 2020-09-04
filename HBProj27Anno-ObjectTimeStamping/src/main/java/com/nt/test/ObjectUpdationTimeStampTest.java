package com.nt.test;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class ObjectUpdationTimeStampTest {

	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		
		try {
			tx=ses.beginTransaction();
			//Load object
			account=ses.get(BankAccount.class,37L);
			if(account!=null) {
				account.setBalance(account.getBalance()+1000);
				flag=true;
			}
			else {
				System.out.println("record not found");
				return;
			}
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			// Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object updated");
				System.out.println("Account is opened on::"+account.getOpeningDate());
				System.out.println("Account lasly modified on::"+account.getLastUpdated());
				System.out.println("Account version::"+account.getVersion());
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
