package domaineMetier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "Contact") //Caract�rise la classe Contact comme �tant persistante
// Le nom de l'entity par d�faut est celui de la classe
// Caract�rise la table mapp�e avec Contact
@Table(name = "CONTACTS")

public class Contact {

	@Id
	// @GeneratedValue quand la cl� ou la donn�e est g�n�r�e par la base
	@Column(name = "ID")
	private long id;
	@Column(name = "FNAME", length = 100)
	private String prenomFname;
	@Column(name = "LNAME", length = 100)
	private String nomLname;
	@Column(name = "EMAIL", length = 255)
	private String mail;
	@Column(name = "CONTACT_TYPE", length = 30)
	private String typeContact;
	@Column(name = "AGE")
	private int age;

	
	public Contact() {
		
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrenomFname() {
		return prenomFname;
	}

	public void setPrenomFname(String prenomFname) {
		this.prenomFname = prenomFname;
	}

	public String getNomLname() {
		return nomLname;
	}

	public void setNomLname(String nomLname) {
		this.nomLname = nomLname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
