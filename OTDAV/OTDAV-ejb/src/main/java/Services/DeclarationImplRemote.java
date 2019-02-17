package Services;

import java.util.List;

import javax.ejb.Remote;

import Entities.Declaration;

@Remote
public interface DeclarationImplRemote {
	public void addDeclaration(Declaration d);
	public List<Declaration> getDeclarationByAdherent(int id);
	public void revokeDeclaration(int idDeclaration);
	public List<Declaration> getDeclarationGroupedByMember();
}
