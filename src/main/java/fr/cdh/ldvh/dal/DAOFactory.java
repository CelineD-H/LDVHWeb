package fr.cdh.ldvh.dal;

import fr.cdh.ldvh.dal.mysql.AventurierDAOMySQL;
import fr.cdh.ldvh.dal.mysql.CreatureDAOMySQL;
import fr.cdh.ldvh.dal.mysql.ObjetDAOMySQL;
import fr.cdh.ldvh.dal.mysql.PageDAOMySQL;

public abstract class DAOFactory {

	public static CreatureDAO creatureDAO;
	public static ObjetDAO objetDAO;
	public static PageDAO pageDAO;
	public static AventurierDAO aventurierDAO;
	
	public static CreatureDAO getCreatureDAO() {
		if (creatureDAO == null) {
			creatureDAO = new CreatureDAOMySQL();
		}
		return creatureDAO;
	}
	
	public static ObjetDAO getObjetDAO() {
		if (objetDAO == null) {
			objetDAO = new ObjetDAOMySQL();
		}
		return objetDAO;
	}
	
	public static PageDAO getPageDAO() {
		if (pageDAO == null) {
			pageDAO = new PageDAOMySQL();
		}
		return pageDAO;
	}
	
	public static AventurierDAO getAventurierDAO() {
		if (aventurierDAO == null) {
			aventurierDAO = new AventurierDAOMySQL();
		}
		return aventurierDAO;
	}
}
