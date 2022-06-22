package com.atr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atr.bo.CancelBO;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingId = request.getParameter("bid");
		CancelBO fbo = new CancelBO();
		int result = fbo.flightDelete(bookingId);
		System.out.println("My result is"+result);
		if(result!=0) {
			System.out.println(bookingId);
			System.out.println("row deleted");
			RequestDispatcher rd = request.getRequestDispatcher("cancellnsuccess.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("delete page fail");
			RequestDispatcher rd=request.getRequestDispatcher("fetchfailure.jsp");
			rd.forward(request,response);
		}
		
		
	}
	
/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingid = request.getParameter("bookingid");
		CancelBO fbo = new CancelBO();
		int result = fbo.flightDelete(bookingid);
		System.out.println(result);
		if(result!=0) {
			RequestDispatcher rd = request.getRequestDispatcher("cancellnsuccess.jsp");
			rd.forward(request, response);
			System.out.println(bookingid);
			System.out.println("row deleted");
		}
		else {
			System.out.println(bookingid);
		System.out.println("row deletetion failed");
			
		}
	
	}
			*/
	}


