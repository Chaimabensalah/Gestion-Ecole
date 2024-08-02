package com.ecole.gestion.ecole.model;

 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "directeur", catalog = "gestionecole")
@PrimaryKeyJoinColumn(name = "idPersonne")
public class Directeur extends Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Salaire salaire;
	//private String matricule;
	private String cin;
	//private Set<Personne> personnes = new HashSet<Personne>(0);

	public Directeur() {
	}

	 

	public Directeur(  String matricule, String cin ) {
		//this.salaire = salaire;
		//this.matricule = matricule;
		this.cin = cin;
		//this.personnes = personnes;
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

	 

}
