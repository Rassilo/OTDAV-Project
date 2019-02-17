package Entities;

import java.io.Serializable;
import javax.persistence.*;

import Enumerations.DM;

/**
 * Entity implementation class for Entity: DecMusique
 *
 */
@Entity

public class DecMusique extends Declaration {
	@Enumerated(EnumType.STRING)
	private DM typeDeclarationMusique;
	private String compositeur;

	private static final long serialVersionUID = 1L;

	public DecMusique() {
		super();
	}

	public DM getTypeDeclarationMusique() {
		return typeDeclarationMusique;
	}

	public void setTypeDeclarationMusique(DM typeDeclarationMusique) {
		this.typeDeclarationMusique = typeDeclarationMusique;
	}

	public String getCompositeur() {
		return compositeur;
	}

	public void setCompositeur(String compositeur) {
		this.compositeur = compositeur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
