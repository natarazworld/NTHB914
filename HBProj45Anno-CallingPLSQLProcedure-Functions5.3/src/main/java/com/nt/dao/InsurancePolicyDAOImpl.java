package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

/*CREATE OR REPLACE PROCEDURE P_GET_POLICIES_BY_TENURE 
(
  MINTENURE IN NUMBER 
, MAXTENURE IN NUMBER 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  
  OPEN DETAILS FOR
    SELECT POLICYID,POLICYNAME,POLICYTYPE,COMPANY,TENURE FROM INSURANCEPOLICY WHERE TENURE>=MINTENURE AND TENURE<=MAXTENURE;
  
END ;
======================================================================
CREATE OR REPLACE FUNCTION FX_GET_POLICY_DETAILS_BY_ID 
(
  ID IN NUMBER 
, NAME OUT VARCHAR2 
, DURATION OUT NUMBER 
) RETURN VARCHAR2 AS 
 FIRM VARCHAR2(10);
BEGIN
  
  SELECT POLICYNAME,COMPANY,TENURE INTO NAME,FIRM,DURATION FROM INSURANCEPOLICY WHERE POLICYID=ID;
  
  RETURN FIRM;
END;
*/
public class InsurancePolicyDAOImpl implements IInsurancePolicyDAO {

	@Override
	public List<InsurancePolicy> getPolociesByTenure(int start, int end) {
		Session ses=null;
		Transaction tx=null;
		ProcedureCall call=null;
		Output output=null;
		ResultSetOutput rsOutput=null;
		List<InsurancePolicy> list=null;
		//get Session object
		ses=HibernateUtil.getSession();
		// begin Tx
		if(!ses.getTransaction().isActive())
			 tx=ses.beginTransaction();
		//create PorcedureCall object
		call=ses.createStoredProcedureCall("P_GET_POLICIES_BY_TENURE" ,InsurancePolicy.class);
		//register both IN,OUT params and set values to IN params
		call.registerParameter(1, Integer.class,ParameterMode.IN).bindValue(start);
		call.registerParameter(2, Integer.class,ParameterMode.IN).bindValue(end);
		call.registerParameter(3,Class.class,ParameterMode.REF_CURSOR );
		//pagination
		//call.setFirstResult(0); call.setMaxResults(2);
		//call PL/SQP proceure  and get ouput
		output=call.getOutputs().getCurrent();
		rsOutput=(ResultSetOutput)output;
		//get ResultList object from rsOutput
		list=rsOutput.getResultList();
		return list;
	}

	@Override
	public String[] getPolocyById(int id) {
		Session ses=null;
		Transaction tx=null;
	    //get Session object
		ses=HibernateUtil.getSession();
		//create/Locate Tx
		if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
		   String result[]=ses.doReturningWork(new ReturningWork<String[]>() {

			@Override
			public String[] execute(Connection con) throws SQLException {
				CallableStatement cs=null;
				String outputs[]=null;
				//create CallableStatement object
				cs=con.prepareCall("{?=call  FX_GET_POLICY_DETAILS_BY_ID(?,?,?)}");
				//register OUT,RETURN params with JDBC types
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4, Types.INTEGER);
				//set values to IN param
				cs.setInt(2,id);
				//execute PL/SQL function
				cs.execute();
				//gather results  from return ,out params
				outputs=new String[3];
				outputs[0]=cs.getString(1); //company
				outputs[1]=cs.getString(3); //name
				outputs[2]=String.valueOf(cs.getInt(4));
			return outputs;
			}//method
		}//anonymous inner class
		   );  //method call
		
		return result;
	}//method

}//class
