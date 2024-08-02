package com.ecole.gestion.ecole.model;



import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "professeur")
@PrimaryKeyJoinColumn(name = "idPersonne")
public class Professeur extends Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Personne personne;
	//private Salaire salaire;
	//private String matricule;
	private String cin;
	private String diplome;
	private Date dateDebutTravail;
	private Set<CahierTexte> cahiertextes = new HashSet<CahierTexte>(0);
	//private Set<Seance> seances = new HashSet<Seance>(0);
	//private Set<Garde> gardes = new HashSet<Garde>(0);

	public Professeur() {
	}

 
	public Professeur(   String matricule, String cin,
			String diplome ) {
		//this.personne = personne;
		//this.salaire = salaire;
		//this.matricule = matricule;
		this.cin = cin;
		this.diplome = diplome;
		//this.cahiertextes = cahiertextes;
		//this.seances = seances;
		//this.gardes = gardes;
	}


	 
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salaire_idSalaire", nullable = false)
	public Salaire getSalaire() {
		return this.salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}*/

//	@Column(name = "Matricule", length = 45)
//	public String getMatricule() {
//		return this.matricule;
//	}
//
//	public void setMatricule(String matricule) {
//		this.matricule = matricule;
//	}

	@Column(name = "CIN", length = 45)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Column(name = "Diplome", length = 45)
	public String getDiplome() {
		return this.diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professeur")
	public Set<CahierTexte> getCahiertextes() {
		return this.cahiertextes;
	}

	public void setCahiertextes(Set<CahierTexte> cahiertextes) {
		this.cahiertextes = cahiertextes;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateDebutTravail", length = 10)
	public Date getDateDebutTravail() {
		return this.dateDebutTravail;
	}

	public void setDateDebutTravail(Date dateDebutTravail) {
		this.dateDebutTravail = dateDebutTravail;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "professeur")
	public Set<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professeur")
	public Set<Garde> getGardes() {
		return this.gardes;
	}

	public void setGardes(Set<Garde> gardes) {
		this.gardes = gardes;
	}*/

}
