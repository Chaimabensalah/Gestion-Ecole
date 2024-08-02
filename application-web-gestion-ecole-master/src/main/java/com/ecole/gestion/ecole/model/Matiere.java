package com.ecole.gestion.ecole.model;

 
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "matiere", catalog = "gestionecole")
public class Matiere {

	private int idMatiere;
	//private Unite unite;
	private String nomMatiere;
	private String coeficient;
	private String nombreHeure;
	private String nombreExamen;
 
	//private Set<Seance> seances = new HashSet<Seance>(0);
	//private Set<Examen> examens = new HashSet<Examen>(0);
	private Set<Absence> absences = new HashSet<Absence>(0);
	private Set<Retard> retards = new HashSet<Retard>(0);
	private Set<Devoir> devoirs = new HashSet<Devoir>(0);
	
	private Set<Observation> observations = new HashSet<Observation>(0);
	private Set<Note> notes = new HashSet<Note>(0);
	

	public Matiere() {
	}

	 

	public Matiere(int idMatiere,  String nomMatiere, String coeficient, String nombreHeure,
			String nombreExamen ) {
		this.idMatiere = idMatiere;
		//this.unite = unite;
		this.nomMatiere = nomMatiere;
		this.coeficient = coeficient;
		this.nombreHeure = nombreHeure;
		this.nombreExamen = nombreExamen;
//		this.seances = seances;
//		this.examens = examens;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idMatiere", unique = true, nullable = false)
	public int getIdMatiere() {
		return this.idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Unite_idUnite1", nullable = false)
//	public Unite getUnite() {
//		return this.unite;
//	}
//
//	public void setUnite(Unite unite) {
//		this.unite = unite;
//	}

	@Column(name = "NomMatiere", length = 45)
	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	@Column(name = "Coeficient", length = 45)
	public String getCoeficient() {
		return this.coeficient;
	}

	public void setCoeficient(String coeficient) {
		this.coeficient = coeficient;
	}

	@Column(name = "NombreHeure", length = 45)
	public String getNombreHeure() {
		return this.nombreHeure;
	}

	public void setNombreHeure(String nombreHeure) {
		this.nombreHeure = nombreHeure;
	}

	@Column(name = "nombreExamen", length = 45)
	public String getNombreExamen() {
		return this.nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matiere")
//	public Set<Seance> getSeances() {
//		return this.seances;
//	}
//
//	public void setSeances(Set<Seance> seances) {
//		this.seances = seances;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matiere")
//	public Set<Examen> getExamens() {
//		return this.examens;
//	}
//
//	public void setExamens(Set<Examen> examens) {
//		this.examens = examens;
//	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matiere")
	public Set<Absence> getAbsences() {
		return this.absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matiere")
	public Set<Retard> getRetards() {
		return this.retards;
	}

	public void setRetards(Set<Retard> retards) {
		this.retards = retards;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matiere")
	public Set<Devoir> getDevoirs() {
		return this.devoirs;
	}

	public void setDevoirs(Set<Devoir> devoirs) {
		this.devoirs = devoirs;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matiere")
	public Set<Observation> getObservations() {
		return this.observations;
	}

	public void setObservations(Set<Observation> observations) {
		this.observations = observations;
	}
	
	@JsonIgnore 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eleve")
	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}



	
	
}
