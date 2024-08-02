package com.ecole.gestion.ecole.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
 
import javax.persistence.ManyToMany;

 
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "responsable" ,catalog = "gestionecole")
@PrimaryKeyJoinColumn(name = "idPersonne")
public class Responsable extends Personne implements Serializable {

 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cin;
	private String lienParente;
	private Set<Eleve> eleves = new HashSet<Eleve>(0);

	public Responsable() {
	}
 
	@Column(name = "CIN", length = 45, unique = true)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
	
	@Column(name="lienParente")
	public String getLienParente() {
		return lienParente;
	}

	public void setLienParente(String lienEleve) {
		this.lienParente = lienEleve;
	}

	@JsonIgnore 
	@ManyToMany(mappedBy = "responsables")
    public Set<Eleve> getEleves() {
		return this.eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}

	 
	@Override
	public String toString() {
		return "Responsable [cin=" + cin + "]";
	}

	 

}
