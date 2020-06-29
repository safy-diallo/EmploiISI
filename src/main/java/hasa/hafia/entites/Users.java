package hasa.hafia.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany (mappedBy = "users")
	private List<Roles> roles= new ArrayList<Roles>();
	
	@OneToMany (mappedBy = "users")
	private List<Offres> offres= new ArrayList<Offres>();

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String nom, List<Roles> roles, List<Offres> offres) {
		super();
		this.id = id;
		this.nom = nom;
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
	
	

}
