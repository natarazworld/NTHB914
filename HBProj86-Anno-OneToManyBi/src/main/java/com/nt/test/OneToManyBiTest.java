package com.nt.test;

import com.nt.dao.IOneToManyBiDAO;
import com.nt.dao.OneToManyBiDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
	    //create DAO
		IOneToManyBiDAO dao=new OneToManyBiDAOImpl();
		//invoke method
		//dao.saveDataUsingParent();
		 dao.saveDataUsingChild();
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();

	}//main
}//class
