package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.IInsurancePolicy;
import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest1 {

	public static void main(String[] args) {
		Session ses=null;
		IInsurancePolicy policy=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy= ses.load(InsurancePolicy.class,9001L);
			System.out.println(policy.getClass()+"   "+policy.getClass().getSuperclass()+"  "+Arrays.toString(policy.getClass().getInterfaces()));
			   System.out.println(policy);
		}//try
		catch(HibernateException he) {
			System.out.println("record not found---");
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
