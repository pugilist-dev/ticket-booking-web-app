package com.atr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atr.bo.ProfileUpdateBo;
import com.atr.model.CustomerModel;
@WebServlet("/ProfileUpdate")
public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String ssnType=request.getParameter("ssnType");
		String ssnNo=request.getParameter("ssnNo");
		
		CustomerModel cmodel=new CustomerModel();
		cmodel.setCustomerName(name);
		cmodel.setDob(dob);
		cmodel.setSsnNo(ssnNo);
		cmodel.setSsnType(ssnType);
		
		ProfileUpdateBo updt=new ProfileUpdateBo();
		CustomerModel res=updt.update(cmodel);
		
		 if(res!=null)
		  {	
			 HttpSession sessionHome=request.getSession();
			  sessionHome.setAttribute("cm", res);
			 request.setAttribute("value", "1");
			 request.setAttribute("errorMessage", "Updation Successfull, Try Again");
             RequestDispatcher rd=request.getRequestDispatcher("/Profile.jsp");
			  rd.forward(request, response);
			  		 
		  }
		  else
		  {	
			  request.setAttribute("value", "0");
			  request.setAttribute("errorMessage", "Updation failed, Try Again");
              RequestDispatcher rd=request.getRequestDispatcher("/Profile.jsp");
			  rd.forward(request, response);
		  }
		
	}

}
