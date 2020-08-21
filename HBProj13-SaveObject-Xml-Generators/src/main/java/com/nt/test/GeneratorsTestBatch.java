package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class GeneratorsTestBatch {

	public static void main(String[] args) {
		Session ses=null;
		Product prod=null,prod1=null;
		Transaction tx=null;
		Integer idVal=0,idVal1=0;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		  //create Entity  object to save with Db s/w
		prod=new Product();
		//prod.setPid(9010);
		 prod.setPname("chair1");
		 prod.setPrice(40000.0f);
		 prod.setQty(80.0f);
		
		  try {
			  tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			      //save object
			   for(int i=1;i<=20;++i) {
				   prod=new Product();
					//prod.setPid(9010);
					 prod.setPname("chair1");
					 prod.setPrice(40000.0f);
					 prod.setQty(80.0f);
			     idVal=(int)ses.save(prod);
			     System.out.println("Generated id values ::"+idVal);
			     flag=true;
			   }
		  }
		  catch(HibernateException he) {
			  he.printStackTrace();
			  flag=false;
		  }
		  finally {
			   //commit or rollback  Tx
			    if(flag==true) {
			    	   tx.commit();  //internally calls con.commit()
	                 System.out.println("Object is saved");		    	
			    }
			    else {
			    	tx.rollback(); //internally calls  con.rollback()
			    	 System.out.println("Object is not saved");
			    }
			    
			    //close  session object
			    HibernateUtil.closeSession(ses);
			    //close SessionFactroy
	   		    HibernateUtil.closeSessionFactory();
		  }//finally  */
		  

	}//main
}//class
