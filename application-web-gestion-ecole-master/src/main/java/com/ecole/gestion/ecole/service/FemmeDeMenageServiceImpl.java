package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecole.gestion.ecole.dao.FemmeDeMenageRepository;
import com.ecole.gestion.ecole.model.FemmeDeMenage;

public class FemmeDeMenageServiceImpl implements FemmeDeMenageService {
	
	@Autowired
	private FemmeDeMenageRepository femmeRepository;

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FemmeDeMenageService#delete(com.ecole.gestion.ecole.model.FemmeDeMenage)
	 */
	@Override
	public void delete(FemmeDeMenage arg0) {
		femmeRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FemmeDeMenageService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long arg0) {
		femmeRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FemmeDeMenageService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		femmeRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FemmeDeMenageService#findAll()
	 */
	@Override
	public List<FemmeDeMenage> findAll() {
		return femmeRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FemmeDeMenageService#findOne(java.lang.Long)
	 */
	@Override
	public FemmeDeMenage findOne(Long arg0) {
		return femmeRepository.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.ecole.gestion.ecole.service.FemmeDeMenageService#save(S)
	 */
	@Override
	public <S extends FemmeDeMenage> S save(S arg0) {
		return femmeRepository.save(arg0);
	}
	
	
	

}
