package domaineMetierTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import domaineMetier.Contact;

import static org.junit.Assert.assertEquals;

public class ContactTest {

	@Test
	public void testRecupContactIDEgal1() {
		EntityManagerFactory createEntityManagerFactory = Persistence
				.createEntityManagerFactory("BaseContacts");

		EntityManager createEntityManager = createEntityManagerFactory
				.createEntityManager();

		Contact contactRecupere = createEntityManager.find(Contact.class, 1L);

		assertEquals(1, contactRecupere.getId());
		assertEquals("Dave", contactRecupere.getPrenomFname());
		assertEquals("Smith", contactRecupere.getNomLname());
		assertEquals("dsmith@icloud.com", contactRecupere.getMail());
		assertEquals("friend", contactRecupere.getTypeContact());
		assertEquals(46, contactRecupere.getAge());

	}

}
