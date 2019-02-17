package Services.Depots;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Deposant;
import Entities.Depot;
import Enums.DepotStatus;

public class DepotService implements IDepotService{

    @PersistenceContext
    public EntityManager em;

	@Override
	public void add(Depot d) {
		em.persist(d);
	}

	@Override
	public void remove(Depot d) {
		em.remove(d);		
	}

	@Override
	public void update(Depot d) {
		em.merge(d);		
	}

	@Override
	public Depot getId(int id) {
		return em.find(Depot.class,id);	
	}

	@Override
	public List<Depot> getAll() {
	    String sql = "From Depot d ";
	    TypedQuery<Depot> query=em.createQuery(sql,Depot.class);
	    try{
            return  query.getResultList();
        }catch(Exception ex){
            return  new ArrayList<>();
        }	
	}

	@Override
	public List<Depot> getAllByStatus(DepotStatus status) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
