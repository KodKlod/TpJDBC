package accesBases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domaineMetier.Contact;

public class JpaContactsDAO implements IContactsDAO {

	public JpaContactsDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> trouverEmailDesContactsParType(String type)
			throws Exception {
		EntityManager createEntityManager = getEntityManager();
		Contact contactRecupere = createEntityManager.find(Contact.class, type);
		contactRecupere.getMail();
		return null;
	}

	@Override
	public Integer creationContactEnBase(String nom, String prenom,
			String eMail, int age, String typeContact) throws Exception {
		EntityManager createEntityManager = getEntityManager();

		Contact nouveauContact = new Contact();
		nouveauContact.setPrenomFname(prenom);
		nouveauContact.setNomLname(nom);
		nouveauContact.setMail(eMail);
		nouveauContact.setTypeContact(typeContact);
		nouveauContact.setAge(age);
		createEntityManager.getTransaction().begin();
		createEntityManager.persist(nouveauContact);
		// Le .persist correpond au C du CRUD
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		return null;
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory createEntityManagerFactory = Persistence
				.createEntityManagerFactory("BaseContacts");
		// EntityManager ne peut être un Singleton
		EntityManager createEntityManager = createEntityManagerFactory
				.createEntityManager();
		return createEntityManager;
	}

}
