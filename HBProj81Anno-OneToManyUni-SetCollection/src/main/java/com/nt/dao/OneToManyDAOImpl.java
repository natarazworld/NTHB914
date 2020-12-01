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
		       company.setModels(Set.of(model1,model2));
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
	
	@Override
	public void loadDataUsingParent() {
		// get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				  try {
			    	   if(!ses.getTransaction().isActive())
			    		     tx=ses.beginTransaction();
			    	   //prepare and execute HQL query
			    	   Query query=ses.createQuery("from  com.nt.entity.CarCompany");
			    	   List<CarCompany> list=query.getResultList();
			    	   list.forEach(company->{
			    		   System.out.println("parent::"+company);
			    		   Set<CarModel> childs=company.getModels();
			    		   System.out.println(childs.isEmpty());
			    		   /*childs.forEach(model->{
			    			   System.out.println("chid::"+model);
			    		   });*/
			    	   });
			    	   
				  }//try
				  catch(HibernateException he) {
			    	   he.printStackTrace();
			       }
	}//method
	
	@Override
	public void loadDataUsingParentAndQBC() {
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		  try {
	    	   if(!ses.getTransaction().isActive())
	    		     tx=ses.beginTransaction();
	    	   //write QBC logic
	    	   Criteria criteria=ses.createCriteria(CarCompany.class);
	    	   List<CarCompany> list=criteria.list();
	    	   list.forEach(company->{
	    		   System.out.println("parent ::"+company);
	    		   Set<CarModel> childs=company.getModels();
	    		   childs.forEach(model->{
	    			   System.out.println("Child::"+model);
	    		   });
	    	   });
	    	   
		  }//try
		  catch(HibernateException he) {
			  he.printStackTrace();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
	}
	
	@Override
	public void deleteOneChildFromCollectionOfChildsBelongingToAParent() {
		// get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				var flag=false;  // type inference variable  (from java 10 ..)
				  try {
			    	   if(!ses.getTransaction().isActive())
			    		     tx=ses.beginTransaction();
			    	   //Load parent obj
			    	   CarCompany company=ses.get(CarCompany.class, 153);
			    	   //get all its childs
			    	   Set<CarModel> models=company.getModels();
			    	   //Load Specific Child object
			    	   CarModel model=ses.get(CarModel.class,101L);
			    	   models.remove(model);
			    	   flag=true;
				  }//try
				  catch(HibernateException he) {
					  flag=false;
					  he.printStackTrace();
				  }
				  catch(Exception e) {
					  flag=false;
					  e.printStackTrace();
				  }
				  finally {
					  //perform TxMgmt
					    if(flag) {
					    	System.out.println("Object is deleted");
					    	tx.commit();
					    }
					    else {
					    	System.out.println("Object is not deleted");
					    	tx.rollback();
					    }
				  }
		
	}
	
}//class
