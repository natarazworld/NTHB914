package com.nt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobSeeker;
import com.nt.utility.HibernateUtil;

public class LOBsInsertTest {

	public static void main(String[] args) {
		
		byte imageContent[]=null;
		char textContent[]=null;
		try(	FileInputStream fis=new FileInputStream("marriage.jpg"))
	   {
		//prepare byte[] from image file
		 imageContent=new byte[fis.available()];
		fis.read(imageContent);
		//prepare char[] form text file
		File file=new File("resume.txt");
		try(FileReader reader=new FileReader(file)){
		 textContent=new char[(int) file.length()];
		reader.read(textContent);
		 }//try2
		}//try1
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
		//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				boolean flag=false;
		try {
			//begin Tx
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			//pepare  Entity class object
			JobSeeker seeker=new JobSeeker();
			seeker.setJsName("ramesh");
			seeker.setJsAddrs("hyd");
			seeker.setPhoto(imageContent);
			seeker.setResume(textContent);
			seeker.setActive(false);
			int idVal=(int) ses.save(seeker);
			System.out.println("Generated id value::"+idVal);
			flag=true;
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//perform TxMgmt
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved");
			}
			//closes sessionfactory
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//main
}//class
