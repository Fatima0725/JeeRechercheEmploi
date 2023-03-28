package com.groupeisi.securityweb.dto;

import java.util.List;

import com.groupeisi.securityweb.entities.Droit;

public interface Droitdto {

	public int save (Droit droit);
	public List<Droit> getAll();
	public Droit getOne(int id);

}
