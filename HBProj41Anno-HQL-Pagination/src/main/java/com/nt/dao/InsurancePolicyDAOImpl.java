package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsurancePolicyDAOImpl implements IInsurancePolicyDAO {

	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		Session ses=null;
		Query query=null;
		long count=0;
		List<InsurancePolicy> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//get Acccess to named HQL query
			query=ses.getNamedQuery("GET_ALL_POLICIES");
			//perform pagination
			query.setFirstResult(startPos);
			query.setMaxResults(pageSize);
			//excute query
			list=query.getResultList();
		}
		catch(HibernateException he) {
			he.printStackTrace();
			throw he;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}//method

	@Override
	public long getTotalRecordsCount() {
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		long count=0;
		List<Long> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			//get Acccess to named HQL query
			query=ses.getNamedQuery("GET_POLICIES_COUNT");
			//exdcute query
			list=query.getResultList();
			count=list.get(0);
		}
		catch(HibernateException he) {
			he.printStackTrace();
			throw he;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}//method

}//class
