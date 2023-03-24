package fr.cdh.ldvh.dal.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.cdh.ldvh.bo.Attaque;
import fr.cdh.ldvh.bo.Benefique;
import fr.cdh.ldvh.bo.Creature;
import fr.cdh.ldvh.bo.Defense;
import fr.cdh.ldvh.bo.Malefique;
import fr.cdh.ldvh.bo.Medecine;
import fr.cdh.ldvh.bo.Objet;
import fr.cdh.ldvh.bo.Page;
import fr.cdh.ldvh.bo.Tresor;
import fr.cdh.ldvh.dal.ConnectionProvider;
import fr.cdh.ldvh.dal.DALException;
import fr.cdh.ldvh.dal.PageDAO;

public class PageDAOMySQL implements PageDAO {

	private static final String SQL_GET_DESTINATION = "SELECT * FROM page INNER JOIN jointure_page_page WHERE pageDestination = pageId AND pageDepart = ?";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM page WHERE pageId = ?";
	private static final String SQL_GET_CREATURE = "SELECT * FROM creature INNER JOIN jointure_page_creatures WHERE creature = creatureId AND page = ?";
	private static final String SQL_GET_OBJETS = "SELECT * FROM objet INNER JOIN jointure_page_objets WHERE objet = objetId AND page = ?";

	@Override
	public void ajouterDestinationDAO(Page currentPage) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SQL_GET_DESTINATION);
			rqt.setInt(1, currentPage.getNumPage());
			rs = rqt.executeQuery();
			while (rs.next()) {
				Page destination = new Page(rs.getInt("pageId"), rs.getString("texte"), rs.getBoolean("finHistoire"));
				currentPage.ajouterDestination(destination);
			}
		} catch (SQLException e) {
			throw new DALException("Ajouter destination failed", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Page selectById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Page p = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				p = new Page(rs.getInt("pageId"), rs.getString("texte"), rs.getBoolean("finHistoire"));
			}
		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + id, e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	@Override
	public Creature getCreature(int page) throws DALException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Creature c = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SQL_GET_CREATURE);
			rqt.setInt(1, page);
			rs = rqt.executeQuery();

			if (rs.next()) {
				if (rs.getString("creatureType") == "MAL") {
					c = new Malefique(rs.getString("creatureNom"), rs.getString("creatureDescription"),
							rs.getInt("malPointsDeVie"), rs.getInt("malPointsAttaque"), rs.getInt("malPointsDefense"));
				} else {
					c = new Benefique(rs.getString("creatureNom"), rs.getString("creatureDescription"),
							rs.getString("benEnigme"));
				}
			}

		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'import des creatures", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	@Override
	public void ajouterCreaturesDAO(Page page) throws DALException {
			
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Creature c = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SQL_GET_CREATURE);
			rqt.setInt(1, page.getNumPage());
			rs = rqt.executeQuery();

			while (rs.next()) {
				if (rs.getString("creatureType").equals("MAL")) {
					c = new Malefique(rs.getString("creatureNom"), rs.getString("creatureDescription"),
							rs.getInt("malPointsDeVie"), rs.getInt("malPointsAttaque"), rs.getInt("malPointsDefense"));
					page.ajouterCreature(c);
				} else if (rs.getString("creatureType").equals("BEN")) {
					c = new Benefique(rs.getString("creatureNom"), rs.getString("creatureDescription"),
							rs.getString("benEnigme"));
					page.ajouterCreature(c);
				}
			}

		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'import des creatures", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void ajouterObjetsDAO(Page page) throws DALException {
			
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Objet o = null;
		try {
			cnx = ConnectionProvider.getConnection();
			rqt = cnx.prepareStatement(SQL_GET_OBJETS);
			rqt.setInt(1, page.getNumPage());
			rs = rqt.executeQuery();

			while (rs.next()) {
				if (rs.getString("objetType").equals("FO")) {
					o = new Attaque(rs.getString("objetNom"), rs.getString("objetDescription"),
							rs.getInt("objetAttaque"));
					page.ajouterObjet(o);
				} else if (rs.getString("objetType").equals("ME")) {
					o = new Medecine(rs.getString("objetNom"), rs.getString("objetDescription"),
							rs.getInt("objetMedecine"));
					page.ajouterObjet(o);
				} else if (rs.getString("objetType").equals("DE")) {
					o = new Defense(rs.getString("objetNom"), rs.getString("objetDescription"),
							rs.getInt("objetDefense"));
					page.ajouterObjet(o);
				} else if (rs.getString("objetType").equals("TR")) {
					o = new Tresor(rs.getString("objetNom"), rs.getString("objetDescription"),
							rs.getInt("objetTresor"));
					page.ajouterObjet(o);
				}
			}

		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'import des objets", e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(page.getObjets());
	}

}