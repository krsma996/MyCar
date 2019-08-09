package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Marka = request.getParameter("Marka");
		String Model = request.getParameter("Model");
		String Cena = request.getParameter("Cena");
		String Boja = request.getParameter("Boja");
		String GodinaProizvodnje = request.getParameter("GodinaProizvodnje");
		
		boolean upisiAuto = AdminDao.DodajAutoUBazu(Marka, Model, Cena, Boja, GodinaProizvodnje);
		if(upisiAuto) {
			response.sendRedirect("view/administrator.jsp");
		}else {
			response.sendRedirect("view/addCar.jsp");
		}
			
		
	}

}
