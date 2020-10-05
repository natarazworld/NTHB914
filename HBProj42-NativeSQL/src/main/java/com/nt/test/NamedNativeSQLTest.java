package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		// get HB Session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			 //get Access to Named NativeSQL query
			NativeQuery<Object[]>  nquery=ses.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");
			//set value to query params
			nquery.setParameter(1,"LIFE");
			//execute query
			List<Object[]> list=nquery.getResultList();
			list.forEach(row->{
				for(Object o:row)
					System.out.print(o+"  ");
				System.out.println();
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
