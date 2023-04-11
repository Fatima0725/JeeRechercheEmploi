package com.isi.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.isi.entities.Cv;

public class CvDaoTest {

	@Test
	public void testAddCv() {
		CvLocal cvDao = new CvImpl();
		
		//Creer un nouvel CV
		Cv newCv = new Cv();
		newCv.setNom("niang");
		newCv.setPrenom("fatima");
		newCv.setAdresse("DAKAR");
		newCv.setAge(23);
		newCv.setEmail("fatimaniang208@gmail.com");
		newCv.setPassword("Passer123");
		newCv.setExperienceProfessionnel("ABFGHNJ DFCGHYJUK FGHYJU");
		newCv.setNiveauEtude("Master 1");
		newCv.setSpecialite("Developper");
		newCv.setTelephone("778786565");
		//Ajouter dans la base
		cvDao.addCv(newCv);
		
		//Verifier que le CV est crée
		Cv addeCv = cvDao.getCv(newCv.getId());
		assertEquals("niang", addeCv.getNom());
		assertEquals("fatima", addeCv.getPrenom());
		assertEquals("DAKAR", addeCv.getAdresse());
		assertEquals(23, addeCv.getAge());
		assertEquals("fatimaniang208@gmail.com", addeCv.getEmail());
		assertEquals("Passer123", addeCv.getPassword());
		assertEquals("ABFGHNJ DFCGHYJUK FGHYJU", addeCv.getExperienceProfessionnel());
		assertEquals("Master 1" , addeCv.getNiveauEtude());
		assertEquals("Developper", addeCv.getSpecialite());
		assertEquals("778786565", addeCv.getTelephone());
	}
	
	
}
