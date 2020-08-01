package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration cfg=null;
		try {
			//boot strap hibernate
			 cfg=new Configuration();
			 cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			 //build SessionFactory
			 factory=cfg.buildSessionFactory();
		}//tru
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	
	//required only while working with Try with resource
	public  static  SessionFactory  getSessionFactory() {
		if(factory!=null)
			return factory;
		else
			throw new HibernateException("Problem is SessionFactory object creation");
	}
	
	/*public static  Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	
	
	//optional while working with Try with resource
	public static  void  closeSession(Session ses) {
		 if(ses!=null)
			 ses.close();
	}
	
	//optional while working with Try with resource
	public  static void   closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	*/
}
