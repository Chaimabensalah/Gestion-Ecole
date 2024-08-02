package com.ecole.gestion.ecole.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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
@Table(name = "niveau")
public class Niveau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idNiveau;
	private String niveau;
	//private Set<Unite> unites = new HashSet<Unite>(0);
	private Set<Eleve> eleves = new HashSet<Eleve>(0);
	//private Set<Classe> classes = new HashSet<Classe>(0);

	public Niveau() {
	}

	public Niveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}

	public Niveau(int idNiveau, String niveau,   Set<Eleve> eleves) {
		this.idNiveau = idNiveau;
		this.niveau = niveau;
		//this.unites = unites;
		//this.eleves = eleves;
		//this.classes = classes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idNiveau", unique = true, nullable = false)
	public int getIdNiveau() {
		return this.idNiveau;
	}

	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}

	@Column(name = "Niveau", length = 45)
	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "niveau_has_unite", catalog = "gestionecole", joinColumns = {
			@JoinColumn(name = "niveau_idNiveau", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "unite_idUnite", nullable = false, updatable = false) })
	public Set<Unite> getUnites() {
		return this.unites;
	}

	public void setUnites(Set<Unite> unites) {
		this.unites = unites;
	}8*/
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "niveau")
	public Set<Eleve> getEleves() {
		return this.eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "niveau")
	public Set<Classe> getClasses() {
		return this.classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}*/

}
