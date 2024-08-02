package com.ecole.gestion.ecole.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.gestion.ecole.dao.EleveRepository;
import com.ecole.gestion.ecole.dao.InscriptionRepository;
import com.ecole.gestion.ecole.dao.ResponsableRepository;
//import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.*;

@Service("eleveService")
@Transactional

public class EleveServiceImpl implements EleveService {
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private ResponsableRepository responsableRepository;
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
//	@Autowired
//	private InscriptionRepository inscriptionRepository;

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.EleveService#delete(com.websystique.springboot.model.Eleve)
	 */
	@Override
	public void delete(Eleve arg0) {
		eleveRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.EleveService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Long arg0) {
		eleveRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.EleveService#findAll()
	 */
	@Override
	public List<Eleve> findAll() {
		return eleveRepository.findAll();
	}
	
	 
	@Override
	public Page<Eleve> findAll(Pageable arg0) {
			return eleveRepository.findAll(arg0);
		}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.EleveService#findOne(java.lang.Integer)
	 */
	
	@Override
	public Eleve findOne(Long arg0) {
		return eleveRepository.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.EleveService#save(S)
	 */
	@Override
	public <S extends Eleve> S save(S arg0) {
		return eleveRepository.save(arg0);
	}
	
	 

	  
	
//	@Override
//	public Eleve findLast(long id) {
//		return eleveRepository.findLast(id);
//	}
//	
//	
//	@Override
//	public long getMax() {
//		return eleveRepository.getMax();
//	}
//	
	
	@Override
	public Page<Eleve> chercherEleves(String x, Pageable pageable) {
		return eleveRepository.chercherEleves(x, pageable);
	}
	
	@Override
	public Eleve findByMatricule(String arg0) {
		return eleveRepository.findByMatricule(arg0);
	}

	@Override
	public List<Eleve> findElevesParClasse(Classe classe) {
		return eleveRepository.findElevesParClasse(classe);
	}

	@Override
	public Eleve saveEleve2(Eleve eleve) {
		
		 return eleveRepository.save(eleve);
	}
	@Override
	public Eleve saveEleve(Eleve eleve,String cin) {
		
	    Responsable r=responsableRepository.findParCin(cin);
	    eleve.getResponsables().add(r);
	    Inscription ins=new Inscription();
	    ins.setEleve(eleve);
	    inscriptionRepository.save(ins);
	    
	    return eleveRepository.save(eleve);}
	@Override
	public Eleve findByemail(String email) {
		return eleveRepository.findParEmail(email);
	}

	@Override
	public void saveEleve(Eleve e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inscription findCurrentInscription(Eleve eleve) {
		List<Inscription> ins=inscriptionRepository.getInscriptionsParEleve(eleve);
		for(int i=0;i<ins.size();i++) {
			if (ins.get(i).isCurrent())
				return ins.get(i);
		}
		return null;
		
	}

	@Override
	public List<Eleve> findActive() {
		
		return eleveRepository.findActive(true);
	}

//	@Override
//	public Eleve saveEleve(String cin, String email) {
//		Responsable r=responsableRepository.findParCin(cin)
//		return null;
//	}

	 
 

}
