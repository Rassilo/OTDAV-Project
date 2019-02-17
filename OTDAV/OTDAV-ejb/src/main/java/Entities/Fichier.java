package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import Enums.FichierType;


@Entity
public class Fichier implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String path;
	private Date date;
	@Enumerated(EnumType.STRING)
	private FichierType type;
	//relations

	@ManyToOne
	private Deposant deposant; 

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public Deposant getDeposant() {
		return deposant;
	}

	public void setDeposant(Deposant deposant) {
		this.deposant = deposant;
	}

	public FichierType getType() {
		return type;
	}

	public void setType(FichierType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	
	
	
	
}
