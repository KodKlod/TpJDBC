package domaineMetier;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

import static org.junit.Assert.assertEquals;

import static com.ninja_squad.dbsetup.Operations.sequenceOf;


public class HobbiesJpaDbSetupTest {

	// En plus des logs hibernate
	// Je me crée un log spécifique de niveau info
	private final static Logger LOGGER = LoggerFactory
			.getLogger(HobbiesJpaDbSetupTest.class);

	private static EntityManagerFactory createEntityManagerFactory;

	@BeforeClass
	public static void avantTout() {
	createEntityManagerFactory = Persistence.createEntityManagerFactory("BaseTestContacts");
	}

	// Avec DbSetup et H2, preparation des jeux de donnees
	@Before
    public void prepare() throws Exception {
        Operation operation =
            sequenceOf(
OperationsDataBaseTest.DELETE_ALL,
		OperationsDataBaseTest.INSERT_REFERENCE_DATA);
		DbSetup dbSetup = new DbSetup(new DriverManagerDestination(
				"jdbc:h2:~/test",
				"", ""), operation);
		dbSetup.launch();
    }


	@Test
	public void testRecupHobbyIDEgal8() {

		// EntityManager ne peut être un Singleton
		EntityManager createEntityManager = createEntityManagerFactory
				.createEntityManager();

		// Le .find répond au R du CRUD
		// Voir pour les CUD ce qui est disponible
		Hobbies hobbyRecupere = createEntityManager.find(Hobbies.class, 8L);

		LOGGER.info("Nom du hobby remonté : " + hobbyRecupere.getActivite());

		assertEquals(8, hobbyRecupere.getId());
		assertEquals("Guitar", hobbyRecupere.getActivite());
		// assertEquals(6, hobbyRecupere.getContact().getId());
		// assertEquals("Jill", hobbyRecupere.getContact().getPrenomFname());
		// assertEquals("Jackson", hobbyRecupere.getContact().getNomLname());
		/*
		 * Calendar cal = Calendar.getInstance();
		 * cal.setTime(hobbyRecupere.getDepuis());
		 * assertThat(cal.get(Calendar.DAY_OF_MONTH), equalTo(26));
		 * assertThat(cal.get(Calendar.MONTH), equalTo(Calendar.APRIL));
		 * assertThat(cal.get(Calendar.YEAR), equalTo(2017));
		 */
	}

}
