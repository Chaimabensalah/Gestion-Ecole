package com.ecole.gestion.ecole.controller;


 
import java.security.Principal;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.ecole.gestion.ecole.model.Absence;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Matiere;
import com.ecole.gestion.ecole.model.Retard;
import com.ecole.gestion.ecole.service.AbsenceService;
import com.ecole.gestion.ecole.service.EleveService;
import com.ecole.gestion.ecole.service.MatiereService;
import com.ecole.gestion.ecole.service.RetardService;
 

@RestController
public class AbsenceRetardResetController {
		@Autowired
		AbsenceService absenceService;
	
		@Autowired
		RetardService retardService;
	
		@Autowired
		MatiereService matiereService;
	
		@Autowired
		EleveService eleveService;
		 
		 @RequestMapping("/user")
		  public Principal user(Principal user) {
		    return user;
		  }
		 
	// -------------------absence d'un eleve  par matiere------------------------------------------
	   @RequestMapping(value = "/absences/{eleve}/{matiere}", method = RequestMethod.POST)
	   public Absence createabsence(@RequestBody Absence absence,@PathVariable String eleve,@PathVariable String matiere ) {
			absenceService.saveAbsence(absence,eleve,matiere);
			return absence;
			}
	   
	// -------------------retard d'un eleve  par matiere------------------------------------------
	   @RequestMapping(value = "/retards/{eleve}/{matiere}", method = RequestMethod.POST)
	   public Retard createRetard(@RequestBody Retard retard,@PathVariable String eleve,@PathVariable String matiere ) {
		    retardService.saveRetard(retard,eleve,matiere);
		    return retard;
	   		}
	
   // -------------------Absence par matiere------------------------------------------
		@RequestMapping(value = "/absences/{id}/matiere", method = RequestMethod.GET)
		public Matiere getAbsenceParMatiere(@PathVariable("id") int id) {
			Absence a=absenceService.findOne(id);
			Matiere matiere=a.getMatiere();
			return matiere;
			}
		
   // -------------------Absence par matiere------------------------------------------
		@RequestMapping(value = "/absences/justifier/{id}", method = RequestMethod.GET)
		public Absence justifier(@PathVariable("id") int id) {
			Absence a=absenceService.findOne(id);
			a.setJustife(true);
			absenceService.save(a);
			return a;
			}

	// ------------------- absence par idEleve------------------------------------------
		@RequestMapping(value = "/absences/{id}/eleve", method = RequestMethod.GET)
		public Eleve getEleveFromAbsence(@PathVariable("id") int id) {
			Absence a=absenceService.findOne(id);
			Eleve eleve  =a.getEleve();
			return eleve;
			}
   // ------------------- tout les absences-----------------------------------------
//			@RequestMapping(value = "/absences", method = RequestMethod.GET)
//			public List<Absence> getEleve() {
//				return absenceService.findAll();
//				 
//			}
			
	// ------------------- les absence d'un eleve-----------------------------------------
		@RequestMapping(value = "/absences/eleve/{matricule}", method = RequestMethod.GET)
		public List<Absence> getabsenceParEleve(@PathVariable("matricule") String matricule) {
			Eleve eleve=eleveService.findByMatricule(matricule);
			List<Absence>absences=absenceService.findParELeve(eleve);
		 
			String nomMatiere;
			
			for(int i=0;i<absences.size();i++)
			{
				nomMatiere=absences.get(i).getMatiere().getNomMatiere();
				absences.get(i).setM(nomMatiere);
				 
			}
			
			return absences;
			}
		
		
	// ------------------- liste absence d'une classe----------------------------------------
		@RequestMapping(value = "/absences/classe/{nomclasse}", method = RequestMethod.GET)
		public List<Absence> getabsenceParClasse(@PathVariable("nomclasse") String nomclasse) {
			return absenceService.findParClasse(nomclasse);
			}
		
		
	// ------------------- liste de retards  d'une classe----------------------------------------
		@RequestMapping(value = "/retards/classe/{nomclasse}", method = RequestMethod.GET)
		public List<Retard> getRetardsParClasse(@PathVariable("nomclasse") String nomclasse) {
			return retardService.findParClasse(nomclasse);
			}

	// ------------------- supprimer une absence-----------------------------------------
		@RequestMapping(value = "/absences/{id}", method = RequestMethod.DELETE)
		public  void deleteAbsence(@PathVariable("id") int id) {
			absenceService.delete(id);
			}
			
			
	// ------------------- supprimer un retard ----------------------------------------
		@RequestMapping(value = "/retards/{id}", method = RequestMethod.DELETE)
		public  void deleteRetard(@PathVariable("id") int id) {
			retardService.delete(id);
			}
		
   // ------------------- liste de retard d'un eleve----------------------------------------
		@RequestMapping(value = "/retards/eleve/{id}", method = RequestMethod.GET)
		public Eleve getEleveFormRetard(@PathVariable("id") int id) {
			return retardService.findOne(id).getEleve();
					}

}
