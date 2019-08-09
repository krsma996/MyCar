package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.Admin;
import dao.AdminDao;
import dao.LoginDao;
import model.User;

/**
 * Servlet implementation class AddBalanceServlet
 */
@WebServlet("/AddBalanceServlet")
public class AddBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String UserName = request.getParameter("UserName");
		 String Balance = request.getParameter("Balance");
		
		LoginDao login = new LoginDao();
		
		boolean proveriUsera = login.DaLiJeUserUBazi(UserName);
		//idemo dalje
		if(proveriUsera) {
			User user = login.VratiUsera(UserName);
			boolean dodajNovac = AdminDao.DodajUseruNovac(user, Balance);
			if(dodajNovac) {
				response.sendRedirect("view/administrator.jsp");
			}else {
				response.sendRedirect("view/addBalance.jsp");
			}
		}
		
	}

}
