package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Car;
import model.Racun;
import model.User;
import validacija.UserValidacija;

/**
 * Servlet implementation class PlatiRacunServlet
 */
@WebServlet("/PlatiRacunServlet")
public class PlatiRacunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		UserValidacija uv = new UserValidacija();
	
		String [] check = request.getParameterValues("check");
		String [] kolicina = request.getParameterValues("kolicina");
		List<Car> listaAuta = userDao.autaSaRacuna(check);
		List<String> listaKolicina = uv.urediKolicinu(kolicina);
		
		double TotalPrice = userDao.IznosRacuna(listaAuta, listaKolicina);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("OvdeJeUser");
		Date date = new Date();
		Racun racun = userDao.sacuvajRacun(user, date, listaAuta);
		
		request.setAttribute("TotalPrice", TotalPrice);
		request.setAttribute("listaAuta", listaAuta);
		request.setAttribute("listaKolicina", listaKolicina);
		
		if(user.getNovcanik()>= TotalPrice) {
			userDao.UpdateNovcanik(user, TotalPrice);
			userDao.UpdateStanje(listaAuta, listaKolicina);
			RequestDispatcher rd = request.getRequestDispatcher("view/racun.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("view/user.jsp");
		}
		
		
		}
			
		
	}


