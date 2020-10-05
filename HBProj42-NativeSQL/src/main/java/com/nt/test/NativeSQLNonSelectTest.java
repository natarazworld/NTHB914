package com.nt.test;

import java.awt.HeadlessException;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.utility.HibernateUtil;

public class NativeSQLNonSelectTest {

	public static void main(String[] args) {
		// get HB Session obj
		Session ses=HibernateUtil.getSession();
	     //============ Inserting record with direct values =========================
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		try {
			//Locate/Begin Tx
			if(!ses.getTransaction().isActive())
			        tx=ses.beginTransaction();
			//create NativeQuery object having Native SQL query
			NativeQuery nquery=ses.createSQLQuery("INSERT INTO INSURANCEPOLICY VALUES(POLICYID_SEQ.NEXTVAL,?,?,?,?)");
			//set values to query params
			nquery.setParameter(1,"JA++");
			nquery.setParameter(2, "Life");
			nquery.setParameter(3,"TATA");
			nquery.setParameter(4,15);
			//execute the query
			count=nquery.executeUpdate();
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Record insert :: count"+count);
			}
			else {
				tx.rollback();
				System.out.println("record not inserted");
			}
		}//finally
	}//main
}//class
