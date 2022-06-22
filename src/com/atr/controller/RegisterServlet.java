package com.atr.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atr.bo.RegisterBO;
import com.atr.model.CustomerModel;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Registration Servlet is executing");
	 String name=request.getParameter("name");
	 String email=request.getParameter("email");
	 String password=request.getParameter("psw");
	 String dob=request.getParameter("dob");
	 String address=request.getParameter("address");
	 String gender=request.getParameter("gender");
	 String phno=request.getParameter("phno");
	 String ssn_type=request.getParameter("ssntype");
	 String ssn_number=request.getParameter("ssnnumber");
	 String security=request.getParameter("security");
	 String security_answer=request.getParameter("securityanswer");
	 System.out.println("calling cutomer model");
	CustomerModel cm=new CustomerModel();
	 cm.setAddress(address);
	 cm.setCustomerName(name);
	 cm.setDob(dob);
	 cm.setEmail(email);
	 cm.setGender(gender);
	 cm.setPassword(password);
	 cm.setPhone(phno);
	 cm.setSecurity(security);
	 cm.setSecurityAnswer(security_answer);
	 cm.setSsnNo(ssn_number);
	 cm.setSsnType(ssn_type);
    /* PrintWriter pw=response.getWriter();
     pw.println("<html> "
     		+ "<body> "
     		+ "<h1>Re-directing to Registration page </h1> "
     		+"<h3>name email password dob address gender phno ssn_type ssn_number security</h3>"
     		+ "</body> "
     		+ "</html>");*/
	// System.out.println("calling bo from servlet");
     RegisterBO rbo=new RegisterBO();
     int s= rbo.RegisterCustomer(cm);
 //	System.out.println("returned from bo to servlet");
     if(s!=0) 
		  {	
			 /* HttpSession sessionHome=request.getSession();
			  sessionHome.setAttribute("cm", cm);
			  System.out.println("going to home page with customermodels obj");
			  response.sendRedirect("Home.jsp");*/
    	// request.setAttribute("errorMessage", "Login Failed Check the user credentials, Try Again");
    	//	System.out.println("Registration Servlet is executing id excuted");
         RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
		  rd.forward(request, response);
		  }
		  else
		  {	
			//	System.out.println("Registration Servlet is executing else is executed");
			 // request.setAttribute("errorMessage", "Login Failed Check the user credentials, Try Again");
             RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
			  rd.forward(request, response);
		  }
     
    /* pw.println(name);
     pw.println(email);
     pw.println(password);
     pw.println(dob);
     pw.println(address);
     pw.println(gender);
     pw.println(phno);
     pw.println(ssn_type);
     pw.println(ssn_number);
     pw.println(security);
     pw.println(security_answer);*/
	}

}
