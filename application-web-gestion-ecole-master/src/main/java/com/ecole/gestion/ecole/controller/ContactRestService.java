package com.ecole.gestion.ecole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecole.gestion.ecole.model.Contact;
import com.ecole.gestion.ecole.service.ContactService;

@RestController
public class ContactRestService {
	
	@Autowired
	ContactService contactService;
	
	// ------------------- cree un contact associe a un fournisseur----------------------------------------
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public Contact createContact(@RequestBody Contact contact ) {
		contactService.save(contact);
		 return contact;
	}
	

}
