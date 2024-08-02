package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Contact;
import com.ecole.gestion.ecole.model.Facture;
import com.ecole.gestion.ecole.model.Fournisseur;
import com.ecole.gestion.ecole.service.FactureService;
import com.ecole.gestion.ecole.service.FournisseurService;
@RestController
public class FournisseurRestService {

	@Autowired
	FournisseurService fournisseurService;
	
	@Autowired
	FactureService factureService;
	
	// -------------------Recuperer liste des fournisseurs---------------------------------------------
	@RequestMapping(value="/fournisseurs",method=RequestMethod.GET)
	public List<Fournisseur> listFournisseur(){
		return fournisseurService.findActive();
	}
	
	// -------------------Recuperer liste des fournisseurs---------------------------------------------
		@RequestMapping(value="/fournisseurs/{id}",method=RequestMethod.GET)
		public Fournisseur Fournisseur(@PathVariable("id") int id){
			return fournisseurService.findOne(id);
		}

	// -------------------Creer un nv fournisseur-------------------------------------------
	@RequestMapping(value = "/fournisseurs/{cin}", method = RequestMethod.POST)
	public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur ,@PathVariable("cin") String cin) {
		fournisseurService.save(fournisseur,cin);
		return fournisseur;
	}
	
	// -------------------desable une facture par son id---------------------------------------------
	    @RequestMapping(value = "/fournisseurs/desable/{id}", method = RequestMethod.GET)
		public Fournisseur desableFournisseurParId(@PathVariable("id") int id) {
			 Fournisseur f=fournisseurService.findOne(id);
			 f.setActive(false);
			 return fournisseurService.save(f);
			 }
		
	    
// -------------------return contact fromfournisseur par son id---------------------------------------------
	    @RequestMapping(value = "/fournisseurs/{id}/contacts", method = RequestMethod.GET)
		public Contact contactFromFournisseurParId(@PathVariable("id") int id) {
			 Fournisseur f=fournisseurService.findOne(id);
			 
			 return f.getContact();
			 }
	
//================================factures==========================================
	
	// -------------------Creer un nv facture-------------------------------------------
		@RequestMapping(value = "/factures/{nomFournisseur}", method = RequestMethod.POST)
		public Facture createFacture(@RequestBody Facture facture,@PathVariable String nomFournisseur ) {
			return factureService.save(facture,nomFournisseur);
			 
		}
	//--------------------------list of factures------------------------------------------
		@RequestMapping(value="/factures",method=RequestMethod.GET)
		public List<Facture> listFactures(){
			return factureService.findActive();
			//return factureService.findAll();
		}
		
   //--------------------------une facture-----------------------------------------
		@RequestMapping(value="/factures/{id}",method=RequestMethod.GET)
		public Facture Facture(@PathVariable ("id") long id){
			return factureService.findOne(id);
				}
		
	// -------------------desable une facture par son id---------------------------------------------
		@RequestMapping(value = "/factures/desable/{id}", method = RequestMethod.GET)
		public Facture desablefactureParId(@PathVariable("id") long id) {
		 	 Facture facture=factureService.findOne(id);
		 	 facture.setActive(false);
		 	 factureService.save(facture);
		 	 return facture;
		 		}
   //--------------------------une facture-----------------------------------------
		@RequestMapping(value="/factures/fournisseur/{id}",method=RequestMethod.GET)
		public Fournisseur Fournisseur(@PathVariable ("id") long id){
			return factureService.findOne(id).getFournisseur();
						}
	
	
}
