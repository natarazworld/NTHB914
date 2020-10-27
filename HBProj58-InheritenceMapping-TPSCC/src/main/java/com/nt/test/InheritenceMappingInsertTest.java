package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingInsertTest {

	public static void main(String[] args) {
	    //get Session
		Session ses=HibernateUtil.getSession();
         //prepare Entiy objects..
		Person per=new Person();
		per.setName("rajesh"); per.setAddrs("hyd");
		
		Employee emp=new Employee();
		emp.setName("suresh"); emp.setAddrs("hyd");
	    emp.setDesg("dev"); emp.setSalary(90000f); emp.setDeptNo(1001);
	    
	    Student st=new Student();
	    st.setName("rakesh"); st.setAddrs("vizag"); st.setCollege("CBIET");
	    st.setBranch("EEE"); st.setAvg(90.55f);
	    
	    Transaction tx=null;
	    boolean flag=false;
	    try {
	    	if(!ses.getTransaction().isActive())
	    		 tx=ses.beginTransaction();
	    	  ses.save(per);
	    	  ses.save(emp);
	    	  ses.save(st);
	    	  flag=true;
	    }
	    catch(HibernateException he) {
	    	flag=false;
	    	he.printStackTrace();
	    }
	    finally {
	    	//perform TxMgmt
	    	if(flag) {
	    		tx.commit();
	    		System.out.println("objects are saved");
	    	}
	    	else {
	    		tx.rollback();
	    		System.out.println("Objects are not saved");
	    	}
	    		//close Session factory
	    	HibernateUtil.closeSessionFactory();
	    }//finally

	}//main
}//class
