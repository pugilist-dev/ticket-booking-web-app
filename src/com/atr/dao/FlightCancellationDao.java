package com.atr.dao;

import com.atr.model.BookingModel;

public interface FlightCancellationDao {

public BookingModel fetchBybookingId(String bookid);

public int removeFlight(String bookingId);
	
}