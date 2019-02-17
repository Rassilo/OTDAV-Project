package Services;

import java.util.List;

import javax.ejb.Local;

import Entities.Declaration;
@Local
public interface DeclarationImplLocal {
	public void addDeclaration(Declaration d);
	public List<Declaration> getDeclarationByAdherent(int id);
	public void revokeDeclaration(int idDeclaration);
	public List<Declaration> getDeclarationGroupedByMember() ;
}
