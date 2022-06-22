package com.atr.dao;

import java.util.ArrayList;

import com.atr.model.CustomerModel;
import com.atr.model.FlightModel;
public interface FlightATRInterface {
public ArrayList<FlightModel> viewAllFlightDetails(FlightModel f);

public FlightModel getFlight(String fNo);

public int BookFlight(FlightModel f, CustomerModel cm);

}
