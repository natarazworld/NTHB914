package com.nt.test;

import com.nt.dao.IMToMDAO;
import com.nt.dao.MToMDAOImpl;
import com.nt.utility.HibernateUtil;

public class MToMAnnoTest {

	public static void main(String[] args) {
		//create DAO
		IMToMDAO dao=new MToMDAOImpl();
		//dao.saveDataUsingParent();
		dao.saveDataUsingChild();

		 //close sessionfactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
