package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Address;
import com.nt.entity.StudentInfo;
import com.nt.utility.HibernateUtil;

public class ComponentMappingInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		Address addrs1=null, addrs2=null;
		StudentInfo info1=null,info2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		addrs1=new Address();
		addrs1.setDoorNo("10-20-3/A");
		addrs1.setStreetName("RK Street");
		addrs1.setAreaName("Ameerpet");
		addrs1.setState("Telangana");
		addrs1.setCountry("India");
		addrs1.setPinCode(566777L);
		info1=new StudentInfo();
		info1.setSname("rajesh"); info1.setAvg(89.55f); 
		info1.setAddrs(addrs1);  //HAS-A relationship
		
		addrs2=new Address();
		addrs2.setDoorNo("11-20-3/A");
		addrs2.setStreetName("DK Street");
		addrs2.setAreaName("Ameerpet");
		addrs2.setState("Telangana");
		addrs2.setCountry("India");
		addrs2.setPinCode(562777L);
		info2=new StudentInfo();
		info2.setSname("raj"); info2.setAvg(89.55f); 
		info2.setAddrs(addrs2);  //HAS-A relationship
		
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			   ///save objs
			ses.save(info1);
			ses.save(info2);
                 flag=true;			
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object are saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
