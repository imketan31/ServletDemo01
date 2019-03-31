package com.sample.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.DBconn.jdbcRegister;
import com.sample.DBconn.jdbcUpdate;
import com.sample.model.empModel;

public class updateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String fname = req.getParameter("fname");
		String lname = String.valueOf(req.getParameter("lname"));
		String gen = req.getParameter("gen");
		long mob = Long.parseLong(req.getParameter("mob"));

		empModel e1 = new empModel();
 
		e1.setId(id);
		e1.setUsername(uname);
		e1.setPassword(pass);
		e1.setFirstname(fname);
		e1.setLastname(lname);
		e1.setGender(gen);
		e1.setMob(mob);

		jdbcUpdate j = new jdbcUpdate();
		 j.update(e1);
	}
	
}
