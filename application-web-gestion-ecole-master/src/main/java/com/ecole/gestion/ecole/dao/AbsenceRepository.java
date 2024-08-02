package com.ecole.gestion.ecole.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Absence;
import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;



@Repository
//@RepositoryRestResource
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
	
	@Query("select a from Absence a where a.eleve=:x ")                                        
    List<Absence> findParEleve(@Param("x") Eleve eleve);

	@Query("select a from Absence a where a.eleve.classe=:x ")                                        
    List<Absence> findParClasse(@Param("x") Classe classe);

}
