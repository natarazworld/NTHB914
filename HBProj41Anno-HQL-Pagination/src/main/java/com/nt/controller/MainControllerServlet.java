package com.nt.controller;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.nt.dto.InsurancePolicyDTO;
import com.nt.service.IInsurancePolicyMgmtService;
import com.nt.service.InsurancePolicyMgmtServiceImpl;

@WebServlet(value="/controller",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
  private IInsurancePolicyMgmtService  service;
	public void init() throws ServletException {
          service=new InsurancePolicyMgmtServiceImpl();		
	}

	public void destroy() {
		service=null;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   int pageNo=0;
	   int pageSize=3; //default pageSize
	   String spval=null;
	   HttpSession ses=null;
	   List<InsurancePolicyDTO> listDTO=null;
	   RequestDispatcher rd=null;
	   String targetPage=null;
	  long  pagesCount=0;
	   
	   //create or Locate Session obj
	   ses=req.getSession(true);
	   //read s1 req param value
	    spval=req.getParameter("s1");
	   if(spval.equalsIgnoreCase("GenerateReport")) {  //for submit button
		   //get pagesize of form
		      pageSize=Integer.parseInt(req.getParameter("pageSize"));
		   //set pageno as 1 for initial request
		   pageNo=1;
		   //keep pageSize in Session scope to across the multiple requests of a browser s/w
		   if(ses!=null) 
			  ses.setAttribute("pageSize",pageSize);   
		   
	   }//if
	   else {   //for hyperlink
		   //get pageNo from hyperlink supplied addtional req param value
		   pageNo=Integer.parseInt(req.getParameter("pageNo"));
		   //get pagesize from session scope
		    if(ses!=null)
		       pageSize=(int) ses.getAttribute("pageSize");
	   }
	   try {
	   //invoke service class methods
		   pagesCount=service.fetchPagesCount(pageSize);
	    listDTO=service.fetchPageData(pageSize, pageNo);
	   //keep listDTO (output) in request scope
	    req.setAttribute("policiesList",listDTO);
	    req.setAttribute("pagesCount",pagesCount);
	    targetPage="/report.jsp";
	   }
	   catch(HibernateException he) {
		   targetPage="/error.jsp";
		   he.printStackTrace();
	   }
	   catch(Exception e) {
		   targetPage="/error.jsp";
		   e.printStackTrace();
	   }
		   //forward to target page
	      rd=req.getRequestDispatcher(targetPage);
	      rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
