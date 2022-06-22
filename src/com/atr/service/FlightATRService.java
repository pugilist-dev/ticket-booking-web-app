package com.atr.service;

import java.util.ArrayList;

import com.atr.dao.FlightATRIntImpl;
import com.atr.dao.FlightATRInterface;
import com.atr.model.CustomerModel;
import com.atr.model.FlightModel;

public class FlightATRService {

	public ArrayList<FlightModel> viewAllflights(FlightModel f) {
		FlightATRInterface fdao=new FlightATRIntImpl();
		ArrayList<FlightModel> flist= fdao.viewAllFlightDetails(f);
		return flist;
	}

	public FlightModel getFlight(String fNo) {
		FlightATRInterface fdao=new FlightATRIntImpl();
		FlightModel f1=fdao.getFlight(fNo);
		return f1;
		
	}

	public int BookFlight(FlightModel f, CustomerModel cm) {
		FlightATRInterface fdao= new FlightATRIntImpl();
		int status=fdao.BookFlight(f,cm);
		return status;
	}
}
