package com.ecole.gestion.ecole.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Servicee;
import com.ecole.gestion.ecole.service.ServiceMetier;

@RestController
public class ServiceRestApi {
	@Autowired
	ServiceMetier serviceMetier;
	
	// ------------------- inscription dun eleve dans un service   -----------------------------------------
	   @RequestMapping(value = "/servicees/{idPersonne}", method = RequestMethod.POST)
	   public Servicee createservice(@RequestBody Servicee service,@PathVariable("idPersonne") long idPersonne ) {
		    return serviceMetier.save(service,idPersonne);
			
			}
	   
	// ------------------- inscription dun eleve dans un service   -----------------------------------------
	   @RequestMapping(value = "/servicees/mois/{idPersonne}/{nomService}", method = RequestMethod.GET)
	   public int getMoisNomPaye(@PathVariable("idPersonne") long idPersonne,@PathVariable("nomService") String nomService ) {
		     
			return serviceMetier.findMoisNomPaye(idPersonne, nomService);
			}
	   
	// ------------------- inscription dun eleve dans un service   -----------------------------------------
	   @RequestMapping(value = "/servicees/{idPersonne}", method = RequestMethod.GET)
	   public List<Servicee> getserviceParEleve(@PathVariable("idPersonne") long idPersonne ) {
		     
			return serviceMetier.findServiceParEleve(idPersonne);
			}
	   

}
