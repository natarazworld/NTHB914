package com.nt.test;

import com.nt.dao.TransferDataDAO;
import com.nt.dao.TransferDataDAOImpl;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class InteractingWithTwoDBsTest {

	public static void main(String[] args) {
		TransferDataDAO dao=null;
		//create DAO
		dao=new TransferDataDAOImpl();
		//invoke methods
		System.out.println(dao.transferProductById(16));
		
		//close SEssion factory
		OracleHibernateUtil.closeSessionFactory();
		MySQLHibernateUtil.closeSessionFactory();
	}//main
}//class
