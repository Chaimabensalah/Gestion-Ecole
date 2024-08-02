package com.ecole.gestion.ecole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Aide;
import com.ecole.gestion.ecole.service.AideService;

@RestController
public class TestRestApi {
	 
	@Autowired
	AideService aideService;
	
	//------------------------------get aides par cin
	@RequestMapping(value = "/aides/{cin}", method = RequestMethod.GET)
	public Aide getAides(@PathVariable("cin")String cin) {
	    
		return aideService.findByCin(cin);
		}

}
