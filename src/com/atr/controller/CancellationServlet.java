package com.atr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atr.bo.CancelBO;
import com.atr.model.BookingModel;



@WebServlet("/CancellationServlet")
public class CancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid=request.getParameter("bookingid");
		CancelBO fbo=new CancelBO();
		BookingModel fd=fbo.fetchDetailsById(bookid);
		System.out.println(fd);
		if(fd!=null) {
			System.out.println("servlet page success1");
			RequestDispatcher rd=request.getRequestDispatcher("fetchdetailsssuccess.jsp");
			request.setAttribute("details",fd);//attaching data to req attribute to display on jsp page
			System.out.println(fd);
			System.out.println("servlet page success2");
			rd.forward(request,response);
			System.out.println("servlet page success3");
	}
	else {
		System.out.println("servlet page fail");
		RequestDispatcher rd=request.getRequestDispatcher("fetchfailure.jsp");
		rd.forward(request,response);

	
	}
	}
}

