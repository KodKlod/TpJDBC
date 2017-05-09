package domaineMetier;


import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HobbiesTest {
	// En plus des logs hibernate
	// Je me crée un log spécifique de niveau info
	private final static Logger LOGGER = LoggerFactory
			.getLogger(HobbiesTest.class);

	@Test
	public void testRecupHobbyIDEgal8() {
		// Les trois lignes qui suivent sont des incontournables.
		EntityManagerFactory createEntityManagerFactory = Persistence
				.createEntityManagerFactory("BaseContacts");
		// EntityManager ne peut être un Singleton
		EntityManager createEntityManager = createEntityManagerFactory
				.createEntityManager();

		// Le .find répond au R du CRUD
		// Voir pour les CUD ce qui est disponible
		Hobbies hobbyRecupere = createEntityManager.find(Hobbies.class, 8L);

		LOGGER.info("Nom du hobby remonté : " + hobbyRecupere.getActivite());

		assertEquals(8, hobbyRecupere.getId());
		assertEquals("Guitar", hobbyRecupere.getActivite());
		assertEquals(6, hobbyRecupere.getContact().getId());
		assertEquals("Jill", hobbyRecupere.getContact().getPrenomFname());
		assertEquals("Jackson", hobbyRecupere.getContact().getNomLname());
		Calendar cal = Calendar.getInstance();
		cal.setTime(hobbyRecupere.getDepuis());
		assertThat(cal.get(Calendar.DAY_OF_MONTH), equalTo(26));
		assertThat(cal.get(Calendar.MONTH), equalTo(Calendar.APRIL));
		assertThat(cal.get(Calendar.YEAR), equalTo(2017));

		System.out.println(hobbyRecupere.getContact().getId());
	}

}
