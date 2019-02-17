package OTDAV.managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import Entities.AdhMorale;
import Entities.AdhPhysique;
import Entities.Adherent;
import Enumerations.EA;
import Enumerations.EtatCompte;
import Services.AdherentImplLocal;
import Utils.CryptPassword;
import Utils.Routing;
import Utils.SMS;

@ManagedBean
public class AdherentBean {

	@EJB
	private AdherentImplLocal adherentImplLocal;
	@ManagedProperty(value = "#{identity}")
	AuthBean authBean;

	private String msgDeDemission;
	private AdhPhysique modelPhysique = new AdhPhysique();
	private AdhMorale modelMorale = new AdhMorale();

	private List<String> cities = new ArrayList<>();
	private List<String> countries = new ArrayList<>();

	// to store the selected category to subscribe
	private String newCategory;
	// store the unsubscribed categories for the user
	private List<String> unsubscribedCategories = new ArrayList<>();

	private String selectedCity;
	private String selectedCountry;

	// pour physique + morale
	private Part fileCin;
	private Part fileProfil;

	// pour morale
	private Part fileRegComm;
	private Part fileStatut;
	private Part fileJort;
	private Part fileStatFiscale;
	private Part fileDeclarExistence;

	private String confirmPassword;

	public void subscribeToNewCategory() {
		adherentImplLocal.subscribeToNewCategory(authBean.getU().getIdAdherent(), newCategory);
	}

	public String getSubscribedCategory() {
		String allSubscribedCateg;
		allSubscribedCateg = adherentImplLocal.getAllSubscribedCategory(authBean.getU());
		return allSubscribedCateg;
	}

	public void uploadCinOrPasseport(String folderName) throws IOException {

		InputStream in = fileCin.getInputStream();
		File f = new File(folderName + "\\" + fileCin.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public void uploadPhotoProfil(String folderName) throws IOException {
		InputStream in = fileProfil.getInputStream();
		File f = new File(folderName + "\\" + fileProfil.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public void uploadRegComm(String folderName) throws IOException {

		InputStream in = fileRegComm.getInputStream();
		File f = new File(folderName + "\\" + fileRegComm.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public void uploadStatut(String folderName) throws IOException {

		InputStream in = fileStatut.getInputStream();
		File f = new File(folderName + "\\" + fileStatut.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public void uploadJORT(String folderName) throws IOException {

		InputStream in = fileJort.getInputStream();
		File f = new File(folderName + "\\" + fileJort.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public void uploadStatFiscale(String folderName) throws IOException {

		InputStream in = fileStatFiscale.getInputStream();
		File f = new File(folderName + "\\" + fileStatFiscale.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public void uploadDeclarExistence(String folderName) throws IOException {

		InputStream in = fileDeclarExistence.getInputStream();
		File f = new File(folderName + "\\" + fileDeclarExistence.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
	}

	public String signUpAsAdherentMorale() throws InterruptedException, IOException {
		modelMorale.setCopieCin(modelMorale.getCin() + "/" + fileCin.getSubmittedFileName());
		modelMorale.setNbPoints(0);
		modelMorale.setSolde(0);
		modelMorale.setVille(selectedCity);
		modelMorale.setPhotoProfil(modelMorale.getCin() + "/" + fileProfil.getSubmittedFileName());
		CryptPassword cp = new CryptPassword();
		String encryptedPassword = cp.get_SHA_512_SecurePassword(modelMorale.getMotDePasse(), "x");
		modelMorale.setMotDePasse(encryptedPassword);
		modelMorale.setDateDerniereCotisation(new Date());
		modelMorale.setDateAdhesion(new Date());
		modelMorale.setEtatCompte(EtatCompte.NonConfirme);
		modelMorale.setRegCommCopie(modelMorale.getCin() + "/" + fileRegComm.getSubmittedFileName());
		modelMorale.setStatutCopie(modelMorale.getCin() + "/" + fileStatut.getSubmittedFileName());
		modelMorale.setJortCopie(modelMorale.getCin() + "/" + fileJort.getSubmittedFileName());
		modelMorale.setMatriculeFiscaleCopie(modelMorale.getCin() + "/" + fileStatFiscale.getSubmittedFileName());
		modelMorale
				.setDeclarationExistenceCopie(modelMorale.getCin() + "/" + fileDeclarExistence.getSubmittedFileName());

		// create a folder with the company's name
		String folderName = Routing.server + modelMorale.getCin();
		File dir = new File(folderName);
		dir.mkdir();
		TimeUnit.SECONDS.sleep(3);
		uploadCinOrPasseport(folderName);
		uploadRegComm(folderName);
		uploadStatut(folderName);
		uploadJORT(folderName);
		uploadStatFiscale(folderName);
		uploadDeclarExistence(folderName);
		uploadPhotoProfil(folderName);
		adherentImplLocal.addAdherent(modelMorale);
		return "Registered?faces-redirect=true";

	}

	public String signUpAsAdherentPhysique() throws InterruptedException, IOException {
		
		
		modelPhysique.setCopieCin(modelPhysique.getCin() + "/" + fileCin.getSubmittedFileName());
		modelPhysique.setNbPoints(0);
		modelPhysique.setSolde(0);
		modelPhysique.setNationalite(selectedCountry);
		modelPhysique.setVille(selectedCity);
		modelPhysique.setPhotoProfil(modelPhysique.getCin() + "/" + fileProfil.getSubmittedFileName());
		CryptPassword cp = new CryptPassword();
		String encryptedPassword = cp.get_SHA_512_SecurePassword(modelPhysique.getMotDePasse(), "x");
		modelPhysique.setMotDePasse(encryptedPassword);
		modelPhysique.setDateDerniereCotisation(new Date());
		modelPhysique.setDateAdhesion(new Date());

		// date naissance to change it
		modelPhysique.setDateNaissance(new Date());

		modelPhysique.setEtatCompte(EtatCompte.NonConfirme);
		modelPhysique.setEtatAdherent(EA.Vivant);
		String folderName = Routing.server + modelPhysique.getCin();
		File dir = new File(folderName);
		dir.mkdir();
		TimeUnit.SECONDS.sleep(3);
		uploadCinOrPasseport(folderName);
		uploadPhotoProfil(folderName);
		adherentImplLocal.addAdherent(modelPhysique);
		// send a message to the new adherent
		// SMS.sendSMS(modelPhysique.getTelephone(),"Votre compte a été bien enregistré
		// ! \n Bienvenue chez OTDAV");
		return "Registered?faces-redirect=true";

	}

	public String demissioner() {

		Adherent adh = new Adherent();
		// to change by the logged user and eliminate this line
		adh = adherentImplLocal.getAdherentById(authBean.getU().getIdAdherent());
		adh.setEtatCompte(EtatCompte.Demissione);
		adh.setRaisonDemission(msgDeDemission);
		adh.setDateDemission(new Date());
		adherentImplLocal.updateAdherentApresDemission(adh);
		authBean.logout();
		return "/adherent/ResignedAfterResign?faces-redirect=true";
	}

	public String redirectToDemission() {
		return "demission?faces-redirect=true";
	}

	public String redirectToLogin() {
		return "login?faces-redirect=true";
	}

	public String redirectToProfil() {
		return "Profil?faces-redirect=true";
	}

	public String redirectToSignUpPage() {
		return "signupAdh?faces-redirect=true";
	}

	public String redirectToInsriptionPhysique() {
		return "signupPhysique?faces-redirect=true";

	}

	public String redirectToPayment() {
		return "payment?faces-redirect=true";

	}

	public String redirectToInsriptionMorale() {

		return "signupMorale?faces-redirect=true";
	}

	public List<String> getCities() {
		cities.add("Tunis");
		cities.add("Ariana");
		cities.add("Ben Arous");
		cities.add("Mannouba");
		cities.add("Nabeul");
		cities.add("Zaghouan");
		cities.add("Bizerte");
		cities.add("Beja");
		cities.add("Jendouba");
		cities.add("Kef");
		cities.add("Siliana");
		cities.add("Sousse");
		cities.add("Monastir");
		cities.add("Mahdia");
		cities.add("Sfax");
		cities.add("Kairouan");
		cities.add("Kasserine");
		cities.add("Sidi Bouzid");
		cities.add("Gabes");
		cities.add("Mednine");
		cities.add("Tataouine");
		cities.add("Gafsa");
		cities.add("Tozeur");
		cities.add("Kebili");
		return cities;
	}

	public List<String> getUnsubscribedCategories() {

		String subCateg = adherentImplLocal.getAllSubscribedCategory(authBean.getU());
		if (!(subCateg.contains("AuteurMusicale")))
			unsubscribedCategories.add("AuteurMusicale");
		if (!(subCateg.contains("CompositionMusicale")))
			unsubscribedCategories.add("CompositionMusicale");
		if (!(subCateg.contains("Literature")))
			unsubscribedCategories.add("Literature");
		if (!(subCateg.contains("Theatre")))
			unsubscribedCategories.add("Theatre");
		if (!(subCateg.contains("Artistique")))
			unsubscribedCategories.add("Artistique");
		if (!(subCateg.contains("Autre")))
			unsubscribedCategories.add("Autre");
		return unsubscribedCategories;
	}

	public AdherentImplLocal getAdherentImplLocal() {
		return adherentImplLocal;
	}

	public void setAdherentImplLocal(AdherentImplLocal adherentImplLocal) {
		this.adherentImplLocal = adherentImplLocal;
	}

	public AuthBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	public String getMsgDeDemission() {
		return msgDeDemission;
	}

	public void setMsgDeDemission(String msgDeDemission) {
		this.msgDeDemission = msgDeDemission;
	}

	public AdhPhysique getModelPhysique() {
		return modelPhysique;
	}

	public void setModelPhysique(AdhPhysique modelPhysique) {
		this.modelPhysique = modelPhysique;
	}

	public AdhMorale getModelMorale() {
		return modelMorale;
	}

	public void setModelMorale(AdhMorale modelMorale) {
		this.modelMorale = modelMorale;
	}

	public String getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(String newCategory) {
		this.newCategory = newCategory;
	}

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public Part getFileCin() {
		return fileCin;
	}

	public void setFileCin(Part fileCin) {
		this.fileCin = fileCin;
	}

	public Part getFileProfil() {
		return fileProfil;
	}

	public void setFileProfil(Part fileProfil) {
		this.fileProfil = fileProfil;
	}

	public Part getFileRegComm() {
		return fileRegComm;
	}

	public void setFileRegComm(Part fileRegComm) {
		this.fileRegComm = fileRegComm;
	}

	public Part getFileStatut() {
		return fileStatut;
	}

	public void setFileStatut(Part fileStatut) {
		this.fileStatut = fileStatut;
	}

	public Part getFileJort() {
		return fileJort;
	}

	public void setFileJort(Part fileJort) {
		this.fileJort = fileJort;
	}

	public Part getFileStatFiscale() {
		return fileStatFiscale;
	}

	public void setFileStatFiscale(Part fileStatFiscale) {
		this.fileStatFiscale = fileStatFiscale;
	}

	public Part getFileDeclarExistence() {
		return fileDeclarExistence;
	}

	public void setFileDeclarExistence(Part fileDeclarExistence) {
		this.fileDeclarExistence = fileDeclarExistence;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public void setUnsubscribedCategories(List<String> unsubscribedCategories) {
		this.unsubscribedCategories = unsubscribedCategories;
	}

	public void test() {

		System.out.println("Button Clicked !!");
	}

	public String getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public List<String> getCountries() {
		countries.add("Tunisienne");
		countries.add("Algerienne");
		countries.add("Marrocaine");

		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

}
