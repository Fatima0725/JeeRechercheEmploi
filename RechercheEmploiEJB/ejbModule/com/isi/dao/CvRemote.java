package com.isi.dao;

import java.util.List;

import com.isi.entities.Cv;

import jakarta.ejb.Remote;

@Remote
public interface CvRemote {
	public Cv addCv(Cv cv);
	public Cv getCv(Long id);
	public List<Cv> listCvs();
	
}
