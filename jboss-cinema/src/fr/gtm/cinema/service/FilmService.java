package fr.gtm.cinema.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import fr.gtm.cinema.dao.FilmDAO;
import fr.gtm.cinema.entities.Film;

@Singleton
public class FilmService {
	@EJB private FilmDAO dao;
	
	public List<Film> getAllFilms() {
		return dao.getAll();
	}
}
