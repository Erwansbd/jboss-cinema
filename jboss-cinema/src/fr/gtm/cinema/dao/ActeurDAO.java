package fr.gtm.cinema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.cinema.entities.Acteur;

public class ActeurDAO {
	@PersistenceContext(name="cinema") private EntityManager em;
	
	public List<Acteur> getAll(){
		return em.createNamedQuery("Acteur.all", Acteur.class)
					.getResultList();
	}
}
