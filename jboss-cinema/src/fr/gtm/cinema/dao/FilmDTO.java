package fr.gtm.cinema.dao;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import fr.gtm.cinema.entities.Film;

public class FilmDTO implements Serializable{
	

	private long id;
	private String titre;
	private String realisateur;
	private LocalDate dateSortie;
	private int duree;	// durée en minutes;
	private double prixHT;
	
	public FilmDTO() {
		
	}
	
	public FilmDTO(Film film) {
		id = film.getId();
		titre = film.getTitre();
		realisateur = film.getRealisateur();
		dateSortie = film.getDateSortie();
		duree = film.getDuree();
		prixHT = film.getPrixHT();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
}
