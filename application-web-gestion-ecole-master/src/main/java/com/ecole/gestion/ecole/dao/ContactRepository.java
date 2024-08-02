package com.ecole.gestion.ecole.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecole.gestion.ecole.model.Contact;







//@Repository
@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query("select a from Contact a where a.cin=:x ")                                        
	Contact findByCin(@Param("x") String cin);

}
