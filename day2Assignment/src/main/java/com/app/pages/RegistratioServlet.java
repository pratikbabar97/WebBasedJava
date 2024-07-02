package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate.*;
import static java.sql.Date.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class RegistratioServlet
 */
@WebServlet(value = "/voter_register")
public class RegistratioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl UserDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			UserDao = new UserDaoImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Err In Init "+ getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			UserDao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("in destroy method");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			
			String fname=request.getParameter("fn");
			String lname = request.getParameter("ln");
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			String dob = request.getParameter("dob");
			if(Period.between( LocalDate.parse(dob),LocalDate.now()).getYears() > 21) {
				User newUser = new User(fname, lname, email, password,valueOf(LocalDate.parse(dob)));
				UserDao.voterRegistration(newUser);
				pw.print("<h1>Voter Registratin Successfull</h1><a href='login.html'>Go Back</a>");
			}
			else {
				pw.print("<h1>Voter Registratin Unsuccessfull</h1><a href='login.html'>Go Back</a>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("In doPost method "+ getClass(),e);
		}
	}

}
