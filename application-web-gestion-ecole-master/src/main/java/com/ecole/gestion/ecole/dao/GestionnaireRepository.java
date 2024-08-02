package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Gestionnaire;








@Repository
public interface GestionnaireRepository extends CrudRepository<Gestionnaire, Long> {
	@Query("select e from Gestionnaire e where e.active=:x ")                                        
    List<Gestionnaire> findActive(@Param("x") boolean active);

}
