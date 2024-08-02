package com.ecole.gestion.ecole.controller;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Garde;
import com.ecole.gestion.ecole.model.Professeur;
import com.ecole.gestion.ecole.service.AideService;
import com.ecole.gestion.ecole.service.GardeService;
import com.ecole.gestion.ecole.service.ProfesseurService;
//import com.websystique.springmvc.model.User;

@RestController
 
public class GardeResetService {
	
		@Autowired 
		AideService aideService;
		
		@Autowired 
		ProfesseurService profService;
		
		@Autowired 
		GardeService gardeService;
 
   // ------------------- sauvgarder une garde (prof,aide)-----------------------------------------------
	 	@RequestMapping(value = "/gardes/{matricule}/{matriculeAide}", method = RequestMethod.POST)
	  	public void createGarde(@RequestBody Garde garde,@PathVariable("matricule") String matricule,@PathVariable("matriculeAide") String matriculeAide) {
	 		 gardeService.save(garde,matricule,matriculeAide);
	 		}
	 	
  //------------------------------get gardes----------------------------------------------
 		@RequestMapping(value = "/gardes", method = RequestMethod.GET)
 		public List<Garde> getGardes() {
 		    
 			return gardeService.findActive();
 			}
 // -------------------desable l'eleve par son id---------------------------------------------
 		@RequestMapping(value = "/gardes/{id}/desable", method = RequestMethod.GET)
 		public Garde desableGarde(@PathVariable("id") long id) {
 			Garde g=gardeService.findOne(id);
 			g.setActive(false);
 			return gardeService.save(g);
 		}
 		
 //------------------------------get garde par id----------------------------------------------
 		@RequestMapping(value = "/gardes/{id}", method = RequestMethod.GET)
 		public Garde getGarde(@PathVariable("id") long id) {
 		    
 			return gardeService.findOne(id);
 			}
 		
//------------------------------get garde par id----------------------------------------------
 		@RequestMapping(value = "/gardes/prof/{id}", method = RequestMethod.GET)
 		public Professeur getProfFromGarde(@PathVariable("id") long id) {
 		    
 			return gardeService.findProf(id);
 			}

}