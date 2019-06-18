package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import Enums.ContratStatus;


@Entity
public class Contrat implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Date dateDebut;
	private Date datefin;
	private float price;
	@Enumerated(EnumType.STRING)
	private ContratStatus status;
	//relations
	
	@OneToMany(mappedBy="contrat",cascade = CascadeType.ALL)
	private List<Depot> depots;
	
	private static final long serialVersionUID = 1L;
	
	public String getDescription() {
		return description;
	}
	
	
	public List<Depot> getDepots() {
		return depots;
	}


	public void setDepots(List<Depot> depots) {
		this.depots = depots;
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

	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDatefin() {
		return datefin;
	}



	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public ContratStatus getStatus() {
		return status;
	}



	public void setStatus(ContratStatus status) {
		this.status = status;
	}
	
	

	
}
