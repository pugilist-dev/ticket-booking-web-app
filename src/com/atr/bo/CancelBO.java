package com.atr.bo;

import com.atr.model.BookingModel;
import com.atr.service.CancelService;


public class CancelBO {

	public BookingModel fetchDetailsById(String bookid) {
		// TODO Auto-generated method stub
		CancelService frs = new CancelService();
	 BookingModel fbm=	frs.flightFetchById(bookid);
	
	
		System.out.println("bo op");
		return fbm;
	}

	public int flightDelete(String bookingId) {
		// TODO Auto-generated method stub
		CancelService frs = new CancelService();
        int result = frs.deleteFlight(bookingId);
		
		return result;
		
		
	}
	
}

