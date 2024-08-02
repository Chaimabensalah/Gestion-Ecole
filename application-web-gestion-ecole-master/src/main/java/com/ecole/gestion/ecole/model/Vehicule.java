package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicule", catalog = "gestionecole")
public class Vehicule  {

	private int idVehicule;
	//private Transport transport;
	private String matricule;
	private String modele;
	private Date dateDachat;
	private boolean active;
	private String marque;
	//private Set<Chauffeur> chauffeurs = new HashSet<Chauffeur>(0);

	public Vehicule() {
	}

	public Vehicule(int idVehicule, Transport transport) {
		this.idVehicule = idVehicule;
		//this.transport = transport;
	}

	public Vehicule(int idVehicule, Transport transport, String matricule, String modele, Date dateDachat,
			Set<Chauffeur> chauffeurs) {
		this.idVehicule = idVehicule;
		//this.transport = transport;
		this.matricule = matricule;
		this.modele = modele;
		this.dateDachat = dateDachat;
		//this.chauffeurs = chauffeurs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idVehicule", unique = true, nullable = false)
	public int getIdVehicule() {
		return this.idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
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

	@Column(name = "Matricule", length = 45)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Column(name = "Modele", length = 45)
	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

 
	@Column(name = "Date_dachat", length = 10)
	public Date getDateDachat() {
		return this.dateDachat;
	}

	public void setDateDachat(Date dateDachat) {
		this.dateDachat = dateDachat;
	}

	@Column(name = "active", length = 45)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "marque", length = 45)
	public String getMarque() {
		return marque;
	}
	

	public void setMarque(String marque) {
		this.marque = marque;
	}

	
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule")
//	public Set<Chauffeur> getChauffeurs() {
//		return this.chauffeurs;
//	}
//
//	public void setChauffeurs(Set<Chauffeur> chauffeurs) {
//		this.chauffeurs = chauffeurs;
//	}
	
	

}
