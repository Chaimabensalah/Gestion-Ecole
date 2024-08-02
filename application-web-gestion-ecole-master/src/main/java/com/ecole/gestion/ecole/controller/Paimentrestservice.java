package com.ecole.gestion.ecole.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ecole.gestion.ecole.model.Paiement;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.InscriptionService;
import com.ecole.gestion.ecole.service.PaiementService;

@RestController
public class Paimentrestservice {
	@Autowired
	PaiementService paiementService;
	
	@Autowired
	EleveService eleveService;
	
	@Autowired
	InscriptionService inscriptionService;
	
	// -------------------absence d'un eleve  par matiere------------------------------------------
	@RequestMapping(value = "/paiements/{email}/{typePaiement}", method = RequestMethod.POST)
	public Paiement createPaiment(@RequestBody Paiement paiement,@PathVariable("email") String email,@PathVariable("typePaiement") int typePaiement) {

		return paiementService.save(paiement,email,typePaiement);
		 
	}
	@RequestMapping(value = "/paiements/service/{id}/{nomService}", method = RequestMethod.POST)
	public Paiement createPaimentwithService(@RequestBody Paiement paiement,@PathVariable("id") long id,@PathVariable("nomService") String nomService) {

		return paiementService.save(paiement,id,nomService);
		 
	}
	
	// -------------------recuperer  les periode paye et non paye dun eleve---------------------------------------------
//		@RequestMapping(value = "/paiement/reste/{matricule}", method = RequestMethod.GET)
//		public List<Integer> getPaiementParEleve(@PathVariable("matricule") String matricule) {
//			return paiementService.getPaiementParEleve(matricule);
//		}
}
