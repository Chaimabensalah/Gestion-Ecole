package com.ecole.gestion.ecole.service;

import java.util.Calendar;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;
@Service
public class InscriptionServiceImpl implements InscriptionService {
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	@Autowired
	private EleveService eleveService;

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#delete(com.websystique.springboot.model.Inscription)
	 */
	@Override
	public void delete(Inscription arg0) {
		inscriptionRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer arg0) {
		inscriptionRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		inscriptionRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#findAll()
	 */
	@Override
	public List<Inscription> findAll() {
		return inscriptionRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#findOne(java.lang.Integer)
	 */
	@Override
	public Inscription findOne(Integer arg0) {
		return inscriptionRepository.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#save(S)
	 */
	@Override
	public <S extends Inscription> S save(S arg0) {
		return inscriptionRepository.save(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.InscriptionService#saveAndFlush(S)
	 */
	@Override
	public <S extends Inscription> S saveAndFlush(S arg0) {
		return inscriptionRepository.saveAndFlush(arg0);
	}


	@Override
	public Inscription save(Inscription inscription, String email) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Eleve eleve=eleveService.findByemail(email);
		inscription.setEleve(eleve);
		inscription.setDateInscription(date);
		
		return inscriptionRepository.save(inscription);
	}
	
	
	
}
