package depotBeans;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import Entities.Depot;
import Entities.Contrat;
import Entities.Deposant;
import Enums.CategoryType;
import Enums.ContratStatus;
import Enums.DepotStatus;
import Services.Depots.IDeposantService;
import Services.Depots.IDepotService;

@ManagedBean
@SessionScoped
public class DepotBean {
		
	@EJB
	IDeposantService deposantService;
	@EJB
	IDepotService depotService;
	
	final String indexUrl = "/deposant/index.jsf?faces-redirect=true";
	private Depot depot;
	
	@PostConstruct
	public void init() {
		setDepot(new Depot());
	}
	
	public String goToDetail(Depot d) {
		depot = d;
		return "/deposant/depot/detail.jsf?faces-redirect=true";
	}
	
	public String gotoPay(Depot d) {
		depot = d;
		return "/deposant/depot/pay.jsf?faces-redirect=true";
	}
	
	public String payDepot(){
		
		Contrat c = new Contrat();
		c.setDepot(depot);
		c.setDateDebut(new Date());
		c.setPrice(100);
		c.setStatus(ContratStatus.paid);
		depotService.addC(c);
		depot.setStatus(DepotStatus.waitingConfirmation);
		depotService.update(depot);
		return "/deposant/depot/list.jsf?faces-redirect=true";

	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	
	
	
	
}
