package com.nt.dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements IOneToOneFKDAO {

	@Override
	public void saveData() {
		//get Session 
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Person per=new Person("raja","hyd");
		Passport pspt=new Passport("india", LocalDate.of(2030,10,10));
		pspt.setPersonDetails(per);
		Person per1=new Person("ravi","vizag");
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			ses.save(pspt);
			ses.save(per1);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}//finally

	}//method
}//class
