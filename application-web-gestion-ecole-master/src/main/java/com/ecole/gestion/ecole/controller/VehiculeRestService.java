package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Vehicule;
import com.ecole.gestion.ecole.service.VehiculeService;

@RestController
public class VehiculeRestService {
	
	@Autowired
	VehiculeService vehiculeService;
	
	//---------------------save vehicules---------------------------------------
	@RequestMapping(value = "/vehicules", method = RequestMethod.POST)
  	public void createVehiule(@RequestBody Vehicule vehicule) {
		vehicule.setActive(true);
 		 vehiculeService.save(vehicule);
 		}
	
	
	// -------------------desable l'eleve par son id---------------------------------------------
	 @RequestMapping(value = "/vehicules/desable/{id}", method = RequestMethod.GET)
	 public Vehicule desableVehiculeParId(@PathVariable("id") int id) {
	 		Vehicule vehicule=vehiculeService.findOne(id);
	 		vehicule.setActive(false);
	 		return vehiculeService.save(vehicule);
	 		}
	 
	// ------------------- liste of vehicules--------------------------------------------
	 @RequestMapping(value = "/vehicules", method = RequestMethod.GET)
	 public List<Vehicule> voitures() {
		 
			return vehiculeService.findActive();
		}
	 
	// ------------------- liste of vehicules--------------------------------------------
	 @RequestMapping(value = "/vehicules/{id}", method = RequestMethod.GET)
	 public Vehicule voiture(@PathVariable("id") int id) {
			 
				return vehiculeService.findOne(id);
			}


}
