package com.atr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atr.model.BookingModel;


public class FlightCancellDaoImp implements FlightCancellationDao{
	//String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String username ="hr";
	String password = "hr";
	Connection con =null;
	PreparedStatement pstmt = null;
	@Override
	public BookingModel fetchBybookingId(String bookid) {
		// TODO Auto-generated method stub
		      BookingModel fd=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement("select * from booking_info where booking_id= ?");//tablnm=fetchbinfo ,bid
			// r tablnm booking_info booking_id
			
			pstmt.setString(1, bookid);
			//System.out.println("imp page");
			//System.out.println(bookid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				fd= new BookingModel();
				//System.out.println("dfdfdf");
				fd.setBookingId(rs.getString(1));
				fd.setBookingDate(rs.getString(2));
				fd.setFlightNo(rs.getString(3));
				fd.setPhone(rs.getString(7));
				fd.setPrice(rs.getString(4));
				fd.setSeatBooked(rs.getString(5));
				fd.setDepartureDate(rs.getString(6));
			}

			//System.out.println("reet");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return fd;
	}
	int s=0;
	@Override
	public int removeFlight(String bookingId) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			 PreparedStatement pstmt = con.prepareStatement("delete from booking_info  where booking_id=?");
			
			 pstmt.setString(1, bookingId);
			 
		    s= pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
}