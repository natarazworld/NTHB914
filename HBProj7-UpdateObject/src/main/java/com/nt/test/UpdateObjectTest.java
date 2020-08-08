package com.nt.test;





import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest {
	
	public static void main(String[] args) {
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=true;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare full object for modifcation with exiting id
		account=new BankAccount();
		account.setAcno(1021L);
		account.setHolderName("rakesh"); account.setBalance(400000);
		try {
			//begin Tx
			tx=ses.beginTransaction();
			  ses.update(account);
             flag=true;			
		}
		catch(HibernateException  he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("Object updated");
			 }
			 else {
				 tx.rollback();
				 System.out.println("object not updated");
			 }
				 
			//close objs
			 HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
		
	}//main

}//class
