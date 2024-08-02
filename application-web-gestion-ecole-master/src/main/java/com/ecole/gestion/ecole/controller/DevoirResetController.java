package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Devoir;
import com.ecole.gestion.ecole.model.Matiere;
import com.ecole.gestion.ecole.service.DevoirService;
import com.ecole.gestion.ecole.service.MatiereService;



@RestController
public class DevoirResetController {
	@Autowired
	DevoirService devoirService;
	
	@Autowired
	MatiereService matiereService;
	
	// ------------------- sauvgarder un devoir par matiere et classe---------------------------------------
	@RequestMapping(value = "/devoirs/{matiere}/{classe}", method = RequestMethod.POST)
	public Devoir saveDevoir(@RequestBody Devoir devoir,@PathVariable String matiere,@PathVariable String classe ) {
		return devoirService.saveDevoir(devoir,matiere,classe);
	}

	// ------------------- modifier un devoir----------------------------------------
	@RequestMapping(value = "/devoirs/", method = RequestMethod.PUT)
	public Devoir updateDevoir(@RequestBody Devoir devoir ) {
		Devoir devoiru=devoirService.findOne(devoir.getIdDevoir());
		devoiru.setIdDevoir(devoir.getIdDevoir());
		devoiru.setClasse(devoir.getClasse());
		devoiru.setDateDevoir(devoir.getDateDevoir());
		devoiru.setTache(devoir.getTache());
		devoiru.setMatiere(devoir.getMatiere());
		return devoirService.save(devoiru);
	}
	
	// ------------------- recuperer les devoirs par matiere---------------------------------------
	@RequestMapping(value = "/devoirs/matiere/{nomMatiere}", method = RequestMethod.GET)
	public List<Devoir> getDevoirsParMatiere(@PathVariable("nomMatiere") String nomMatiere) {
		Matiere matiere =matiereService.findByNom(nomMatiere);
		List <Devoir> devoirs =devoirService.findDevoirsParMatiere(matiere);
		return devoirs;
	}
	
	// ------------------- recuperer les devoirs d'un eleve---------------------------------------
	@RequestMapping(value = "/devoirs/eleve/{matricule}", method = RequestMethod.GET)
	public List<Devoir> getDevoirsParEleve(@PathVariable("matricule") String matricule) {
		List <Devoir> devoirs =devoirService.findDevoirsParEleve(matricule);
		return devoirs;
	}
	 
	// ------------------- recuperer un devoir par son id----------------------------------------
	@RequestMapping(value = "/devoirs/{idDevoir}", method = RequestMethod.GET)
	public Devoir getDevoirParId(@PathVariable("idDevoir") int idDevoir) {
		return devoirService.findOne(idDevoir);
	}
	
	// ------------------- Supprimer un devoir-----------------------------------------
	@RequestMapping(value = "/devoirs/sup/{id}", method = RequestMethod.DELETE)
	public  void deleteDevoir(@PathVariable("id") int id) {
		devoirService.delete(id);
	}
}
