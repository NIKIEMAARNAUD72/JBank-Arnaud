package org.jbank.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jbank.model.Client;

public class ClientDAOImpl implements ClientDAO {

	private SessionFactory sessionFactory;

	public ClientDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();

	}

	public List<Client> findAll() {
		Session session = sessionFactory.openSession();
		List<Client> result = session.createQuery("from Client").list();
		return result;
	}

	public void remove(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(client);
		session.getTransaction().commit();

	}

	public Client findClient(String user, String pass) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Client client2 = (Client) session.createQuery("from Client where username='"+user+"' and password ='"+pass+"'").uniqueResult();
		return client2;
	}

	public Client findClient(int client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Client client2 = (Client) session.createQuery("from Client where id_cl='"+client+"'").uniqueResult();
		return client2;
	}
	
	public void update(Client client) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(client);
		session.getTransaction().commit();
	}

}

