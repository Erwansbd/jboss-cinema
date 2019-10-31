package fr.gtm.cinema.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import fr.gtm.cinema.dao.FilmDAO;
import fr.gtm.cinema.dao.FilmDTO;
import fr.gtm.cinema.entities.Film;

@Singleton
public class FilmService {
	@EJB private FilmDAO dao;
	
	public List<Film> getAllFilms() {
		return dao.getAll();
	}
	
	public List<FilmDTO> getAllFilmsDTO() {
		List<FilmDTO> filmsdto = new ArrayList<FilmDTO>();
		List<Film> films = dao.getAll();
		for(Film film : films) {
			filmsdto.add(new FilmDTO(film));
		}
		return filmsdto;
	}
	
	public Film findById(long id) {
		return dao.findById(id);
	}

}
