package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Gardien;







//@Repository
@RepositoryRestResource
public interface GardienRepository extends CrudRepository<Gardien, Long> {
	
	@Query("select e from Gardien e where e.active=:x ")                                        
    List<Gardien> findActive(@Param("x") boolean active);

}
