package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProductDTO;
import com.nt.service.ProductMgmtService;
import com.nt.service.ProductMgmtServiceImpl;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	  private ProductMgmtService service;   
	@Override
	public void init() throws ServletException {
	     service=new ProductMgmtServiceImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      int id=0;
	      ProductDTO  dto=null;
	      RequestDispatcher rd=null;
		  //read form data..
	      id=Integer.parseInt(req.getParameter("pid"));
	      try {
		   //use service
	        dto=service.fetchProduct(id);
	        req.setAttribute("pDTO",dto);
	        //forward to result.jsp
	        rd=req.getRequestDispatcher("/result.jsp");
	        rd.forward(req, res);
	      }//try
	      catch(Exception e) {
	    	  e.printStackTrace();
	    	  rd=req.getRequestDispatcher("/error.jsp");
		        rd.forward(req, res);
	      }

	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
	
	@Override
	public void destroy() {
	   service=null;
	}

}
