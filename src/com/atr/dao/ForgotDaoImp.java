package com.atr.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ForgotDaoImp {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String url="jdbc:oracle:thin:@localhost:1521:XE";//select * from global_name; to get XE
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
	
	public String getQuestion(String emailID) {
		String res=null;
		try {
			commonCode();
			pstmp=conn.prepareStatement("select security_question from security_question where email= ? and security_question LIKE '% %'");
			pstmp.setString(1, emailID);
			rs=pstmp.executeQuery();
			System.out.println(emailID);
				if(rs.next())
				 {	
					 res=rs.getString("security_question");
					 System.out.println("got security question");
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
	        }
		return res;
	}
	public Boolean resetPasswordCheck(String email,String answer, String question) {
			Boolean res= false;
				try {
					this.commonCode();
					pstmp=conn.prepareStatement("select * from security_question where email=? and security_question=? ");
					pstmp.setString(1, email);
					pstmp.setString(2, question);
					System.out.println(answer);
					System.out.println(question);
					System.out.println(email);
					rs=pstmp.executeQuery();
					System.out.println("completed the checking");
					if(rs.next()){ 
						System.out.println(rs.getString("answer"));
							if(answer.equals(rs.getString("answer")))
					 {	
						System.out.println(rs.getString("answer"));
						res=true;
					 }
					}
					else{
						System.out.println("failed");
					}
		 		} catch (SQLException e) {
				 e.printStackTrace();
			}
				return res;
	}
	public int resetPasswordUpdate(String password1, String email) {
		int res = 1;
		try {
			this.commonCode();
			conn.setAutoCommit(false);
			pstmp=conn.prepareStatement("update login set password=? where email=?");
			pstmp.setString(1, password1);
			pstmp.setString(2, email);
			int out=pstmp.executeUpdate();
			pstmp=conn.prepareStatement("update customer_master set password=? where email=?");
			pstmp.setString(1, password1);
			pstmp.setString(2, email);
			System.out.println(password1);
			System.out.println(email);
			if(out==1){
				int out2=pstmp.executeUpdate();
				  if(out2==1){
					  System.out.println("c_master table updated");
					  conn.commit();
				  }
				  else{
					 res=0;
					 System.out.println("c_master table updation failed");
				  }
				System.out.println("login table updated");
			} 
			else
			{   
				res=0;
				System.out.println("login table updation failed");
			}
			pstmp.executeUpdate();
			
			conn.close();
			System.out.println("completed the checking");
			
 		} catch (SQLException e) {
 			try {
				conn.rollback();
 				} catch (SQLException e1) {
					e1.printStackTrace();
 				}
 			res=0;
		e.printStackTrace();
	 }
		return res;
	}
}
