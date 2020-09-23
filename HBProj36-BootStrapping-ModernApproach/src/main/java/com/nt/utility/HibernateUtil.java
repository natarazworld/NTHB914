package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.InsurancePolicy;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration cfg=null;
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		try {
			//boot strap hibernate
			 cfg=new Configuration();
			 cfg.configure("com/nt/cfg/hibernate.cfg.xml");
			 cfg.addResource("com/nt/entity/InsurancePolicy.hbm.xml");
			 //cfg.addAnnotatedClass(InsurancePolicy.class) //for annoated classes
			 //build ServiceRegistry
			 builder=new StandardServiceRegistryBuilder();
			 //create ServiceRegistry
			 registry=builder.applySettings(cfg.getProperties()).build();
			 //build SessionFactory
			 factory=cfg.buildSessionFactory(registry);
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
