package org.jbank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbank.model.Compte;
import org.jbank.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO {

	private SessionFactory sessionFactory;

	public TransactionDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Transaction transaction) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(transaction);
		session.getTransaction().commit();
	}


	public List<Transaction> findAll() {
		Session session = sessionFactory.openSession();
		List<Transaction> result = session.createQuery("from Transaction").list();
		return result;
	}

}
