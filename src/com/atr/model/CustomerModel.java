package com.atr.model;

import java.io.Serializable;

public class CustomerModel implements Serializable{
	private static final long serialVersionUID = 1L;
		private String Phone;
		private String customerName;
		private String dob;
		private String email;
		private String password;
		private String ssnType;
		private String ssnNo;
		private String security;
		private String securityAnswer;
		private String address;
		private String gender;
		public String getSecurity() {
			return security;
		}
		public void setSecurity(String security) {
			this.security = security;
		}
		public String getSecurityAnswer() {
			return securityAnswer;
		}
		public void setSecurityAnswer(String securityAnswer) {
			this.securityAnswer = securityAnswer;
		}
		public String getPhone() {
			return Phone;
		}
		public void setPhone(String phone) {
			Phone = phone;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSsnType() {
			return ssnType;
		}
		public void setSsnType(String ssnType) {
			this.ssnType = ssnType;
		}
		public String getSsnNo() {
			return ssnNo;
		}
		public void setSsnNo(String ssnNo) {
			this.ssnNo = ssnNo;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
}
