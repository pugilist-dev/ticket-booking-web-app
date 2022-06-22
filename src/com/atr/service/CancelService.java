package com.atr.service;

import com.atr.dao.FlightCancellDaoImp;
import com.atr.dao.FlightCancellationDao;
import com.atr.model.BookingModel;


public class CancelService {

	public BookingModel flightFetchById(String bookid) {
		// TODO Auto-generated method stub
		FlightCancellationDao fdao =new FlightCancellDaoImp();

BookingModel fbm = fdao.fetchBybookingId(bookid);

System.out.println("service op");
   return fbm;
	}

	public int deleteFlight(String bookingId) {
		// TODO Auto-generated method stub
      FlightCancellationDao fdao =new FlightCancellDaoImp();
		
		int status = fdao.removeFlight(bookingId);
		System.out.println("service result");
		return status;
		
	}
}
