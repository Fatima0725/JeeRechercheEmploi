package com.isi.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;

import com.groupeisi.securityweb.entities.Droit;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity
public class Offre implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titrePoste;
	private String description;
	private LocalDateTime datePublication;
	private String postuler;
	@ManyToMany(mappedBy = "offres")
    private List<CategorieEmploi> categories;

	
	  public Offre(String titrePoste, String description, LocalDateTime datePublication, String postuler,
			List<CategorieEmploi> categories) {
		super();
		this.titrePoste = titrePoste;
		this.description = description;
		this.datePublication = datePublication;
		this.postuler = postuler;
		this.categories = categories;
	}

	
	 
	public List<CategorieEmploi> getCategories() {
		return categories;
	}
	public void setCategories(List<CategorieEmploi> categories) {
		this.categories = categories;
	}

	private static final long serialVersionUID = 1L;

	public Offre() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getTitrePoste() {
		return this.titrePoste;
	}

	public void setTitrePoste(String titrePoste) {
		this.titrePoste = titrePoste;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public LocalDateTime getDatePublication() {
		return this.datePublication;
	}

	public void setDatePublication(LocalDateTime datePublication) {
		this.datePublication = datePublication;
	}
	public Offre(String titrePoste, String description, List<CategorieEmploi> categories) {
		super();
		this.titrePoste = titrePoste;
		this.description = description;
		this.categories = categories;
	}

	public String getPostuler() {
		return postuler;
	}

	public void setPostuler(String postuler) {
		this.postuler = postuler;
	}
	
   
}
