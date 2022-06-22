package com.atr.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atr.bo.LoginBo;
import com.atr.model.CustomerModel;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String email=request.getParameter("email");
		  String password=request.getParameter("password");
		  System.out.println("in servlet");
		  LoginBo obj=new LoginBo();
		  CustomerModel cm =obj.login(email,password);
		  String name=cm.getCustomerName();	   
		  if(name!=null)
		  {	
			  System.out.println("login Checks To true");
			  HttpSession sessionHome=request.getSession();
			  sessionHome.setAttribute("cm", cm);
			  response.sendRedirect("Home.jsp");
		  }
		  else
		  {	
			  request.setAttribute("errorMessage", "Login Failed Check the user credentials, Try Again");
              RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
			  rd.forward(request, response);
		  }  	
	}

}
