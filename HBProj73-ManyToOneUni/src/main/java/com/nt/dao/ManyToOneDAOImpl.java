package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	}//main
}//class
