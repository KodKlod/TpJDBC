package baseRH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class MainOracle {

	static String requeteSql = "SELECT FNAME FROM CONTACTS order by FNAME";
	static String databaseUrl = "jdbc:oracle:thin:ANNUAIRE/SYSTEM@localhost:1521:xe";
	
	public MainOracle() {
	}

	public static void main(String[] args)throws Exception {
        
		DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl);
        Statement requete = connexion.createStatement();
        ResultSet resultat = requete.executeQuery(requeteSql);
        	while (resultat.next()) {
            String prenom = resultat.getString("FNAME");
            System.out.println(prenom);
        }
        resultat.close();
        requete.close();
        connexion.close();
	}

}