package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class InsurancePolicyDAOImpl implements IInsurancePolicyDAO {
    //private static final String HQL_TRANSFER_INSURANCE_POLICIES="INSERT INTO com.nt.entity.PremiumInsurancePolicy(pid,policyName,company,policyType,tenure) SELECT i.policyId,i.policyName,i.company,i.policyType,i.tenure FROM com.nt.entity.InsurancePolicy as i WHERE i.tenure>=:min ";  
	/*	@Override
		public String transferPremiumPolicies(int minTenure) {
			Session ses=null;
			Transaction tx=null;
			int count=0;
			Query query=null;
			boolean flag=false;
			String msg=null;
			//get Session 
			ses=HibernateUtil.getSession();
			try {
				//begin Tx
				tx=ses.beginTransaction();
				//prepare Query object
				  query=ses.createQuery(HQL_TRANSFER_INSURANCE_POLICIES);
				  //set values to query params
				  query.setParameter("min",minTenure);
				  //execute the Query
				  count=query.executeUpdate();
				  flag=true;
			}
			catch(HibernateException he) {
				he.printStackTrace();
				flag=false;
			}
			finally {
				if(flag) {
					tx.commit();
				msg="no.of records that are copied::"+count;
				}
				else {
					tx.rollback();
					msg="record not copied/inserted";
				}
			}
			return msg;
		}//method
	*/
	
		@Override    // With Named Queries
	public String transferPremiumPolicies(int minTenure) {
		Session ses=null;
		Transaction tx=null;
		int count=0;
		Query query=null;
		boolean flag=false;
		String msg=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			//prepare Query object having access to NamedQuery
			  query=ses.getNamedQuery("HQL_INSERT_TRANSFER_POLICIES");
			  //set values to query params
			  query.setParameter("min",minTenure);
			  //execute the Query
			  count=query.executeUpdate();
			  flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
			msg="no.of records that are copied::"+count;
			}
			else {
				tx.rollback();
				msg="record not copied/inserted";
			}
		}
		return msg;
	}//method

	
}//class
