package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Car;
import model.Racun;
import model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.LongPredicate;

import javax.persistence.Query;

import org.hibernate.Session;

public class UserDao {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public List<Car> vratiSveAutomobile(){
		List<Car>listaAuta = null;
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			String upit = "From Car";
			Query query = session.createQuery(upit);
			listaAuta = query.getResultList();
			session.getTransaction().commit();
			return listaAuta;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
		public List<Car> autaSaRacuna(String[]check){
			List<Car>listaAuta = new ArrayList<>();
			Session session = sf.openSession();
			session.beginTransaction();
			try {
				for(int i=0; i<check.length;i++) {
					long id = Long.parseLong(check[i]);
					Car car = new Car();
					car = session.get(Car.class, id);
					listaAuta.add(car);
				}
				session.getTransaction().commit();
				return listaAuta;
				
			} catch (Exception e) {
				session.getTransaction().commit();
				return listaAuta;
			}finally {
				session.close();
			}
			
		}
		
		public Racun sacuvajRacun(User user,Date date,List<Car>listaAuta) {
			Racun racun = new Racun();
			racun.setUser(user);
			racun.setDate(date);
			racun.setListaAuta(listaAuta);	
			Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				session.save(racun);
				session.getTransaction().commit();
				return racun;
				
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
			}finally {
				session.close();
			}
			
		}
		
		
      public double IznosRacuna(List<Car>listaAuta,List<String>listaKolicina) {
    	     double rez = 0.0;
    	   for(int i = 0;i<listaAuta.size();i++) {
    	    rez = rez + listaAuta.get(i).getCena() * Integer.parseInt(listaKolicina.get(i));
    	   }
    	 
    	return rez;
      }
      
      
      
      
      public void UpdateNovcanik(User user,double TotalPrice) {
    	  user.setNovcanik(user.getNovcanik() - TotalPrice);
    	  Session session = sf.openSession();
    	  session.beginTransaction();
    	  try {
    		  session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
		   session.getTransaction().rollback();
		}finally {
			session.close();
		}
      }
      public void UpdateStanje (List<Car>listaAuta,List<String>listaKolicina) {
    	  Car car;
    	  Session session = sf.openSession();
  		  session.beginTransaction();
    	  
    	  try {
    		  for(int i = 0;i<listaAuta.size();i++) {
    			car = listaAuta.get(i);
    			car.setStanje(car.getStanje() - Integer.parseInt(listaKolicina.get(i)));
    			session.update(car);	
    		  }
    		  session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
    	  
      }
}
