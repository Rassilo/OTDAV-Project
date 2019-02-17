package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import Enumerations.EtatDeclaration;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Declaration implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDeclaration;
	private String titre;
	private String description;
	private String auteur;
	private String fichier;
	private String preuve;
	private Date dateDeclaration;
	@Enumerated(EnumType.STRING)
	private EtatDeclaration etatDeclaration;
	
	

	// prop de navigation
	@ManyToOne
	private Adherent adherent;
	
	private static final long serialVersionUID = 1L;

	public Declaration() {
		super();
	}

	public int getIdDeclaration() {
		return idDeclaration;
	}

	public void setIdDeclaration(int idDeclaration) {
		this.idDeclaration = idDeclaration;
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

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

	public String getPreuve() {
		return preuve;
	}

	public void setPreuve(String preuve) {
		this.preuve = preuve;
	}

	public Date getDateDeclaration() {
		return dateDeclaration;
	}

	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public EtatDeclaration getEtatDeclaration() {
		return etatDeclaration;
	}

	public void setEtatDeclaration(EtatDeclaration etatDeclaration) {
		this.etatDeclaration = etatDeclaration;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
}
