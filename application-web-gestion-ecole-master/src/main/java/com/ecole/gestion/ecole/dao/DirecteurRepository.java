package com.ecole.gestion.ecole.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Directeur;







//@Repository
@RepositoryRestResource
public interface DirecteurRepository extends CrudRepository<Directeur, Integer> {

}

