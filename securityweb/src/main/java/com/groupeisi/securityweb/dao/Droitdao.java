package com.groupeisi.securityweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.groupeisi.securityweb.config.HibernateUtil;
import com.groupeisi.securityweb.dto.Droitdto;
import com.groupeisi.securityweb.entities.Droit;

public class Droitdao implements Droitdto {
	private Session session;
	private Transaction transaction;
	
	public Droitdao () {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public int save(Droit droit) {
		try {
			transaction = session.beginTransaction();
			session.save(droit);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}


	@SuppressWarnings("unchecked")
	public List<Droit> getAll() {
		return session.createQuery("select droit from Droit droit").getResultList();
		
	}

	@Override
	public Droit getOne(int l) {
		return session.get(Droit.class, l);
	}
}
