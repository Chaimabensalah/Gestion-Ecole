package com.ecole.gestion.ecole.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Examen;
import com.ecole.gestion.ecole.model.Matiere;
import com.ecole.gestion.ecole.model.Note;

@Service
public class NoteMetierImpl implements NoteService {
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private EleveService eleveService;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	 

	@Override
	public long count() {
		return noteRepository.count();
	}

	@Override
	public void delete(Integer arg0) {
		noteRepository.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends Note> arg0) {
		noteRepository.delete(arg0);
	}

	@Override
	public void delete(Note arg0) {
		noteRepository.delete(arg0);
	}

	@Override
	public void deleteAll() {
		noteRepository.deleteAll();
	}

	@Override
	public boolean exists(Integer arg0) {
		return noteRepository.exists(arg0);
	}

	@Override
	public Iterable<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public Iterable<Note> findAll(Iterable<Integer> arg0) {
		return noteRepository.findAll(arg0);
	}

	@Override
	public Note findOne(Integer arg0) {
		return noteRepository.findOne(arg0);
	}

	@Override
	public <S extends Note> Iterable<S> save(Iterable<S> arg0) {
		return noteRepository.save(arg0);
	}

	@Override
	public <S extends Note> S save(S arg0) {
		return noteRepository.save(arg0);
	}

	@Override
	public <S extends Note> S saveNote(S arg0,String matiere ,String eleve) {
		arg0.setEleve(eleveRepository.findByMatricule(eleve));
		arg0.setMatiere(matiereRepository.findByNom(matiere));
		return noteRepository.save(arg0);
	}
	
	@Override
	public List<Note> findByClasseAndMatiere(Classe classe ,Matiere matiere,Examen examen) {
	//	List<Note>notes=null;
		
		//List<Eleve> eleves=eleveService.findElevesParClasse(classe);
		List<Note>notes=noteRepository.findParClasse(classe,matiere);
		
		return notes;
		
	}
	
	@Override
	public Note findByEleveD(Eleve eleve,Matiere matiere,Examen examen) { 
		
	return  noteRepository.findByEleveD(eleve, matiere,examen);
			
	}

	@Override
	public List<Note> findByEleve(Eleve eleve, Matiere matiere) {
		return  noteRepository.findByEleve(eleve, matiere);
	}

	@Override
	public Eleve findEleve(int idNote) {
		Note note=noteRepository.findOne(idNote);
		Eleve eleve =note.getEleve();
		return eleve;
	}
	
	
}
