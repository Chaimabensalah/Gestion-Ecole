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
@Table(name = "absence", catalog = "gestionecole")
public class Absence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAbsence;
	private Eleve eleve;
	//private Seance seance;
	private Date dateAbsence;
	private Matiere matiere;
	private boolean justife;
	private String m;
	private String e;

	public Absence() {
	}

	public Absence(int idAbsence, Eleve eleve) {
		this.idAbsence = idAbsence;
		this.eleve = eleve;
		//this.seance = seance;
	}

	public Absence(int idAbsence, Eleve eleve,  Date dateAbsence) {
		this.idAbsence = idAbsence;
		this.eleve = eleve;
		//this.seance = seance;
		this.dateAbsence = dateAbsence;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAbsence", unique = true, nullable = false)
	public int getIdAbsence() {
		return this.idAbsence;
	}

	public void setIdAbsence(int idAbsence) {
		this.idAbsence = idAbsence;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Eleve_idPersonne", nullable = false)
	public Eleve getEleve() {
		return this.eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Matiere_idMatiere", nullable = false)
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere m) {
		this.matiere = m;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Seance_idSeance", nullable = false)
	public Seance getSeance() {
		return this.seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}*/

	@Temporal(TemporalType.DATE)
	@Column(name = "DateAbsence", length = 10)
	public Date getDateAbsence() {
		return this.dateAbsence;
	}

	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}

	@Column(name = "justifie")
	public boolean isJustife() {
		return justife;
	}

	public void setJustife(boolean justife) {
		this.justife = justife;
	}
	
	public String getM() {
		return m;
	}



	public void setM(String m) {
		this.m = m;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	
	

}
