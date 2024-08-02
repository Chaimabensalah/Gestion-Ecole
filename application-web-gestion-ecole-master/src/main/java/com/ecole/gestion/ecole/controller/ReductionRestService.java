package com.ecole.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Reduction;
import com.ecole.gestion.ecole.service.ReductionService;


@RestController
public class ReductionRestService {

	@Autowired
	ReductionService reductionService;
	
	// -------------------Absence par matiere------------------------------------------
	@RequestMapping(value = "/reductions", method = RequestMethod.GET)
	public List<Reduction> getReductions() {
		return reductionService.findAll();
		    
				}
			
}
