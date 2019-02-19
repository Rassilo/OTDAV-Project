package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import Enums.CategoryType;
import Enums.DepotStatus;


@Entity
public class Depot implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String titre;
	private String auteur;
	private Date dateCreation;
	@Enumerated(EnumType.STRING)
	private DepotStatus status;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	//relations

	@OneToMany(mappedBy="depot")
	private List<Contrat> contrats; 
	
	@ManyToOne
	private Deposant deposant;	
 
	@ManyToOne
	private Contrat contrat;	
	
	private static final long serialVersionUID = 1L;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getId() {
		return id;
	}



	public List<Contrat> getContrats() {
		return contrats;
	}



	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}



	public Deposant getDeposant() {
		return deposant;
	}



	public void setDeposant(Deposant deposant) {
		this.deposant = deposant;
	}



	public Contrat getContrat() {
		return contrat;
	}



	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}



	public DepotStatus getStatus() {
		return status;
	}

	public void setStatus(DepotStatus status) {
		this.status = status;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
	
	
}
