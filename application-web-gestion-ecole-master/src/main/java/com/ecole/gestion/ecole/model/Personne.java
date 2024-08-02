package com.ecole.gestion.ecole.model;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
 
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

@Entity
@Table(name = "personne", catalog = "gestionecole")
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class Personne implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPersonne;
	private String sexe;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String email;
	private String adresse;
	private String telephone;
	private String codePostale;
	private String ville;
	private String pays;
	private boolean active;
	
	//private boolean statut;
	//private Set<Professeur> professeurs = new HashSet<Professeur>(0);
	 
	public Personne() {
		super();
	}

	 

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPersonne", unique = true, nullable = false)
	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	

	@Column(name = "Sexe", length = 45)
	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Column(name = "Nom", length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Prenom", length = 45)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "DateDeNaissance", length = 45)
	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	@Column(name = "Email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Adresse", length = 45)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "telephone", length = 45)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String tel) {
		this.telephone = tel;
	}

	@Column(name = "CodePostale", length = 45)
	public String getCodePostale() {
		return this.codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	@Column(name = "Ville", length = 45)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "Pays", length = 45)
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Professeur> getProfesseurs() {
		return this.professeurs;
	}

	public void setProfesseurs(Set<Professeur> professeurs) {
		this.professeurs = professeurs;
	}
*/
	  
//	@Column(name = "statut", length = 45)
//	public boolean getStatut() {
//		return this.statut;
//	}
//
//	public void setStatut(boolean prenom) {
//		this.statut = prenom;
//	}
	
	@Column(name = "active", length = 45)
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", sexe=" + sexe + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDeNaissance=" + dateDeNaissance + ", email=" + email + ", adresse=" + adresse + ", tel=" + telephone
				+ ", codePostale=" + codePostale + ", ville=" + ville + ", pays=" + pays + "]";
	}

}
