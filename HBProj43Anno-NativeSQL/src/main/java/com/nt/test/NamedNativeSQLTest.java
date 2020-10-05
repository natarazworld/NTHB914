package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		// get HB Session obj
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int count=0;
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
			System.out.println("================================");
			 //get Access to Named NativeSQL query
			NativeQuery<InsurancePolicy>  nquery1=ses.getNamedNativeQuery("GET_ALL_POLICIES");
			//execute query
			List<InsurancePolicy> list1=nquery1.getResultList();
			list1.forEach(System.out::println);
			
			System.out.println("================================");
			 //get Access to Named NativeSQL query
			NativeQuery<InsurancePolicy>  nquery2=ses.getNamedNativeQuery("DELETE_POLICY_BY_ID");
			//set value to query param
			nquery2.setParameter("id",678L);
			//execute query
			 count=nquery2.executeUpdate();
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			
			if(flag) {
				tx.commit();
				System.out.println("no.of record effted::"+count);
			}
			else {
				tx.rollback();
				System.out.println("records not deleted");
			}
			//close session factiry
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
