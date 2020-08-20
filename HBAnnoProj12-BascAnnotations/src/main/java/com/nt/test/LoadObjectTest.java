package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.IProject;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		IProject proj=null;
	    //get Session 
		ses=HibernateUtil.getSession();
		try {
			//Load object
			proj=ses.load(IProject.class,9005L);
			System.out.println(proj.getClass()+"   "+proj.getClass().getSuperclass()+"  "+Arrays.toString(proj.getClass().getInterfaces()));  
			System.out.println(proj);
			  
		}//try
		catch(HibernateException  he) {
			System.out.println("Record not found");
			he.printStackTrace();
			
		}
		finally {
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}//main
}//class
