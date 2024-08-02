package com.ecole.gestion.ecole.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecole.gestion.ecole.model.*;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long>{
	
	@Query("select r from Responsable r where r.cin=:x ")    
	Responsable findParCin(@Param("x") String cin);

}
