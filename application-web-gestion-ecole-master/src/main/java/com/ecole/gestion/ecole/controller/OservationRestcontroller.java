package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Observation;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.ObservationService;

@RestController
public class OservationRestcontroller {
	
	@Autowired
	ObservationService observationService;
	
	@Autowired
	EleveService eleveService;
	
	// ------------------- sauvgarder lobservation par eleve et matiere----------------------------------------
	@RequestMapping(value = "/observations/{matiere}/{eleve}", method = RequestMethod.POST)
	public Observation createObservation(@RequestBody Observation observation,@PathVariable String matiere,@PathVariable String eleve ) {
		observationService.saveObservation(observation,matiere,eleve);
		return observation;
	}
	
	// ------------------- les observation d'un eleve----------------------------------------
	@RequestMapping(value = "/observations/eleve/{matricule}", method = RequestMethod.GET)
	public List<Observation> getObservationsParEleve(@PathVariable("matricule") String matricule) {
       Eleve eleve=eleveService.findByMatricule(matricule);	
       List<Observation> observations=observationService.findByEleve(eleve);
		return observations;
	}
	
	// ------------------- observation par id----------------------------------------
	@RequestMapping(value = "/observations/{idObservation}", method = RequestMethod.GET)
	public Observation getObservationById(@PathVariable("idObservation") int idObservation) {
		return observationService.findOne(idObservation);
	}
	
	// ------------------- Supprimer une observation-----------------------------------------
	@RequestMapping(value = "/observations/{id}", method = RequestMethod.DELETE)
	public  void deleteObservation(@PathVariable("id") int id) {
			observationService.delete(id);
		}
}
