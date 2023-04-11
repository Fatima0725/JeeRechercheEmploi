package com.isi.dao;

import java.util.List;

import com.isi.entities.CategorieEmploi;
import com.isi.entities.Cv;

import jakarta.ejb.Local;

@Local
public interface CvLocal {
	public Cv addCv(Cv cv);
	public Cv getCv(Long id);
	public List<Cv> listCvs();
	public Cv findByEmailAndPassword(String email, String password);
	public void updateCV(Cv cv);
	public CategorieEmploi addCategory(CategorieEmploi categorie_emploi);
}
