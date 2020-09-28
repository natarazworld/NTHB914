package com.nt.test;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class HQLNonSelectTest {

	public static void main(String[] args) {
		// get SEssion ob
		Session ses = HibernateUtil.getSession();
		 //=================== HQL SELECT UPDATe Query ================
		boolean flag=false;
		Transaction tx=null;
		int count=0;
		try {
			tx=ses.beginTransaction(); //mandatory
			//prepare Query object
			Query query=ses.createQuery("  UPDATE com.nt.entity.InsurancePolicy  SET  tenure=tenure  +:bonusYears WHERE policyName like :initialLetters");
			//set query param value
			query.setParameter("bonusYears",10);
			query.setParameter("initialLetters","J%");
			//execute Query
			count=query.executeUpdate();
		   flag=true;
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
				flag=false;
			}
			finally {
				if(flag) {
					tx.commit();
					 System.out.println("no.of records that are effected::"+count);
				}
				else {
					tx.rollback();
				}
				HibernateUtil.closeSessionFactory();
			}//finally
		
	}// main
}// class
