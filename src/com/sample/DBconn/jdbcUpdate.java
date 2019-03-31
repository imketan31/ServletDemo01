package com.sample.DBconn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.model.empModel;

public class jdbcUpdate {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/details";
	public static final String Username = "root";
	public static final String Pass = "root";
	
	Connection conn;
	PreparedStatement pstmt;
	int res;
	
	
	public void update(empModel e1) {
		
		
		try {

			// step 01 :- Load the driver .
			Driver d1 = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d1);

			// step 02 :- get DbConnection via Driver.
			conn = DriverManager.getConnection(DB_URL, Username, Pass);

			// step 03 :- Fire a SQL Query.
			String SQl = "Update user SET firstname = ? , lastname = ? , username = ? , password = ? , gender = ? ,"
					+ " mobile=?  WHERE id = ?";
			pstmt = conn.prepareStatement(SQl);
			pstmt.setString(1, e1.getFirstname());
			pstmt.setString(2, e1.getLastname());
			pstmt.setString(3, e1.getUsername());
			pstmt.setString(4, e1.getPassword());
			pstmt.setString(5, e1.getGender());
			pstmt.setLong(6, e1.getMob());
			pstmt.setInt(7, e1.getId());
			 pstmt.executeUpdate();

			// step 04:- process Result
			if (true) {

				//System.out.println(res);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			// Step 04 :- Object Closing Ceremony
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
