package org.jbank.dao;

import java.util.List;

import org.jbank.model.Client;
import org.jbank.model.Compte;

public interface CompteDAO {

	void save(Compte compte);

	List<Compte> findAll();
	
	void remove(Compte compte);

	Compte findCompte(String emetteur);
	
	Compte findCompte(int id);

	void update(Compte c1);
	
}