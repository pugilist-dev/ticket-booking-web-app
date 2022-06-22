package com.atr.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.atr.model.CustomerModel;
import com.atr.model.FlightModel;

public class FlightATRIntImpl implements FlightATRInterface {
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String username="HR";
	private String password="hr";
	Connection con=null;
	int status;
	PreparedStatement pstmt= null;

	@Override
	public ArrayList<FlightModel> viewAllFlightDetails(FlightModel f) {
		ArrayList<FlightModel> flist=new ArrayList<FlightModel>();
			FlightModel f1 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(" SELECT * FROM FLIGHT_MASTER WHERE SRC=? AND DEST=? AND TO_DATE(DEPART_DATE)=?"
					+ " AND AVA_SEATS>=? ORDER BY DEPART_DATE,DEPART_TIME,FARE");
			pstmt.setLong(1,f.getSource());
			pstmt.setLong(2,f.getDestination());
			pstmt.setString(3,f.getDepartDate());
			pstmt.setLong(4,f.getAvaSeats());
			ResultSet rs1=pstmt.executeQuery();
			while(rs1.next()){
				f1= new FlightModel();
				f1.setFlightNo(rs1.getString(1));
				f1.setAirlineId(rs1.getString(2));
				f1.setTotalSeats(rs1.getInt(3));
				f1.setSource(rs1.getInt(4));
				f1.setDestination(rs1.getInt(5));
				f1.setDepartTime(rs1.getString(6));
				f1.setFare(rs1.getInt(7));
				f1.setAvaSeats(rs1.getInt(8));
				f1.setDepartDate(rs1.getString(9));
				flist.add(f1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return flist;
	}

	@Override
	public FlightModel getFlight(String fNo) {
		FlightModel f1 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(" SELECT * FROM FLIGHT_MASTER WHERE F_NO=? ORDER BY DEPART_DATE,DEPART_TIME,FARE");
			pstmt.setString(1,fNo);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				f1= new FlightModel();
				f1.setFlightNo(rs.getString(1));
				f1.setAirlineId(rs.getString(2));
				f1.setTotalSeats(rs.getInt(3));
				f1.setSource(rs.getInt(4));
				f1.setDestination(rs.getInt(5));
				f1.setDepartTime(rs.getString(6));
				f1.setFare(rs.getInt(7));
				f1.setAvaSeats(rs.getInt(8));
				f1.setDepartDate(rs.getString(9));
				}
			}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		return f1;
		}

	@Override
	public int BookFlight(FlightModel f, CustomerModel cm) {
		try {
			PreparedStatement pstmt1= null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement("INSERT INTO BOOKING_INFO (BOOKING_ID, BOOKING_DT,F_NO,PRICE,SEAT_BOOK,DEPART_DATE,PHONE) VALUES (?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?)");
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("SELECT BOOKSEQ.NEXTVAL FROM DUAL");
			rs.next();
			String bookseq=rs.getString(1);
			rs =stmt.executeQuery("SELECT  TO_CHAR(sysdate, 'DD-MON-YY') FROM DUAL");
			rs.next();
			String date=rs.getString(1);
			int seat_book=1;
			rs.close();
			System.out.println(f.getDepartDate().substring(0, 10));
			System.out.println(date);
			pstmt.setString(1, bookseq);
			pstmt.setString(2, date);
			pstmt.setString(3, f.getFlightNo());
			pstmt.setInt(4, f.getFare());
			pstmt.setInt(5, seat_book);
			pstmt.setString(6,f.getDepartDate().substring(0, 10));
			pstmt.setString(7, cm.getPhone());
			int status=pstmt.executeUpdate();
			if(status!=0) {
				int r1=f.getAvaSeats()-1;
				pstmt1 = con.prepareStatement("UPDATE FLIGHT_MASTER SET AVA_SEATS=? WHERE F_NO=?");
				pstmt1.setInt(1, r1);
				pstmt1.setString(2, f.getFlightNo());
				status= pstmt1.executeUpdate();
				return status;
			}else {
				return 0;
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
