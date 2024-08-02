package com.ecole.gestion.ecole.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.*;



@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {
    @Query("select p from Personne p where p.idPersonne=:x ")                                        
	Eleve findLast(@Param("x") long id);
    
	@Query("select max(p.idPersonne) from Personne p") 
	Long getMax();
	
	@Query("select e from Eleve e where e.nom like :x")
	public Page<Eleve> chercherEleves(@Param("x")String x,Pageable pageable); 
	
	@Query("select p from Eleve p where p.matricule=:x ")                                        
	Eleve findByMatricule(@Param("x") String matricule);
	
	@Query("select e from Eleve e where e.classe=:x ")                                        
	List<Eleve> findElevesParClasse(@Param("x") Classe classe);
	
	@Query("select e from Eleve e where e.email=:x ")                                        
	Eleve findParEmail(@Param("x") String email);
	
	@Query("select e from Eleve e where e.active=:x ")                                        
	List<Eleve> findActive(@Param("x") boolean active);
	
  
       
      
}
