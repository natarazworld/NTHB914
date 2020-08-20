package com.nt.thread.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;

public class MyRequest implements Runnable {
	private Session ses;
	private Product p;
	public MyRequest(Session ses,Product p) {
		this.ses=ses;
		this.p=p;
	}

	@Override
	public void run() {
		System.out.println("MyRequest.run()--->name::"+Thread.currentThread().getName());
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
	   try {
		   tx=ses.beginTransaction();
		   idVal=(Integer)ses.save(p);
		   flag=true;
		   System.out.println("generated id value::"+idVal);
	   }//try
	   catch(Exception e) {
		   flag=false;
		   e.printStackTrace();
	   }
	   finally {
		   if(flag)
			   tx.commit();
		   else
			   tx.rollback();
	   }

	}

}
