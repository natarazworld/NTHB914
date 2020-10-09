package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class JPACriteriaTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		//get Session object
		ses=HibernateUtil.getSession();
		/*	//========== Executing entity Query ==================
			try {
				if(!ses.getTransaction().isActive())
					 tx=ses.beginTransaction();
				
				   //create CriteriaBuiler object
			  CriteriaBuilder 	builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
			  CriteriaQuery<Project>  ctQuery=builder.createQuery(Project.class);
			  //Create Root obj specifying Entity class   /table name from which records should be selected
			  Root<Project> root=ctQuery.from(Project.class);
			  //add root object to CriteriaQuery object
			  ctQuery.select(root);
			  //prepare Query object having ctQuery obj
			  Query<Project> query=ses.createQuery(ctQuery);
			  //execute JPA QBC logic
			  List<Project> list=query.getResultList();
			  //process the Result
			  list.forEach(System.out::println);
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				//close SessionFactory
				HibernateUtil.closeSessionFactory();
			}
			*/
		
		//========== Executing entity Query  with conditions==================
		/*	try {
				if(!ses.getTransaction().isActive())
					 tx=ses.beginTransaction();
				
				   //create CriteriaBuiler object
			  CriteriaBuilder 	builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
			  CriteriaQuery<Project>  ctQuery=builder.createQuery(Project.class);
			  //Create Root obj specifying Entity class   /table name from which records should be selected
			  Root<Project> root=ctQuery.from(Project.class);
			  //add root object to CriteriaQuery object
			  ctQuery.select(root);
			  //create Parmaters
			  ParameterExpression<Long> param1=builder.parameter(Long.class);
			  ParameterExpression<Long> param2=builder.parameter(Long.class);
			  //create Predicate objects representing conditions and specifying parameters
			  Predicate pdc1=builder.ge(root.get("projId"), param1);   //   projId>=?
			  Predicate pdc2=builder.le(root.get("projId"), param2);   //   projId<=?
			  Predicate finalCond=builder.and(pdc1,pdc2);  //projId>=?  and projId<=?
			  //add Predicate object to CriteriaQuery object  as where clause condition 
			  ctQuery.where(finalCond); // where projId>=?  and projId<=?
			  //create Order obj
			   Order order=builder.desc(root.get("projName"));  // order by ProjName desc
			   //add order obj Criteria Query obj
			   ctQuery.orderBy(order);
			  //prepare Query object having ctQuery obj
			  Query<Project> query=ses.createQuery(ctQuery);
			  //set query param values 
			  query.setParameter(param1,1000L);
			  query.setParameter(param2,2000L);
			  //execute JPA QBC logic
			  List<Project> list=query.getResultList();
			  //process the Result
			  list.forEach(System.out::println);
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				//close SessionFactory
				HibernateUtil.closeSessionFactory();
			}*/
		
		/*try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			
			   //create CriteriaBuiler object
		  CriteriaBuilder 	builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
		  CriteriaQuery<Project>  ctQuery=builder.createQuery(Project.class);
		  //Create Root obj specifying Entity class   /table name from which records should be selected
		  Root<Project> root=ctQuery.from(Project.class);
		  ctQuery.select(root).
		                              where(builder.and(builder.ge(root.get("projId"),100L),
		                            		         builder.le(root.get("projId"),2000L))).orderBy(builder.desc(root.get("projName")));
		  //prepare Query
		  Query query=ses.createQuery(ctQuery);
		  //execute JPA -QBC
		 List<Project> list=query.getResultList();
		 //process result
		 list.forEach(System.out::println);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}*/
		
		/*try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			   //create CriteriaBuiler object
		  CriteriaBuilder 	builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
		  CriteriaQuery<Project>  ctQuery=builder.createQuery(Project.class);
		  //create Root object
		  Root<Project> root=ctQuery.from(Project.class);
		  //SQL :: select * from Project where  location in('hyd','delhi','vizag')  order by  projName desc
		  ctQuery.select(root).
		                   where((root.get("location").in("hyd","delhi","vizag"))).
		                   orderBy(builder.desc(root.get("projName")));
		  //prepare Query
		  Query query=ses.createQuery(ctQuery);
		  //execute JPA -QBC
		 List<Project> list=query.getResultList();
		 //process result
		 list.forEach(System.out::println);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}*/
		
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			   //create CriteriaBuiler object
		  CriteriaBuilder 	builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
		  CriteriaQuery<Project>  ctQuery=builder.createQuery(Project.class);
		  //create Root object
		  Root<Project> root=ctQuery.from(Project.class);
		  //prepare condtions
		  //SQL :: select * from Project where  teamSize between(10,20)  and  projName like 'o%' 
		  ctQuery.select(root).
		                   where(builder.
		                		         and(builder.between(root.get("teamSize"), 10,20),
		                		                 builder.like(root.get("projName"),"o%")
		                		                 )
		                		      );
		                   
		
		  //prepare Query
		  Query query=ses.createQuery(ctQuery);
		  //execute JPA -QBC
		 List<Project> list=query.getResultList();
		 //process result
		 list.forEach(System.out::println);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
