package com.ecole.gestion.ecole.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

 
@Entity
@Table(name = "eleve",catalog = "gestionecole")
@PrimaryKeyJoinColumn(name = "idPersonne")
public class Eleve extends Personne {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Classe classe;
    private Set<Inscription> inscriptions=new HashSet<Inscription>(0);
 	private Niveau niveau;
 	private int typePaiement;
 //	private Transport tansport;
 
	//private Positiongps positiongps;
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	private String matricule;
	/*private Set<Retard> retards = new HashSet<Retard>(0);
	private Set<Bulletin> bulletin = new HashSet<Bulletin>(0);
	private Set<Observation> observations = new HashSet<Observation>(0);*/
	private Set<Absence> absences = new HashSet<Absence>(0);
	private Set<Note> notes=new HashSet<Note>(0);

	public Eleve() {
	}
	

	@Column(name = "Matricule", length = 45)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	@Column(name = "typePaiement", length = 45)
	public int getTypePaiement() {
		return typePaiement;
	}


	public void setTypePaiement(int typePayement) {
		this.typePaiement = typePayement;
	}
	 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Classe_idClasse" )
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@OneToMany(fetch = FetchType.LAZY ,mappedBy ="eleve")
	 
	public Set <Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscription) {
		this.inscriptions = inscription;
	}
	 

	 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "niveau_idNiveau", nullable = false)
	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	 

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "positiongps_idPosition", nullable = false)
	public Positiongps getPositiongps() {
		return this.positiongps;
	}

	public void setPositiongps(Positiongps positiongps) {
		this.positiongps = positiongps;
	}*/
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Transpot_idTransport" )
// 	public Transport getTansport() {
//		return tansport;
//	}
//
//
//	public void setTansport(Transport tansport) {
//		this.tansport = tansport;
//	}


	@JsonIgnore
 	@ManyToMany()
 	 @JoinTable(name = "respo_eleve", joinColumns = @JoinColumn(name = "eleve", referencedColumnName = "idPersonne"), inverseJoinColumns = @JoinColumn(name = "respo", referencedColumnName = "idPersonne"))
 	public Set<Responsable> getResponsables() {
		return this.responsables;
	}
 
	public void setResponsables(Set<Responsable> responsable) {
		this.responsables = responsable;
	}

	

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "eleve")
	public Set<Retard> getRetards() {
		return this.retards;
	}

	public void setRetards(Set<Retard> retards) {
		this.retards = retards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eleve")
	public Set<Bulletin> getBultiens() {
		return this.bulletin;
	}

	public void setBultiens(Set<Bulletin> bulletin) {
		this.bulletin = bulletin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eleve")
	public Set<Observation> getObservations() {
		return this.observations;
	}

	public void setObservations(Set<Observation> observations) {
		this.observations = observations;
	}*/
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eleve")
	public Set<Absence> getAbsences() {
		return this.absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eleve")
	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	

	



	@Override
	public String toString() {
		return "Eleve [ matricule=" + matricule + "]";
	}

	 
}
