package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import Enumerations.EtatCompte;

/**
 * Entity implementation class for Entity: Adherent
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Adherent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAdherent;
	private String cin; // personne physique ou morale
	private String copieCin; // personne physique ou morale
	private String rib;
	private int nbPoints;
	private float solde;
	private String adresse;
	private String ville;
	private int codePostal;
	private String telephone;
	private String fax;
	private String email;
	private String motDePasse;
	private Date dateDerniereCotisation;
	private Date dateAdhesion;
	private EtatCompte etatCompte;
	private String categorieAbonnement; // séparer les catégories par -
	private String raisonDemission;
	private Date dateDemission;
	private String photoProfil;
	private static final long serialVersionUID = 1L;

	// prop de navigation
	@OneToMany(mappedBy = "adherent")
	private List<Declaration> listeDeclarations;

	public Adherent() {
		super();
	}

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCopieCin() {
		return copieCin;
	}

	public void setCopieCin(String copieCin) {
		this.copieCin = copieCin;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateDerniereCotisation() {
		return dateDerniereCotisation;
	}

	public void setDateDerniereCotisation(Date dateDerniereCotisation) {
		this.dateDerniereCotisation = dateDerniereCotisation;
	}

	public Date getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public EtatCompte getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(EtatCompte etatCompte) {
		this.etatCompte = etatCompte;
	}

	public String getCategorieAbonnement() {
		return categorieAbonnement;
	}

	public void setCategorieAbonnement(String categorieAbonnement) {
		this.categorieAbonnement = categorieAbonnement;
	}

	public String getRaisonDemission() {
		return raisonDemission;
	}

	public void setRaisonDemission(String raisonDemission) {
		this.raisonDemission = raisonDemission;
	}

	public Date getDateDemission() {
		return dateDemission;
	}

	public void setDateDemission(Date dateDemission) {
		this.dateDemission = dateDemission;
	}

	public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	public List<Declaration> getListeDeclarations() {
		return listeDeclarations;
	}

	public void setListeDeclarations(List<Declaration> listeDeclarations) {
		this.listeDeclarations = listeDeclarations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
