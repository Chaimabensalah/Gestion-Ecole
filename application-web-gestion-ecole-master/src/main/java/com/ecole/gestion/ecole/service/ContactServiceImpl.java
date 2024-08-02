package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.gestion.ecole.dao.ContactRepository;
import com.ecole.gestion.ecole.model.Contact;

@Service("ContactService")
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contact;
//	@Autowired
//	private FournisseurService fournisseur;

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ContactService#delete(com.ecole.gestion.ecole.model.Contact)
	 */
	@Override
	public void delete(Contact arg0) {
		contact.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ContactService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long arg0) {
		contact.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ContactService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		contact.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ContactService#findAll()
	 */
	@Override
	public List<Contact> findAll() {
		return contact.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ContactService#findOne(java.lang.Long)
	 */
	@Override
	public Contact findOne(Long arg0) {
		return contact.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.ContactService#save(S)
	 */
	@Override
	public <S extends Contact> S save(S arg0) {
		return contact.save(arg0);
	}
	
	@Override
	public <S extends Contact> S saveContact(S arg0,String nom) {
		 
		return contact.save(arg0);
	}
	
	

}
