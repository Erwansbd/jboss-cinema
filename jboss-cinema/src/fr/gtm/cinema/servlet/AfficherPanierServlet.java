package fr.gtm.cinema.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.cinema.dao.FilmDTO;
import fr.gtm.cinema.entities.Panier;

/**
 * Servlet implementation class AfficherPanierServlet
 */
@WebServlet("/AfficherPanierServlet")
public class AfficherPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private Panier panier;
	public static final Logger tchikita = Logger.getLogger("Cinema");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/show-panier.jsp";
		List<FilmDTO> filmsdto = panier.getFilmsdto();
		int cpt = panier.getSize();
		panier.PrixTotalTTC(filmsdto);
		double prix = panier.getPrixTotalTTC();
		request.setAttribute("films", filmsdto);
		request.setAttribute("cpt", cpt);
		request.setAttribute("prix", prix);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		tchikita.info("La taille du panier est de : "+panier.getSize());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
