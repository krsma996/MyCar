package validacija;

import java.util.ArrayList;
import java.util.List;

public class UserValidacija {
	
	public List<String> urediKolicinu(String[]kolicina){
		 List<String> listaKolicine = new ArrayList<String>();
		for(int i=0; i<kolicina.length;i++) {
			if(!(kolicina[i].equals(0))) {
				listaKolicine.add(kolicina[i]);
			}
			
		}
		return listaKolicine;
	}
	

}
