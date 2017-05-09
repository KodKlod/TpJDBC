package domaineMetier;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class ContactTest {
	// En plus des logs hibernate
	// Je me crée un log spécifique de niveau info
	private final static Logger LOGGER = LoggerFactory
			.getLogger(ContactTest.class);

	@Test
	public void testRecupContactIDEgal1() {
		// Les trois lignes qui suivent sont des incontournables.
		EntityManagerFactory createEntityManagerFactory = Persistence
				.createEntityManagerFactory("BaseContacts");
		// EntityManager ne peut être un Singleton
		EntityManager createEntityManager = createEntityManagerFactory
				.createEntityManager();

		// Le .find répond au R du CRUD
		// Voir pour les CUD ce qui est disponible
		Contact contactRecupere = createEntityManager.find(Contact.class, 1L);

		LOGGER.info("Nom du contact remonté : " + contactRecupere.getNomLname());

		assertEquals(1, contactRecupere.getId());
		assertEquals("Dave", contactRecupere.getPrenomFname());
		assertEquals("Smith", contactRecupere.getNomLname());
		assertEquals("dsmith@icloud.com", contactRecupere.getMail());
		assertEquals("friend", contactRecupere.getTypeContact());
		assertEquals(46, contactRecupere.getAge());

		assertEquals(2, contactRecupere.getHobbies().size());
		// Et comment je fais pour comparer les valeurs de chacun des deux
		// hobbies ?
		//
	}

}
