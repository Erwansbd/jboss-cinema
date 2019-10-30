package fr.gtm.cinema.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.cinema.entities.Film;
import fr.gtm.cinema.service.FilmService;

/**
 * Servlet implementation class AfficherFilmServlet
 */
@WebServlet("/AfficherFilmServlet")
public class AfficherFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private FilmService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "";
		List<Film> films = service.getAllFilms();
		request.setAttribute("films", films);
		page = "/show-films.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
