package depotBeans;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Entities.Depot;
import Entities.Deposant;
import Enums.CategoryType;
import Enums.DepotStatus;
import Services.Depots.IDeposantService;
import Services.Depots.IDepotService;

@ManagedBean
@RequestScoped
public class DepotProfileBean {
		
	@EJB
	IDeposantService deposantService;
	@EJB
	IDepotService depotService;
	
	final String indexUrl = "/deposant/index.jsf?faces-redirect=true";
	private Depot depot;
	
	@PostConstruct
	public void init() {
		depot = new Depot();
	}
	
	public String addDepotRequest() {
		depot.setDeposant(getCurrentUser());
		depot.setStatus(DepotStatus.waiting);
		depotService.add(depot);
		return indexUrl;
	}
	
	public List<Depot> getDepots(){
		return depotService.getAllByUser(getCurrentUser());
	}
	
	public Deposant getCurrentUser() {
		return deposantService.getByCin(SessionBean.getCurrentDeposant().getCin());
	}
	
	public boolean isEnabled() {
		return getCurrentUser().isEnabled();
	}
	
	public CategoryType[] getCategories() {
		return CategoryType.values();
	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	
	
}
