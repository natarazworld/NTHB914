package com.nt.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class FlushTest {

	public static void main(String[] args) {
		Session ses=null;
		Membership member=null;
		long idVal=0;
	     //get Session
		ses=HibernateUtil.getSession();
		//prepare object
		member=new Membership();
		member.setMid(56L);
		member.setName("rajesh");
		member.setAddrs("hyd1");
		member.setRewardPoints(43L);
		try {
			 idVal=(long) ses.save(member);
			 System.out.println("Generated id value::"+idVal);
			 ses.flush();
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			 //close objs
			 HibernateUtil.closeSession(ses);
			 HibernateUtil.closeSessionFactory();
		}
		
		}//main
}//class
