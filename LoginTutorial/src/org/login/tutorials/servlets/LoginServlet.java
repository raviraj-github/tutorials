package org.login.tutorials.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.login.tutorial.resource.UserDetailsDTO;
import org.login.tutorials.DAO.UserDAO;

/**
 * LoginServlet : Handle request for user login validation
 * @author Ravi Raj
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOGGER = Logger.getLogger(LoginServlet.class.getName()); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String userName = req.getParameter("user_name");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		UserDAO userDAO = new UserDAO();
		
		if(!userDAO.isUserExist(userName)) {
			out.write("User does not exist..");
			LOGGER.info("User does not exist :: "+userName);
		} else {
			UserDetailsDTO user = userDAO.validateLogin(userName, password);	
			
			if(user != null) {
				out.write("Welcome "+user.getName());
				LOGGER.info("User logged in sucessfully");
			} else {
				String errMsg = "Username or password is incorrect";
				out.write(errMsg);
				LOGGER.info(errMsg);
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
