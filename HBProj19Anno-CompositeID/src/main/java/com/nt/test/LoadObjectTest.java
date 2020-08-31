package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		ProgrammerProjectInfo info=null;
		PrgmrProjId id=null;
			//get Session 
			ses=HibernateUtil.getSession();
			
			try {
			     //prepare Entity object
			       id=new PrgmrProjId();
			       id.setPid(103); id.setProjId(5003);
			       //load object
			       info=ses.get(ProgrammerProjectInfo.class, id);
			       if(info!=null)
			    	   System.out.println(info);
			       else
			    	   System.out.println("record not found");
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				//close objs
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
		
	}//class
}//main
