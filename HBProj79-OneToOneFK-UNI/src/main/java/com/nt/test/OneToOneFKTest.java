package com.nt.test;

import com.nt.dao.IOneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOImpl;

public class OneToOneFKTest 
{
    public static void main( String[] args )
    {
    	IOneToOneFKDAO dao=null;
      //create DAO
    	dao=new OneToOneFKDAOImpl();
    	dao.saveData();
    }
}
