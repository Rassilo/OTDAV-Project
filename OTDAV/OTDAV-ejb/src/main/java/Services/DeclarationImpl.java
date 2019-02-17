package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Adherent;
import Entities.Declaration;
import Enumerations.EtatDeclaration;

/**
 * Session Bean implementation class DeclarationImpl
 */
@Stateless
@LocalBean
public class DeclarationImpl implements DeclarationImplRemote, DeclarationImplLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public DeclarationImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDeclaration(Declaration d) {
		em.persist(d);

	}

	@Override
	public List<Declaration> getDeclarationByAdherent(int id) {
		Query jpql = em.createQuery("select d from Declaration d where d.adherent=:l");

		jpql.setParameter("l", em.find(Adherent.class, id));
		return jpql.getResultList();
	}

	@Override
	public void revokeDeclaration(int idDeclaration) {
		Declaration dec = new Declaration();
		dec = em.find(Declaration.class, idDeclaration);
		dec.setEtatDeclaration(EtatDeclaration.Revoque);
		em.merge(dec);
		System.out.println("Declaration no " + idDeclaration + " revoked and merged ! ");

	}

	@Override
	public List<Declaration> getDeclarationGroupedByMember() {
		Query jpql = em.createQuery("select d from Declaration d");

		return jpql.getResultList();
	}

}
