package com.ecole.gestion.ecole.model;

 

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facture", catalog = "gestionecole")
public class Facture  {

	private Long idFacture;
	private Fournisseur fournisseur;
	private int numeroFacture;
	private String produit;
	private float nombreProduit;
	private float prixHT ;
	private float  totalHT;
	private boolean active;
 
	private Date date;

	public Facture() {
	}

	  

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFacture", unique = true, nullable = false)
	public Long getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFournisseur", nullable = false)
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	@Column(name = "Date", length = 45)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(name = "NumeroFacture", length = 45)
	public int getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}


	@Column(name = "Produit", length = 45)
	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}


	@Column(name = "nombreProduit", length = 45)
	public float getNombreProduit() {
		return nombreProduit;
	}

	public void setNombreProduit(float nombreProduit) {
		this.nombreProduit = nombreProduit;
	}


	@Column(name = "PrixHT", length = 45)
	public float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}


	@Column(name = "total_HT", length = 45)
	public float getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(float totalHT) {
		this.totalHT = totalHT;
	}


	@Column(name = "active", length = 45)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
