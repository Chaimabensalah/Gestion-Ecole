package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Examen;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.ExamenService;

@RestController
public class ExamenRestController {
	
	@Autowired
	ExamenService examenService;
	
	@Autowired
	EleveService eleveService;
	
	// -------------------sauvgarderun examen pour une matiere et classe--------------------------------------------
	@RequestMapping(value = "/examens/{matiere}/{classe}", method = RequestMethod.POST)
	public Examen createExamen(@RequestBody Examen examen,@PathVariable String matiere,@PathVariable String classe ) {
		examenService.saveExam(examen,matiere,classe);
		return examen;
	}
	
	// -------------------recuperer  les examens d'un eleve---------------------------------------------
	@RequestMapping(value = "/examens/{matricule}", method = RequestMethod.GET)
	public List<Examen> getExamensParEleve(@PathVariable("matricule") String matricule) {
		List <Examen> examens=examenService.findByEleve(matricule);
		return examens;
	}
	
	// -------------------recuperer les examen dune matiere---------------------------------------------
	@RequestMapping(value = "/examens/matiere/{nomMatiere}", method = RequestMethod.GET)
	public List<Examen> getExamenParMatiere(@PathVariable("nomMatiere") String nomMatiere) {
		List <Examen> examens=examenService.findParMatiere(nomMatiere);
		return examens;
	}
	
	// -------------------get examen par id ---------------------------------------------
	@RequestMapping(value = "/examens/id/{idExamen}", method = RequestMethod.GET)
	public Examen getExamenParId(@PathVariable("idExamen") int idExamen) {
		return examenService.findOne(idExamen);
	}
		
	// ------------------- Supprimer un examen-----------------------------------------
	@RequestMapping(value = "/examens/{id}", method = RequestMethod.DELETE)
	public  void deleteExamen(@PathVariable("id") int id) {
		examenService.delete(id);
	}
}
