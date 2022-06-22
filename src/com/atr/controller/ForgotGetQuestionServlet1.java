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
import com.atr.model.CustomerModel;

@WebServlet("/ForgotGetQuestionServlet")
public class ForgotGetQuestionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  String emailID=request.getParameter("email");
		  System.out.println(emailID);
		  System.out.println("in servlet");
		  ForgotBo obj=new ForgotBo();
		  String res =obj.getQuestion(emailID);
		  System.out.println(res);
		  String out="";
		  if(res.equals("1")){
		  out="What_is_the_name_of_your_pet?";
		  }
		  if(res.equals("2")){out="Who's_your_favourite_teacher?";}
		  if(res.equals("3")){out="Name_of_your_first_teacher.";}
		  if(res.equals("4")){out="What_is_your_favourite_number/digit?";}
		  if(res.equals("5")) {out="Any_keyword_you_like_to_specify";}
			
		  if(res!=null)
		  {
			  HttpSession sessionForgot2=request.getSession();
			  sessionForgot2.setAttribute("question", out);
			  sessionForgot2.setAttribute("qnum", res);
			  sessionForgot2.setAttribute("email", emailID);
			  
			  response.sendRedirect("forgot2.jsp");
			  //if not null i have to pass res<security question> to the 
			  
		  }
		  else
		  {		
			  request.setAttribute("errorMessage", "Invalid Email ID, Try again");
			  RequestDispatcher rd=request.getRequestDispatcher("/forgot1.jsp");
			  rd.forward(request, response);
			  //if null we have to show a message as reset password unsuccessfull(email not available) on login page 
		  }
			  	
	}

}
