package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Niveau;
import com.ecole.gestion.ecole.service.NiveauService;

@RestController
public class NiveauResetService {
	
	@Autowired
	NiveauService niveauService;
	
	 // ------------------- tout les niveaux-----------------------------------------
	@RequestMapping(value = "/niveaux", method = RequestMethod.GET)
	public List<Niveau> getNiveaux() {
		
		return niveauService.findAll();
		 
	}

}
