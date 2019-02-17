package Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Adherent;
import Enumerations.EtatCompte;

/**
 * Session Bean implementation class AdherentImpl
 */
@Stateless
@LocalBean
public class AdherentImpl implements AdherentImplRemote, AdherentImplLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public AdherentImpl() {
		// TODO Auto-generated constructor stub
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	@Override
	public void addAdherent(Adherent a) {
		em.persist(a);

	}

	@Override
	public void demissioner(int id) {
		Adherent adherent = new Adherent();
		adherent = em.find(Adherent.class, id);
		adherent.setEtatCompte(EtatCompte.Demissione);
		adherent.setRaisonDemission("Démissioné a cause de .......");
		adherent.setDateDemission(new Date());
		System.out.println("Adhérent démissioné");

	}

	@Override
	public void subscribeToNewCategory(int id, String categorie) {
		Adherent adherent = new Adherent();
		adherent = em.find(Adherent.class, id);
		String subscribedCategories = adherent.getCategorieAbonnement();
		if (!subscribedCategories.contains(categorie)) {
			adherent.setCategorieAbonnement(subscribedCategories.concat("-" + categorie));
			em.merge(adherent);

		} else
			System.out.println("Already subscribed to this category= " + categorie);

	}

	@Override
	public Adherent getAdherentById(int id) {
		Adherent adh = new Adherent();

		adh = em.find(Adherent.class, id);

		return adh;
	}

	@Override
	public int getNumberOfDays(Date sysDate, Date lastDonDate) {
		int days = Math.abs(daysBetween(lastDonDate, sysDate));
		System.out.println("difference DATE ==>" + days);

		return days;
	}

	@Override
	public void updateAdherentApresDemission(Adherent adherent) {
		Adherent x = new Adherent();
		x = em.find(Adherent.class, adherent.getIdAdherent());
		em.merge(adherent);

	}

	@Override
	public Adherent login(String login, String password) {
		try {
			Query query = em.createQuery("select e from Adherent e where (e.cin=:l or e.email=:l) and e.motDePasse=:p");
			query.setParameter("l", login).setParameter("p", password);
			return (Adherent) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAllSubscribedCategory(Adherent adherent) {
		String subscribedCategories = adherent.getCategorieAbonnement();
		return subscribedCategories;
	}

	@Override
	public boolean isUniqueCinAndEmail(String cin, String email) {
		Query query = em.createQuery("select e from Adherent e where e.cin=:c or e.email=:l");
		query.setParameter("c", cin);
		query.setParameter("l", email);

		List<Adherent> results = new ArrayList<>();
		results = query.getResultList();
		if (results.isEmpty())
			return true;

		else if (results.size() != 0)
			return false;

		return false;
	}

	@Override
	public List<Adherent> getAllAdherent() {
		Query query = em.createQuery("select e from Adherent e");
		return query.getResultList();
	}

}
