package Services.Depots;

import java.util.List;

import javax.ejb.Remote;

import Entities.Contrat;
import Entities.Deposant;
import Entities.Depot;
import Enums.ContratStatus;
import Enums.DepotStatus;
@Remote
public interface IDepotService {
	public void add(Depot d);
	public void remove(Depot d);
	public void update(Depot d);
	public Depot getId(int id);
	public List<Depot> getAll();
	public List<Depot> getAllByUser(Deposant deposant);
	public List<Depot> getAllByStatus(DepotStatus status);
	
	public Contrat addC(Contrat c);
	public void removeC(Contrat c);
	public void updateC(Contrat c);
	public Contrat getContratByDepot(Depot d);
	public List<Contrat> getAllContracts(ContratStatus cStatus,Depot d);
}
