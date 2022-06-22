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
@WebServlet("/ForgotCheckServlet")
public class ForgotCheckServlet2 extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String answer=request.getParameter("answer");
   		HttpSession sessionForgot2=request.getSession();
   				String ques=(String) sessionForgot2.getAttribute("qnum");
   		
   		String email=request.getParameter("email");
		System.out.println("in ForgotcheckServlet servlet");
		System.out.println(answer);
		System.out.println(ques);
		System.out.println(email);
		ForgotBo obj=new ForgotBo();
	    boolean res =obj.resetPasswordCheck(email,answer, ques);
	      if(res==true)
		  {
	    	  HttpSession sessionForgot3=request.getSession();
			  sessionForgot3.setAttribute("email", email);
			  response.sendRedirect("forgot3.jsp");
			 
		  }
		  else
		  {		
			  request.setAttribute("errorMessage", "Invalid Answer, Try again");
			  RequestDispatcher rd=request.getRequestDispatcher("forgot2.jsp");
			  rd.forward(request, response);
			  //if true we have to show a message as reset password unsuccessfull on login page 
		  }
		  
		  
		  	
	}

}
