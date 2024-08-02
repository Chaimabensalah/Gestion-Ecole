package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
 
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paiement", catalog = "gestionecole")
public class Paiement  {

	private int idPaiement;
	//private Garde garde;
	//private boolean paye;
	private String typeService;
	private float montant;
	private String modePaiement;//cheque espece ,virement
	private Inscription inscription;
	private String numCheque;
	private Date datePaiment;
	private String numRecu;
	private String mois;
	//private int typePaiement;
	//private int resteAPaye;
	private Eleve eleve;
	//private Set<Typepaiement> typepaiements = new HashSet<Typepaiement>(0);
	//private Set<Facture> factures = new HashSet<Facture>(0);
	//private Set<Transport> transports = new HashSet<Transport>(0);

	public Paiement() {
	}

	public Paiement(int idPaiement, Garde garde, boolean paye) {
		this.idPaiement = idPaiement;
	//	this.garde = garde;
		//this.paye = paye;
	}

	public Paiement(int idPaiement, Garde garde, boolean paye, Set<Inscription> inscriptions,
			 Set<Facture> factures, Set<Transport> transports) {
		this.idPaiement = idPaiement;
	//	this.garde = garde;
		//this.paye = paye;
	//	this.inscriptions = inscriptions;
		//this.typepaiements = typepaiements;
		//this.factures = factures;
		//this.transports = transports;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPaiement", unique = true, nullable = false)
	public int getIdPaiement() {
		return this.idPaiement;
	}

	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "garde_idGarde", nullable = false)
//	public Garde getGarde() {
//		return this.garde;
//	}
//
//	public void setGarde(Garde garde) {
//		this.garde = garde;
//	}

//	@Column(name = "Paye", nullable = false)
//	public boolean isPaye() {
//		return this.paye;
//	}
//
//	public void setPaye(boolean paye) {
//		this.paye = paye;
//	}
	
	 
	
	
	@Column(name = "montant", nullable = false)
	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	
	@Column(name = "modePaiement", nullable = false)
	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiment) {
		this.modePaiement = modePaiment;
	}
	@OneToOne(fetch = FetchType.LAZY)
	public Inscription getInscription() {
		return this.inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	
	@Column(name = "numCheque")
	public String getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(String numchaque) {
		this.numCheque = numchaque;
	}
	
	@Column(name = "datePaiement", nullable = false)
	public Date getDatePaiment() {
		return datePaiment;
	}

	public void setDatePaiment(Date datePaiment) {
		this.datePaiment = datePaiment;
	}
	
	@Column(name = "numRecu")
	public String getNumRecu() {
		return numRecu;
	}

	public void setNumRecu(String numRecu) {
		this.numRecu = numRecu;
	}
	
	

//	@Column(name = "typePaiement")
//	public int getTypePaiement() {
//		return typePaiement;
//	}
//
//	public void setTypePaiement(int typePaiment) {
//		this.typePaiement = typePaiment;
//	}
	
//	@Column(name = "reste_a_paye")
//	public int getResteAPaye() {
//		return resteAPaye;
//	}
//
//	public void setResteAPaye(int resteAPaye) {
//		this.resteAPaye = resteAPaye;
//	}

	@Column(name = "service")
	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	@Column(name = "mois")
	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois =mois;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
	
	
	
	
	

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paiement")
//	public Set<Typepaiement> getTypepaiements() {
//		return this.typepaiements;
//	}
//
//	public void setTypepaiements(Set<Typepaiement> typepaiements) {
//		this.typepaiements = typepaiements;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paiement")
//	public Set<Facture> getFactures() {
//		return this.factures;
//	}
//
//	public void setFactures(Set<Facture> factures) {
//		this.factures = factures;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paiement")
//	public Set<Transport> getTransports() {
//		return this.transports;
//	}
//
//	public void setTransports(Set<Transport> transports) {
//		this.transports = transports;
//	}

}
