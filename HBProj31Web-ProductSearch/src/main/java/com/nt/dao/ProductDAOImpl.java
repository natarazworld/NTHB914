package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {
	

	@Override
	public Product getProduct(int pid) {
		Session ses=null,ses1=null;
		Product prod=null;
	        //get SEssion object
		ses=HibernateUtil.getSession();
		ses1=HibernateUtil.getSession();
		System.out.println(ses.hashCode()+"   "+ses1.hashCode());
		//get/load object
		prod=ses.get(Product.class, pid);
		return prod;
	}

}
