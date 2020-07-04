package hasa.hafia.entites;

import javax.persistence.*;
@Entity
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@ManyToOne
	private Users users = new Users();
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int id, String libelle, Users users) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	

}
