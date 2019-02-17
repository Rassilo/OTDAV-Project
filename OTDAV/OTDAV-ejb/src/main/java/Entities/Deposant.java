package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import Enums.DeposantType;


@Entity
public class Deposant implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cin;
	private String matricule;
	private String name;
	private String surname;
	private String email;
	private String login;
	private String password;
	private String lieuCommerce;
	private String numeroCommerce;
	private String raison;
	private Date dateCommerce;
	private long phone;
	@Enumerated(EnumType.STRING)
	private DeposantType type;
	private String address;
	
	
	//Relations
	@OneToMany(mappedBy="deposant")
	private List<Depot> depots;
	
	@OneToMany(mappedBy="deposant")
	private List<Fichier> fichiers;
	
	private static final long serialVersionUID = 1L;
	
	public Integer getId() {
		return id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Depot> getDepots() {
		return depots;
	}

	public void setDepots(List<Depot> depots) {
		this.depots = depots;
	}

	public DeposantType getType() {
		return type;
	}

	public void setType(DeposantType type) {
		this.type = type;
	}

	public String getLieuCommerce() {
		return lieuCommerce;
	}

	public void setLieuCommerce(String lieuCommerce) {
		this.lieuCommerce = lieuCommerce;
	}

	public String getNumeroCommerce() {
		return numeroCommerce;
	}

	public void setNumeroCommerce(String numeroCommerce) {
		this.numeroCommerce = numeroCommerce;
	}

	public Date getDateCommerce() {
		return dateCommerce;
	}

	public void setDateCommerce(Date dateCommerce) {
		this.dateCommerce = dateCommerce;
	}

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}
	
	
	
	
	
	
}
