package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AdhMorale
 *
 */
@Entity

public class AdhMorale extends Adherent {

	
	private String nomEntreprise;
	private String numRegComm;
	private String regCommCopie;
	private String statutCopie;
	private String jortCopie;
	private String matriculeFiscaleCopie;
	private String declarationExistenceCopie;

	private static final long serialVersionUID = 1L;

	public AdhMorale() {
		super();
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getNumRegComm() {
		return numRegComm;
	}

	public void setNumRegComm(String numRegComm) {
		this.numRegComm = numRegComm;
	}

	public String getRegCommCopie() {
		return regCommCopie;
	}

	public void setRegCommCopie(String regCommCopie) {
		this.regCommCopie = regCommCopie;
	}

	public String getStatutCopie() {
		return statutCopie;
	}

	public void setStatutCopie(String statutCopie) {
		this.statutCopie = statutCopie;
	}

	public String getJortCopie() {
		return jortCopie;
	}

	public void setJortCopie(String jortCopie) {
		this.jortCopie = jortCopie;
	}

	public String getMatriculeFiscaleCopie() {
		return matriculeFiscaleCopie;
	}

	public void setMatriculeFiscaleCopie(String matriculeFiscaleCopie) {
		this.matriculeFiscaleCopie = matriculeFiscaleCopie;
	}

	public String getDeclarationExistenceCopie() {
		return declarationExistenceCopie;
	}

	public void setDeclarationExistenceCopie(String declarationExistenceCopie) {
		this.declarationExistenceCopie = declarationExistenceCopie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
   
}
