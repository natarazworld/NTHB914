package com.nt.test;

import java.util.List;

import com.nt.dao.IInsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOImpl;
import com.nt.entity.InsurancePolicy;

public class PRocedureCallTest {
   public static void main(String[] args) {
	   IInsurancePolicyDAO dao=null; 
	   List<InsurancePolicy> list=null;
	   String result[]=null;
	//create DAO class object
	   dao=new InsurancePolicyDAOImpl();
	   //invoke method
	   list=dao.getPolociesByTenure(20,35);
	   list.forEach(System.out::println);
	   System.out.println("......................");
	   result=dao.getPolocyById(9003);
	   System.out.println(result[0]+"   "+result[1]+"  "+result[2]);
   }//main
}//class