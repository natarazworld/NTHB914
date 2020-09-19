package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.MySQLHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferDataDAOImpl implements TransferDataDAO {

	@Override
	public String transferProductById(int pid) {
		Session oraSes=null,mysqlSes=null;
		Transaction oraTx=null,mysqlTx=null;
		Product prod=null;
		var idVal=0;
		var flag=false;   // java 10 local variable type inference (compiler decides the datype based on the initial that is assigned) 
		//get Both session objects
		oraSes=OracleHibernateUtil.getSession();
		mysqlSes=MySQLHibernateUtil.getSession();
		//Load product from Oracle DB s/w
		 oraTx=oraSes.beginTransaction();  //dummy Tx for oracle
		 prod=oraSes.get(Product.class, pid);
		 if(prod==null)
			    return "No record found";
		 else {
			 try {
				 mysqlTx=mysqlSes.beginTransaction();
				   idVal=(int)mysqlSes.save(prod);
				   flag=true;
			 }
			 catch(HibernateException he) {
				 he.printStackTrace();
				 flag=false;
			 }
			 finally {
				 //perform TxMgmt
				  if(flag) {
					  mysqlTx.commit();
					 return "record copied from oracle DB to mysql DB having idVal::"+idVal;
				  }//if
				  else {
					  mysqlTx.rollback();
					  return "record not copied from oracle DB to mysql DB ";
				  }
			 }//finally
		 }//else
		 
		 }//method
	}//classs
