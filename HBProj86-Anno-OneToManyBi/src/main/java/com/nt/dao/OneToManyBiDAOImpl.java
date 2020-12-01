package com.nt.dao;

import java.sql.SQLException;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Company;
import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements IOneToManyBiDAO {

	@Override
	public void saveDataUsingParent() {
		 
		//get Session
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Company comp=new Company("HCL","hyd","IT");
		Project proj1=new Project("OpenFx","financial",10);
		Project proj2=new Project("citiBank","banking",20);
	   //add childs to parent
		comp.setProjects(Set.of(proj1,proj2));
		//add parent to childs
		proj1.setCompany(comp);
		proj2.setCompany(comp);
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin tx
			 if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			    ses.save(comp);
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
			//perform Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}//finally
		
	}//method
	
	@Override
	public void saveDataUsingChild() {
		 
		//get Session
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Company comp=new Company("Wiport","mumbai","IT");
		Project proj1=new Project("Aadhar","portfolid",10);
		Project proj2=new Project("FFW","govt",10);
	   //add childs to parent
		comp.setProjects(Set.of(proj1,proj2));
		//add parent to childs
		proj1.setCompany(comp);
		proj2.setCompany(comp);
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin tx
			 if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			    ses.save(proj1); ses.save(proj2);
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
			//perform Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}//finally
		
	}//method


}
