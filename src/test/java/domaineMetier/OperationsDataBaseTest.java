package domaineMetier;

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

public class OperationsDataBaseTest {

	// Nettoyage des tables avant demarrage des tests
	public static final Operation DELETE_ALL = deleteAllFrom("HOBBIES",
			"CONTACTS");


	//Creer les jeux de donnees
	public static final Operation INSERT_REFERENCE_DATA =
			sequenceOf(
				insertInto("CONTACTS")
					.columns("ID","FNAME","LNAME")
					.values(6,"Jill","Jackson")
					.build(),
				insertInto("HOBBIES")
.columns("ID", "HOBBY").values(8, "Guitar")
					.build());
	}
