package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.Adherent;

@Remote
public interface AdherentImplRemote {
	public void addAdherent(Adherent a);

	public void demissioner(int id);

	public void subscribeToNewCategory(int id, String categorie);

	public Adherent getAdherentById(int id);

	public int getNumberOfDays(Date sysDate, Date lastDonDate);

	public void updateAdherentApresDemission(Adherent adherent);

	public Adherent login(String login, String password);

	public String getAllSubscribedCategory(Adherent adherent);

	public boolean isUniqueCinAndEmail(String cin, String email);

	public List<Adherent> getAllAdherent();
}
