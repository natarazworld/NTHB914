package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {
	

	@Override
	public Product getProduct(int pid) {
		Session ses=null,ses1=null;
		Product prod=null;
		Transaction tx=null;
	        //get SEssion object
		ses=HibernateUtil.getSession();
		ses1=HibernateUtil.getSession();
		// dummy Begin Tx
		 tx=ses.beginTransaction();
		System.out.println(ses.hashCode()+"   "+ses1.hashCode());
		//get/load object
		prod=ses.get(Product.class, pid);
		return prod;
	}

}
