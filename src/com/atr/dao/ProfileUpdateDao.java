package com.atr.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atr.model.CustomerModel;
public class ProfileUpdateDao {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String url="jdbc:oracle:thin:@172.18.134.42:1521:XE";//select * from global_name; to get XE
	String username="hr";
	String Password="hr";
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmp;
	
	
	public void commonCode() throws SQLException {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 conn=DriverManager.getConnection(url, username, Password);
			 	} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	public CustomerModel update(CustomerModel cmodel) {
		int res = 1;
		ResultSet rs=null;
		CustomerModel cm =new CustomerModel();;
		try {
			this.commonCode();
			pstmp=conn.prepareStatement("update customer_master set customer_name=?,dob=?,ssnno=?,ssn_type=?,address=?,gender=? where email=?");
			pstmp.setString(1, cmodel.getCustomerName());
			pstmp.setString(2, cmodel.getDob());
			pstmp.setString(3, cmodel.getSsnNo());
			pstmp.setString(4, cmodel.getSsnType());
			pstmp.setString(5, cmodel.getAddress());
			pstmp.setString(6, cmodel.getGender());
			pstmp.setString(7, cmodel.getEmail());
			 res=pstmp.executeUpdate();
				if(res==1){
					System.out.println("c_master table updated");
					pstmp=conn.prepareStatement("select * from customer_master where email=?");
					rs=pstmp.executeQuery();
					if(rs.next())
					{
						System.out.println("completed getting data from customer_master table");
						 cm.setCustomerName(rs.getString("customer_name"));
						 cm.setPhone(rs.getString("c_id"));
						 cm.setEmail(rs.getString("email"));
						 cm.setDob(rs.getString("dob"));
						 cm.setSsnType(rs.getString("ssn_type"));
					}
					conn.close();
				}
			} catch (SQLException e) {
 			 			res=0;
		e.printStackTrace();
	 }
		return cm;
	}
	
}
