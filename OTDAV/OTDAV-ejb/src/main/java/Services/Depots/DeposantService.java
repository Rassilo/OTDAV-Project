package Services.Depots;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Deposant;
import Entities.Depot;
import Entities.Fichier;


@Stateless
@LocalBean
public class DeposantService implements IDeposantService{

    @PersistenceContext
    public EntityManager em;
	
	@Override
	public Deposant add(Deposant d) {
		// TODO Auto-generated method stub
		em.persist(d);
		em.flush();
		return d;
	}

	@Override
	public void remove(Deposant d) {
		// TODO Auto-generated method stub
		em.remove(d);
	}

	@Override
	public void update(Deposant d) {
		// TODO Auto-generated method stub
		em.merge(d);
	}

	@Override
	public Deposant getId(int id) {
		// TODO Auto-generated method stub
		return em.find(Deposant.class,id);
	}

	@Override
	public Deposant getByDepot(Depot d) {
		 TypedQuery<Deposant> query=em.createQuery("select d from Deposant d where d.depot=:depot ",Deposant.class);
	     query.setParameter("depot",d);
	     return  query.getSingleResult();
	}

	@Override
	public List<Deposant> getAll(Deposant d) {
	String sql = "From Deposant d ";
	   TypedQuery<Deposant> query=em.createQuery(sql,Deposant.class);
	   try{
	        return  query.getResultList();
	   }catch(Exception ex){
	        return  new ArrayList<>();
	   }	
	}
	
	
	@Override
	public List<Deposant> getAllBy(String word,String field) {
	   String sql = "From Deposant d where d."+field+" like '%"+word+"%'";
	   System.out.println("---------------- sql => " +sql);
	   TypedQuery<Deposant> query=em.createQuery(sql,Deposant.class);
	   try{
	        return  query.getResultList();
	   }catch(Exception ex){
	        return  new ArrayList<>();
	   }	
	}

	@Override
	public Deposant getByCin(String cin) {
		 TypedQuery<Deposant> query=em.createQuery("select d from Deposant d where d.cin=:cin ",Deposant.class);
	     query.setParameter("cin",cin);
	     try {
		     return  query.getSingleResult();
		   }catch(Exception ex){
			   return null;
		   }
	}

	@Override
	public void addF(Fichier f) {
		em.persist(f);
	}

	@Override
	public void removeF(Fichier f) {
		em.remove(f);
	}

	@Override
	public void updateF(Fichier f) {
		em.merge(f);
	}

	@Override
	public List<Fichier> getAllF() {
		 TypedQuery<Fichier> query=em.createQuery("select f from Fichier ",Fichier.class);
	     try {
		     return  query.getResultList();
		   }catch(Exception ex){
			   return new ArrayList<>();
		   }
	}

	@Override
	public List<Fichier> getAllFileByDeposant(Deposant d) {
		 TypedQuery<Fichier> query=em.createQuery("select f from Fichier f where f.deposant=:deposant ",Fichier.class);
	     query.setParameter("deposant",d);

		 try {
		     return  query.getResultList();
		   }catch(Exception ex){
			   return new ArrayList<>();
		   }	}

}
