package com.ecole.gestion.ecole.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "contact")
@PrimaryKeyJoinColumn(name = "idPersonne")
public class Contact extends Personne  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Fournisseur fournisseur;
	private String fonction;
	private String cin;
	//private Set<Personne> personnes = new HashSet<Personne>(0);

	public Contact() {
	}
 

	 
//	@OneToOne(fetch = FetchType.LAZY)
// 
//	public Fournisseur getFournisseur() {
//		return this.fournisseur;
//	}
//
//	public void setFournisseur(Fournisseur fournisseur) {
//		this.fournisseur = fournisseur;
//	}

    @Column(name="fonction")
	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	@Column(name = "CIN", length = 45)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	

	 

}
