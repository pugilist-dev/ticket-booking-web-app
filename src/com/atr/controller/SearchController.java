package com.atr.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atr.bo.FlightATRBO;
import com.atr.model.FlightModel;
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int from= Integer.parseInt(request.getParameter("ffrom"));
		int to= Integer.parseInt(request.getParameter("fto"));
		String date= request.getParameter("fdate");
		int seats= Integer.parseInt(request.getParameter("fseat"));
		FlightATRBO fbo = new FlightATRBO();
		FlightModel f = new FlightModel();
		f.setSource(from);
		f.setDestination(to);
		f.setDepartDate(date);
		f.setAvaSeats(seats);
		ArrayList<FlightModel> fb = fbo.SearchFlight(f);
		if(fb!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("resultnew.jsp");
			request.setAttribute("details", fb);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
			request.setAttribute("details", fb);
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
