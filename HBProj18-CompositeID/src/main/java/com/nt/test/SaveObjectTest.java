package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		ProgrammerProjectInfo info=null;
		PrgmrProjId id=null;
		boolean flag=false;
			//get Session 
			ses=HibernateUtil.getSession();
			
			try {
				//begin Tx
				tx=ses.beginTransaction();
			     //prepare Entity object
			       id=new PrgmrProjId();
			       id.setPid(101); id.setProjId(5001);
			       info=new ProgrammerProjectInfo();
			       info.setId(id); info.setPname("rajesh"); info.setProjName("OpenFx");
			       info.setDeptNo(567);
			       //save object
			        id=(PrgmrProjId) ses.save(info);
			        System.out.println("Generated id value::"+id);
				    flag=true;
		}//try
			catch(HibernateException he) {
				flag=false;
				he.printStackTrace();
			}
			catch(Exception e) {
				flag=false;
				e.printStackTrace();
			}
			finally {
				//Perform TxMgmt
				if(flag) {
					tx.commit();
					System.out.println("object is saved");
				}
				else {
					tx.rollback();
					System.out.println("Object is not saved");
				}
				//close objs
				HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
		
	}//class
}//main
