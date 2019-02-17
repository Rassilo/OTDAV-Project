package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;

import Enums.DepotStatus;


@Entity
public class Depot implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	@Enumerated(EnumType.STRING)
	private DepotStatus status;
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
	
	
	
}
