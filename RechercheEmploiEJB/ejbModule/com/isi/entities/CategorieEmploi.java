package com.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.securityweb.entities.Comptes;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Entity implementation class for Entity: CategorieEmploi
 *
 */
@Entity
@Table(name = "categorie_emploi")
public class CategorieEmploi implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;
    
    @ManyToMany
    @JoinTable(
        name = "category_offre",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "offre_id"))
    private List<Offre> offres;
	
	 


	public CategorieEmploi(String nom, List<Offre> offres) {
		super();
		this.nom = nom;
		this.offres = offres;
	}



	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "offre_emploi_categorie_emploi", joinColumns
	 * = @JoinColumn(name = "categorie_emploi_id"), inverseJoinColumns
	 * = @JoinColumn(name = "offre_emploi_id")) private List<OffreEmploi>
	 * offresEmploi;
	 */
	



	public List<Offre> getOffres() {
		return offres;
	}


	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}


	public CategorieEmploi() {
		super();
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	/*
	 * public List<OffreEmploi> getOffresEmploi() { return offresEmploi; }
	 * 
	 * 
	 * public void setOffresEmploi(List<OffreEmploi> offresEmploi) {
	 * this.offresEmploi = offresEmploi; }
	 * 
	 * 
	 * public CategorieEmploi(String nom, List<OffreEmploi> offresEmploi) { super();
	 * this.nom = nom; this.offresEmploi = offresEmploi; }
	 */


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
   
}
