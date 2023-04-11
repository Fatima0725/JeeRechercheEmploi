package com.isi.dao;

import java.util.List;

import com.isi.entities.CategorieEmploi;
import com.isi.entities.Offre;

import jakarta.ejb.Local;

@Local
public interface OffreLocal {
	public CategorieEmploi addCategory(CategorieEmploi categorie_emploi);
	public CategorieEmploi getCategorie(Long id);
	public List<CategorieEmploi> listCategories();
	public CategorieEmploi trouverParNom(String nom);
	
	
	  public Offre addOffre(Offre offre); 
	  public Offre getOffre(Long id); 
	  public List<Offre> listOffres();
	  public List<Offre> findAllOffresWithCategories();
	
	
	
	  
	 
}
