package com.nt.test;

import com.nt.dao.IInsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOImpl;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		IInsurancePolicyDAO dao=null;
		  //create DAO class object
		dao=new InsurancePolicyDAOImpl();
		//invoke method
		System.out.println(dao.transferPremiumPolicies(25));
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
