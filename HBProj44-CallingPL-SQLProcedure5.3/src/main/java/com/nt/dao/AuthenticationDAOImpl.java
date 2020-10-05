package com.nt.dao;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import com.nt.utility.HibernateUtil;

/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
(
  USERNAME IN VARCHAR2 
, PASSWORD IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
  CNT  NUMBER(5);
BEGIN
  SELECT COUNT(*) INTO CNT FROM USERINFO  WHERE UNAME=USERNAME AND PWD=PASSWORD;

  IF(CNT<>0) THEN
    RESULT:='VALID CREDENTIALS';
   ELSE
    RESULT:='INVALID CREDENTIALS';
  END IF;  
END P_AUTHENTICATION;
*/
public class AuthenticationDAOImpl implements IAuthenticationDAO {

	@Override
	public String authenticate(String username, String password) {
	   Session ses=null;
	   Transaction tx=null;
	   ProcedureCall call=null;
	   String result=null;
		//get Session object
	   ses=HibernateUtil.getSession();
	   //Locate /create Tx
	   if(!ses.getTransaction().isActive())
		     tx=ses.beginTransaction();
	   //create Procedure Call object
	    call=ses.createStoredProcedureCall("P_AUTHENTICATION");
	  //register IN ,OUT params with JDBC types and also IN params with values
	    call.registerParameter(1,String.class, ParameterMode.IN).bindValue(username);
	    call.registerParameter(2,String.class, ParameterMode.IN).bindValue(password);
	    call.registerParameter(3,String.class,ParameterMode.OUT);
	    //call PL/SQL procedure
	    result=(String) call.getOutputParameterValue(3);
		return result;
	}//method
}//class
