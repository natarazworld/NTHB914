package com.nt.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobSeeker;
import com.nt.utility.HibernateUtil;

public class LOBsSelectTest {

	public static void main(String[] args) {
		
		byte imageContent[]=null;
		char textContent[]=null;
			//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				FileOutputStream fos=null;
				FileWriter writer=null;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//load object
			JobSeeker seeker=ses.get(JobSeeker.class,46);
			//create Dest image file having byte[] content
			 fos=new FileOutputStream("store/photo.jpg");
			fos.write(seeker.getPhoto());
			
			 writer=new FileWriter("store/resume.txt");
			writer.write(seeker.getResume());
		    fos.flush();
		    writer.flush();
		    System.out.println("LOB files are retrieved");
		    System.out.println("JobSeeker info::"+seeker.getJsId()+" "+seeker.getJsName()+"  "+seeker.getJsAddrs());
		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//closes sessionfactory
			HibernateUtil.closeSessionFactory();
			try {
				if(fos!=null)
					fos.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if(writer!=null)
					writer.close();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}//finally
		
	}//main
}//class
