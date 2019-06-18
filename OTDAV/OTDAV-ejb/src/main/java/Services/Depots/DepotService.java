package Services.Depots;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Contrat;
import Entities.Deposant;
import Entities.Depot;
import Enums.ContratStatus;
import Enums.DepotStatus;

@Stateless
@LocalBean
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

	@Override
	public List<Depot> getAllByUser(Deposant deposant) {
	 	String sql = "From Depot d where d.deposant=:deposant";
	    TypedQuery<Depot> query=em.createQuery(sql,Depot.class);
	    query.setParameter("deposant",deposant);
	    try{
            return  query.getResultList();
        }catch(Exception ex){
            return  new ArrayList<>();
        }	
	}

	@Override
	public Contrat addC(Contrat c) {		
		em.persist(c);
		em.flush();
		return c;
	}

	@Override
	public void removeC(Contrat c) {
		em.remove(c);
	}

	@Override
	public void updateC(Contrat c) {
		em.merge(c);
	}

	@Override
	public Contrat getContratByDepot(Depot d) {
		String sql = "From Contrat c where c.depot=:depot";
	    TypedQuery<Contrat> query=em.createQuery(sql,Contrat.class);
	    query.setParameter("depot",d);
	    try{
            return  query.getSingleResult();
        }catch(Exception ex){
            return null;
        }		
	}

	@Override
	public List<Contrat> getAllContracts(ContratStatus cStatus,Depot d) {
		String sql = "";
		if(cStatus ==null & d == null)	
		  sql = "From Contrat c";
	    TypedQuery<Contrat> query=em.createQuery(sql,Contrat.class);
	    try{
            return  query.getResultList();
        }catch(Exception ex){
            return  new ArrayList<>();
        }	
	}
	
}
