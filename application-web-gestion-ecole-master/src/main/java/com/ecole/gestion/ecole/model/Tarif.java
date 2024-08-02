package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tarif", catalog = "gestionecole")
public class Tarif {

	private int idTarif;
	//private Transport transport;
	private int montant;
	private String nomTarif;
	private Set<Garde> gardes = new HashSet<Garde>(0);
	private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	//private Set<Reduction> reductions = new HashSet<Reduction>(0);

	public Tarif() {
	}

	 
 
	public Tarif(String nomTarif, int montant) {
		this.montant = montant;
		this.nomTarif=nomTarif;
		}



	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTarif", unique = true, nullable = false)
	public int getIdTarif() {
		return this.idTarif;
	}

	public void setIdTarif(int idTarifs) {
		this.idTarif = idTarifs;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "transport_idTransport", nullable = false)
//	public Transport getTransport() {
//		return this.transport;
//	}
//
//	public void setTransport(Transport transport) {
//		this.transport = transport;
//	}

	@Column(name = "Montant", precision = 12, scale = 0)
	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	
	@Column(name = "nom_tarif")
	public String getNomTarif() {
		return nomTarif;
	}

	public void setNomTarif(String nomTarif) {
		this.nomTarif = nomTarif;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifs")
	public Set<Garde> getGardes() {
		return this.gardes;
	}

	public void setGardes(Set<Garde> gardes) {
		this.gardes = gardes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifs")
	public Set<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifs")
//	public Set<Reduction> getReductions() {
//		return this.reductions;
//	}
//
//	public void setReductions(Set<Reduction> reductions) {
//		this.reductions = reductions;
//	}

}
