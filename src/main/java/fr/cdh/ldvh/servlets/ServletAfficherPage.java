package fr.cdh.ldvh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cdh.ldvh.bll.BLLException;
import fr.cdh.ldvh.bll.PageManager;
import fr.cdh.ldvh.bo.Aventurier;
import fr.cdh.ldvh.bo.Objet;
import fr.cdh.ldvh.bo.Page;
import fr.cdh.ldvh.dal.DALException;

/**
 * Servlet implementation class ServletAfficherPage
 */
@WebServlet("/AfficherPage")
public class ServletAfficherPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int numPage = Integer.parseInt(request.getParameter("destination"));
		Page prochaine = new Page();
		Aventurier heros = (Aventurier)session.getAttribute("heros");
		
		
		try {
			PageManager pageManager = new PageManager();
			prochaine = pageManager.getPageDAO().selectById(numPage);
			
			pageManager.ajouterDestinationDAO(prochaine);
			pageManager.ajouterCreaturesDAO(prochaine);
			pageManager.ajouterObjetsDAO(prochaine);
			System.out.println(prochaine.getObjets());
			for (Objet o : prochaine.getObjets()) {
				heros.ajouterObjet(o);
			}
			prochaine.ajouterAventurier(heros);
			session.setAttribute("page", prochaine);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur bll");
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur dal");
			e.printStackTrace();
		}
		
		
		session.setAttribute("currentPage", prochaine);
		RequestDispatcher rd = request.getRequestDispatcher("Livre");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
