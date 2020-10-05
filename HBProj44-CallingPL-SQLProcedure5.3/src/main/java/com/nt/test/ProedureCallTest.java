package com.nt.test;

import com.nt.dao.AuthenticationDAOImpl;
import com.nt.dao.IAuthenticationDAO;
import com.nt.utility.HibernateUtil;

public class ProedureCallTest {

	public static void main(String[] args) {
		IAuthenticationDAO dao=null;
		//create DAO
		dao=new AuthenticationDAOImpl();
		//invoke method
		System.out.println(dao.authenticate("raja", "rani"));
		
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
