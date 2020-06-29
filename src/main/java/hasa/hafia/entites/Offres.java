package hasa.hafia.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Offres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomEntreprise;
	private String descriptionOffre;
	
	@OneToMany(mappedBy = "offres")
	private List<Demande> demandes = new ArrayList<Demande>();
	@ManyToOne
	private Users users= new Users();
	public Offres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offres(int id, String nomEntreprise, String descriptionOffre, List<Demande> demandes, Users users) {
		super();
		this.id = id;
		this.nomEntreprise = nomEntreprise;
		this.descriptionOffre = descriptionOffre;
		this.demandes = demandes;
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getDescriptionOffre() {
		return descriptionOffre;
	}
	public void setDescriptionOffre(String descriptionOffre) {
		this.descriptionOffre = descriptionOffre;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	

}
