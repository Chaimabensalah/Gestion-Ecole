package com.ecole.gestion.ecole.model;

 

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fournisseur",catalog = "gestionecole")
public class Fournisseur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idFournisseur;
	private String adresse;
	private String email;
	private String ville;
	private String telephone;
	private String nom;
	private boolean active;
	private Contact contact;
//	private Set<Facture> factures = new HashSet<Facture>(0);
    //private Set<Contact> contacts = new HashSet<Contact>(0);
   /// private Set<Responsable> responsables = new HashSet<Responsable>(0);

	public Fournisseur() {
	}

	 

 
	
	 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFournisseur", unique = true, nullable = false)
	public int getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	 

	@Column(name = "Adresse", length = 45)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "Email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "Telephone", length = 45)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String email) {
		this.telephone = email;
	}
	
	@Column(name = "ville", length = 45)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String email) {
		this.ville = email;
	}
	
	@Column(name = "Nom", length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String email) {
		this.nom = email;
	}
	
	@Column(name = "active", length = 45)
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	 
	
	
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
//	public Set<Facture> getFactures() {
//		return this.factures;
//	}
//
//	public void setFactures(Set<Facture> factures) {
//		this.factures = factures;
//	}
//
//	@JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
//	public Set<Contact> getContacts()
//		{
//			return this.contacts;
//		}
//
//	public void setContacts(Set<Contact> contacts) {
//		this.contacts = contacts;
//	}
	
	 

}
