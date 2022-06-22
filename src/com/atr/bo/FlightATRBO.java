package com.atr.bo;

import java.util.ArrayList;

import com.atr.model.CustomerModel;
import com.atr.model.FlightModel;
import com.atr.service.FlightATRService;

public class FlightATRBO {

	public ArrayList<FlightModel> SearchFlight(FlightModel f) {
		FlightATRService frs= new FlightATRService();
		ArrayList<FlightModel> list=frs.viewAllflights(f);

		return list;
	}

	public FlightModel getFlight(String fNo) {
		FlightATRService fs= new FlightATRService();
		FlightModel f1=fs.getFlight(fNo);
		return f1;
	}

	public int BookFlight(FlightModel f, CustomerModel cm) {
		FlightATRService fatr = new FlightATRService();
		int status = fatr.BookFlight(f,cm);
		return status;
	}
}
