package accesBases;

public class MainJPA {

	public MainJPA() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		JpaContactsDAO meCreer = new JpaContactsDAO();
		try {
			meCreer.creationContactEnBase("Pecheux", "Claude",
					"claude.p@mail.fr", 53, "co-worker");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
