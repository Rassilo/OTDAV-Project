package Services.Depots;

import java.util.List;

import Entities.Deposant;
import Entities.Depot;
import Enums.DepotStatus;

public interface IDepotService {
	public void add(Depot d);
	public void remove(Depot d);
	public void update(Depot d);
	public Depot getId(int id);
	public List<Depot> getAll();
	public List<Depot> getAllByStatus(DepotStatus status);
}
