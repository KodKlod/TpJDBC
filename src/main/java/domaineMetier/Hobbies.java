package domaineMetier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Hobbies")
// Caractérise la classe comme étant persistante
// Le nom de l'entity par défaut est celui de la classe
// Caractérise la table mappée avec cette classe
@Table(name = "HOBBIES")
public class Hobbies {

	@Id
	// @GeneratedValue quand la clé ou la donnée est générée par la base
	@Column(name = "ID")
	private long id;
	@Transient
	/*
	 * @Column(name = "SINCE")
	 * 
	 * @Temporal(TemporalType.DATE)
	 */
	private Date depuis;
	@Column(name = "HOBBY", length = 100)
	private String activite;

	@Transient
	// @ManyToOne
	// @JoinColumn(name = "CONTACT_ID")
	private Contact contact;

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	protected Date getDepuis() {
		return depuis;
	}

	protected void setDepuis(Date depuis) {
		this.depuis = depuis;
	}

	public String getActivite() {
		return activite;
	}

	protected void setActivite(String activite) {
		this.activite = activite;
	}

	protected Contact getContact() {
		return contact;
	}

	protected void setContact(Contact contact) {
		this.contact = contact;
	}

	public Hobbies() {
	}

	public Hobbies(long id, String activite) {
		this.id = id;
		this.activite = activite;
	}

}
