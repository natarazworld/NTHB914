package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Subscriber;
import com.nt.entity.TVChannel;
import com.nt.utility.HibernateUtil;

public class MToMDAOImpl implements IMToMDAO {

	@Override
	public void saveDataUsingParent() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//parepare objects
		TVChannel zee=new TVChannel("ZEETV","ZEE Entertainment", "India");
		TVChannel star=new TVChannel("STARTTV","Start india", "India");
		Subscriber raja=new Subscriber("raja rao","gold", "hyd");
		Subscriber suresh=new Subscriber("suresh ","silver", "delhi");
		Subscriber jani=new Subscriber("jani bhasha","gold", "mumbai");
		//set childs to parent
		zee.setSubscribers(List.of(raja,suresh));
		star.setSubscribers(List.of(raja,suresh,jani));
		//set parents to childs
		raja.setChannels(List.of(zee,star));
		suresh.setChannels(List.of(zee,star));
		jani.setChannels(List.of(star));
		Transaction tx=null;
				boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//save objs
			  ses.save(zee); ses.save(star);
			  flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			//perform Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are  not saved");
			}
		}
	}//method
	
	@Override
	public void saveDataUsingChild() {
		//get Session object
				Session ses=HibernateUtil.getSession();
				//parepare objects
				TVChannel sony=new TVChannel("SONY","SONY Entertainment", "India");
				TVChannel ETV=new TVChannel("ETV","RGC", "india");
				Subscriber ramesh=new Subscriber("ramesh","gold", "hyd");
				Subscriber anil=new Subscriber("anil ","silver", "delhi");
				Subscriber teja=new Subscriber("Teja","gold", "mumbai");
				//set childs to parent
				sony.setSubscribers(List.of(ramesh,anil));
				ETV.setSubscribers(List.of(anil,teja,ramesh));
				//set parents to childs
				ramesh.setChannels(List.of(sony,ETV));
				anil.setChannels(List.of(sony,ETV));
				teja.setChannels(List.of(ETV));
				Transaction tx=null;
						boolean flag=false;
				try {
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
					//save objs
					  ses.save(anil); ses.save(teja); ses.save(ramesh);
					  flag=true;
				}
				catch(HibernateException he) {
					flag=false;
					he.printStackTrace();
				}
				catch(Exception e) {
					flag=false;
					e.printStackTrace();
				}
				finally {
					//perform Tx Mgmt
					if(flag) {
						tx.commit();
						System.out.println("Objects are saved");
					}
					else {
						tx.rollback();
						System.out.println("Objects are  not saved");
					}
				}//finally
		
	} //method
}//class
