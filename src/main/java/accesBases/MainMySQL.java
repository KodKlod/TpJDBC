package accesBases;

public class MainMySQL {

	public MainMySQL() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception{
		IContactsDAO daoCreate = new JdbcContactsDAO();
		Integer ligneCreee = daoCreate.creationContactEnBase
		("Dubois","Patty","dp@toto.fSr", 32,"Client");
		System.out.println(ligneCreee);	
		}

}
