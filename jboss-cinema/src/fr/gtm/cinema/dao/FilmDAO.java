package fr.gtm.cinema.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.cinema.entities.Film;

@Singleton
public class FilmDAO extends AbstractDAO<Film, Long> {
	@PersistenceContext(name="cinema") private EntityManager em;
	
	public FilmDAO() {
		super(Film.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Film> getAll(){
		return em.createNamedQuery("Film.all", Film.class)
					.getResultList();
	}
}
