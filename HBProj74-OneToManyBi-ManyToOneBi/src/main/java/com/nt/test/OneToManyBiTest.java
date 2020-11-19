package com.nt.test;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOImpl;
import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {
	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=new OneToManyDAOImpl();
		//use DAO
		//dao.saveDataUsingParent();
		// dao.saveDataUsingChilds();
		//dao.loadDataUsingParent();
	    dao.loadDataUsingChild();
		
	}//main
}//class
