package baseRH;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import accesBases.IContactsDAO;
import accesBases.JpaContactsDAO;



public class Main {

	
	public Main() {
	}

	public static void main(String[] args)throws Exception {
		Logger loggeur = Logger.getLogger("monLogger");
		
		// IContactsDAO dao = new JdbcContactsDAO();
		IContactsDAO dao = new JpaContactsDAO();
		
		// La valeur de contType est déclaréé dans l'onglet
		// Arguments de Run Configurations
		String contType=args[0];
		loggeur.log(Level.INFO, "Recherche des contacts de type " + contType);
		
		List<String> emails = dao.trouverEmailDesContactsParType(contType);
		
		for (String email : emails){
			loggeur.log(Level.INFO, email);;
			
		}

	}

}