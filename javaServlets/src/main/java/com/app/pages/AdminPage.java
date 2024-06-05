package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AdminDaoImpl;
import com.app.entities.Candidate;

@WebServlet("/admin_page")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. set content type
		response.setContentType("text/html");

		// 2. PW
		try (PrintWriter pw = response.getWriter()) {

			// 3. get HttpSession from WC
			HttpSession session = request.getSession();

			// 4. get ADMIN dao from session
			AdminDaoImpl adminDao = (AdminDaoImpl) session.getAttribute("admin_dao");

			// 5. list of top 2 candidates
			List<Candidate> candidates = new ArrayList<>();
			candidates = adminDao.top2();
			for (Candidate c : candidates) {
				pw.print("<h5>" + c + "</h5><br>");
			}
			
			// 6. votes analysis 
			List<String> candidateGroup = new ArrayList<>();
			candidateGroup = adminDao.voteAnalysis();
			for (String c : candidateGroup) {
				pw.print("<h5>" + c + "</h5><br>");
			}

		} catch (Exception e) {
			throw new ServletException("err in doGet of Admin" + getClass(), e);
		}

	}

}
