package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.gestion.ecole.dao.ContactRepository;
import com.ecole.gestion.ecole.dao.FournisseurRepository;
import com.ecole.gestion.ecole.model.Contact;
import com.ecole.gestion.ecole.model.Fournisseur;

@Service("FournisseurService")
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FournisseurService#delete(com.ecole.gestion.ecole.model.Fournisseur)
	 */
	@Override
	public void delete(Fournisseur arg0) {
		fournisseurRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FournisseurService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(int arg0) {
		fournisseurRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FournisseurService#findAll()
	 */
	@Override
	public List<Fournisseur> findAll() {
		return fournisseurRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FournisseurService#findByNom(java.lang.String)
	 */
	@Override
	public Fournisseur findByNom(String nom) {
		return fournisseurRepository.findByNom(nom);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FournisseurService#findOne(java.lang.Integer)
	 */
	@Override
	public Fournisseur findOne(int arg0) {
		return fournisseurRepository.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FournisseurService#save(S)
	 */
	@Override
	public <S extends Fournisseur> S save(S arg0,String cin) {
		Contact c=contactRepository.findByCin(cin);
		arg0.setContact(c);
		return fournisseurRepository.save(arg0);
	}
	
	@Override
	public <S extends Fournisseur> S save(S arg0) {
		 
		return fournisseurRepository.save(arg0);
	}
	
	@Override
	public Page<Fournisseur> findAll(Pageable arg0) {
			return fournisseurRepository.findAll(arg0);
		}

	@Override
	public List<Fournisseur> findActive() {
		return fournisseurRepository.findActive(true);
	}
	
	

}
