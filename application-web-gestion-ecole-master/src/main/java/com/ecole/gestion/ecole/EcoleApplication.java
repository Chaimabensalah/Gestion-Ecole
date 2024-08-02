package com.ecole.gestion.ecole;
import com.ecole.gestion.ecole.service.*;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;

 
 
@SpringBootApplication
public class EcoleApplication  {
	@Autowired
	static
	TarifsService tarifService;
	
	public static void main(String[] args) {
		 
		
		SpringApplication.run(EcoleApplication.class, args);
//		Tarif tarif =new Tarif("inscription",600);
//		Tarif tarif1 =new Tarif("scolarite",1600);
//		Tarif tarif2 =new Tarif("garde",700);
//		Tarif tarif3 =new Tarif("transport",900);
//		tarifService.save(tarif);
//		tarifService.save(tarif1);
//		tarifService.save(tarif2);
//		tarifService.save(tarif3);
	}
	
	
//	  
	 
	 
	 
 
}
