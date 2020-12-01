package com.nt.test;

import com.nt.dao.IOneToManyDAO;
import com.nt.dao.OneToManyDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToManyTest 
{
    public static void main( String[] args )
    {
    	//create DAO
    	IOneToManyDAO dao=new OneToManyDAOImpl();
    	//invoke method
    	 dao.saveDataUsingParent();
    	
    	HibernateUtil.closeSessionFactory();
     
    }
}
