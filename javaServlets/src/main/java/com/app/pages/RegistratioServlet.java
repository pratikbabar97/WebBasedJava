package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

@WebServlet(value = "/voter_register")
public class RegistratioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDaoImpl UserDao;

	public void init(ServletConfig config) throws ServletException {
		try {
			UserDao = new UserDaoImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Err In Init " + getClass(), e);
		}
	}

	public void destroy() {
		try {
			UserDao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("in destroy method");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			String fname = request.getParameter("fn");
			String lname = request.getParameter("ln");
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			Date dob = Date.valueOf(request.getParameter("dob"));
			if (LocalDate.now().getYear() - dob.toLocalDate().getYear() > 21) {
				User newUser = new User(fname, lname, email, password, dob);
				int rows = UserDao.voterRegistration(newUser);
				if (rows == 1)
					pw.print("<h2>Registration Successful !!!</h2><br><a href='login.html'>Go Back</a>");
				else
					pw.print(
							"<h2>Registration Unsuccessful, Some error occured !!!</h2><br><a href='voter_registration.html'>Go Back</a>");
			} else {
				pw.print(
						"<h2>Registration Unsuccessful, Age should be above 21 !!!</h2><br><a href='voter_registration.html'>Go Back</a>");
			}
		} catch (Exception e) {
			throw new ServletException("In doPost method " + getClass(), e);
		}
	}

}
