package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Rola;
import model.User;
import validacija.ValidacijaZaRegistraciju;

public class RegistracijaDao {
	
	public SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	public boolean UpisiUseraUBazu(String UserName,String Password,String BrojLicneKarte) {
		User user = new User();
		user.setUserName(UserName);
		user.setPassword(Password);
	    user.setBrojLicneKarte(Integer.parseInt(BrojLicneKarte));  
	    Rola rola;
	    
	    if(ValidacijaZaRegistraciju.DaLiJeAdmin(UserName, Password)) {
	    	 rola= Rola.ADMINISTRATOR; 	
	    }else {
	    	rola = Rola.KORISNIK;
	    }
	    user.setRola(rola);
	    
	    Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	session.save(user);
	    	session.getTransaction().commit();
	    	System.out.println("Uspesno ubacen User!");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Puko si");
			return false;
		}finally {
			session.close();
		}
	    
	   
	   }
	
	
	
	

}
