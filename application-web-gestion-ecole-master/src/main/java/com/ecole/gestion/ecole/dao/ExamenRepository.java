package com.ecole.gestion.ecole.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.*;





@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {

	@Query("select e from Examen e where e.classe=:x ")   
	List<Examen> findByEleve(@Param("x") Classe classe);
	
	@Query("select e from Examen e where e.matiere=:x ")   
	List<Examen> findParMatiere(@Param("x") Matiere matiere);

}
