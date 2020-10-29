package com.nt.test;

import java.sql.SQLException;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.utility.HibernateUtil;

public class AnnoIneritenceMappingTest {

	public static void main(String[] args) {
	//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
       //begin Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			  //prepare objects
			   CardPayment payment1=new CardPayment();
			   payment1.setAmount(9000f); payment1.setCardNo(456788L); payment1.setCardType("credit");
			   payment1.setPaymentGateway("VISA");
			   
			   ChequePayment payment2=new ChequePayment();
			   payment2.setAmount(9000f); payment2.setChequeNo(1574448L); payment2.setChequeType("self");
			   payment2.setExpiryDate(LocalDate.of(2021,10, 21));
			    //save objs
			   ses.save(payment1);
			   ses.save(payment2);
			flag=true;
	}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			//Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("objects are not saved");
			}
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
