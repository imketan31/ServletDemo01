package com.sample.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.DBconn.jdbcRegister;
import com.sample.model.empModel;

public class RegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String gen = req.getParameter("gen");
		long mob = Long.parseLong(req.getParameter("mob"));

		empModel e1 = new empModel();

		e1.setUsername(uname);
		e1.setPassword(pass);
		e1.setFirstname(fname);
		e1.setLastname(lname);
		e1.setGender(gen);
		e1.setMob(mob);

		jdbcRegister j = new jdbcRegister();
		boolean result = j.dbConn(e1);

		// resp.sendRedirect("NewFile.html");
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.html");

		disp.forward(req, resp);

	}
}
