package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Secretaire;









//@Repository
@RepositoryRestResource
public interface SecretaireRepository extends CrudRepository<Secretaire, Long> {
	
	@Query("select e from Secretaire e where e.active=:x ")                                        
    List<Secretaire> findActive(@Param("x") boolean active);

}
