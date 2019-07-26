package validacija;

import admin.Admin;

public class ValidacijaZaRegistraciju {
	
	public static boolean ProveriPassword(String Password,String RepeatedPassword) {
		
	  if(Password.equals(RepeatedPassword)) {
		  return true;
	  }else {
		  return false;
	  }
		
		
		
	}
	
	
	public static boolean DaLiJeAdmin(String UserName,String Password) {
		Admin admin = new Admin();
		
		if(UserName.equals(admin.getAdminUserName())&& Password.equals(admin.getAdminPassword())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
