package hasa.hafia.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

	private int id;
	private String nom;
	private String username;
	private String password;
	private String email;
	private String prenom;
	private int etat;

	
	@OneToMany (mappedBy = "users")
	private List<Roles> roles= new ArrayList<Roles>();
	
	@OneToMany (mappedBy = "users")
	private List<Offres> offres= new ArrayList<Offres>();

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String nom, String prenom, String password, String email, List<Roles> roles,
			List<Offres> offres) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.offres = offres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public List<Offres> getOffres() {
		return offres;
	}

	public void setOffres(List<Offres> offres) {
		this.offres = offres;
	}


	public Users(int etat) {
		super();
		this.etat = etat;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
