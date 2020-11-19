package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtil;


public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void loadDataUsingParent() {
		
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//execute HQL query
			Query query=ses.createQuery("from UserInfo");
			List<UserInfo> list=query.getResultList();
			list.forEach(user->{
				System.out.println("parent::"+user);
				//get the childs of each parent
				Set<PhoneNumber> childs=user.getPhones();
				childs.forEach(ph->{
					System.out.println("child ::"+ph);
				});
			});
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSessionFactory();
		}
		
	}//method

	@Override
	public void loadDataUsingParentThroughQBC() {
		// get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				try {
					if(!ses.getTransaction().isActive())
						 tx=ses.beginTransaction();
					//prepare Criteria object
					Criteria criteria=ses.createCriteria(UserInfo.class);
					criteria.setFetchMode("phones",FetchMode.DEFAULT);
					List<UserInfo> list=criteria.list();
					list.forEach(user->{
						System.out.println("parent ::"+user);
						/*	Set<PhoneNumber> childs=user.getPhones();
							childs.forEach(ph->{
								System.out.println("child::"+ph);
							});*/
					});
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
				finally {
					//close  objs
					HibernateUtil.closeSessionFactory();
				}
	}//method
	
	@Override
	public void loadDataUsingParentThroughJPQBC() {
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//create Criteria Builder
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<UserInfo> ctQuery=builder.createQuery(UserInfo.class);
			//create  Root object
			Root<UserInfo>root=ctQuery.from(UserInfo.class);
			root.fetch("phones",JoinType.LEFT);
			//add Root object CriteriaQuery object
			ctQuery.select(root);
			//prepare Query object
			Query query=ses.createQuery(ctQuery);
			List<UserInfo> list=query.getResultList();
			list.forEach(user->{
				System.out.println("parent ::"+user);
				Set<PhoneNumber> childs=user.getPhones();
				childs.forEach(ph->{
					System.out.println("child::"+ph);
				});
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSessionFactory();
		}
	}//method
	
	@Override
	public void LoadDataUisngParentThroughHQLJoin() {
		// get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				try {
					if(!ses.getTransaction().isActive())
						 tx=ses.beginTransaction();
					//execute HQL Join Query
					Query query=ses.createQuery("select u from UserInfo  u inner join fetch u.phones ph ");
					List<UserInfo> list=query.getResultList();
					list.forEach(user->{
						System.out.println("parent :"+user);
						Set<PhoneNumber> childs=user.getPhones();
						childs.forEach(ph->{
							System.out.println("child::"+ph);
						});
					});
					
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
				finally {
					//close  objs
					HibernateUtil.closeSessionFactory();
				}
	}//method
	
	@Override
	public void LoadDataUisngParentThroughHQLJoinScalar() {
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//execute HQL Join Query
			Query query=ses.createQuery("select u.userId,u.username,u.addrs ,ph.regNo,ph.phone,ph.type,ph.provider from UserInfo u inner join  u.phones ph ");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) 
					System.out.print(val+"  ");
				
				System.out.println();
			});
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//close  objs
			HibernateUtil.closeSessionFactory();
		}
		
	}

	
}//class
