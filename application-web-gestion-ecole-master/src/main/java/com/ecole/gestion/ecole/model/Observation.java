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
@Table(name = "observation", catalog = "gestionecole")
public class Observation  {

	private int idObservation;
	private Eleve eleve;
	//private Seance seance;
	private String remarque;
	private Date date;
	private Matiere matiere;
	//private int elevePersonneIdPersonne;

	public Observation() {
	}

	public Observation(int idObservation, Eleve eleve,  int elevePositionGpsIdPosition,
			int elevePersonneIdPersonne) {
		this.idObservation = idObservation;
		this.eleve = eleve;
		//this.seance = seance;
	}

	public Observation(int idObservation, Eleve eleve, String remarque, String date,
			int elevePositionGpsIdPosition, int elevePersonneIdPersonne) {
		this.idObservation = idObservation;
		this.eleve = eleve;
		//this.seance = seance;
		this.remarque = remarque;
		//this.date = date;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idObservation", unique = true, nullable = false)
	public int getIdObservation() {
		return this.idObservation;
	}

	public void setIdObservation(int idObservation) {
		this.idObservation = idObservation;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Eleve_idEleve", nullable = false)
	public Eleve getEleve() {
		return this.eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Matiere_idMAtiere", nullable = false)
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "seance_idSeance", nullable = false)
//	public Seance getSeance() {
//		return this.seance;
//	}
//
//	public void setSeance(Seance seance) {
//		this.seance = seance;
//	}

	@Column(name = "Remarque")
	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	@Column(name = "Date", length = 45)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	 

	 

}
