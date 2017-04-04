package accesBases;

import java.util.List;

public interface IContactsDAO {
	List<String> trouverEmailDesContactsParType(String type) throws Exception;
	
	Integer creationContactEnBase(String nom, String prenom, String eMail, int age, String typeContact ) throws Exception;
	
}
