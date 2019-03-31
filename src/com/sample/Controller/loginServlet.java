package com.sample.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.DBconn.jdbcLogin;
import com.sample.model.empModel;


public class loginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		jdbcLogin jdbc = new jdbcLogin();
		
		String responce="responce";
	empModel result = jdbc.login(username, password);
		
	if(result!=null) {
		req.setAttribute("emp", result);
		req.getRequestDispatcher("/details.jsp").forward(req, resp);
	}else {
	
		req.setAttribute("responce", responce);
		
	}
	}

}
