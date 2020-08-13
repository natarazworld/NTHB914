package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {
	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Project proj=null;
		Long idVal=0L;
		//Get Session obj
		ses=HibernateUtil.getSession();
		//create Entity class object
		 proj=new Project();
		  proj.setProjId(9009L);
		  proj.setProjName("OpenFx5");
		  //proj.setTeamSize(10);
		  proj.setCompany("HCL");
		try {
			//begin Transaction
			tx=ses.beginTransaction();
			  idVal=(Long) ses.save(proj);
			  System.out.println("generated id value::"+idVal);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			//Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
