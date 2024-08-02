package com.ecole.gestion.ecole.model;


import static javax.persistence.GenerationType.IDENTITY;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "note", catalog = "gestionecole")
public class Note {

	private int idNote;
	private Examen examen;
	private String noteExam;
	private String remarque;
	private Eleve eleve;
	private Matiere matiere;
	//private Set<Bulletin> bulletins = new HashSet<Bulletin>(0);

	public Note() {
	}

	 

	public Note(int idNote,  String noteExam, String remarque) {
		this.idNote = idNote;
		//this.examen = examen;
		this.noteExam = noteExam;
		this.remarque = remarque;
		//this.bulletins = bulletins;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idNote", unique = true, nullable = false)
	public int getIdNote() {
		return this.idNote;
	}

	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Examen_idExamen")
	public Examen getExamen() {
		return this.examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Column(name = "NoteExam", length = 45)
	public String getNoteExam() {
		return this.noteExam;
	}

	public void setNoteExam(String noteExam) {
		this.noteExam = noteExam;
	}

	@Column(name = "Remarque", length = 45)
	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Eleve_idPersonne")
	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matiere_idMatiere")
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	

	 

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
//	public Set<Bulletin> getBulletins() {
//		return this.bulletins;
//	}
//
//	public void setBulletins(Set<Bulletin> bulletins) {
//		this.bulletins = bulletins;
//	}
	
	

}
