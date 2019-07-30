package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginDao {
	
	public SessionFactory  sf = new Configuration().configure().buildSessionFactory();

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	
	public boolean DaLiJeUserUBazi (String UserName) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String upit = "From User where UserName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", UserName);
			
			List<User> listaUsera = query.getResultList();
			if(listaUsera.isEmpty()) {
				session.getTransaction().commit();
			    System.out.println("Ne postoji User u bazi");
				return false;
				
			}else {
				session.getTransaction().commit();
				System.out.println("Dobar je user");
				return true;
			}
						
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nije Dobar UserName");
			return false;
		}finally {
			session.close();
		}
		
			
	}
	
	
	public boolean DaliPasswordOdgovaraUseru(String UserName,String Password) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String upit = "From User where UserName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", UserName);
			
			List<User> listaUsera = query.getResultList();
			for(User userIzbaze: listaUsera) {
				if(userIzbaze.getPassword().equals(Password)) {
					session.getTransaction().commit();
					System.out.println("Pustaj Usera");
					return true;
					
				}else {
					session.getTransaction().rollback();
					System.out.println("Los User");
					return false;
				}
				
			}
			return false;	
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}
	
	public User VratiUsera (String UserName) {
		
		User user = new User();
		
		Session session = sf.openSession();
		session.beginTransaction();
			
		try {
			String upit = "From User where UserName = :korisnickoIme";
			Query query = session.createQuery(upit);
			query.setParameter("korisnickoIme", UserName);
			
			List<User> listaUsera = query.getResultList();
			user = listaUsera.get(0);
			return user;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}
	
	
	
	
	
	

}
