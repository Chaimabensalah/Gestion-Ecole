package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "examen", catalog = "gestionecole")
public class Examen {

	private int idExamen;
	private Matiere matiere;
	private Classe classe;
	private String numExamen;
	private Integer pourcentage;
	private Set<Note> notes = new HashSet<Note>(0);
	private boolean  valide;
	private Date date;
	private String duree;

	public Examen() {
	}

	public Examen(int idExamen, Horaire horaire, Matiere matiere) {
		this.idExamen = idExamen;
		//this.horaire = horaire;
		this.matiere = matiere;
	}

	public Examen(int idExamen, Horaire horaire, Matiere matiere, String numExamen, Integer pourcentage,
			Set<Note> notes) {
		this.idExamen = idExamen;
	//	this.horaire = horaire;
		this.matiere = matiere;
		this.numExamen = numExamen;
		this.pourcentage = pourcentage;
		this.notes = notes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idExamen", unique = true, nullable = false)
	public int getIdExamen() {
		return this.idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	 
	 
	@OneToOne(fetch = FetchType.LAZY)
	 
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Column(name = "NumExamen", length = 45)
	public String getNumExamen() {
		return this.numExamen;
	}

	public void setNumExamen(String numExamen) {
		this.numExamen = numExamen;
	}

	@Column(name = "Pourcentage")
	public Integer getPourcentage() {
		return this.pourcentage;
	}

	public void setPourcentage(Integer pourcentage) {
		this.pourcentage = pourcentage;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "examen")
	public Set<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	@Column(name = "valide")
	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse( Classe classe) {
		this.classe = classe;
	}
	
	@Column(name = "date", columnDefinition="DATETIME")
	 
	public Date getDateDebut() {
		return this.date;
	}

	public void setDateDebut(Date date) {
		this.date = date;
	}
	
	@Column(name = "duree", length = 45)
	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

}
