angular.module('ecole', ['ui.router']).config(function($stateProvider,$urlRouterProvider){
	
	$stateProvider.state('login',{
		url:'/login',
		templateUrl:'views/login.html',
		controller:'loginController'

}); 
	
	$stateProvider.state('home',{
		url:'/home',
		templateUrl:'views/home.html',
		controller:'loginController'

}); 
//______________________________secretaire_________________________________________________________________

	$stateProvider.state('inscription',{
		url:'/inscription',
		templateUrl:'views/secretaire/inscription.html',
		controller:'secretaireController'

});  
	
	$stateProvider.state('inscriptionFrere',{
		url:'/inscriptionFrere',
		templateUrl:'views/secretaire/inscriptionFrere.html',
		controller:'secretaireController'

});  
	
	$stateProvider.state('listeInscriptions',{
		url:'/listeInscriptions',
		templateUrl:'views/secretaire/listeInscriptions.html',
		controller:'secretaireController'

});  
	$stateProvider.state('fraisInscriptions',{
		url:'/fraisInscriptions',
		templateUrl:'views/secretaire/fraisInscription.html',
		controller:'secretaireController'

}); 
	
	$stateProvider.state('fraisScolarite',{
		url:'/fraisScolarite',
		templateUrl:'views/secretaire/fraisScolarite.html',
		controller:'secretaireController'

});  
	
	$stateProvider.state('ajouterService',{
		url:'/ajouterService',
		templateUrl:'views/secretaire/ajouterService.html',
		controller:'secretaireController'

}); 
	
	$stateProvider.state('profil',{
		url:'/profil',
		templateUrl:'views/secretaire/profil.html',
		controller:'secretaireController'

}); 
//________________________gestionnaire_____________________________________________________________
	$stateProvider.state('gestionnaireHome',{
		url:'/gestionnaireHome',
		templateUrl:'views/gestionnaire/gestionnaireHome.html',
		controller:'NewEmpController'

});
	
	$stateProvider.state('ajouterFournisseur',{
		url:'/ajouterFournisseur',
		templateUrl:'views/gestionnaire/gestionFinance/ajouterFournisseur.html',
		controller:'fournisseurController'

});
	
	$stateProvider.state('listeFournisseurs',{
		url:'/listeFournisseurs',
		templateUrl:'views/gestionnaire/gestionFinance/listeFournisseurs.html',
		controller:'fournisseurController'

});
	
	$stateProvider.state('ajouterFacture',{
		url:'/ajouterFacture',
		templateUrl:'views/gestionnaire/gestionFinance/ajouterFacture.html',
		controller:'fournisseurController'

});
	 
	$stateProvider.state('ficheEmployee',{
		url:'/ficheEmployee',
		templateUrl:'views/gestionnaire/gestionPersonnel/ficheEmployee.html',
		controller:'NewEmpController'

});
	$stateProvider.state('listeEmployee',{
		url:'/listeEmployee',
		templateUrl:'views/gestionnaire/gestionPersonnel/listeEmployee.html',
		controller:'NewEmpController'

});
	 
	 
	$stateProvider.state('ajouterEmployee',{
		url:'/ajouterEmployee',
		templateUrl:'views/gestionnaire/gestionPersonnel/AjouterEmployee.html',
		controller:'NewEmpController'

});
	
	$stateProvider.state('garde',{
		url:'/garde',
		templateUrl:'views/gestionnaire/gestionService/garde.html',
		controller:'serviceController'

});
	
	$stateProvider.state('transport',{
		url:'/transport',
		templateUrl:'views/gestionnaire/gestionService/transport.html',
		controller:'serviceController'

});
	
	$stateProvider.state('vehicules',{
		url:'/vehicules',
		templateUrl:'views/gestionnaire/gestionService/vehicules.html',
		controller:'serviceController'

});	
	
//_____________________professeur__________________________________________________________
	
	$stateProvider.state('absence',{
		url:'/absence',
		templateUrl:'views/prof/absence.html',
		controller:'absenceRetardController'

});
	$stateProvider.state('devoirs',{
		url:'/devoirs',
		templateUrl:'views/prof/devoirs.html',
		controller:'devoirController'

});
	$stateProvider.state('observations',{
		url:'/observations',
		templateUrl:'views/prof/observations.html',
		controller:'observationController'

});
	
	$stateProvider.state('cahierText',{
		url:'/cahierText',
		templateUrl:'views/prof/cahier.html',
		controller:'cahierTexteController'

});
	
	$stateProvider.state('notes',{
		url:'/notes',
		templateUrl:'views/prof/notes.html',
		controller:'notesController'

});
	
	$stateProvider.state('controles',{
		url:'/controles',
		templateUrl:'views/prof/controle.html',
		controller:'profController'

});
	
	$stateProvider.state('gardes',{
		url:'/gardes',
		templateUrl:'views/prof/gardes.html',
		controller:'profController'

});
	
	$stateProvider.state('classes',{
		url:'/classes',
		templateUrl:'views/prof/classes.html',
		controller:'profController'

});

//_______________________________________Responsable___________________________________________
	
	$stateProvider.state('absenceRespo',{
		url:'/absenceRespo',
		templateUrl:'views/responsable/absence.html',
		controller:'responsableController'

});
	
	$stateProvider.state('notesRespo',{
		url:'/notesRespo',
		templateUrl:'views/responsable/notes.html',
		controller:'responsableController'

});
	$stateProvider.state('devoirsRespo',{
		url:'/devoirsRespo',
		templateUrl:'views/responsable/devoirs.html',
		controller:'responsableController'

});
	
	$stateProvider.state('controlesRespo',{
		url:'/controlesRespo',
		templateUrl:'views/responsable/controles.html',
		controller:'responsableController'

});
	
	$stateProvider.state('profilRespo',{
		url:'/profilRespo',
		templateUrl:'views/responsable/profil.html',
		controller:'responsableController'

});
//___________________________________eleve__________________________________________________
	
	$stateProvider.state('absenceEleve',{
		url:'/absenceEleve',
		templateUrl:'views/eleve/absenceEleve.html',
		controller:'eleveController'

});
	
	$stateProvider.state('notesEleve',{
		url:'/notesEleve',
		templateUrl:'views/eleve/notes.html',
		controller:'eleveController'

});
	
	$stateProvider.state('devoirsEleve',{
		url:'/devoirsEleve',
		templateUrl:'views/eleve/devoirs.html',
		controller:'eleveController'

});
	
	$stateProvider.state('controlesEleve',{
		url:'/controlesEleve',
		templateUrl:'views/eleve/controles.html',
		controller:'eleveController'

});
 
	
});