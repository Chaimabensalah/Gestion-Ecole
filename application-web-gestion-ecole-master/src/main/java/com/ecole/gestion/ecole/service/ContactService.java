package com.ecole.gestion.ecole.service;

import java.util.List;

import com.ecole.gestion.ecole.model.Contact;

public interface ContactService {

	void delete(Contact arg0);

	void delete(Long arg0);

	void deleteAll();

	List<Contact> findAll();

	Contact findOne(Long arg0);

	<S extends Contact> S save(S arg0);
	
	<S extends Contact> S saveContact(S arg0,String nom);

}