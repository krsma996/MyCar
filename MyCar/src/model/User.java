package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	private String UserName;
	private String Prezime;
	private String Password;
	private String Novcanik;
    private int BrojLicneKarte;	
    @OneToMany
	List <Racun> listaRacuna = new ArrayList<Racun>();
    @OneToMany
	List <Car> listaAuta = new ArrayList<>();
    @Enumerated
    private Rola rola;
    
	public int getBrojLicneKarte() {
		return BrojLicneKarte;
	}
	public void setBrojLicneKarte(int brojLicneKarte) {
		BrojLicneKarte = brojLicneKarte;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNovcanik() {
		return Novcanik;
	}
	public void setNovcanik(String novcanik) {
		Novcanik = novcanik;
	}
	public List<Racun> getListaRacuna() {
		return listaRacuna;
	}
	public void setListaRacuna(List<Racun> listaRacuna) {
		this.listaRacuna = listaRacuna;
	}
	public List<Car> getListaAuta() {
		return listaAuta;
	}
	public void setListaAuta(List<Car> listaAuta) {
		this.listaAuta = listaAuta;
	}
	public Rola getRola() {
		return rola;
	}
	public void setRola(Rola rola) {
		this.rola = rola;
	}
	
	
	
	

}
