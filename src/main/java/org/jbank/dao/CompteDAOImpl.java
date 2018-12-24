package org.jbank.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbank.listener.HibernateListener;
import org.jbank.model.Client;
import org.jbank.model.Compte;

public class CompteDAOImpl implements CompteDAO {

	private SessionFactory sessionFactory;

	public CompteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Compte compte) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(compte);
		session.getTransaction().commit();

	}

	public List<Compte> findAll() {
		Session session = sessionFactory.openSession();
		List<Compte> result = session.createQuery("from Compte").list();
		return result;
	}

	public void remove(Compte compte) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(compte);
		session.getTransaction().commit();

	}
	
	public void update(Compte compte) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(compte);
		session.getTransaction().commit();

	}

	@Override
	public Compte findCompte(String numero) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Compte com = (Compte) session.createQuery("from Compte where numero='"+numero+"'").uniqueResult();
		return com;
	}
	
	public Compte findCompte(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Compte com = (Compte) session.createQuery("from Compte where client='"+id+"'").uniqueResult();
		return com;
	}

}
