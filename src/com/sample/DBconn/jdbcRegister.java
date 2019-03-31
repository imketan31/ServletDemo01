package com.sample.DBconn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.sample.model.empModel;

public class jdbcRegister {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/details";
	public static final String Username = "root";
	public static final String Pass = "root";
	boolean isSuccess;

	public boolean dbConn(empModel emp) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// Step 01 :-load the driver.
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);

			// Step 02 :- get DB connection via driver
			conn = DriverManager.getConnection(DB_URL, Username, Pass);

			// step 03 :- Fire a SQl Query

			String Query = " INSERT INTO user(username,password, firstname, lastname,gender,mobile) "
					+ "VALUES (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(Query);

			pstmt.setString(1, emp.getUsername());
			pstmt.setString(2, emp.getPassword());
			pstmt.setString(3, emp.getFirstname());
			pstmt.setString(4, emp.getLastname());
			pstmt.setString(5, emp.getGender());
			pstmt.setLong(6, emp.getMob());

			int res = pstmt.executeUpdate();

			if (res >= 0) {
				System.out.println("SUccess");
				isSuccess = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Step 04 :- Object Closing Ceremony
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {

				System.err.println(e);
			}

		}

		return isSuccess;
	}

}
