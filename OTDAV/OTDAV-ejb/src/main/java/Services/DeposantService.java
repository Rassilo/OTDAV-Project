package Services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Deposant;

public class DeposantService implements IDeposantService{

    @PersistenceContext
    public EntityManager em;
	
	@Override
	public void add(Deposant d) {
		// TODO Auto-generated method stub
		em.persist(d);
	}

}
