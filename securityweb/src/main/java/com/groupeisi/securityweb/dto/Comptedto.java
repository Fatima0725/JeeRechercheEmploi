package com.groupeisi.securityweb.dto;

import java.util.List;

import com.groupeisi.securityweb.entities.Comptes;

public interface Comptedto {

	public int save (Comptes compte);
	public List<Comptes> getAll();
	public boolean login(String userName, String password);

}
