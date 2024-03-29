package OTDAV.managedBeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.AdhMorale;
import Entities.AdhPhysique;
import Entities.Adherent;
import Entities.Admin;
import Enumerations.EtatCompte;
import Services.AdherentImplLocal;
import Services.DeclarationImplLocal;
import Utils.CryptPassword;

@ManagedBean(name = "identity")
@SessionScoped
public class AuthBean {
	@EJB
	private AdherentImplLocal adherentImplLocal;
	@EJB
	DeclarationImplLocal declaratinImplLocal;

	private boolean isNotLogged = true;
	private boolean isLogged = false;
	private Boolean loggedInAsAdherent = false;
	private Boolean loggedInAsAdmin = false;

	// to render the special container and form for the user if "resigned"
	private boolean resigned = false;

	private Adherent u = new Adherent();
	private boolean etatCompte = false;

	public String doLogin() {

		String navigateTo = "";
		// get the password from the form, encrypt it and find it in the table
		// to check it !

		String pwd = u.getMotDePasse();
		CryptPassword cp = new CryptPassword();
		String encryptedPassword = cp.get_SHA_512_SecurePassword(pwd, "x");

		Adherent userLoggedIn = adherentImplLocal.login(u.getCin(), encryptedPassword);
		u = userLoggedIn;

		int nbDays = adherentImplLocal.getNumberOfDays(new Date(), userLoggedIn.getDateDerniereCotisation());
		if (userLoggedIn instanceof AdhPhysique || userLoggedIn instanceof AdhMorale) {

			setLogged(true);
			setNotLogged(false);
			setLoggedInAsAdherent(true);
			System.out.println("OK");
			return "/declarations/AddDeclarationLiterature?faces-redirect=true";

		}

		if (userLoggedIn instanceof Admin) {

			setLogged(true);
			setNotLogged(false);
			setLoggedInAsAdmin(true);
			navigateTo = "/admin/Dashboard?faces-redirect=true";
		}
		return navigateTo;

	}

	public String logout() {
		isLogged = false;
		isNotLogged = true;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/adherent/login?faces-redirect=true";
	}

	public String redirectToDashboard() {
		return "/Admin/Dashboard?faces-redirect=true";
	}

	public AdherentImplLocal getAdherentImplLocal() {
		return adherentImplLocal;
	}

	public void setAdherentImplLocal(AdherentImplLocal adherentImplLocal) {
		this.adherentImplLocal = adherentImplLocal;
	}

	public DeclarationImplLocal getDeclaratinImplLocal() {
		return declaratinImplLocal;
	}

	public void setDeclaratinImplLocal(DeclarationImplLocal declaratinImplLocal) {
		this.declaratinImplLocal = declaratinImplLocal;
	}

	public boolean isNotLogged() {
		return isNotLogged;
	}

	public void setNotLogged(boolean isNotLogged) {
		this.isNotLogged = isNotLogged;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getLoggedInAsAdherent() {
		return loggedInAsAdherent;
	}

	public void setLoggedInAsAdherent(Boolean loggedInAsAdherent) {
		this.loggedInAsAdherent = loggedInAsAdherent;
	}

	public Boolean getLoggedInAsAdmin() {
		return loggedInAsAdmin;
	}

	public void setLoggedInAsAdmin(Boolean loggedInAsAdmin) {
		this.loggedInAsAdmin = loggedInAsAdmin;
	}

	public boolean isResigned() {
		return resigned;
	}

	public void setResigned(boolean resigned) {
		this.resigned = resigned;
	}

	public Adherent getU() {
		return u;
	}

	public void setU(Adherent u) {
		this.u = u;
	}

	public boolean isEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(boolean etatCompte) {
		this.etatCompte = etatCompte;
	}

}
