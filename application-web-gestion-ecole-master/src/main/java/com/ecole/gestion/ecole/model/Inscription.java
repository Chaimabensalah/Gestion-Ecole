package com.ecole.gestion.ecole.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "inscription")
public class Inscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idInscription;
	//private Anneescolaire anneescolaire;
	//private Paiement paiement;
	private Tarif tarif;
	private Date dateInscription;
	private Eleve eleve;
	private boolean valide;
	private boolean current;

	public Inscription() {
	}

	 
 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idInscription", unique = true, nullable = false)
	public int getIdInscription() {
		return this.idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AnneeScolaire_idAnneeScolaire", nullable = false)
	public Anneescolaire getAnneescolaire() {
		return this.anneescolaire;
	}

	public void setAnneescolaire(Anneescolaire anneescolaire) {
		this.anneescolaire = anneescolaire;
	}*/

	 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tarifs_idTarifs")
	public Tarif getTarifs() {
		return this.tarif;
	}

	public void setTarifs(Tarif tarifs) {
		this.tarif = tarifs;
	}
	
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "paiment_idPaiment" )
//	public Paiement getPaiement() {
//		return paiement;
//	}
//
//
//
//	public void setPaiement(Paiement paiement) {
//		this.paiement = paiement;
//	}



	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateInscription", length = 19)
	public Date getDateInscription() {
		return this.dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Eleve_idPersonne")
	public Eleve getEleve() {
		return this.eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	@Column(name = "valide")
	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	

	@Column(name = "current")
	public boolean isCurrent() {
		return current;
	}


	public void setCurrent(boolean current) {
		this.current = current;
	}



	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", anneescolaire=" + ", paiement="
				  + ", dateInscription=" + dateInscription + "]";
	}

}
