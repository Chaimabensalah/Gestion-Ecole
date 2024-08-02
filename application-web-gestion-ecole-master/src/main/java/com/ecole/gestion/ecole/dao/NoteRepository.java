package com.ecole.gestion.ecole.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecole.gestion.ecole.model.Classe;
import com.ecole.gestion.ecole.model.Eleve;
import com.ecole.gestion.ecole.model.Examen;
import com.ecole.gestion.ecole.model.Matiere;
import com.ecole.gestion.ecole.model.Note;




@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
	
	@Query("select n from Note n where n.eleve=:x and n.matiere=:y ")                                        
    List<Note> findByEleve(@Param("x") Eleve eleve,@Param("y") Matiere matiere);

	@Query("select n from Note n where n.eleve=:x and n.matiere=:y and n.examen=:z  ")                                        
    Note findByEleveD(@Param("x") Eleve eleve,@Param("y") Matiere matiere,@Param("z") Examen examen);

	@Query("select n from Note n where n.eleve.classe=:x and n.matiere=:y")                                        
    List<Note> findParClasse(@Param("x") Classe classe,@Param("y") Matiere matiere);

	
//	@Query("select n from Note n where n.note=:y and n.matiere=:x ")                                        
//    List<Note>findByClasseAndMatiere(@Param("y") Classe classe,@Param("x") Matiere matiere);



}
