package org.jbank.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbank.dao.ClientDAO;
import org.jbank.action.ClientAction;
import org.jbank.dao.ClientDAOImpl;
import org.jbank.dao.CompteDAO;
import org.jbank.dao.CompteDAOImpl;
import org.jbank.dao.TransactionDAO;
import org.jbank.dao.TransactionDAOImpl;
import org.jbank.listener.HibernateListener;
import org.jbank.model.Client;
import org.jbank.model.Compte;
import org.jbank.model.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TransactionAction extends ActionSupport implements ModelDriven<Transaction> {

	private Transaction transaction;  
	private List<Transaction> transactionList;


	@Override
	public String execute() throws Exception {
		return this.listTransactions();
	}
	
	public String listTransactions() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		TransactionDAO transactionDAO = new TransactionDAOImpl(sessionFactory);
		this.transactionList = transactionDAO.findAll();
		return SUCCESS;
	}

	int montant;
	String emetteur;
	String recepteur;
	@Action(value="operation",
			results= { @Result(name="success", location="addtransa.jsp"),
					@Result(name="error", location="errortransa.jsp" ),
					@Result(name="erreur", location="errortransa3.jsp" )})
	public String TransactionSolde() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		CompteDAO compteDAO = new CompteDAOImpl(sessionFactory);
		ClientDAO clientDAO = new ClientDAOImpl(sessionFactory);
		TransactionDAO transactionDAO = new TransactionDAOImpl(sessionFactory);
		Compte c1 = compteDAO.findCompte(emetteur);
		Client cl = clientDAO.findClient(c1.getClient().getId_cl());
		Compte c2 = compteDAO.findCompte(recepteur);
		String erreur = "erreur";
		if( cl.getId_cl()== c1.getClient().getId_cl() && c1 != null && c2 != null && c1.getSolde() >= montant && c1.getClient() != c2.getClient()) {
			int reste = c1.getSolde() - montant;
			int ajout = c2.getSolde() + montant;
			c1.setSolde(reste);
			c2.setSolde(ajout);
			compteDAO.update(c1);
			compteDAO.update(c2);
			transaction.setCreation(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MM yyyy")));
			transaction.setEmetteur(c1);
			transaction.setRecepteur(c2);
			String montant2 = Integer.toString(montant);
			transaction.setMontant(montant2);
			transactionDAO.save(transaction);
			return SUCCESS;
		}else if( cl.getId_cl()== c1.getClient().getId_cl() && c1 != null && c2 != null && c1.getSolde() < montant && c1.getClient() != c2.getClient()){
			return ERROR;
		} else {
			return erreur;
		}
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public String getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}

	@Override
	public Transaction getModel() {
		// TODO Auto-generated method stub
		return transaction;
	}
	
	
}
