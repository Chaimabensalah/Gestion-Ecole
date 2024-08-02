package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cahiertexte", catalog = "gestionecole")
public class CahierTexte {

	private int idCahierTexte;
	private Professeur professeur;
	private String date;
	private String tache;
	private Matiere matiere;
	private Classe classe;
	//private Set<Seance> seances = new HashSet<Seance>(0);

	public CahierTexte() {
	}

	public CahierTexte(int idCahiertexte, Professeur professeur) {
		this.idCahierTexte = idCahiertexte;
		this.professeur = professeur;
	}

	public CahierTexte(int idCahiertexte, Professeur professeur, String date, String heure, String tache ) {
		this.idCahierTexte = idCahiertexte;
		this.professeur = professeur;
		this.date = date;
		//this.heure = heure;
		this.tache = tache;
		//this.seances = seances;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCahierTexte", unique = true, nullable = false)
	public int getIdCahierTexte() {
		return this.idCahierTexte;
	}

	public void setIdCahierTexte(int idCahiertexte) {
		this.idCahierTexte = idCahiertexte;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professeur_idProfesseur")
	public Professeur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	//@Temporal(TemporalType.DATE)
	@Column(name = "Date",length = 45)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	@Column(name = "Tache")
	public String getTache() {
		return this.tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cahiertexte")
//	public Set<Seance> getSeances() {
//		return this.seances;
//	}
//
//	public void setSeances(Set<Seance> seances) {
//		this.seances = seances;
//	}
	
	@OneToOne(fetch = FetchType.LAZY)
	//@PrimaryKeyJoinColumn
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere( Matiere matiere) {
		this.matiere = matiere;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse( Classe classe) {
		this.classe = classe;
	}

}
