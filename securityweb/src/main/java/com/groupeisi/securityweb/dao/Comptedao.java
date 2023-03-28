package com.groupeisi.securityweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.groupeisi.securityweb.config.HibernateUtil;
import com.groupeisi.securityweb.dto.Comptedto;
import com.groupeisi.securityweb.entities.Comptes;

public class Comptedao implements Comptedto {

	private Session session;
	private Transaction transaction;
	
	public Comptedao () {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public int save(Comptes compte) {
		try {
			transaction = session.beginTransaction();
			session.save(compte);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Comptes> getAll() {
		return session.createQuery("select comptes from Comptes comptes").getResultList();
		
	}

	public boolean login(String userName, String password) {

		Comptes user = null;
		try {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (Comptes) session.createQuery("FROM Comptes U WHERE U.userName = :userName").setParameter("userName", userName)
					.uniqueResult();
			
			if(user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	
}
