package org.jbank.action;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
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

public class CompteAction extends ActionSupport implements ModelDriven<Compte> {

	private Compte compte = new Compte();
	private List<Compte> compteList;

	@Override
	public String execute() throws Exception {
		return this.listComptes();
	}

	@Action(value="registerCompte", 
			results= { @Result(name="success", location="accueil.jsp")})
	public String addCompte() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		CompteDAO compteDAO = new CompteDAOImpl(sessionFactory);
		compteDAO.save(compte);
		return SUCCESS;
	}

	public String listComptes() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		CompteDAO compteDAO = new CompteDAOImpl(sessionFactory);
		this.compteList = compteDAO.findAll();
		return SUCCESS;
	}

	public String deleteCompte() {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		CompteDAO compteDAO = new CompteDAOImpl(sessionFactory);
		if(compte != null) {
			compteDAO.remove(compte);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	
	
	@Override
	public Compte getModel() {
		// TODO Auto-generated method stub
		return compte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
