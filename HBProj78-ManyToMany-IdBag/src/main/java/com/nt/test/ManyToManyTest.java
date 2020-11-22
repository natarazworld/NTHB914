package com.nt.test;



import com.nt.dao.IManyToManyDAO;
import com.nt.dao.ManyToManyDAOImpl;

public class ManyToManyTest {

	public static void main(String[] args) {
		//create DAO class object
		IManyToManyDAO dao=new ManyToManyDAOImpl();
		//invoke methods
		dao.saveDataUsingParents();
		

	}//main
}//class
