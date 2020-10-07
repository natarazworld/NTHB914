package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class CriteriaAPITest {

	public static void main(String[] args) {
		//get Session object
		Session ses=HibernateUtil.getSession();
		/*Transaction tx=null;
		try {
			//create or Locate Tx
			if(!ses.getTransaction().isActive())
		           tx=ses.beginTransaction();
			// Create Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
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
		}*/
		//=========== Adding condtions (Criterion objs) to Criteria object ====================
		Transaction tx=null;
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
		}
		
	}//main
}//cass
