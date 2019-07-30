package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.Rola;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		        String UserName = request.getParameter("UserName");
		        String Password = request.getParameter("Password");
		        
		        LoginDao login = new LoginDao();
		        User user = new User();
		        
		        
		        
		        boolean proveri = login.DaLiJeUserUBazi(UserName);	        
		        
		        if(proveri) {
		        	
		        	boolean proveripassword = login.DaliPasswordOdgovaraUseru(UserName, Password);
		        	if(proveripassword) {
		        		user = login.VratiUsera(UserName);
			        	HttpSession session = request.getSession();
			        	session.setAttribute("OvdeJeUser", user);
			        	if(user.getRola().equals(Rola.ADMINISTRATOR)) {
			        		response.sendRedirect("view/administrator.jsp");
			        	}else {
			        		response.sendRedirect("view/user.jsp");
			        	}
			        	
			        }else {
			        	response.sendRedirect("login.html");
			        }
		        	
		       }else {
		    	   response.sendRedirect("login.html");
		       }
		      	
	}

}
