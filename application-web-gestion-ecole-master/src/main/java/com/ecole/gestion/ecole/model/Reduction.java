package com.ecole.gestion.ecole.model;

 

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "reduction", catalog = "gestionecole")
public class Reduction {

	private int idReduction;
	//private Tarif tarif;
	private float prctageReduction;
	private String typeReduction;

	public Reduction() {
	}

	public Reduction(int idReduction, Tarif tarifs) {
		this.idReduction = idReduction;
	//	this.tarif = tarifs;
	}

	public Reduction(int idReduction, Tarif tarifs, String prctageReduction, String typeReduction) {
		this.idReduction = idReduction;
		//this.tarif = tarifs;
		//this.prctageReduction = prctageReduction;
		this.typeReduction = typeReduction;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idReduction", unique = true, nullable = false)
	public int getIdReduction() {
		return this.idReduction;
	}

	public void setIdReduction(int idReduction) {
		this.idReduction = idReduction;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Tarifs_idTarifs", nullable = false)
//	public Tarif getTarifs() {
//		return this.tarif;
//	}
//
//	public void setTarifs(Tarif tarifs) {
//		this.tarif = tarifs;
//	}

	@Column(name = "prctageReduction", length = 45)
	public float getPrctageReduction() {
		return this.prctageReduction;
	}

	public void setPrctageReduction(float prctageReduction) {
		this.prctageReduction = prctageReduction;
	}

	@Column(name = "typeReduction", length = 45)
	public String getTypeReduction() {
		return this.typeReduction;
	}

	public void setTypeReduction(String typeReduction) {
		this.typeReduction = typeReduction;
	}

}
