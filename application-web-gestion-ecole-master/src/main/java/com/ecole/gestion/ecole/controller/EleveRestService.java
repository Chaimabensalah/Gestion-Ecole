package com.ecole.gestion.ecole.controller;


import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.dao.ResponsableRepository;
import com.ecole.gestion.ecole.model.*;
//import com.websystique.springboot.model.User;
import com.ecole.gestion.ecole.service.*;

@RestController

public class EleveRestService {

	@Autowired
	EleveService eleveService; 
	
	@Autowired 
	ResponsableService responsableService;
	
	@Autowired 
	ClasseService classeService;
	
	@Autowired 
	InscriptionService inscriptionService;
	
	@Autowired
	ResponsableRepository responsableRepository;
	
	@Autowired 
	NiveauService niveauService;
	
	// -------------------recuperer tout les eleves---------------------------------------------
	@RequestMapping(value="/eleves",method=RequestMethod.GET)
	public List<Eleve> listEleves( ){
		return eleveService.findActive();
	}

	// -------------------recuperer les eleves d'une classe---------------------------------------------
    	@RequestMapping(value = "/eleves/{nomClasse}", method = RequestMethod.GET)
 		public List<Eleve> getEleveFormClasse(@PathVariable("nomClasse") String nomClasse) {
 			Classe classe =classeService.findByNom(nomClasse);
 			List<Eleve> eleves=eleveService.findElevesParClasse(classe);
 			return eleves;
 		}
    	
    	// -------------------sauvgarder un eleve---------------------------------------------
 		@RequestMapping(value = "/eleves", method = RequestMethod.POST)
 		public Eleve createeleve(@RequestBody Eleve eleve  ) {
 	 		 return eleveService.save(eleve);
 		}
 		
 	// -------------------sauvgarder leleve avec le relation entre eleve et responsable---------------------------------------------
 		@RequestMapping(value = "/eleves/{cin}/{idNiveau}/{cin2}", method = RequestMethod.POST)
 		public Eleve createEleve(@RequestBody Eleve eleve ,@PathVariable("cin") String cin,@PathVariable("idNiveau") int id,@PathVariable("cin2") String cin2) {
 			eleve.setNiveau(niveauService.findOne(id));
 			eleve.setActive(true);
 			eleve.setMatricule(generateId(eleve.getNom()));
 			eleveService.save(eleve);
 		    eleve.getResponsables().add(responsableService.findParCin(cin));
 		    eleve.getResponsables().add(responsableService.findParCin(cin2));
 		     
 		    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
 			Inscription inscription=new Inscription();
 			inscription.setDateInscription(date);
 			inscription.setEleve(eleve);
 			inscription.setValide(false);
 			inscription.setCurrent(true);
 			inscriptionService.save(inscription);
 	 		return eleveService.save(eleve);
 		}
 	// -------------------recuperer l'eleve par son email---------------------------------------------
 		@RequestMapping(value = "/eleves/email/{email}", method = RequestMethod.GET)
 		public Eleve getEleveParEmail(@PathVariable("email") String email) {
 			return eleveService.findByemail(email);
 		}
 	// -------------------recuperer l'eleve par son id---------------------------------------------
 		@RequestMapping(value = "/eleves/one/{id}", method = RequestMethod.GET)
 		public Eleve getEleveParId(@PathVariable("id") long id) {
 			Eleve eleve=eleveService.findOne(id);;
 			return eleve;
 		}
 		
 	// -------------------desable l'eleve par son id---------------------------------------------
 		@RequestMapping(value = "/eleves/desable/{id}", method = RequestMethod.GET)
 		public Eleve desableEleveParId(@PathVariable("id") long id) {
 			Eleve eleve=eleveService.findOne(id);
 			eleve.setActive(false);
 			return eleve;
 		}
 		
 	//generate the matricule
 		public String generateId(String nom){
 			long randomId = 0;
 			Random rand = new Random(); 
 			      String d=nom.substring(0,3);
 			      randomId = rand.nextLong()/1000000000;  
 			      randomId=randomId/100000;
 			      
 			      if(randomId<0) {randomId=-randomId;}
 		 
 			return d+randomId; 
 			}
 		 
}
