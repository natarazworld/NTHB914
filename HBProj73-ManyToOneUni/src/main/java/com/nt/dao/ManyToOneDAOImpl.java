package com.nt.dao;

import java.awt.HeadlessException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Department;
import com.nt.entity.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveDataUsingChild() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//prepare objects
			   //child objs
			     EmpDetails emp1=new EmpDetails("raja","hyd",90000.0f);
			     EmpDetails emp2=new EmpDetails("rajesh","vizag",70000.0f);
			     EmpDetails emp3=new EmpDetails("suresh","delhi",60000.0f);
			     //parent obj
			     Department dept=new Department("IT", "mumbai", 10);
			     //set parent obj to multiple child objects
			     emp1.setDept(dept); emp2.setDept(dept);  emp3.setDept(dept);
			     //save child objects
			     ses.save(emp1); ses.save(emp2); ses.save(emp3);
			     flag=true;
		   }//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Objects are save (many to one)");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not save (many to one)");
			}
			//close sessionfactory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//method
	
	@Override
	public void loadDataUsingChild() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load objects
			Query query=ses.createQuery("from EmpDetails");
			List<EmpDetails> list=query.getResultList();
			list.forEach(emp->{
				
				  System.out.println("Child::"+emp.getEno()+"  "+emp.getEname()+"  "+emp.getEadd()+"  "+emp.getSalary());
				  //get Associated parent object
				  Department dept=emp.getDept();
				  System.out.println("Parent::"+dept.getDno()+"  "+dept.getDname()+"  "+dept.getLocation()+"  "+dept.getCapacity());
			});
				
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close HB objs
			HibernateUtil.closeSessionFactory();
		}
	}//method
	
	@Override
	public void deleteAllChildsAndItsParent() {
		//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				boolean flag=false;
				try {
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
					//Load all child object
					Query query=ses.createQuery("from EmpDetails");
					List<EmpDetails>  list=query.getResultList();
					list.forEach(emp->{
						ses.delete(emp);
					});
					flag=true;
					
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				finally {
					//perform TxMgmt
					 if(flag) {
						 tx.commit();
						 System.out.println("All chids and its parents are deleted ");
					 }
					 else {
						 tx.rollback();
						 System.out.println("All chids and its parents are not deleted ");
					 }
					//close HB objs
					HibernateUtil.closeSessionFactory();
				}
	}//method
	
	/*@Override
	public void deleteOneChildFromParent() {   ///Bad code..
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load child obj
			EmpDetails emp=ses.get(EmpDetails.class, 3);
			ses.delete(emp);
			flag=true;
		}
		finally {
			//perform TxMgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("One chid of a parent is deleted ");
			 }
			 else {
				 tx.rollback();
				 System.out.println("One chid of a parent is not deleted ");
			 }
			//close HB objs
			HibernateUtil.closeSessionFactory();
		}//finally
	}//method
	*/	
	
	@Override
	public void deleteOneChildFromParent() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			Query query=ses.createQuery("DELETE FROM EmpDetails WHERE eno=:no");
			query.setParameter("no",2);
		     int count=query.executeUpdate();
		     flag=true;
		}
		finally {
			//perform TxMgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("One chid of a parent is deleted ");
			 }
			 else {
				 tx.rollback();
				 System.out.println("One chid of a parent is not deleted ");
			 }
			//close HB objs
			HibernateUtil.closeSessionFactory();
		}//finally
	}
	
}//class
