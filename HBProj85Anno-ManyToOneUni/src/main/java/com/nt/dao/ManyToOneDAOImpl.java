package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PoliticalLeader;
import com.nt.entity.PoliticalParty;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl  implements IManyToOneDAO{

	@Override
	public void saveDataUsingChilds() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		  PoliticalParty party1=new PoliticalParty("BJP","saffron-Green","Lotus");
		  PoliticalLeader  leader1=new PoliticalLeader("modi", "PM","delhi");
		  PoliticalLeader  leader2=new PoliticalLeader("yogi", "CM","UP");
		  //map parent to childs
		  leader1.setParty(party1);
		  leader2.setParty(party1);
		  
		  PoliticalParty party2=new PoliticalParty("AAP","white","Broom");
		  PoliticalLeader  leader3=new PoliticalLeader("Aravind", "CM","delhi");
		  PoliticalLeader  leader4=new PoliticalLeader("prasanth", "D-CM","delhi");
		  leader3.setParty(party2);
		  leader4.setParty(party2);
		  
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			    ses.save(leader1); ses.save(leader2); ses.save(leader3); ses.save(leader4);
			 flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}//finally
		
	}//method
}//class
