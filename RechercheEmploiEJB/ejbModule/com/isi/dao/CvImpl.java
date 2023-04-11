package com.isi.dao;

import java.util.List;

import com.isi.entities.CategorieEmploi;
import com.isi.entities.Cv;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpSession;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Stateless
public class CvImpl implements CvLocal{
	@PersistenceContext(unitName = "RechercheEmploiEJB")
	private EntityManager em;
	
	@Override
	public Cv addCv(Cv cv) {
		// TODO Auto-generated method stub
		//em.persist(cv);
		//return cv;
		if (em != null) { // Add null-check to avoid NullPointerException
            em.persist(cv);
        } else {
            // Handle the case where em is null
            throw new IllegalStateException("EntityManager is null");
        }
		return cv;
	}
	
	@Override
	public CategorieEmploi addCategory(CategorieEmploi categorie_emploi) {
		if(em != null) {
			em.persist(categorie_emploi);
		}else {
            throw new IllegalStateException("EntityManager is null");

		}
		return categorie_emploi;
	}

	@Override
	public Cv getCv(Long id) {
	    Cv cv = null;

	    try {
	        cv = em.find(Cv.class, id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }

	    return cv;
	}

	@Override
	public List<Cv> listCvs() {

		if (em != null) { // Add null-check to avoid NullPointerException
			TypedQuery<Cv> query = em.createQuery(
		            "SELECT c FROM Cv c WHERE c.email != :adminEmail", Cv.class);
		    query.setParameter("adminEmail", "admin@gmail.com");
		    List<Cv> cvs = query.getResultList();
		    return cvs;
        } else {
            // Handle the case where em is null
            throw new IllegalStateException("EntityManager is null");
        }
	}
	
	@Override
	public Cv findByEmailAndPassword(String email, String password) {
		/*
		 * try { return (Cv) em.
		 * createQuery("SELECT d FROM cv d WHERE d.email = :email AND d.password = :password"
		 * ) .setParameter("email", email) .setParameter("password", password)
		 * .getSingleResult(); } catch (Exception e) { return null;
		 * 
		 * }
		 */
		try {
			TypedQuery<Cv> query = em.createQuery("SELECT d FROM Cv d WHERE d.email = :email AND d.password = :password", Cv.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		}catch (NoResultException e) {
            return null;
        }
		
		
	 }
	
	@Override
	public void updateCV(Cv cv) {
		//em.merge(cv);
			em.getTransaction().begin();
		   em.merge(cv);
		   em.getTransaction().commit();
	}

}
