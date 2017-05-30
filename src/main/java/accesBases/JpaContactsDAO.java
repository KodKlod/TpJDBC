package accesBases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domaineMetier.Contact;

public class JpaContactsDAO implements IContactsDAO {

	public JpaContactsDAO() {

	}



	@SuppressWarnings("unchecked")
	@Override
	public List<String> trouverEmailDesContactsParType(String type)
			throws Exception {
		String rechParTypeContact = "Select a.mail from Contact a "
				+ " where a.typeContact=?1 ";
		EntityManager createEntityManager = getEntityManager();

		TypedQuery<String> maQuery = (TypedQuery<String>) createEntityManager
				.createQuery(rechParTypeContact);
		// Query maQuery = createEntityManager.createQuery(rechParTypeContact);
		maQuery.setParameter(1, type);

		List<String> list = maQuery.getResultList();

		return list;
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
