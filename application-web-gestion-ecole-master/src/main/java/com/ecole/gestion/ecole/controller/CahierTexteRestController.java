package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.CahierTexte;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.service.CahierTexteService;
import com.ecole.gestion.ecole.service.ClasseService;;

@RestController
public class CahierTexteRestController {
	
	@Autowired
	CahierTexteService cahierTexteService;
	
	@Autowired
	ClasseService classeService;
	
	// ------------------- cahier de texte par matiere et classe----------------------------------------
	@RequestMapping(value = "/cahierTextes/{matiere}/{classe}", method = RequestMethod.POST)
	public CahierTexte createCahierTexte(@RequestBody CahierTexte cahierTexte,@PathVariable String matiere,@PathVariable String classe ) {
		cahierTexteService.saveCahierText(cahierTexte,matiere,classe);
		return cahierTexte;
	}
	
	// ------------------- cahier de texte d'une classe----------------------------------------
	@RequestMapping(value = "/cahierTextes/classe/{nomClasse}", method = RequestMethod.GET)
	public CahierTexte getCahierTextePerClasse(@PathVariable("nomClasse") String nomClasse) {
		Classe classe=classeService.findByNom(nomClasse);
		CahierTexte cahierTexte=cahierTexteService.findCahierParClasse(classe);
		return cahierTexte;
	}
	
	// -------------------  cahier de texte par matiere---------------------------------------
	@RequestMapping(value = "/cahierTextes/matiere/{nomMatiere}", method = RequestMethod.GET)
	public List<CahierTexte> getCahierTextePerMatiere(@PathVariable("nomMatiere") String nomMatiere) {
		List<CahierTexte> cahierTextes=cahierTexteService.findCahierParMatiere(nomMatiere);
		return cahierTextes;
	}
	
	// ------------------- tout les cahiers de texte----------------------------------------
	@RequestMapping(value = "/cahierTextes", method = RequestMethod.GET)
	public List<CahierTexte> getAllCahierTexte() {
		return  cahierTexteService.findAll();
	}
	
	// ------------------- cahier de texte par id ----------------------------------------
	@RequestMapping(value = "/cahierTextes/{id}", method = RequestMethod.GET)
	public CahierTexte getCahierTexteParId(@PathVariable("id") int idCahierTexte) {
		return  cahierTexteService.findOne(idCahierTexte);
	}

	// ------------------- Supprimer un cahier de texte----------------------------------------
	@RequestMapping(value = "/cahierTextes/{id}", method = RequestMethod.DELETE)
	public  void deleteCahierTexte(@PathVariable("id") int id) {
		cahierTexteService.delete(id);
	}
	
	

}
