package org.jbank.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;
import org.jbank.dao.ClientDAO;
import org.jbank.dao.ClientDAOImpl;
import org.jbank.dao.CompteDAO;
import org.jbank.dao.CompteDAOImpl;
import org.jbank.listener.HibernateListener;
import org.jbank.model.Client;
import org.jbank.model.Compte;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientAction extends ActionSupport implements ModelDriven<Client>, SessionAware {

	private Client client = new Client();
	private Compte compte = new Compte();
	private List<Client> clientList;
	private Map<String, Object> session1;

	@Override
	public String execute() throws Exception {
		return this.listClients();
	}

	@Action(value="registerClient",
			results= { @Result(name="success", location="confirmation.jsp"),
					@Result(name="error", location="errorform.jsp" ) })
	public String addClient() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		ClientDAO clientDAO = new ClientDAOImpl(sessionFactory);
		CompteDAO compteDAO = new CompteDAOImpl(sessionFactory);
		String rand = Integer.toString(ThreadLocalRandom.current().nextInt(1000, 9998 + 1));
		if(client != null) {
			client.setPassword(rand);
			int random = ThreadLocalRandom.current().nextInt(000000, 999998 + 1);
			compte.setNumero(random);
			compte.setType("courant");
			compte.setSolde(100000);
			compte.setCreation(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MM yyyy")));
			client.setActive(0);
			clientDAO.save(client);
			compte.setClient(client);
			compteDAO.save(compte);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	public String listClients() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		ClientDAO clientDAO = new ClientDAOImpl(sessionFactory);
		this.clientList = clientDAO.findAll();
		return SUCCESS;
	}

	public String deleteClient() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		ClientDAO clientDAO = new ClientDAOImpl(sessionFactory);
		if(client != null) {
			clientDAO.remove(client);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	@Action(value="verified", 
			results= { @Result(name="success", location="accueil2.jsp"),
					@Result(name="error", location="errorlogin.jsp" ) ,
					@Result (name="mdp", location="mdp.jsp")})
	public String clientCheck() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		ClientDAO clientDAO = new ClientDAOImpl(sessionFactory);
		CompteDAO compteDAO = new CompteDAOImpl(sessionFactory);
		Client c = new Client();
		Compte c1 = new Compte();
		String user = client.getUsername();
		String pass = client.getPassword();
		c = clientDAO.findClient(user,pass);
		c1 = compteDAO.findCompte(c.getId_cl());

		String mdp="mdp";
		if( c !=null && c.getUsername().equals(user) && c.getPassword().equals(pass) && c.getActive() == 1) {
			this.session1.put("user", c);
			this.session1.put("account", c1);
			return SUCCESS;
		}else if(c !=null && c.getUsername().equals(user) && c.getPassword().equals(pass) && c.getActive() == 0){
			this.session1.put("user", c);
			this.session1.put("account", c1);
			return mdp;
		} else {
			return ERROR;
		}
	}

	private String passw;
	@Action(value="active",
			results= { @Result(name="success", location="accueil2.jsp"),
					@Result(name="error", location="errormdp.jsp" )})
	public String PasswordClient() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		ClientDAO clientDAO = new ClientDAOImpl(sessionFactory);
		if( passw != null) {
			client = (Client) session1.get("user");
			client.setActive(1);
			client.setPassword(passw);
			clientDAO.update(client);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	@Action(value="formulaire", 
			results= { @Result(name="success", location="formulaire.jsp")})
	public String formulaire() {
		return SUCCESS;
	}

	@Action(value="login",
			results= { @Result(name="success", location="login.jsp")})
	public String login() {
		return SUCCESS;
	}

	@Action(value="logout",
			results= { @Result(name="success", location="accueil.jsp")})
	public String logout() {
		this.session1.remove("c");
		return SUCCESS;
	}
	
	@Action(value="cancel",
			results= { @Result(name="success", location="accueil.jsp")})
	public String retour() {
		return SUCCESS;
	}


	public Map<String, Object> getSession() {
		return session1;
	}

	public void setSession(Map<String, Object> session1) {
		this.session1 = session1;
	}

	@Override
	public Client getModel() {
		return client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Map<String, Object> getSession1() {
		return session1;
	}

	public void setSession1(Map<String, Object> session1) {
		this.session1 = session1;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}



	@Action(value="accueil",
			results= { @Result(name="success", location="accueil2.jsp")})
	public String accueil() {
		return SUCCESS;
	}
	@Action(value="compte",
			results= { @Result(name="success", location="compte.jsp")})
	public String compte() {
		return SUCCESS;
	}
	@Action(value="transactions",
			results= { @Result(name="success", location="addTransaction.jsp")})
	public String transaction() {
		return SUCCESS;
	}
	@Action(value="history",
			results= { @Result(name="success", location="history.jsp")})
	public String history() {
		return SUCCESS;
	}
	@Action(value="apropos",
			results= { @Result(name="success", location="apropos.jsp")})
	public String apropos() {
		return SUCCESS;
	}
}
