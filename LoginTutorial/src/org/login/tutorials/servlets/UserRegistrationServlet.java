package org.login.tutorials.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.login.tutorials.DAO.UserDAO;

/**
 * UserRegistrationServlet : Handle request for user registration
 * @author Ravi Raj
 *
 */
public class UserRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(UserRegistrationServlet.class.getName()); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("first_name") + " " +req.getParameter("last_name");
		
		UserDAO userDAO = new UserDAO();
		boolean isUserAdded = userDAO.addUser( name ,req.getParameter("user_name"), 
				req.getParameter("email"), req.getParameter("password"));
		
		if(isUserAdded) {
			out.write("Welcome "+name);
		} else {
			out.write("Error occurred. Username already exist..");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
