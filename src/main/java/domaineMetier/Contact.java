package domaineMetier;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity (name = "Contact") //Caractérise la classe Contact comme étant persistante
// Le nom de l'entity par défaut est celui de la classe
// Caractérise la table mappée avec Contact
@Table(name = "CONTACTS")

public class Contact {

	@Id
	// @GeneratedValue quand la clé ou la donnée est générée par la base
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

	// @Transient
	@OneToMany
	@JoinColumn(name = "CONTACT_ID")
	private Set<Hobbies> hobbies;

	public Contact() {

	}

	public Set<Hobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobbies> hobbies) {
		this.hobbies = hobbies;
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

}
