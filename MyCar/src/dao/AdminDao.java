package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Car;
import model.Rola;
import model.User;

public class AdminDao {
	
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	

	
	public static List<User> vratiSveUsere(){
		List<User> listaUsera = null;
		Session session = sf.openSession();
		session.beginTransaction();
			
		try {
			String upit = "From User";
			Query query = session.createQuery(upit);
			listaUsera = query.getResultList();
			session.getTransaction().commit();
			return listaUsera;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}
	
	public static boolean DodajAutoUBazu(String Marka,String Model, String Cena, String Boja,String GodinaProizvodnje,String Stanje) {
		Car car = new Car();
		car.setMarka(Marka);
		car.setModel(Model);
		double CenaAuta = Double.parseDouble(Cena);
		car.setCena(CenaAuta);
		car.setBoja(Boja);
		car.setGodinaProizvodnje(Integer.parseInt(GodinaProizvodnje));
		car.setStanje(Integer.parseInt(Stanje));
		
		Session session = sf.openSession();
		session.beginTransaction();
	  
		try {
			session.save(car);
			session.getTransaction().commit();
			return true;	
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	public static boolean DodajUseruNovac(User user,String Balance) {
		double uplata = Double.parseDouble(Balance);
		double staroStanje = user.getNovcanik();
		double konacno= uplata + staroStanje;
		
		if(user.getRola().equals(Rola.ADMINISTRATOR)) {
			user.setNovcanik(0);
		}else {
			user.setNovcanik(konacno);
		}
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			session.update(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
	      session.close(); 
		}		
	}
	
	public static boolean UpdateUseruNovac(User user,String Balance) {
		double uplata = Double.parseDouble(Balance);
		user.setNovcanik(uplata);
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			session.update(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
	
	
	

}


