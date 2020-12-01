package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.CarCompany;
import com.nt.entity.CarModel;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements IOneToManyDAO {

	@Override
	public void saveDataUsingParent() {
	  // get Session
		Session ses=HibernateUtil.getSession();
		//prepare object
		    //parent object
		       CarCompany  company=new CarCompany("maruthi-suzuki","noida");
		       //child objects
		       CarModel model1=new CarModel("Baleno","HatchBack","diesel");
		       CarModel model2=new CarModel("Brezza","HatchBack","diesel");
		       //add childs to parent
		       company.setModels(List.of(model1,model2));
		       Transaction tx=null;
		       boolean flag=false;
		       try {
		    	   if(!ses.getTransaction().isActive())
		    		     tx=ses.beginTransaction();
		    	     ses.save(company);
		    	   flag=true;
		       }//try
		       catch(HibernateException he) {
		    	   he.printStackTrace();
		       }
		       finally {
		    	   if(flag) {
		    		   tx.commit();
		    		   System.out.println("Objects are saved");
		    	   }
		    	   else {
		    		   tx.rollback();
		    		   System.out.println("Objects are not saved");
		    	   }
		       }//finally
	}//method
	
		
}//class
