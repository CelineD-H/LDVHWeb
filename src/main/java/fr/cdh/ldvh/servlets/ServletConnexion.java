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
import fr.cdh.ldvh.bo.Page;
import fr.cdh.ldvh.dal.DALException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pseudo = request.getParameter("pseudo");
		Aventurier heros = new Aventurier(pseudo);
		
		HttpSession session = request.getSession();
		session.setAttribute("heros", heros);
		
		try {
			PageManager pageManager = new PageManager();
			Page pageDepart = pageManager.getPageDAO().selectById(1);
			pageDepart.ajouterAventurier(heros);
			pageManager.ajouterDestinationDAO(pageDepart);
			session.setAttribute("page", pageDepart);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur bll");
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur dal");
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Livre");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
