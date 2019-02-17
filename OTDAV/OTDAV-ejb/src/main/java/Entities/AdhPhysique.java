package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import Enumerations.EA;
import Enumerations.EtatCivil;

/**
 * Entity implementation class for Entity: AdhPhysique
 *
 */
@Entity

public class AdhPhysique extends Adherent {

	private String nom;
	private String prenom;
	private String nationalite;
	private String lieuNaissance;
	private Date dateNaissance;
	private String pseudonyme;
	@Enumerated(EnumType.STRING)
	private EA etatAdherent;
	@Enumerated(EnumType.STRING)
	private EtatCivil etatCivil;
	private int nbEnfants;
	
	

	private static final long serialVersionUID = 1L;

	public AdhPhysique() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public EA getEtatAdherent() {
		return etatAdherent;
	}

	public void setEtatAdherent(EA etatAdherent) {
		this.etatAdherent = etatAdherent;
	}

	public EtatCivil getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(EtatCivil etatCivil) {
		this.etatCivil = etatCivil;
	}

	public int getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
