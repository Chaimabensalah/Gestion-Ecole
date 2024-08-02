package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Devoir;
import com.ecole.gestion.ecole.model.Matiere;







@Repository
public interface DevoirRepository extends JpaRepository<Devoir, Integer> {
	
	@Query("select d from Devoir d where d.matiere=:x ")                                        
    List<Devoir>findDevoirsParMatiere(@Param("x") Matiere matiere);

	@Query("select d from Devoir d where d.classe=:x and d.valide=:y ")    
	List<Devoir> findDevoirParClasse(@Param("x") Classe classe,@Param("y") boolean valide);
}
