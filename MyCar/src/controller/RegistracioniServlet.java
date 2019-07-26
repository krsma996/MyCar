package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistracijaDao;
import validacija.ValidacijaZaRegistraciju;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet("/RegistracioniServlet")
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
               String UserName = request.getParameter("UserName");
               String Prezime = request.getParameter("Prezime");
               String BrojLicneKarte = request.getParameter("BrojLicneKarte");
               String Password = request.getParameter("Password");
               String RepeatedPassword = request.getParameter("RepeatedPassword");
               
               
		      RegistracijaDao reg = new RegistracijaDao();
		      
		     boolean provera = ValidacijaZaRegistraciju.ProveriPassword(Password, RepeatedPassword);
		     
		     if(provera) {
		    	 boolean UpisiUsera = reg.UpisiUseraUBazu(UserName, RepeatedPassword, Prezime, BrojLicneKarte);
		    	 if(UpisiUsera) {
		    		 response.sendRedirect("index.html");
		    	 }else {
		    		 response.sendRedirect("registracija.html");
		    	 }
		     }else {
		    	 response.sendRedirect("registracija.html");
		     }		
	    }

   }
