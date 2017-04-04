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

		// O� le 1 repr�sente le premier point d'interrogation contenu dans la
		// req sql
		// O� le 0 repr�sente l'indice du param�tre � s�lectionner dans les
		// arguments pr�d�finis
		// dans Run Configurations, onglet Arguments, zone Program Arguments
		// On peut d�finir directement le param�tre dans le .setString
		requete.setString(1, type);
		ResultSet resultat = requete.executeQuery();

		while (resultat.next()) {
			// O� le 1 repr�sente le premier champ du select
			// dans le cas pr�sent EMAIL
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
		
		//R�cup�rer le dernier id de la table contacts pour cr�er l'id du nouvel enregistrement
		
		
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
