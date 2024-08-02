package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ecole.gestion.ecole.service.*;
import com.ecole.gestion.ecole.dao.FemmeDeMenageRepository;
import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;

 

@RestController
public class PersonneRestService {
	@Autowired
	ChauffeurRepository chauffeur;
	@Autowired
	FemmeDeMenageRepository menage;
	
	@Autowired
	GardienRepository gardien;
	
	@Autowired 
	SecretaireRepository secretaire;
	
	@Autowired
	GestionnaireRepository gestionnaire;
	
	@Autowired
	ProfesseurService professeur;
	
	@Autowired
	ResponsableService responsable;
	
	@Autowired
	AideRepository aide;
	
//========================sauvgarder===============================================================
	
	// -------------------sauvgarder un responsable menage-------------------------------------------
	 		@RequestMapping(value = "/femmeDeMenages", method = RequestMethod.POST)
	 		public FemmeDeMenage createRespoMenage(@RequestBody FemmeDeMenage f  ) {
	 	 		 return menage.save(f);
	 		}
	 		
   // -------------------sauvgarder un eleve---------------------------------------------
	 		@RequestMapping(value = "/professeurs", method = RequestMethod.POST)
	 		public Professeur createeleve(@RequestBody Professeur prof ) {
	 	 		 return professeur.save(prof);
	 		}
	
	// -------------------sauvgarder un eleve---------------------------------------------
	 		@RequestMapping(value = "/gardiens", method = RequestMethod.POST)
	 		public Gardien createGardien(@RequestBody Gardien g ) {
	 	 		 return gardien.save(g);
	 		}
	// -------------------sauvgarder un eleve---------------------------------------------
	 		@RequestMapping(value = "/secretaires", method = RequestMethod.POST)
	 		public Secretaire  createSecretaire(@RequestBody Secretaire s ) {
	 	 		 return secretaire.save(s);
	 		}
	// -------------------sauvgarder un eleve---------------------------------------------
	 		@RequestMapping(value = "/gestionnaires", method = RequestMethod.POST)
	 		public Gestionnaire createGestionnaire(@RequestBody Gestionnaire g ) {
	 	 		 return gestionnaire.save(g);
	 		}
	// -------------------sauvgarder un eleve---------------------------------------------
	 		@RequestMapping(value = "/chauffeurs", method = RequestMethod.POST)
	 		public Chauffeur createchauffeurs(@RequestBody Chauffeur c ) {
	 	 		 return chauffeur.save(c);
	 		}
	 // -------------------sauvgarder un eleve---------------------------------------------
	 		@RequestMapping(value = "/aides", method = RequestMethod.POST)
	 		public Aide createAide(@RequestBody Aide a) {
	 	 		 return aide.save(a);
	 		}
	
//=======================================================================================================	
//==============================affichage================================================================
	// -------------------get professeurs---------------------------------------------
		@RequestMapping(value = "/professeurs", method = RequestMethod.GET)
		public List<Professeur> getProf() {
			 
			return professeur.findActive() ;
		}
	

   // -------------------get chauffeur---------------------------------------------
		@RequestMapping(value = "/chauffeurs", method = RequestMethod.GET)
		public List<Chauffeur> getchauffeur() {
					 
			return chauffeur.findActive(true) ;
			}
		
	
   // -------------------get aides--------------------------------------------
		@RequestMapping(value = "/aides", method = RequestMethod.GET)
		public List<Aide> getAides() {
					 
			return aide.findActive(true) ;
			}
			

//   // -------------------get femmeDeMenages---------------------------------------------
		@RequestMapping(value = "/femmeDeMenages", method = RequestMethod.GET)
		public List<FemmeDeMenage> getfemmeDeMenages() {
							 
			return menage.findActive(true) ;
			}
		
      
   // -------------------get gardiens--------------------------------------------
		@RequestMapping(value = "/gardiens", method = RequestMethod.GET)
		public List<Gardien> getgardiens() {
							 
			return gardien.findActive(true) ;
			}
		
   // -------------------get gestionnaire---------------------------------------------
		@RequestMapping(value = "/gestionnaires", method = RequestMethod.GET)
		public List<Gestionnaire> getGestionnaire() {
							 
			return gestionnaire.findActive(true) ;
			}
	
  // -------------------get secretaire---------------------------------------------
		@RequestMapping(value = "/secretaires", method = RequestMethod.GET)
		public List<Secretaire> getScretaires() {
							 
			return secretaire.findActive(true) ;
			}
				
				
//======================desctiver ==================================================================
	// -------------------desable l'eleve par son id---------------------------------------------
	 		@RequestMapping(value = "/chauffeurs/{id}/desable", method = RequestMethod.GET)
	 		public Chauffeur desableCahuffeurParId(@PathVariable("id") long id) {
	 			Chauffeur a=chauffeur.findOne(id);
	 			a.setActive(false);
	 			return chauffeur.save(a) ;
	 		}
	
	// -------------------desable femme de menage par son id---------------------------------------------
	 		@RequestMapping(value = "/femmeDeMenages/{id}/desable", method = RequestMethod.GET)
	 		public FemmeDeMenage desableMenageParId(@PathVariable("id") long id) {
	 			FemmeDeMenage a=menage.findOne(id);
	 			a.setActive(false);
	 			return menage.save(a) ;
	 		}
	 		
	// -------------------desable gardien par son id---------------------------------------------
	 		@RequestMapping(value = "/gardiens/{id}/desable", method = RequestMethod.GET)
	 		public Gardien desableGardienParId(@PathVariable("id") long id) {
	 			Gardien a=gardien.findOne(id);
	 			a.setActive(false);
	 			return gardien.save(a);
	 		}
	
	// -------------------desable Secretaire par son id---------------------------------------------
	 		@RequestMapping(value = "/secretaires/{id}/desable", method = RequestMethod.GET)
	 		public Secretaire desableSecretaireParId(@PathVariable("id") long id) {
	 			Secretaire a=secretaire.findOne(id);
	 			a.setActive(false);
	 			return secretaire.save(a) ;
	 		}
	 
	 // -------------------desable Gestionnaire par son id---------------------------------------------
	 		@RequestMapping(value = "/gestionnaires/{id}/desable", method = RequestMethod.GET)
	 		public Gestionnaire desableGestionnaireParId(@PathVariable("id") long id) {
	 			Gestionnaire a=gestionnaire.findOne(id);
	 			a.setActive(false);
	 			return gestionnaire.save(a);
	 		}
	 		
	 // -------------------desable prof par son id---------------------------------------------
	 		@RequestMapping(value = "/professeurs/{id}/desable", method = RequestMethod.GET)
	 		public Professeur desableProfesseurParId(@PathVariable("id") long id) {
	 			Professeur a=professeur.findOne(id);
	 			a.setActive(false);
	 			return professeur.save(a) ;
	 		}
	 		
	 // -------------------desable aide par son id---------------------------------------------
	 		@RequestMapping(value = "/aides/{id}/desable", method = RequestMethod.GET)
	 		public Aide desableAideParId(@PathVariable("id") long id) {
	 			Aide a=aide.findOne(id);
	 			a.setActive(false);
	 			return aide.save(a) ;
	 		}
//---------------------------------get per id-------------------------------------------
	 		//secretaire
	 		@RequestMapping(value = "/secretaires/{id}", method = RequestMethod.GET)
	 		public Secretaire getSecretaireParId(@PathVariable("id") long id) {
	 			Secretaire a=secretaire.findOne(id);
	 			return a ;
	 		}
	 		
	 		//---------------------------------get per id-------------------------------------------
	 		@RequestMapping(value = "/responsables/one/{id}", method = RequestMethod.GET)
	 		public Responsable getResponsableParId(@PathVariable("id") long id) {
	 			return responsable.findOne(id);
	 			 
	 		}
}
