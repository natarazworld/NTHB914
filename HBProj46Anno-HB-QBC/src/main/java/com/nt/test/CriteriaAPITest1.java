package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

import oracle.security.o3logon.a;



public class CriteriaAPITest1 {

	public static void main(String[] args) {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//===  Getting specific single col valye using HB-QBC Projections
		/*Transaction tx=null;
		try {
			//create or Locate Tx
			if(!ses.getTransaction().isActive())
		           tx=ses.beginTransaction();
			// Create Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
			//prepare Projection for single property
			Projection p1=Projections.property("company");
			//set Projection object to Criteria object
			criteria.setProjection(p1);
			//prepare Criterion object
			Criterion cond=Restrictions.like("company","______");
			//add Criterion object to Criteria obj
			criteria.add(cond);
			//execute QBC logic
			List<String> list=criteria.list();
			//process resukts
			list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}*/
		//===  Getting specific multiple col values using HB-QBC Projections
		/*Transaction tx=null;
		try {
			//create or Locate Tx
			if(!ses.getTransaction().isActive())
		           tx=ses.beginTransaction();
			// Create Criteria object
			Criteria criteria=ses.createCriteria(Project.class);
			//prepare Projection objects for multiple properties
			Projection p1=Projections.property("company");
			Projection p2=Projections.property("projId");
			//add Projections to ProjectionList object
			ProjectionList pList=Projections.projectionList();
			pList.add(p1); pList.add(p2);
			//create ProjectionList to Criteria
			criteria.setProjection(pList);
			//execute QBC logic
			List<Object[]> list=criteria.list();
			//process results
			list.forEach(row->{
				System.out.println(row[0]+"......"+row[1]);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}*/
		
		//===  Getting single aggregate result using HB-QBC Projections
				Transaction tx=null;
				try {
					//create or Locate Tx
					if(!ses.getTransaction().isActive())
				           tx=ses.beginTransaction();
					// Create Criteria object
					Criteria criteria=ses.createCriteria(Project.class);
					//prepare Projection object for aggragate result 
					Projection p1=Projections.max("cost");
                    //add Projection to Criteria
					criteria.setProjection(p1);
					//execute QBC logic
					List<Long> list=criteria.list();
					//process results
					System.out.println("records count::"+list.get(0));
					
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
				finally {
					HibernateUtil.closeSessionFactory();
				}
						
	}//main
}//cass
