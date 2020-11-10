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

public class OneToManyITest {
	public static void main(String[] args) {
		 //get DAO
		OneToManyDAO dao=new OneToManyDAOImpl();
		//use DAO
		//dao.saveDataUsingParent();
		//dao.loadDataUsingParent();
		//dao.addNewChildToExistingParent();
		//dao.deletingAParentAndItsChilds();
		//dao.deleteAllParentsAndTheirChilds();
		//dao.deleteAllParentsAndTheirChilds1();
		//dao.deleteAllChildsOfAParent();
		dao.deleteOneChildFromCollectionOfChildsFromAParent();
		//dao.transferOneChildOfOneParentToAnotherParent();
		
	}//main
}//class
