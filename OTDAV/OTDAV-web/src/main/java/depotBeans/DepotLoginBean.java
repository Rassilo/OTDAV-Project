package depotBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Entities.Deposant;
import Entities.Fichier;
import Enums.FichierType;
import Services.Depots.IDeposantService;

@ManagedBean
@RequestScoped
public class DepotLoginBean {
		
	@EJB
	IDeposantService deposantService;
	
	private String cin;
	private String password;
	private String date;
	private Deposant deposant=new Deposant();
	private String passwordConfirm;
	
	private Part uploadedFileCin;
	private Part uploadedFileFiscale;
	private Part uploadedFileExistance;
	private Part uploadedFileDeclaration;
	private Part uploadedFileCommerce;
	private Part uploadedFileStatut;
	private Part uploadedFileJort;
	private List<Part> parts;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @PostConstruct
    public void init() {
    	
    	parts = new ArrayList();
    }

	public String goToLogin() {
		return "/deposant/login.jsf?faces-redirect=true";
	}
	
	public String doConnect() {
		Deposant deposant=  deposantService.getByCin(cin);
		if(deposant != null) {
			if(passwordEncoder.matches(password, deposant.getPassword())) {
				SessionBean.setCurrentDeposant(deposant);
				return "/deposant/profile/index.jsf?faces-redirect=true";
			}
		}
		
	    FacesMessage fm = new FacesMessage("Mot de passe et/ou cin est incorrect", "ERROR 403");
        fm.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/deposant/login.jsf";
	}
	
	
	public String goRegisterMorale(){
		return "/deposant/registerMorale.jsf?faces-redirect=true";
	}
	
	public String goRegister(){
		return "/deposant/register.jsf?faces-redirect=true";
	}
	
	public String doRegister() {
		
		if(uploadedFileCin == null) {
			return registerError("register","Doit contenir piece identité");
		}
		
		if(deposant.getCin().equals(""))
			return registerError("register","Doit contenir piece identité");

        if(passwordConfirm.equals(deposant.getPassword())){
        	if(deposantService.getByCin(deposant.getCin())!=null) {
    			return registerError("register","Numéro cin déja exsite");
        	}
        	deposant.setPassword(passwordEncoder.encode(passwordConfirm));
        	deposant.setEnabled(false);
		    Deposant d = deposantService.add(deposant);
		    Fichier fichier = new Fichier();
		    String name = UploadUtils.uploadFile(deposant, uploadedFileCin);
		    fichier.setDeposant(d);
		    fichier.setName(name);
		    fichier.setPath(deposant.getCin()+"/"+name);
		    fichier.setType(FichierType.cin);
		    deposantService.addF(fichier);
		    deposant = new Deposant();
	        return "/deposant/login.jsf?faces-redirect=true";
		}
		
		return registerError("register","doit remplir tout les champs");

	}
	
	public String doRegisterMorale() {
		
		if(uploadedFileCin == null) {
			return registerError("register","Doit contenir piece ");
		}
		
		if(deposant.getCin().equals(""))
			return registerError("register","Doit contenir piece identité");

        if(passwordConfirm.equals(deposant.getPassword())){
        	if(deposantService.getByCin(deposant.getCin())!=null) {
    			return registerError("register","Numéro cin déja exsite");
        	}
        	deposant.setPassword(passwordEncoder.encode(passwordConfirm));;
        	deposant.setEnabled(false);
		    Deposant d = deposantService.add(deposant);
		    uploadAndPersistFile(d, uploadedFileCin,FichierType.cin);
		    uploadAndPersistFile(d, uploadedFileCommerce,FichierType.registreCommerce);
		    uploadAndPersistFile(d, uploadedFileDeclaration,FichierType.declaration);
		    uploadAndPersistFile(d, uploadedFileFiscale,FichierType.matriculeFiscale);
		    uploadAndPersistFile(d, uploadedFileExistance,FichierType.existance);
		    uploadAndPersistFile(d, uploadedFileJort,FichierType.jort);
		    uploadAndPersistFile(d, uploadedFileStatut,FichierType.statut);
		    deposant = new Deposant();
	        return "/deposant/login.jsf?faces-redirect=true";
		}
		
		return registerError("register","doit remplir tout les champs");
	}
	
	public void uploadAndPersistFile(Deposant dep, Part file, FichierType type) {
		    Fichier fichier = new Fichier();
		    String name = UploadUtils.uploadFile(dep, file);
		    fichier.setDeposant(dep);
		    fichier.setName(name);
		    fichier.setDate(new Date());
		    fichier.setType(type);
		    fichier.setPath(dep.getCin()+"/"+name);    
		    deposantService.addF(fichier);
	}

	
	public String registerError(String page,String message) {
		    FacesMessage fm = new FacesMessage(message, "ERROR 403");
	        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage(null, fm);
	        return "/deposant/"+page+".jsf";
	}
	
	
	
	public String getCin() {	 
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Deposant getDeposant() {
		return deposant;
	}

	public void setDeposant(Deposant deposant) {
		this.deposant = deposant;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Part getUploadedFileCin() {
		return uploadedFileCin;
	}

	public void setUploadedFileCin(Part uploadedFile) {
		this.uploadedFileCin = uploadedFile;
	}

	public Part getUploadedFileFiscale() {
		return uploadedFileFiscale;
	}

	public void setUploadedFileFiscale(Part uploadedFileFiscale) {
		this.uploadedFileFiscale = uploadedFileFiscale;
	}

	public Part getUploadedFileExistance() {
		return uploadedFileExistance;
	}

	public void setUploadedFileExistance(Part uploadedFileExistance) {
		this.uploadedFileExistance = uploadedFileExistance;
	}

	public Part getUploadedFileDeclaration() {
		return uploadedFileDeclaration;
	}

	public void setUploadedFileDeclaration(Part uploadedFileDeclaration) {
		this.uploadedFileDeclaration = uploadedFileDeclaration;
	}

	public Part getUploadedFileCommerce() {
		return uploadedFileCommerce;
	}

	public void setUploadedFileCommerce(Part uploadedFileCommerce) {
		this.uploadedFileCommerce = uploadedFileCommerce;
	}

	public Part getUploadedFileStatut() {
		return uploadedFileStatut;
	}

	public void setUploadedFileStatut(Part uploadedFileStatut) {
		this.uploadedFileStatut = uploadedFileStatut;
	}

	public Part getUploadedFileJort() {
		return uploadedFileJort;
	}

	public void setUploadedFileJort(Part uploadedFileJort) {
		this.uploadedFileJort = uploadedFileJort;
	}
	
	
	
}
