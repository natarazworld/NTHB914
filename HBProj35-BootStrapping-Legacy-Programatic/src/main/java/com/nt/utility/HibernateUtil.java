package com.nt.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

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
			
			 //set hibernate cfg properties explicitly
			 cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			 cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
			 cfg.setProperty("hibernate.connection.username", "system");
			 cfg.setProperty("hibernate.connection.password", "manager");
			 
			 cfg.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.Oracle10gDialect");
			 cfg.setProperty("hibernate.show_sql", "true");
			 
			 // specify cfg file (xml)
			 cfg.configure("com/nt/cfg/hibernate.cfg.xml");

			 //speficyt the name of the mapping file
			 cfg.addFile("src/main/java/com/nt/entity/InsurancePolicy.hbm.xml");
			  //cfg.addAnnotatedClass(InsurancePolicy.class)
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
	
	public static  Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static  void  closeSession(Session ses) {
		 if(ses!=null)
			 ses.close();
	}
	
	public  static void   closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
