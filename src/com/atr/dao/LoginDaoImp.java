package com.atr.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atr.model.CustomerModel;
public class LoginDaoImp {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String url="jdbc:oracle:thin:@localhost:1521:XE";//select * from global_name; to get XE
	String username="hr";
	String Password="hr";
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmp;
	String result;
	int res;
	public void commonCode() throws SQLException {
			try {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 conn=DriverManager.getConnection(url, username, Password);
			    
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	public CustomerModel login(String email, String password) {
		CustomerModel cm = null;
			try {
				 this.commonCode();
				 cm=new CustomerModel();
				 pstmp=conn.prepareStatement("select * from login where email=? and password=?");
				 pstmp.setString(1, email);
				 pstmp.setString(2, password);
				 System.out.println(email);
				 System.out.println(password);
				 rs=pstmp.executeQuery();
				 System.out.println("completed the checking");
				 if(rs.next())
				 {
					 System.out.println(rs.getString(1));	
					 System.out.println(rs.getString(2));	
					 pstmp=conn.prepareStatement("select * from customer_master where email=?");
					 pstmp.setString(1, email);
					 rs=pstmp.executeQuery();
					 if(rs.next()){
						 System.out.println("completed getting data from customer_master table");
						 cm.setCustomerName(rs.getString("customer_name"));
						 cm.setPhone(rs.getString("phone"));
						 cm.setDob(rs.getString("dob"));
						 cm.setEmail(rs.getString("email"));
						 cm.setSsnNo(rs.getString("ssn_no"));
						 cm.setPassword(rs.getString("password"));
						 cm.setSsnType(rs.getString("ssn_type"));
						 cm.setAddress(rs.getString("address"));
						 cm.setGender(rs.getString("gender"));
					 }
					 
				}

	 		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return cm;
		
	}
	
}
