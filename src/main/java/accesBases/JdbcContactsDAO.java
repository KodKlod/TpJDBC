package accesBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class JdbcContactsDAO implements IContactsDAO {

	@Override
	public List<String> trouverEmailDesContactsParType(String type)
			throws Exception {
		String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970";
		String requeteSql = "SELECT EMAIL FROM CONTACTS WHERE CONTACT_TYPE =?";

		List<String> emails = new ArrayList<String>();
		DriverManager.registerDriver(new Driver());
		Connection connexion = DriverManager.getConnection(databaseUrl,
				"sql8157970", "GTyyUfvfQ6");

		PreparedStatement requete = connexion.prepareStatement(requeteSql);

		// Où le 1 représente le premier point d'interrogation contenu dans la
		// req sql
		// Où le 0 représente l'indice du paramètre à sélectionner dans les
		// arguments prédéfinis
		// dans Run Configurations, onglet Arguments, zone Program Arguments
		// On peut définir directement le paramètre dans le .setString
		requete.setString(1, type);
		ResultSet resultat = requete.executeQuery();

		while (resultat.next()) {
			// Où le 1 représente le premier champ du select
			// dans le cas présent EMAIL
			String email = resultat.getString(1);
			emails.add(email);
		}

		resultat.close();
		requete.close();
		connexion.close();
		return emails;
	}

	@Override
	public Integer creationContactEnBase
	(String nom, String prenom, String eMail, int age, String typeContact )
			throws Exception{
		
		//Récupérer le dernier id de la table contacts pour créer l'id du nouvel enregistrement
		
		
		String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970";
		String requeteSql = "INSERT INTO CONTACTS (LNAME,FNAME,EMAIL,AGE,CONTACT_TYPE)"
				+ " VALUES (? , ? , ? , ? , ? ) ";
				
		DriverManager.registerDriver(new Driver());
		Connection connexion = DriverManager.getConnection(databaseUrl,
				"sql8157970", "GTyyUfvfQ6");
		
			PreparedStatement requete = connexion.prepareStatement(requeteSql);

			requete.setString(1,nom);
			requete.setString(2,prenom);
			requete.setString(3, eMail);
			requete.setInt(4,age);
			requete.setString(5,typeContact);
			
			return requete.executeUpdate();

	
	}
	
	
}
