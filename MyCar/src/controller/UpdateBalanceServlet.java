package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.LoginDao;
import model.User;

/**
 * Servlet implementation class UpdateBalanceServlet
 */
@WebServlet("/UpdateBalanceServlet")
public class UpdateBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UserName = request.getParameter("UserName");
		String Balance = request.getParameter("Balance");
		
		
		LoginDao login = new LoginDao();
		
		boolean proveriUsera = login.DaLiJeUserUBazi(UserName);
		if(proveriUsera) {
		   User user = login.VratiUsera(UserName);
		   boolean UpdateNovac = AdminDao.UpdateUseruNovac(user, Balance);
		   if(UpdateNovac) {
			   response.sendRedirect("view/administrator.jsp");
		   }else {
			   response.sendRedirect("view/updateBalance.jsp");
		   }
		}
			
	}

}
