package com.atr.model;

import java.io.Serializable;
public class FlightModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String flightNo;
	private String airlineId;
	private int totalSeats;
	private int source;
	private int destination;
	private String departTime;
	private int fare;
	private int avaSeats;
	private String departDate;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getAvaSeats() {
		return avaSeats;
	}
	public void setAvaSeats(int avaSeats) {
		this.avaSeats = avaSeats;
	}
	public String getDepartDate() {
		return departDate;
	}
	public void setDepartDate(String date) {
		this.departDate = date;
	}
}
