package com.ecole.gestion.ecole.controller;

 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Responsable;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.FournisseurService;
import com.ecole.gestion.ecole.service.ResponsableService;
//import com.websystique.springmvc.model.User;

@RestController
 
public class ResponsableResetService {
	
		@Autowired
		ResponsableService responsableService;
		
		@Autowired
		EleveService eleveService;
		
		@Autowired
		FournisseurService fourniService;
 
		// ------------------- sauvgarder un responsable------------------------------------------------
		@RequestMapping(value = "/responsables", method = RequestMethod.POST)
  		public void saveresponsable(@RequestBody Responsable respo ) {
			respo.setActive(true);
 			responsableService.save(respo);
 		}
		
		// ------------------- recuperer un responsable par son cin---------------------------------------------
	 	@RequestMapping(value = "/responsables/{cin}", method = RequestMethod.GET)
	 	public Responsable getrespoParCin(@PathVariable("cin") String cin) {
	 		return responsableService.findParCin(cin);
	 		}
	 	
	    // ------------------- recuperer tout les responsables ----------------------------------------------	
	 	@RequestMapping(value = "/responsables", method = RequestMethod.GET)
	 	public List<Responsable> getAllResponsable() {
	 		return responsableService.findAll();
	 		}
	 	
	    // ------------------- modifier un responsable---------------------------------------------- 
	 	@RequestMapping(value = "/responsables/", method = RequestMethod.PUT)
	  	public Responsable updateResponsable(@RequestBody Responsable respo) {
		     Set<Eleve> eleves=new HashSet<Eleve>(0);
	 		 Eleve eleve=eleveService.findOne((long)35);
	 	     eleves.add(eleve);
	 		 respo.setEleves(eleves);
	 		 responsableService.save(respo);
	 		 return respo;
	 		}
}
