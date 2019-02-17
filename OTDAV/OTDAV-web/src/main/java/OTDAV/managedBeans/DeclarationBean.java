package OTDAV.managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import Entities.*;
import Enumerations.EtatDeclaration;
import Services.DeclarationImplLocal;
import Utils.Routing;

@ManagedBean

public class DeclarationBean {

	@EJB
	private DeclarationImplLocal declarationImplLocal;

	// inject the AuthBean managedbean
	@ManagedProperty(value = "#{identity}")
	AuthBean authBean;
	private DecArtistique modelArtistique = new DecArtistique();
	private DecTheatre modelTheatre = new DecTheatre();
	private DecLiterature modelLiterature = new DecLiterature();
	private DecMusique modelMusique = new DecMusique();

	private DecArtistique declarationArtistique = new DecArtistique();
	private DecTheatre declarationTheatre = new DecTheatre();
	private DecLiterature declarationLiterature = new DecLiterature();
	private DecMusique declarationMusique = new DecMusique();

	private static List<Declaration> listeDeclarations = new ArrayList<>();
	private static List<Declaration> listeDeclarationsGroupedByMember = new ArrayList<>();

	// file ==> preuve
	private Part filePreuve;
	private Part fileFichier;

	public void uploadPreuve(String folderName) throws IOException {

		InputStream in = filePreuve.getInputStream();
		File f = new File(folderName + "\\" + filePreuve.getSubmittedFileName());
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

	public void uploadFichier(String folderName) throws IOException {
		InputStream in = fileFichier.getInputStream();
		File f = new File(folderName + "\\" + fileFichier.getSubmittedFileName());
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

	// ajout d'une déclaration artistique
	public void addDeclarationArtistique() throws IOException, InterruptedException {

		// Generate unique name
		String uniqeName = UUID.randomUUID().toString();

		declarationArtistique.setAuteur(modelArtistique.getAuteur());
		declarationArtistique.setDateDeclaration(new Date());
		declarationArtistique.setEtatDeclaration(EtatDeclaration.EnAttente);
		declarationArtistique
				.setFichier(authBean.getU().getCin() + "/" + uniqeName + "/" + fileFichier.getSubmittedFileName());
		declarationArtistique
				.setPreuve(authBean.getU().getCin() + "/" + uniqeName + "/" + filePreuve.getSubmittedFileName());
		declarationArtistique.setTitre(modelArtistique.getTitre());

		// get the current user
		declarationArtistique.setAdherent(authBean.getU());

		String folderName = Routing.server + authBean.getU().getCin() + "\\" + uniqeName;
		File dir = new File(folderName);
		dir.mkdir();

		// make a delay of 3 seconds to create the folder
		TimeUnit.SECONDS.sleep(3);

		uploadFichier(folderName);
		uploadPreuve(folderName);

		declarationImplLocal.addDeclaration(declarationArtistique);

	}

	// ajout d'une déclaration theatre
	public void addDeclarationTheatre() throws IOException, InterruptedException {
		// Generate unique name
		String uniqeName = UUID.randomUUID().toString();
		declarationTheatre.setAuteur(modelTheatre.getAuteur());
		declarationTheatre.setDateDeclaration(new Date());
		declarationTheatre.setEtatDeclaration(EtatDeclaration.EnAttente);
		declarationTheatre
				.setFichier(authBean.getU().getCin() + "/" + uniqeName + "/" + fileFichier.getSubmittedFileName());
		declarationTheatre
				.setPreuve(authBean.getU().getCin() + "/" + uniqeName + "/" + filePreuve.getSubmittedFileName());
		declarationTheatre.setTitre(modelTheatre.getTitre());

		// get the current user
		declarationTheatre.setAdherent(authBean.getU());

		// create a folder with the company's name
		String folderName = Routing.server + authBean.getU().getCin() + "\\" + uniqeName;
		File dir = new File(folderName);
		dir.mkdir();

		// make a delay of 3 seconds to create the folder
		TimeUnit.SECONDS.sleep(3);

		uploadFichier(folderName);
		uploadPreuve(folderName);

		declarationImplLocal.addDeclaration(declarationTheatre);

	}

	// ajout d'une déclaration literature
	public void addDeclarationLiterature() throws IOException, InterruptedException {
		// Generate unique name
		String uniqeName = UUID.randomUUID().toString();

		declarationLiterature.setAuteur(modelLiterature.getAuteur());
		declarationLiterature.setDateDeclaration(new Date());
		declarationLiterature.setEtatDeclaration(EtatDeclaration.EnAttente);
		declarationLiterature
				.setFichier(authBean.getU().getCin() + "/" + uniqeName + "/" + fileFichier.getSubmittedFileName());
		declarationLiterature
				.setPreuve(authBean.getU().getCin() + "/" + uniqeName + "/" + filePreuve.getSubmittedFileName());
		declarationLiterature.setTitre(modelLiterature.getTitre());

		// get the current user
		declarationLiterature.setAdherent(authBean.getU());

		// create a folder with the company's name
		String folderName = Routing.server + authBean.getU().getCin() + "\\" + uniqeName;
		File dir = new File(folderName);
		dir.mkdir();

		// make a delay of 3 seconds to create the folder
		TimeUnit.SECONDS.sleep(3);

		uploadFichier(folderName);
		uploadPreuve(folderName);

		declarationImplLocal.addDeclaration(declarationLiterature);

	}

	// ajout d'une déclaration musique
	public void addDeclarationMusique() throws IOException, InterruptedException {
		// Generate unique name
		String uniqeName = UUID.randomUUID().toString();

		declarationMusique.setAuteur(modelMusique.getAuteur());
		declarationMusique.setDateDeclaration(new Date());
		
		declarationMusique.setDescription(modelMusique.getDescription());
		
		declarationMusique.setEtatDeclaration(EtatDeclaration.EnAttente);
		declarationMusique
				.setFichier(authBean.getU().getCin() + "/" + uniqeName + "/" + fileFichier.getSubmittedFileName());
		declarationMusique
				.setPreuve(authBean.getU().getCin() + "/" + uniqeName + "/" + filePreuve.getSubmittedFileName());
		declarationMusique.setTitre(modelMusique.getTitre());
		declarationMusique.setCompositeur(modelMusique.getCompositeur());

		declarationMusique.setTypeDeclarationMusique(modelMusique.getTypeDeclarationMusique());

		System.out.println("@@ ===>" + modelMusique.getTypeDeclarationMusique());

		// get the current user
		
		
		declarationMusique.setAdherent(authBean.getU());

		// create a folder with the company's name
		String folderName = Routing.server + authBean.getU().getCin() + "\\" + uniqeName;
		File dir = new File(folderName);
		dir.mkdir();

		// make a delay of 3 seconds to create the folder
		TimeUnit.SECONDS.sleep(3);

		uploadFichier(folderName);
		uploadPreuve(folderName);

		declarationImplLocal.addDeclaration(declarationMusique);

	}

	public List<Declaration> getDeclarationGroupedByMember() {
		listeDeclarationsGroupedByMember = declarationImplLocal.getDeclarationGroupedByMember();
		System.out.println("list size =>" + listeDeclarationsGroupedByMember.size());
		for (Declaration item : listeDeclarationsGroupedByMember) {

			System.out.println("new PATH ==> " + item.getFichier());
		}

		return listeDeclarationsGroupedByMember;
	}

	public List<Declaration> getDeclarationByMember() {
		listeDeclarations = declarationImplLocal.getDeclarationByAdherent(authBean.getU().getIdAdherent());

		return listeDeclarations;
	}

	public DecArtistique getDeclarationArtistique() {
		return declarationArtistique;
	}

	public void setDeclarationArtistique(DecArtistique declarationArtistique) {
		this.declarationArtistique = declarationArtistique;
	}

	public DecTheatre getDeclarationTheatre() {
		return declarationTheatre;
	}

	public void setDeclarationTheatre(DecTheatre declarationTheatre) {
		this.declarationTheatre = declarationTheatre;
	}

	public DecLiterature getDeclarationLiterature() {
		return declarationLiterature;
	}

	public void setDeclarationLiterature(DecLiterature declarationLiterature) {
		this.declarationLiterature = declarationLiterature;
	}

	public DecMusique getDeclarationMusique() {
		return declarationMusique;
	}

	public void setDeclarationMusique(DecMusique declarationMusique) {
		this.declarationMusique = declarationMusique;
	}

	public DecArtistique getModelArtistique() {
		return modelArtistique;
	}

	public void setModelArtistique(DecArtistique modelArtistique) {
		this.modelArtistique = modelArtistique;
	}

	public DecTheatre getModelTheatre() {
		return modelTheatre;
	}

	public void setModelTheatre(DecTheatre modelTheatre) {
		this.modelTheatre = modelTheatre;
	}

	public DecLiterature getModelLiterature() {
		return modelLiterature;
	}

	public void setModelLiterature(DecLiterature modelLiterature) {
		this.modelLiterature = modelLiterature;
	}

	public DecMusique getModelMusique() {
		return modelMusique;
	}

	public void setModelMusique(DecMusique modelMusique) {
		this.modelMusique = modelMusique;
	}

	public static List<Declaration> getListeDeclarations() {
		return listeDeclarations;
	}

	public static void setListeDeclarations(List<Declaration> listeDeclarations) {
		DeclarationBean.listeDeclarations = listeDeclarations;
	}

	public static List<Declaration> getListeDeclarationsGroupedByMember() {
		return listeDeclarationsGroupedByMember;
	}

	public static void setListeDeclarationsGroupedByMember(List<Declaration> listeDeclarationsGroupedByMember) {
		DeclarationBean.listeDeclarationsGroupedByMember = listeDeclarationsGroupedByMember;
	}

	public Part getFilePreuve() {
		return filePreuve;
	}

	public void setFilePreuve(Part filePreuve) {
		this.filePreuve = filePreuve;
	}

	public Part getFileFichier() {
		return fileFichier;
	}

	public void setFileFichier(Part fileFichier) {
		this.fileFichier = fileFichier;
	}

	public AuthBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	public String redirectToUserListDeclarations() {
		return "ListDeclarations?faces-redirect=true";
	}

	public String redirectToCategoryAddition() {
		return "SubscribeToCategory?faces-redirect=true";
	}

	public String redirectToAddDeclarationMusique() {
		return "AddDeclarationMusique?faces-redirect=true";
	}

	public String redirectToAddDeclarationTheatre() {
		return "AddDeclarationTheatre?faces-redirect=true";
	}

	public String redirectToAddDeclarationLiterature() {
		return "AddDeclarationLiterature?faces-redirect=true";
	}

	public String redirectToAddDeclarationArtistique() {
		return "AddDeclarationArtistique?faces-redirect=true";
	}

}
