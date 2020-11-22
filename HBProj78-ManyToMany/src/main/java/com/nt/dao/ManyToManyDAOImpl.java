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
		d1.setPatients(Set.of(p1,p2));
		d2.setPatients(Set.of(p1,p2,p3,p4));
		p1.setDoctors(Set.of(d1,d2));
		p2.setDoctors(Set.of(d1,d2));
		p3.setDoctors(Set.of(d2));
		p4.setDoctors(Set.of(d2));
		
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			
			//save objects (parent to child)
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
	
	@Override
	public void saveDataUsingChilds() {
		//get Session
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Doctor d1=new Doctor("satish","apollo","MD");
		Doctor d2=new Doctor("karan","KIMS","MD");
		
		Patient p1=new Patient("AA","heart");
		Patient p2=new Patient("BB","kidney");
		Patient p3=new Patient("CC","cancer");
		Patient p4=new Patient("DD","corona");
		//set patients to doctors and vice-versa
		d1.setPatients(Set.of(p1,p2));
		d2.setPatients(Set.of(p1,p2,p3,p4));
		p1.setDoctors(Set.of(d1,d2));
		p2.setDoctors(Set.of(d1,d2));
		p3.setDoctors(Set.of(d2));
		p4.setDoctors(Set.of(d2));
		
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			
			//save objects (parent to child)
			ses.save(p1); ses.save(p2); ses.save(p3); ses.save(p4);
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
	
	@Override
	public void loadDataUsingParents() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
				if(!ses.getTransaction().isActive())
					tx=ses.beginTransaction();
				//prepare and execute SQL query
				Query query=ses.createQuery("from Doctor");
				List<Doctor> list=query.getResultList();
				list.forEach(doc->{
					System.out.println("parent::"+doc);
				    Set<Patient> childs=doc.getPatients();
				     childs.forEach(pat->{
				    	 System.out.println("child ::"+pat);
				     });
				});
		}//try
		catch(HibernateException he) {
			 he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//method
	
	@Override
	public void loadDataUsingChilds() {
		//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				try {
						if(!ses.getTransaction().isActive())
							tx=ses.beginTransaction();
						//prepare and execute SQL query
						Query query=ses.createQuery("from Patient");
						List<Patient> list=query.getResultList();
						list.forEach(pat->{
							System.out.println("child::"+pat);
						    Set<Doctor> parents=pat.getDoctors();
						     parents.forEach(doc->{
						    	 System.out.println("parent ::"+doc);
						     });
						});
				}//try
				catch(HibernateException he) {
					 he.printStackTrace();
				}
				finally {
					HibernateUtil.closeSessionFactory();
				}//finally
		
	}//method
	
	@Override
	public void deleteSpecificChildFromSpecifcParent() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
				if(!ses.getTransaction().isActive())
					tx=ses.beginTransaction();
				//Load parent
				Doctor doctor=ses.get(Doctor.class,6);
				//get childs
				Set<Patient> childs=doctor.getPatients();
				//Load specific  child
				Patient patient=ses.get(Patient.class,1006);
				childs.remove(patient);
				flag=true;
			
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(" deleted"); 
			}
			else {
				tx.rollback();
				System.out.println(" not deleted");
			}
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
				if(!ses.getTransaction().isActive())
					tx=ses.beginTransaction();
				//Load parent
				Doctor doctor=ses.get(Doctor.class,2);
				//get childs
				Set<Patient> childs=doctor.getPatients();
				childs.removeAll(childs);
				flag=true;
			
		}
		catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println(" deleted"); 
			}
			else {
				tx.rollback();
				System.out.println(" not deleted");
			}
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}
	
}//class
