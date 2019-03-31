package com.sample.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.DBconn.jdbcLogin;

public class AdminLogin extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uname = req.getParameter("uname");
		String pass =req.getParameter("pass");
		
		jdbcLogin log= new jdbcLogin();
		
		log.login(uname, pass);
		
	}

}
