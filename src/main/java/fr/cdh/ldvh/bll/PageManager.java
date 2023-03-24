package fr.cdh.ldvh.bll;

import fr.cdh.ldvh.bo.Page;
import fr.cdh.ldvh.dal.DALException;
import fr.cdh.ldvh.dal.DAOFactory;
import fr.cdh.ldvh.dal.PageDAO;

public class PageManager {

	private PageDAO pageDAO;

	public PageManager() throws BLLException {
		pageDAO = DAOFactory.getPageDAO();
	}

	public PageDAO getPageDAO() {
		return pageDAO;
	}
	
	public void ajouterDestinationDAO(Page currentPage) {
		try {
			pageDAO.ajouterDestinationDAO(currentPage);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ajouterCreaturesDAO(Page currentPage) {
		try {
			pageDAO.ajouterCreaturesDAO(currentPage);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ajouterObjetsDAO(Page currentPage) {
		try {
			pageDAO.ajouterObjetsDAO(currentPage);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


