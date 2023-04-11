package com.isi.dao;

import java.util.List;

import com.isi.entities.CategorieEmploi;
import com.isi.entities.Offre;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class OffreImpl implements OffreLocal{
	@PersistenceContext(unitName = "RechercheEmploiEJB")
	private EntityManager em;

	@Override
	public CategorieEmploi addCategory(CategorieEmploi categorie_emploi) {
		// TODO Auto-generated method stub
		if (em != null) { // Add null-check to avoid NullPointerException
            em.persist(categorie_emploi);
        } else {
            // Handle the case where em is null
            throw new IllegalStateException("EntityManager is null");
        }
		return categorie_emploi;
		
	}

	@Override
	public CategorieEmploi getCategorie(Long id) {
		CategorieEmploi category = em.find(CategorieEmploi.class, id);
		return category;
	}

	@Override
	public List<CategorieEmploi> listCategories() {
		if (em != null) { // Add null-check to avoid NullPointerException
			Query req = em.createQuery("SELECT c from CategorieEmploi c");
			return req.getResultList();
        } else {
            // Handle the case where em is null
            throw new IllegalStateException("EntityManager is null");
        }
		
	}

	public CategorieEmploi trouverParNom(String nom) {
		Query query = em.createQuery("SELECT c FROM CategorieEmploi c WHERE c.nom = :nom");
		query.setParameter("nom", nom);
		try {
	        return (CategorieEmploi) query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

	
	  @Override 
	  public Offre addOffre(Offre offre) {
		// TODO Auto-generated method stub
			if (em != null) { // Add null-check to avoid NullPointerException
	            em.persist(offre);
	        } else {
	            // Handle the case where em is null
	            throw new IllegalStateException("EntityManager is null");
	        }
			return offre;
	  }
	  
	  @Override public Offre getOffre(Long id) { 
		  Offre offre = em.find(Offre.class, id);
		return offre;
		  
	  }
	  
	  @Override public List<Offre> listOffres() { 
		  if (em != null) { // Add null-check to avoid NullPointerException
				Query req = em.createQuery("SELECT c from Offre c");
				return req.getResultList();
	        } else {
	            // Handle the case where em is null
	            throw new IllegalStateException("EntityManager is null");
	        }
		  
	    }

	@Override
	public List<Offre> findAllOffresWithCategories() {
		List<Offre> offres = null;
		try {
	        Query q = em.createQuery("SELECT o FROM Offre o JOIN FETCH o.categories");
	        offres = q.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    return offres;
	}
	 
	
	
}
