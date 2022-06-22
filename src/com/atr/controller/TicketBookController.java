package com.atr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atr.bo.FlightATRBO;
import com.atr.model.FlightModel;
@WebServlet("/TicketBookController")
public class TicketBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String fNo= request.getParameter("flightNo");
 		FlightATRBO fbo = new FlightATRBO();
 		FlightModel fd=fbo.getFlight(fNo);
 		if(fd!=null) {
 			RequestDispatcher rd = request.getRequestDispatcher("bookingnew.jsp");
			request.setAttribute("bookflight", fd);
			rd.forward(request, response);
			HttpSession session= request.getSession();
			session.setAttribute("bookingFlight", fd);
 		}else {
 			RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
			request.setAttribute("bookflight", fd);
			rd.forward(request, response);
 		}
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
