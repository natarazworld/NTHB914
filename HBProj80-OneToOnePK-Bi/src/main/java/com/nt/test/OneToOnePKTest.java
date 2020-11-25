package com.nt.test;

import com.nt.dao.IOneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;

public class OneToOnePKTest 
{
    public static void main( String[] args )
    {
       //create DAO
    	IOneToOnePKDAO dao=new OneToOnePKDAOImpl();
    	//invoke methods
    	//dao.saveDataUsingParent();
    	//dao.saveDataUsingChild();
    	dao.LoadDataUsingParent();
    	
    }//main
}//class
