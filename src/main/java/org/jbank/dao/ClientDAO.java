package org.jbank.dao;

import java.util.List;

import org.jbank.model.Client;


public interface ClientDAO {

	void save(Client client);
	
	void update(Client client);
	
	Client findClient(String user, String pass);
 
	List<Client> findAll();
	
	void remove(Client client);

	Client findClient(int client);

}
