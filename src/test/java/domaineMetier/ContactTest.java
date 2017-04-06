package domaineMetier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactTest {

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

		assertEquals(1, contactRecupere.getId());
		assertEquals("Dave", contactRecupere.getPrenomFname());
		assertEquals("Smith", contactRecupere.getNomLname());
		assertEquals("dsmith@icloud.com", contactRecupere.getMail());
		assertEquals("friend", contactRecupere.getTypeContact());
		assertEquals(46, contactRecupere.getAge());

	}

}
