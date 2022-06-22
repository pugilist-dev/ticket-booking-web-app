package com.atr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.atr.model.CustomerModel;

public class CustomerModelImplementation implements CustomerModelInterface {
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username="hr";
	String password="hr";
	Connection con=null;
	PreparedStatement pstmt=null,pstmt1=null;
	int status=0,status1=0,status2=0;
	int s=0;
	@Override
	public int registerCustomer(CustomerModel c) {
		
		try {
			//System.out.println("executing dao");
			System.out.println(c.getEmail());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement("Insert into login values(?,?)");
			pstmt1.setString(1, c.getEmail());
			pstmt1.setString(2, c.getPassword());
			status1=pstmt1.executeUpdate();
			if(status1!=0) {
				//System.out.println("Inserted values into login!");
			pstmt=con.prepareStatement("Insert into customer_master values(?,TO_DATE(?,'DD-MM-YYYY'),?,?,?,?,?,?,?)");
			//pstmt.setString(1,c.getSecurity());
			pstmt.setString(1,c.getCustomerName());
			pstmt.setString(2,c.getDob());
			pstmt.setString(3, c.getEmail());
			pstmt.setString(4,c.getPassword());
			pstmt.setString(5,c.getSsnType());
			pstmt.setString(6,c.getSsnNo());
			pstmt.setString(7,c.getPhone());
			pstmt.setString(8,c.getAddress());
			pstmt.setString(9,c.getGender());
			//pstmt.setString(10,c.getCustomerName());
			//pstmt.setString(12,c.getSecurityAnswer());
			status=pstmt.executeUpdate();
			  if(status!=0) {
				  System.out.println("Inserted values into customer_master!");
				  pstmt1=con.prepareStatement("Insert into security_Question values(?,?,?)");
				  pstmt1.setString(1, c.getEmail());
				  pstmt1.setString(2, c.getSecurity());
				  pstmt1.setString(3, c.getSecurityAnswer());
				  status2=pstmt1.executeUpdate();
				  if(status2!=0) {
					//  System.out.println("Inserted values into security_question!");
				  //System.out.println("Customer Registered Successfully!");
				  //System.out.println("returning back from dao to so");
				       s=1;
				       con.commit();
				  }
				  else {
					  
					  System.out.println("Registration Unsuccessful! Kindly re-register");
					}
			  }
			  else {
				  System.out.println("Registration Unsuccessful! Kindly re-register");
				}
			}
			else {
				 System.out.println("Registration Unsuccessful! Kindly re-register");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // System.out.println("returning back from dao to so");		
		return s;
		
		
	}

}
