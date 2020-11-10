package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingParent() {
		//get Session
				Session ses=HibernateUtil.getSession();
				//prepare objects
				  //child objs
				PhoneNumber ph1=new PhoneNumber(7999999L,"residence","airtel");
				PhoneNumber ph2=new PhoneNumber(68888888L,"officee","vi");
				Set<PhoneNumber> phonesSet=Set.of(ph1, ph2);
				  //parent obj
				 UserInfo user=new UserInfo("suresh","hyd");
				 //set childs to parent
				 user.setPhones(phonesSet);
				
				Transaction tx=null;
				boolean flag=false;
				try {
					//begin Tx
					if(!ses.getTransaction().isActive())
						 tx=ses.beginTransaction();
					//save objs
					 // ses.save(user);
					ses.persist(user);
					  flag=true;
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				finally {
					//Tx Mgmt
					if(flag) {
						tx.commit();
						System.out.println("parent to child objs are saved");
					}
					else {
						tx.rollback();
						System.out.println("parent to child objs are not saved");
					}
						//close session factory
					HibernateUtil.closeSessionFactory();
				}//finally

	}//method

	@Override
	public void loadDataUsingParent() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load parent object
		  Query query=ses.createQuery("from UserInfo");
			List<UserInfo> list=query.getResultList();
			list.forEach(user->{
				System.out.println("parent::"+user.getUserId()+"  "+user.getUsername()+"  "+user.getAddrs());
				//get associated childs of a parent
				Set<PhoneNumber> childs=user.getPhones();
				System.out.println(childs.isEmpty());
				childs.forEach(ph->	System.out.println("child :"+ph));
			});
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally

	}//method
	
	@Override
	public void addNewChildToExistingParent() {
		//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				boolean flag=false;
				try {
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
					 //Load existing Parent object
					UserInfo user=ses.get(UserInfo.class,1);
					//get all existing childs of a parent
					Set<PhoneNumber> childs=user.getPhones();
					//create new Child
					PhoneNumber ph=new PhoneNumber(6888888, "personal", "jio");
					//add existing childs
					childs.add(ph);
					flag=true;
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				finally {
					//Tx Mgmt
					if(flag) {
						tx.commit();
						System.out.println("new child is added to existing parent");
					}
					else {
						tx.rollback();
						System.out.println("problem in adding new child to existing parent");
					}
						//close session factory
					HibernateUtil.closeSessionFactory();
				}//finally
		
	}//method
	
	@Override
	public void deletingAParentAndItsChilds() {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load a parent
			UserInfo user=ses.get(UserInfo.class, 2);
			//delete the parent 
			 ses.delete(user);
			 flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			//Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println(" parent and its childs are deleted successfully ");
			}
			else {
				tx.rollback();
				System.out.println("Problem in deleting a parent and its childs");
			}
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//method
	
	@Override
	public void deleteAllParentsAndTheirChilds() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load all parent objs.. so assocatied child objs of those parent objects will be loaded automatically
			Query query=ses.createQuery("from com.nt.entity.UserInfo");
		    List<UserInfo> list=query.getResultList();
		    list.forEach(user->{
		    	ses.delete(user);
		    });
           flag=true;			
		}//try
			finally {
				//Tx Mgmt
				if(flag) {
					tx.commit();
					System.out.println(" all parents and their childs are deleted successfully ");
				}
				else {
					tx.rollback();
					System.out.println("Problem in deleting all parent and their childs");
				}
					//close session factory
				HibernateUtil.closeSessionFactory();
			}//finally
		
	}//method
	
	@Override
	public void deleteAllParentsAndTheirChilds1() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//direct parent record deletion.. that throws exception..
			Query query=ses.createQuery("delete from com.nt.entity.UserInfo on  delete cascade");  //throws Exception::  java.sql.SQLIntegrityConstraintViolationException: ORA-02292: integrity constraint (SYSTEM.FKTDTSU7E61OWMWCPRRSQ3GPLC) violated - child record found
		    count=query.executeUpdate();
           flag=true;			
		}//try
			finally {
				//Tx Mgmt
				if(flag) {
					tx.commit();
					System.out.println(" all parents and their childs are deleted successfully -->"+count);
				}
				else {
					tx.rollback();
					System.out.println("Problem in deleting all parent and their childs");
				}
					//close session factory
				HibernateUtil.closeSessionFactory();
			}//finally
		
	}//method
	
	@Override
	public void deleteAllChildsOfAParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load parent
			UserInfo user=ses.get(UserInfo.class, 2);
			//get All childs of a loaded parent
			Set<PhoneNumber> phones=user.getPhones();
			phones.removeAll(phones);
			flag=true;
		}//try
		finally {
			//Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println(" all childs of parent are deleted successfully ");
			}
			else {
				tx.rollback();
				System.out.println("Problem in deleting all childs of a parent");
			}
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
	}
	
	@Override
	public void deleteOneChildFromCollectionOfChildsFromAParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Load parent object(UserInfo) from DB
			UserInfo user=ses.get(UserInfo.class,2);
			//get All childs of a parent
			Set<PhoneNumber> childs=user.getPhones();
			//Load specific child(PhonerNumber) from Db
			PhoneNumber ph=ses.get(PhoneNumber.class, 75);
			childs.remove(ph);
			flag=true;
		}//try
		finally {
			//Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println(" one child from collection of childs Belonging to parent deleted ");
			}
			else {
				tx.rollback();
				System.out.println(" one child from collection of childs Belonging to parent not deleted");
			}
				//close session factory
			HibernateUtil.closeSessionFactory();
		}//finally
	}//method
	
	@Override
	public void transferOneChildOfOneParentToAnotherParent() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int count=0;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			     //Load Source Parent obj
			UserInfo user1=ses.get(UserInfo.class,4);
			    // get all childs of a  source Parent
			Set<PhoneNumber> user1Childs=user1.getPhones();
			//Load child object from Db s/w. (which we want to transfer)
			PhoneNumber ph1=ses.get(PhoneNumber.class,76);
			//get Dest parent object
		     //Load Source Parent obj
			UserInfo user2=ses.get(UserInfo.class,3);
		    // get all childs of a Dest Parent
		Set<PhoneNumber> user2Childs=user2.getPhones();
          //delete child from source parent and add to dest parent (transfering child)
		user2Childs.add(ph1);   //no need of calling  user1Childs.remove(ph1);
		   flag=true;
		   ses.flush();
		}//try			
			finally {
				//Tx Mgmt
				if(flag) {
					tx.commit();
					System.out.println(" child is trasffered");
				}
				else {
					tx.rollback();
					System.out.println("child is not transffered");
				}
					//close session factory
				HibernateUtil.closeSessionFactory();
			}//finally
	}//method

}//class
