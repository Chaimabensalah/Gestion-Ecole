package com.ecole.gestion.ecole.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Inscription;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.InscriptionService;

@RestController
public class InscriptionRestService {
	
	@Autowired
	InscriptionService inscriptionService;
	
	@Autowired
	EleveService eleveService;
	
	// ------------------- cree un contact associe a un fournisseur----------------------------------------
	@RequestMapping(value = "/inscriptions/{email}", method = RequestMethod.POST)
	public Inscription createInscription(@RequestBody Inscription inscription,@PathVariable String email ) {
		
		
		return inscriptionService.save(inscription,email);
	 }
	
	// ------------------- tout les inscriptions----------------------------------------
	@RequestMapping(value = "/inscriptions", method = RequestMethod.GET)
	public List<Inscription> allInscriptions(  ) {
			
		return inscriptionService.findAll();
	}
	
	// -------------------current inscriptions----------------------------------------
		@RequestMapping(value = "/inscriptions/{email}", method = RequestMethod.GET)
		public Inscription currentInscriptions(@PathVariable ("email") String email) {
				
			return eleveService.findCurrentInscription(eleveService.findByemail(email));
		}
	
	
	

}
