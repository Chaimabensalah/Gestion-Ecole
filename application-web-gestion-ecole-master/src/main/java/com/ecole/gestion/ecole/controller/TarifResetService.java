package com.ecole.gestion.ecole.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Tarif;
import com.ecole.gestion.ecole.service.TarifsService;

@RestController
public class TarifResetService {
	@Autowired
	TarifsService tarifService;
	
	// ------------------- tout les inscriptions----------------------------------------
	@RequestMapping(value = "/tarifs/{x}", method = RequestMethod.GET)
	public Tarif getMotant(@PathVariable("x") String service){
		
		return  tarifService.findByService(service);
	}

}
