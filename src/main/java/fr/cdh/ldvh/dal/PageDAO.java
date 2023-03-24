package fr.cdh.ldvh.dal;

import fr.cdh.ldvh.bo.Creature;
import fr.cdh.ldvh.bo.Page;

public interface PageDAO {
	
	public void ajouterDestinationDAO(Page currentPage) throws DALException;

	public Page selectById(int id) throws DALException;
	public Creature getCreature(int page) throws DALException;

	void ajouterCreaturesDAO(Page page) throws DALException;

	void ajouterObjetsDAO(Page page) throws DALException;
}
