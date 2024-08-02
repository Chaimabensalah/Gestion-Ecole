package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Retard;









@Repository
public interface RetardRepository extends JpaRepository<Retard, Integer> {
	
	@Query("select a from Retard a where a.eleve.classe=:x ")                                        
    List<Retard> findParClasse(@Param("x") Classe classe);

}
