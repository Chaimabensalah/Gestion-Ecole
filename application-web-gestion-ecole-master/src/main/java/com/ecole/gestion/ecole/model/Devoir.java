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
@Table(name = "devoir", catalog = "gestionecole")
public class Devoir  {

	private int idDevoir;
	//private Seance seance;
	private String tache;
	private Date dateDevoir;
	private Classe classe;
	private Matiere matiere;
	private boolean valide; 

	public Devoir() {
	}

	

	public Devoir(int idDevoir, String tache, Date dateDevoir, String afairele) {
		this.idDevoir = idDevoir;
		//this.seance = seance;
		this.tache = tache;
		this.dateDevoir = dateDevoir;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idDevoir", unique = true, nullable = false)
	public int getIdDevoir() {
		return this.idDevoir;
	}

	public void setIdDevoir(int idDevoir) {
		this.idDevoir = idDevoir;
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

	@Column(name = "Tache", length = 45)
	public String getTache() {
		return this.tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}

	@Column(name = "DateDevoir", length = 45)
	public Date getDateDevoir() {
		return this.dateDevoir;
	}

	public void setDateDevoir(Date dateDevoir) {
		this.dateDevoir = dateDevoir;
	}

//	@Column(name = "Afairele", length = 45)
//	public String getAfairele() {
//		return this.afairele;
//	}
//
//	public void setAfairele(String afairele) {
//		this.afairele = afairele;
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
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Classe_idClasse", nullable = false)
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	@Column(name = "valide", length = 45)
	public boolean getValide() {
		return valide;
	}



	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	
}
