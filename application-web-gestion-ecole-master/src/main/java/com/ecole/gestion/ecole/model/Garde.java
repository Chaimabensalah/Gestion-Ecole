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
@Table(name = "garde", catalog = "gestionecole")
public class Garde {

	private Long idGarde;
	private Aide aide;
   // private Horaire horaire;
	private Professeur professeur;
	private Date dateDebut;
	private Date dateFin;
	private Tarif tarif;
	private boolean active;
	//private Set<Paiement> paiements = new HashSet<Paiement>(0);

	public Garde() {
	}

/*	public Garde(int idGarde, Aide aide, Horaire horaire, Professeur professeur, Tarifs tarifs) {
		this.idGarde = idGarde;
		this.aide = aide;
		this.horaire = horaire;
		this.professeur = professeur;
		this.tarifs = tarifs;
	}

	public Garde(int idGarde, Aide aide, Horaire horaire, Professeur professeur, Tarifs tarifs,
			Set<Paiement> paiements) {
		this.idGarde = idGarde;
		this.aide = aide;
		this.horaire = horaire;
		this.professeur = professeur;
		this.tarifs = tarifs;
		this.paiements = paiements;
	}*/

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idGarde", unique = true, nullable = false)
	public Long getIdGarde() {
		return this.idGarde;
	}

	public void setIdGarde(Long idGarde) {
		this.idGarde = idGarde;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aide_idPersonne", nullable = false)
	public Aide getAide() {
		return this.aide;
	}

	public void setAide(Aide aide) {
		this.aide = aide;
	}
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "horaire_idHoraire")
//	public Horaire getHoraire() {
//		return this.horaire;
//	}
//
//	public void setHoraire(Horaire horaire) {
//		this.horaire = horaire;
//	}
	
	 
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professeur_idPersonne")
	public Professeur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	@Column(name = "dateDebut", columnDefinition="DATETIME")
	//@Temporal(TemporalType.TIMESTAMP)
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date heureDebut) {
		this.dateDebut = heureDebut;
	}

	@Column(name = "dateFin", columnDefinition="DATETIME")
	//@Temporal(TemporalType.TIMESTAMP)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date heureFin) {
		this.dateFin = heureFin;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tarifs_idTarifs")
	public Tarif getTarifs() {
		return this.tarif;
	}

	public void setTarifs(Tarif tarifs) {
		this.tarif = tarifs;
	}
	
	@Column(name = "active", length = 45)
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "garde")
//	public Set<Paiement> getPaiements() {
//		return this.paiements;
//	}
//
//	public void setPaiements(Set<Paiement> paiements) {
//		this.paiements = paiements;
// 	}

}
