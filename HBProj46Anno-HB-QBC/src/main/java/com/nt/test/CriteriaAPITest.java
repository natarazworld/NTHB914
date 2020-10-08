package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;



public class CriteriaAPITest {

	public static void main(String[] args) {
		//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			//create or Locate Tx
			if(!ses.getTransaction().isActive())
		           tx=ses.beginTransaction();
			// Create Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
			//pagination settings
			criteria.setFirstResult(1);
			criteria.setMaxResults(3);
			//execute QBC logic
			List<Project> list=criteria.list();
			//process resukts
			list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
		//=========== Adding condtions (Criterion objs) to Criteria object ====================
		/*	Transaction tx=null;
			try {
				//create or Locate Tx
				if(!ses.getTransaction().isActive())
			           tx=ses.beginTransaction();
				//prepare Criteria object
				Criteria criteria=ses.createCriteria(Project.class);
				//prepare Criterion objects
				Criterion cond1=Restrictions.ge("teamSize",10);
				Criterion cond2=Restrictions.le("teamSize",20);
				//add Criterion objs to Criteria object
				criteria.add(cond1); criteria.add(cond2);
				//Order object
				Order order1=Order.asc("location");
				Order order=Order.desc("projName");
				criteria.addOrder(order);
				criteria.addOrder(order1);
				//execute QBC logic
				List<Project> list=criteria.list();
				//process results
				list.forEach(System.out::println);
			}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}*/
		
		/*//=========== Adding multiple condtions (Criterion objs) with or and and clauses to Criteria object ====================
			Transaction tx=null;
					try {
						//create or Locate Tx
						if(!ses.getTransaction().isActive())
					           tx=ses.beginTransaction();
						//prepare Criteria object
						Criteria criteria=ses.createCriteria(Project.class);
						//prepared Criteria objects
						Criterion cond1=Restrictions.between("teamSize", 10, 20);
						//Criterion cond2=Restrictions.in("company",List.of("TATA","POLARIS"));
						Criterion cond2=Restrictions.in("company","TATA","POLARIS");
						Criterion cond3=Restrictions.ilike("projName","o%");
						//create Criterion object having and clause b/w cond1,cond2 , or caluse with cond3
						Criterion finalCond=Restrictions.or(Restrictions.and(cond1,cond2),cond3);
						//add Criterion obj to Criteria obj
						criteria.add(finalCond);
						//execute QBC logic
						List<Project> list=criteria.list();
						list.forEach(System.out::println);                   
					}//try
					catch(HibernateException he) {
						he.printStackTrace();
					}
					finally {
						HibernateUtil.closeSessionFactory();
					}	*/
					
			//=========== Adding Sqlcondtion based Criterion object ===============
		/*	Transaction tx=null;
					try {
						//create or Locate Tx
						if(!ses.getTransaction().isActive())
					           tx=ses.beginTransaction();
						//prepare Criteria object
						Criteria criteria=ses.createCriteria(Project.class);
						//create Criterion object
						Criterion  cond=Restrictions.sqlRestriction("rowNum>=? and rownum<=?",
								                                                                              new Object[] {1,3},
								                                                                              new Type[] {StandardBasicTypes.INTEGER,StandardBasicTypes.INTEGER});
						//add Criterion object to Criteria object
						criteria.add(cond);
						//execute QBC logic
						List<Project> list=criteria.list();
						list.forEach(System.out::println);                   
					}//try
					catch(HibernateException he) {
						he.printStackTrace();
					}
					finally {
						HibernateUtil.closeSessionFactory();
					}*/
							
					
	}//main
}//cass
