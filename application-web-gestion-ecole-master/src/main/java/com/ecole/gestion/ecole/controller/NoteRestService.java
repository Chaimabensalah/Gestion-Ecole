package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Examen;
import com.ecole.gestion.ecole.model.Matiere;
import com.ecole.gestion.ecole.model.Note;
import com.ecole.gestion.ecole.service.ClasseService;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.ExamenService;
import com.ecole.gestion.ecole.service.MatiereService;
import com.ecole.gestion.ecole.service.NoteService;

@RestController
public class NoteRestService {

	@Autowired
	NoteService noteService;
	
	@Autowired
	MatiereService matiereService;
	
	@Autowired
	ClasseService classeService;
	
	@Autowired
	EleveService eleveService;
	
	@Autowired
	ExamenService examenService;

	// ------------------- Sauvgarder  une note----------------------------------------
	@RequestMapping(value = "/notes/{matiere}/{eleve}", method = RequestMethod.POST)
	public Note createNote(@RequestBody Note note,@PathVariable String matiere,@PathVariable String eleve ) {
		noteService.saveNote(note,matiere,eleve);
		return note;
	}
	
	// ------------------- recuperer les notes par classe et matiere----------------------------------------
	@RequestMapping(value = "/notes/{nomClasse}/{nomMatiere}", method = RequestMethod.GET)
	public List<Note> getNoteParMatiereAndClasse(@PathVariable("nomClasse") String nomClasse,@PathVariable("nomMatiere") String nomMatiere) {
		Matiere matiere =matiereService.findByNom(nomMatiere);
		Classe classe =classeService.findByNom(nomClasse);
		Examen examen =examenService.findOne(1);
		List <Note> notes =noteService.findByClasseAndMatiere(classe,matiere,examen);
		return notes;
	}

	// ------------------- recupere les notes d'un eleve par matiere----------------------------------------
	@RequestMapping(value = "/notes/eleve/{matricule}/{nomMatiere}", method = RequestMethod.GET)
	public List<Note> getNoteParMatiere(@PathVariable("matricule") String matricule,@PathVariable("nomMatiere") String nomMatiere) {
		Matiere matiere =matiereService.findByNom(nomMatiere);
		Eleve eleve=eleveService.findByMatricule(matricule);
		List <Note> notes =noteService.findByEleve(eleve, matiere);
		return notes;
	}
	
	// ------------------- recuperer l'eleve apartir dune note ----------------------------------------
	@RequestMapping(value = "/notes/{idNote}/eleve", method = RequestMethod.GET)
	public Eleve getEleveFromNote(@PathVariable("idNote") int idNote) {
	    Eleve eleve=noteService.findEleve(idNote);
		return eleve;
	}
	
	// ------------------- Supprimer une note----------------------------------------
	@RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
	public  void deleteNotes(@PathVariable("id") int id) {
		noteService.delete(id);
	}
	
	// ------------------- recuperer  une note----------------------------------------
	@RequestMapping(value = "/notes/{idNote}", method = RequestMethod.GET)
	public Note getNoteParId(@PathVariable("idNote") int idNote) {
		return noteService.findOne(idNote);
	}
}
