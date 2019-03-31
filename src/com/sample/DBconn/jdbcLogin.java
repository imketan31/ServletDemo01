package com.sample.DBconn;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sample.model.empModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class jdbcLogin {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/details";
	public static final String Username = "root";
	public static final String Pass = "root";
	boolean isSuccess;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet res;
	String uname, pass, firstname, lastname, gender;
	long mobile;
	int  id;

	public empModel login(String username, String password) {
		
		empModel emp=new empModel();
		
		
		try {

			// step 01 :- Load the driver .
			Driver d1 = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d1);

			// step 02 :- get DbConnection via Driver.
			conn = DriverManager.getConnection(DB_URL, Username, Pass);

			// step 03 :- Fire a SQL Query.
			String SQl = "Select * from user where username = ? and password = ?";
			pstmt = conn.prepareStatement(SQl);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();

			// step 04:- process Result
			if (res.next()) {

				id=res.getInt("id");
				uname = res.getString("username");
				pass = res.getString("password");
				firstname = res.getString("firstname");
				lastname = res.getString("lastname");
				gender = res.getString("gender");
				mobile = res.getLong("mobile");
			}
			
			
			emp.setId(id);
			emp.setFirstname(firstname);
			emp.setLastname(lastname);
			emp.setUsername(uname);
			emp.setPassword(pass);
			emp.setMob(mobile);
			emp.setGender(gender);

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

		return emp;

	}

}
