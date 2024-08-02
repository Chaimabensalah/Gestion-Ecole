package com.ecole.gestion.ecole.dao;

 


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Aide;
 



//@Repository
@RepositoryRestResource
public interface AideRepository extends JpaRepository<Aide, Long> {
	 
	@Query("select a from Aide a where a.cin=:x ")                                        
		Aide findByCin(@Param("x") String cin);
	  
	@Query("select e from Aide e where e.active=:x ")                                        
    List<Aide> findActive(@Param("x") boolean active);
}
