package com.atr.model;

import java.io.Serializable;

public class AirlinesModel implements Serializable{
	private static final long serialVersionUID = 4142962682350988218L;
	private String airlineId;
	private String airlineName;
	private String DOP;
	public String getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getDOP() {
		return DOP;
	}
	public void setDOP(String dOP) {
		DOP = dOP;
	}	
}
