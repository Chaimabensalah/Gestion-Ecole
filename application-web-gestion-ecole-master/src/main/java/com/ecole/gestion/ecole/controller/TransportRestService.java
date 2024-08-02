package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Transport;
import com.ecole.gestion.ecole.service.AideService;
import com.ecole.gestion.ecole.service.ChauffeurService;
import com.ecole.gestion.ecole.service.TransportService;

@RestController
public class TransportRestService {
	
	@Autowired 
	AideService aideService;
	
	@Autowired 
	ChauffeurService chauffeurService;
	
	@Autowired 
	TransportService transportService;

    // ------------------- sauvgarder une garde (prof,aide)-----------------------------------------------
	
 	@RequestMapping(value = "/transports/{matricule}/{matriculeAide}/{voiture}", method = RequestMethod.POST)
  	public void createGarde(@RequestBody Transport transport,@PathVariable("matricule") String matricule,@PathVariable("matriculeAide") String matriculeAide,@PathVariable("voiture") String voiture) {
 		 transportService.save(transport,matricule,matriculeAide,voiture);
 		}
 	
  //------------------------------get transports-----------------------------------------------
 	@RequestMapping(value = "/transports", method = RequestMethod.GET)
 	public List<Transport> getTransports() {
 		    
 		return transportService.findActive();
 				
 		}
 	
  // -------------------desable l'eleve par son id---------------------------------------------
	@RequestMapping(value = "/transports/{id}/desable", method = RequestMethod.GET)
	public Transport desableTransport(@PathVariable("id") int id) {
	    Transport t=transportService.findOne(id);
		t.setActive(false);
		return transportService.save(t);
		}

}
