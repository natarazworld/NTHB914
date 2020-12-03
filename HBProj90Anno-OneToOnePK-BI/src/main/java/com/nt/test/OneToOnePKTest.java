package com.nt.test;

import com.nt.dao.IOneToOnePKDAO;
import com.nt.dao.OneToOneDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOnePKTest {

	public static void main(String[] args) {
		IOneToOnePKDAO dao=null;
		//create DAO
		dao=new OneToOneDAOImpl();
		//save object
		dao.saveDataUsingParent();
        //close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
