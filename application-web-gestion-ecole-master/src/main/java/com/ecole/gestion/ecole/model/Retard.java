package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name = "retard", catalog = "gestionecole")
public class Retard {

	private int idRetard;
	private Eleve eleve;
	//private Seance seance;
	private Matiere matiere;

	public Retard() {
	}

//	public Retard(int idRetard, Eleve eleve, Seance seance) {
//		this.idRetard = idRetard;
//		this.eleve = eleve;
//		this.seance = seance;
//	}

	public Retard(int idRetard, Eleve eleve, String retardcol) {
		this.idRetard = idRetard;
		this.eleve = eleve;
		//this.seance = seance;
		//this.retardcol = retardcol;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRetard", unique = true, nullable = false)
	public int getIdRetard() {
		return this.idRetard;
	}

	public void setIdRetard(int idRetard) {
		this.idRetard = idRetard;
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

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Seance_idSeance", nullable = false)
//	public Seance getSeance() {
//		return this.seance;
//	}
//
//	public void setSeance(Seance seance) {
//		this.seance = seance;
//	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Matiere_idMatiere", nullable = false)
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere m) {
		this.matiere = m;
	}
	 

}
