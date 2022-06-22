package com.atr.model;

import java.io.Serializable;

public class BookingModel implements Serializable{
	private static final long serialVersionUID = 5081052830115343676L;
		private String bookingId;
		private String bookingDate;
		private String flightNo;
		private String phone;
		private String price;
		private String seatBooked;
		private String departureDate;
		public String getBookingId() {
			return bookingId;
		}
		public void setBookingId(String bookingId) {
			this.bookingId = bookingId;
		}
		public String getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(String bookingDate) {
			this.bookingDate = bookingDate;
		}
		public String getFlightNo() {
			return flightNo;
		}
		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getSeatBooked() {
			return seatBooked;
		}
		public void setSeatBooked(String seatBooked) {
			this.seatBooked = seatBooked;
		}
		public String getDepartureDate() {
			return departureDate;
		}
		public void setDepartureDate(String departureDate) {
			this.departureDate = departureDate;
		}
		

}
