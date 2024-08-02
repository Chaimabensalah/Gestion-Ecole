package com.ecole.gestion.ecole.model;

 

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "transport", catalog = "gestionecole")
public class Transport {

	private int idTransport;
	private Chauffeur chauffeur;
	private Aide aide;
	private Date dateDebut;
	private Date dateFin;
	private Vehicule vehicule;
	private boolean active;
	 
	
	 

	public Transport() {
	}

	 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTransport", unique = true, nullable = false)
	public int getIdTransport() {
		return this.idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paiement_idPaiement", nullable = false)
	public Paiement getPaiement() {
		return this.paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	 

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Tarifs> getTarifses() {
		return this.tarifses;
	}

	public void setTarifses(Set<Tarifs> tarifses) {
		this.tarifses = tarifses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Horaire> getHoraires() {
		return this.horaires;
	}

	public void setHoraires(Set<Horaire> horaires) {
		this.horaires = horaires;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
	public Set<Positiongps> getPositiongpses() {
		return this.positiongpses;
	}

	public void setPositiongpses(Set<Positiongps> positiongpses) {
		this.positiongpses = positiongpses;
	}*/
	
	@OneToOne(fetch = FetchType.LAZY)
	public Aide getAide() {
		return this.aide;
	}

	public void setAide(Aide aide) {
		this.aide = aide;
	}
	
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transport")
//	public Set<Eleve> getEleves() {
//		return eleves;
//	}
//
//	public void setEleves(Set<Eleve> eleves) {
//		this.eleves = eleves;
//	}
//	
	
	@OneToOne(fetch = FetchType.LAZY)
	public Chauffeur getChauffeur() {
		return this.chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	@Column(name = "dateDebut", columnDefinition="DATETIME")
//	@Temporal(TemporalType.TIMESTAMP)
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

	
	@OneToOne(fetch = FetchType.LAZY)
	public Vehicule getVehicule() {
		return vehicule;
	}


	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	@Column(name = "active", length = 45)
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	 
	

}
