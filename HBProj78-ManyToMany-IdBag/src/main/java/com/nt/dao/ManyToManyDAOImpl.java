package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements IManyToManyDAO {

	@Override
	public void saveDataUsingParents() {
		//get Session
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Doctor d1=new Doctor("raja","apollo","MD");
		Doctor d2=new Doctor("rajesh","KIMS","MD");
		
		Patient p1=new Patient("jani","heart");
		Patient p2=new Patient("anil","kidney");
		Patient p3=new Patient("anitha","cancer");
		Patient p4=new Patient("suresh","corona");
		//set patients to doctors and vice-versa
		d1.setPatients(List.of(p1,p2));
		d2.setPatients(List.of(p1,p2,p3,p4));
		p1.setDoctors(Set.of(d1,d2));
		p2.setDoctors(Set.of(d1,d2));
		p3.setDoctors(Set.of(d2));
		p4.setDoctors(Set.of(d2));
		
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			
			//save objects (childs to parent)
		     ses.save(d1); ses.save(d2);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//Transaction mgment
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
		
	}//method
	
	
}//class
