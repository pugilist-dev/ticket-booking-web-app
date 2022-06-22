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
import com.atr.model.CustomerModel;
import com.atr.model.FlightModel;

@WebServlet("/BookFlightServlet")
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();  
        FlightModel fm=(FlightModel) session.getAttribute("bookingFlight");
        String FnO= fm.getFlightNo();
        String aID= fm.getAirlineId();
        int totSeats = fm.getTotalSeats();
        int src = fm.getSource();
        int dest = fm.getDestination();
        String departTime= fm.getDepartTime();
        int fare = fm.getFare();
        int avaSeats=fm.getAvaSeats();
        String departDate=fm.getDepartDate();
        String cName= request.getParameter("cname");
        String cDOB = request.getParameter("cdob");
        String cEmail= request.getParameter("cemail");
        String cTel = request.getParameter("ctel");
        String cSSNType = request.getParameter("ssntype");
        String cSSNNo = request.getParameter("cssno");
        FlightModel f = new FlightModel();
        CustomerModel cm = new CustomerModel();
        f.setFlightNo(FnO);
        f.setAirlineId(aID);
        f.setTotalSeats(totSeats);
        f.setSource(src);
        f.setDestination(dest);
        f.setDepartTime(departTime);
        f.setFare(fare);
        f.setAvaSeats(avaSeats);
        f.setDepartDate(departDate);
        cm.setCustomerName(cName);
        cm.setDob(cDOB);
        cm.setEmail(cEmail);
        cm.setPhone(cTel);
        cm.setSsnType(cSSNType);
        cm.setSsnNo(cSSNNo);
        FlightATRBO fatr= new FlightATRBO();
        int status=fatr.BookFlight(f,cm);
        System.out.println(status);
        if(status!=0) {
        	RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
        }else {
        	
        }
	}

}
