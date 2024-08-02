angular.module('ecole').controller('fournisseurController', ['$scope', '$http', function($scope, $http) {
 
	$scope.fournisseurs=null;
	$scope.factureslist=null;
	
	$scope.perso={};
	$scope.facture={};
	$scope.fournisseur={};
	$scope.total=0;
	var x=$scope.fournisseur.idFournisseur;
	var y=$scope.facture.idFacture;
	
//===================save fournisseur====================================
	
	$scope.saveFournisseur=function(){
		 if (x!=null) {
				$scope.updateFournisseur(x);
				   }
		 else{
		$scope.fournisseur.active=true;
		$http.post('http://localhost:8080/contacts',$scope.perso)
		$http.post('http://localhost:8080/fournisseurs/'+$scope.perso.cin,$scope.fournisseur)
	     .success(function(data){
		    $scope.fournisseur =data;
		    $scope.perso =data;
		})
	     .error(function(err){
		     console.log(err);
	 });
	}}

//====================get all fournisseurs============================================
	$scope.fournisseurs=function(){
	  $http({
	      method: 'GET',
	      url: 'http://localhost:8080/fournisseurs'
	   }).then(function (response){
               $scope.fournisseurs = response.data;
  
	   },function (error){
		    console.log(err);
	   });
	}
	
	$scope.fournisseurs();
//===========================desactiver fournisseur ======================================
	 $scope.deleteFournisseur=function(x,param){
     	var r = confirm("Are you sure?");
 	    if (r == true) { 
			$http.get('http://localhost:8080/fournisseurs/desable/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
	 
//=================================Recuperer fournisseur===================================
	 $scope.recupererFournisseur=function(x){
			
			$http({
			      method: 'GET',
			      url:'http://localhost:8080/fournisseurs/'+x
			        
			   }).then(function (response){
				   $scope.fournisseur=response.data;
				  //  x=$scope.vehicule.idVehicule;
				    $scope.perso=$scope.fournisseur.contact;
	   				$scope.changeValue("d'une vehicule");
	   				
			   },function (error){
				    console.log(err);
			   });
 			
 			}
//=================modifier fournisseur============================================
 
     $scope.updateFournisseur=function(x){
			
			 
			$http.put('http://localhost:8080/fournisseurs/'+x,$scope.fournisseur)
			.then(function (response){
				 
				$scope.fournisseur=response.data;
				//$route.reload();
				
			   },function (error){
				    console.log(err);
			   });
		
			}
     
//==================save facture===================================================
 
	$scope.saveFacture=function(){
		if (y!=null) {
			$scope.updateFacture(y);
			   }
	 else{
		$http.post('http://localhost:8080/factures/'+$scope.fournisseur.nom,$scope.facture)
		.then(function (response){
			 
				$scope.facture=response.data;
				$scope.total=$scope.facture.totalHT;
				
			   },function (error){
				    console.log(err);
			   });
	}}
//===================liste of factures===============================================
		$scope.factures=function(){
			  $http({
			      method: 'GET',
			      url: 'http://localhost:8080/factures'
			   }).then(function (response){
		               $scope.facturesList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}
			
		$scope.factures();
		
//=======================supprimer une facture======================
       $scope.deleteFacture=function(x,param){
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.get('http://localhost:8080/factures/desable/'+x)
			.then(function (response){
				 
				 
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
//=============================recuperer une facture ==========================================     
       $scope.recupererFacture=function(x){
			
			$http({
			      method: 'GET',
			      url:'http://localhost:8080/factures/'+x
			        
			   }).then(function (response){
				   $scope.facture=response.data;
				  $scope.getFournisseurFromFacture(x);
				    
	   				$scope.changeValue("d'une facture");
	   				
			   },function (error){
				    console.log(err);
			   });
			
			}
			
       
//=======================get fournisseur form facture ======================================       
       $scope.getFournisseurFromFacture=function(x){
			
			$http({
			      method: 'GET',
			      url:'http://localhost:8080/factures/fournisseur/'+x
			        
			   }).then(function (response){
				   $scope.fournisseur=response.data;
				    
	   				
			   },function (error){
				    console.log(err);
			   });
			
			}
       
       $scope.updateFacture=function(x){
			
			 
			$http.put('http://localhost:8080/factures/'+x,$scope.facture)
			.then(function (response){
				 
				$scope.facture=response.data;
				//$route.reload();
				
			   },function (error){
				    console.log(err);
			   });
		
			}

     //change value for te button :
       $scope.changeValue=function()
       {
           document.getElementById('button').innerHTML = "Enregistrer la modification";
           document.getElementById('titre').innerHTML =  "Modification  ";
       }	 
	      
	
 

}]);