package com.ecole.gestion.ecole.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "service", catalog = "gestionecole")
public class Servicee {
	
	 private int idService;
	 private String nomService;
	// private int typePaiement;
	 private int paye;
	 private int restAPye;
	 private Eleve eleve;
	 
	 
	 public Servicee() {}
	 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idService", length = 45)
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	@Column(name = "nomService", length = 45)
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomservice) {
		this.nomService = nomservice;
	}
	
//	@Column(name = "typePaiement", length = 45)
//	public int getTypePaiement() {
//		return typePaiement;
//	}
//
//	public void setTypePaiement(int typePaiement) {
//		this.typePaiement = typePaiement;
//	} 
	
	@Column(name = "paye", length = 45)
	public int getPaye() {
		return paye;
	}

	public void setPaye(int paye) {
		this.paye = paye;
	}
	
	@Column(name = "resteApye", length = 45)
	public int getRestAPye() {
		return restAPye;
	}
	public void setRestAPye(int restAPye) {
		this.restAPye = restAPye;
	}
	 
	@OneToOne(fetch = FetchType.LAZY)
	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	 
	 

}
