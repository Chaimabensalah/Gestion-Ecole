package com.ecole.gestion.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.gestion.ecole.model.*;
import com.ecole.gestion.ecole.dao.*;

@Service("responsableService")
@Transactional
public class ResponsableServiceImpl implements ResponsableService {
	@Autowired ResponsableRepository respo;

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.ResponsableService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		respo.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.ResponsableService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Long arg0) {
		return respo.exists(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.ResponsableService#findAll()
	 */
	@Override
	public List<Responsable> findAll() {
		return respo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.ResponsableService#findOne(java.lang.Integer)
	 */
	@Override
	public Responsable findOne(Long arg0) {
		return respo.findOne(arg0);
	}
	
	 

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.ResponsableService#save(S)
	 */
	@Override
	public <S extends Responsable> S save(S arg0) {
		return respo.save(arg0);
	}

	/* (non-Javadoc)
	 * @see com.websystique.springboot.service.ResponsableService#saveAndFlush(S)
	 */
//	@Override
//	public <S extends Responsable> S saveAndFlush(S arg0) {
//		return respo.saveAndFlush(arg0);
//	}
	
	@Override
	public void delete(Long arg0) {
		respo.delete(arg0);
	}

	@Override
	public Responsable findParCin(String cin) {
		return respo.findParCin(cin);
	}
	
	
	
	
}
