package com.ecole.gestion.ecole.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.FemmeDeMenage;

 
//@Repository
@RepositoryRestResource
public interface FemmeDeMenageRepository extends JpaRepository<FemmeDeMenage, Long> 
{

	@Query("select e from FemmeDeMenage e where e.active=:x ")                                        
    List<FemmeDeMenage> findActive(@Param("x") boolean active);
}
