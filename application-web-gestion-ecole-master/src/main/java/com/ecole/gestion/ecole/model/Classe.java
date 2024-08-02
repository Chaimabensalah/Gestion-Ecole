package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "classe", catalog = "gestionecole")
public class Classe  {

	private int idClasse;
	private Niveau niveau;
	private String nomClasse;
	private int nombreEleves;
	private Set<Eleve> eleves = new HashSet<Eleve>(0);
	private Set<Devoir> devoirs = new HashSet<Devoir>(0);
	//private Set<Seance> seances = new HashSet<Seance>(0);
	//private CahierTexte cahierTexte;

	public Classe() {
	}

	public Classe(int idClasse, Niveau niveau) {
		this.idClasse = idClasse;
		this.niveau = niveau;
	}

	public Classe(int idClasse, Niveau niveau, Set<Eleve> eleves) {
		this.idClasse = idClasse;
		this.niveau = niveau;
		//this.eleves = eleves;
		//this.seances = seances;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idClasse", unique = true, nullable = false)
	public int getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	
	@Column(name = "nom_classe", unique = true, nullable = false)
	public String getNomClasse() {
		return this.nomClasse;
	}

	public void setNomClasse(String nom) {
		this.nomClasse = nom;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "niveau_idNiveau")
	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	public Set<Eleve> getEleves() {
		return this.eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	public Set<Devoir> getDevoirs() {
		return this.devoirs;
	}

	public void setDevoirs(Set<Devoir> devoirs) {
		this.devoirs = devoirs;
	}
	
	@Column(name = "nombreeleves")
	public int getNombreEleves() {
		return nombreEleves;
	}

	public void setNombreEleves(int nombreEleve) {
		this.nombreEleves = nombreEleve;
	}
	

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
//	public Set<Seance> getSeances() {
//		return this.seances;
//	}
//
//	public void setSeances(Set<Seance> seances) {
//		this.seances = seances;
//	}
	
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "classeCahier", cascade = CascadeType.ALL)
//	public CahierTexte getCahierTexte() {
//		return this.cahierTexte;
//	}
//
//	public void setCahierTexte(CahierTexte cahierText) {
//		this.cahierTexte = cahierText;
//	}

}
