package org.jbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int libelle;
	@JoinColumn(name = "emetteur", referencedColumnName = "numero")
    @ManyToOne
	private Compte emetteur;
	@JoinColumn(name = "recepteur", referencedColumnName = "numero")
	@ManyToOne
	private Compte recepteur;
	@Column(name = "montant")
	private String montant;
	@Column(name = "creation")
	private String creation;
	
	
	public int getLibelle() {
		return libelle;
	}
	public void setLibelle(int libelle) {
		this.libelle = libelle;
	}
	public Compte getEmetteur() {
		return emetteur;
	}
	public void setEmetteur(Compte emetteur) {
		this.emetteur = emetteur;
	}
	public Compte getRecepteur() {
		return recepteur;
	}
	public void setRecepteur(Compte recepteur) {
		this.recepteur = recepteur;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	
	
	
}
