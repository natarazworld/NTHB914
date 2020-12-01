package com.nt.test;

import com.nt.dao.IManyToOneDAO;
import com.nt.dao.ManyToOneDAOImpl;
import com.nt.utility.HibernateUtil;

public class ManyToOneAnnoTest {

	public static void main(String[] args) {
		//create DAO
		IManyToOneDAO dao=new ManyToOneDAOImpl();
		//invoke methods
		 dao.saveDataUsingChilds();
		 
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
