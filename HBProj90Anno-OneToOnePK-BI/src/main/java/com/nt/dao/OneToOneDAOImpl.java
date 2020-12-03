package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CanteenCard;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements IOneToOnePKDAO {

	@Override
	public void saveDataUsingParent() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//prepare object
		Employee emp=new Employee("raja", "hyd",90000.0f);
		CanteenCard  card=new CanteenCard("miltary","hyd","gold");
		emp.setCardDetails(card);
		card.setEmpDetails(emp);
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			     ses.save(emp);
			     flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//perform Tx Mgmt
			  if(flag) {
				  tx.commit();
				  System.out.println("Objects are saved");
			  }
			  else {
				  tx.rollback();
				  System.out.println("Objects are not saved");
			  }
		}//finally

	}//method
}//class
