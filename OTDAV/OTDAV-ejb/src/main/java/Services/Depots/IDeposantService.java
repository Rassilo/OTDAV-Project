package Services.Depots;

import java.util.List;

import javax.ejb.Remote;

import Entities.Deposant;
import Entities.Depot;
import Entities.Fichier;

@Remote
public interface IDeposantService {
	public Deposant add(Deposant d);
	public void remove(Deposant d);
	public void update(Deposant d);
	public Deposant getId(int id);
	public Deposant getByDepot(Depot d);
	public Deposant getByCin(String cin);
	public List<Deposant> getAll(Deposant d);
	public List<Deposant> getAllBy(String word,String field);
	
	
	// files 
	public void addF(Fichier f);
	public void removeF(Fichier f);
	public void updateF(Fichier f);
	public List<Fichier> getAllF();
	public List<Fichier> getAllFileByDeposant(Deposant d);


}
