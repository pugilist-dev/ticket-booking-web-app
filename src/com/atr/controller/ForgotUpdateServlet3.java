package com.atr.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atr.bo.ForgotBo;

@WebServlet("/ForgotUpdateServlet")
public class ForgotUpdateServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String password=request.getParameter("password");
		  
		  System.out.println("in ForgotUpdateServlet servlet");
		  HttpSession sessionForgot2=request.getSession();
				String email=(String) sessionForgot2.getAttribute("email");
				if(email==null)
				{
					email=request.getParameter("email");
				}
		  ForgotBo obj=new ForgotBo();
		  int res =obj.resetPasswordUpdate(password, email);
		  if(res==1)
		  {	
			  request.setAttribute("errorMessage", "password changed successfully");
              RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
			  rd.forward(request, response);
			  //if res==1 then password has changed and we have to show a message as reset successful and login again on login page
		  }
		  else
		  {		
			 
              request.setAttribute("errorMessage", "password changing failed");
              RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
			  rd.forward(request, response);
		  }
		  
		  
		  	
	}

}
