package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;


@Entity
public class Category implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	//relations

	@OneToMany(mappedBy="contrat")
	private List<Depot> depots; 



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



	public List<Depot> getDepots() {
		return depots;
	}



	public void setDepots(List<Depot> depots) {
		this.depots = depots;
	}
	
	
	
}
