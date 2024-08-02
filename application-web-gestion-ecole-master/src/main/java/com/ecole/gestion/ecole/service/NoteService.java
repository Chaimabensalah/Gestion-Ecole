package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Examen;
import com.ecole.gestion.ecole.model.Matiere;
import com.ecole.gestion.ecole.model.Note;

public interface NoteService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Note> arg0);

	void delete(Note arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Note> findAll();

	Iterable<Note> findAll(Iterable<Integer> arg0);

	Note findOne(Integer arg0);

	<S extends Note> Iterable<S> save(Iterable<S> arg0);

	<S extends Note> S save(S arg0);
	
	public <S extends Note> S saveNote(S arg0,String matiere ,String eleve) ;
	
	public List<Note> findByClasseAndMatiere(Classe classe ,Matiere matiere,Examen examen) ;

	List<Note> findByEleve(Eleve eleve, Matiere matiere);
	
	Note findByEleveD(Eleve eleve, Matiere matiere,Examen examen);

	Eleve findEleve(int idNote);

}