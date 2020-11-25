package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOnePKDAOImpl implements IOneToOnePKDAO {

	@Override
	public void saveDataUsingParent() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Student st=new Student("raja","hyd");
		LibraryMembership lib=new LibraryMembership("gold",
				                                                                            LocalDate.of(2011, 11, 20),
				                                                                            LocalDate.of(2031,11,20));
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		
		Transaction tx=null;
		boolean flag=false;
		
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			     ses.save(st);
			flag=true;
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
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
	
	@Override
	public void saveDataUsingChild() {
		//get Session object
				Session ses=HibernateUtil.getSession();
				//prepare objects
				Student st=new Student("ramesh","hyd");
				LibraryMembership lib=new LibraryMembership("silver",
						                                                                            LocalDate.of(2015, 11, 20),
						                                                                            LocalDate.of(2035,11,20));
				st.setLibraryDetails(lib);
				lib.setStudentDetails(st);
				
				Transaction tx=null;
				boolean flag=false;
				
				try {
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
					     ses.save(lib);
					flag=true;
				}//try
				catch(HibernateException he) {
					flag=false;
					he.printStackTrace();
				}
				catch(Exception e) {
					flag=false;
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
	
	@Override
	public void LoadDataUsingParent() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//prepare and excute HQL
			Query query=ses.createQuery("from com.nt.entity.Student");
			List<Student> list=query.getResultList();
			list.forEach(st->{
				System.out.println("parent::"+st);
				LibraryMembership lib=st.getLibraryDetails();
				System.out.println("child ::"+lib);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method
}//class
