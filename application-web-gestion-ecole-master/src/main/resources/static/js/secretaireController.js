 

angular.module('ecole').controller('secretaireController', ['$scope','$http','$rootScope' ,function($scope, $http,$rootScope,$route) {
//app.controller('profController',function($scope,$http){
    
    $scope.elevesList=$scope.eleve;
    $scope.niveauxList=null;
    $scope.inscriptions=null;
    $scope.tarifs=null;
    $scope.reductions=null;
    $scope.niveaux=null;
    $scope.eleves=null;
    $scope.service=null;
    $scope.services=null;
    $scope.responsables=null;
 
   

    $scope.eleve={}
    
    $scope.eleveS={}
	$scope.respo={}
    $scope.respo2={}
    $scope.inscription={}
    $scope.paiement={};
    $scope.reduction={}
    $scope.data={}
    $scope.service={};
    $scope.mois=0;
    $scope.moisLettre=""
    $scope.moisPaye=0;
    
    //$scope.re="er"
	 
    $scope.cin="";
    $scope.cin2="";
    $scope.niveau="";
    //$rootScope.email="";
    $scope.montant=0;
    $scope.tarif={};
    $scope.montantApresReduction=0;
    //$scope.motantInscription=0.0;
    
   $scope.respoList=null;
    
   
   $scope.getSecretaireConnected=function(){
       
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/secretaires/14'
		        
		   }).then(function (response){
			   $rootScope.empt=response.data;
	  
		   },function (error){
			    console.log(err);
		   });
		}
    $scope.getSecretaireConnected();
 //_____________________________________________________________________________
        
         $scope.saveInscription=function(){
//        	 
        	$scope.respo.cin=$scope.cin;
        	$scope.respo2.cin=$scope.cin2;
        	$http.post('http://localhost:8080/responsables/',$scope.respo)
 			$http.post('http://localhost:8080/responsables/',$scope.respo2)
 			.then(function (response){
 				 
 				$scope.respo=response.data;
 				
 			   },function (error){
 				    console.log(err);
 			   });
 			     $scope.saveEleve($scope.cin,$scope.cin2);
 			
    }
         
        $scope.saveEleve=function(x,y){
        $rootScope.email= $scope.eleve.email;
    	$http.post('http://localhost:8080/eleves/'+x+'/'+$scope.niveau.idNiveau+'/'+y,$scope.eleve) 
		.then(function (response){
			$scope.eleve=response.data;
			
		   },function (error){
			    console.log(err);
		   });
    	
    	   //$scope.saveIns();
         }
        
        $scope.saveFrere=function(){
        	$scope.saveEleve($scope.respo.cin);
        }
        
      //obtenir tout les inscription
        $scope.getAllEleveInscrits=function(){
        
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/eleves'
     		        
     		   }).then(function (response){
     			   $scope.inscriptions=response.data;
     			   $scope.eleves=$scope.inscriptions;
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
         
        $scope.getAllEleveInscrits();
        //obenir tout les niveaux
        $scope.getAllNiveaux=function(){
            
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/niveaux'
     		        
     		   }).then(function (response){
     			   $scope.niveaux=response.data;
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
         
        $scope.getAllNiveaux();
        
        $scope.recupererEleve=function(x){
			
 			$http({
 			      method: 'GET',
 			      url:'http://localhost:8080/eleves/one/'+x
 			        
 			   }).then(function (response){
 				   $scope.eleve=response.data;
 	   				//$scope.changeValue();
 	   				
 			   },function (error){
 				    console.log(err);
 			   });
 			return true;
    			}
        
        //supprimer un eleve
        $scope.deleteEleve=function(x,param){
        	//$scope.recupererObservation(x);
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.get('http://localhost:8080/eleves/desable/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
        
        //get all responsables:
         $scope.getResponsables=function(){
            
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/responsables'
     		        
     		   }).then(function (response){
     			   $scope.responsables=response.data;
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
         $scope.getResponsables();
         
        
//========================paiements=================================================================
        //get tarifs
        $scope.getTarifs=function(){
            
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/tarifs'
     		     
     		   }).then(function (response){
     			   $scope.tarifs=response.data._embedded.tarifs;
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
        
        //$scope.getTarifs();
        //get reductions
        $scope.getReductions=function(){
            
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/reductions'
     		     
     		   }).then(function (response){
     			   $scope.reductions=response.data;
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
        $scope.getReductions();
        
        //get montant par tarif
        $scope.getMontant=function(x){
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/tarifs/'+x
     		     
     		   }).then(function (response){
     			  // $scope.montant=response.data;
     			     $scope.tarif=response.data;
     			    $scope.montant=$scope.tarif.montant;
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
            $scope.getMontant("inscription");
       
            
      //calculer la Reduction()
       $scope.calculerReduction=function(x){
       $scope.montantApresReduction=$scope.montant*(1-($scope.reduction.prctageReduction/100))
       $scope.montantApresReduction= $scope.montantApresReduction.toFixed(2);
       $scope.paiement.montant=$scope.montantApresReduction;
       $scope.myFunction("myPopup2");
       }
        
        $scope.savePaiement=function(){
        //     $scope.paiement.typeService="inscription";
         	$http.post('http://localhost:8080/paiements/'+$rootScope.email+'/'+$scope.paiement.typePaiement,$scope.paiement) 
     		.then(function (response){
     			
     			$scope.paiement=response.data;
     			 
     			
     		   },function (error){
     			    console.log(err);
     		   });
              }
        
        $scope.savePaiementService=function(){
                $scope.paiement.typeService=$scope.service.nomService;
             	$http.post('http://localhost:8080/paiements/service/'+$scope.eleveS.idPersonne+'/'+$scope.service.nomService,$scope.paiement) 
         		.then(function (response){
         			
         			$scope.paiement=response.data;
         			 
         			
         		   },function (error){
         			    console.log(err);
         		   });
                  }
        
         
        
        
        $scope.saveService=function(){
             	$http.post('http://localhost:8080/servicees/'+$scope.eleve.idPersonne,$scope.service) 
         		.then(function (response){
         			
         			$scope.service=response.data;
         			 
         			
         		   },function (error){
         			    console.log(err);
         		   });
             	   //$scope.saveIns();
                  }
        
        $scope.getMoisNonPayes=function(){
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/servicees/mois/'+$scope.eleveS.idPersonne+'/'+$scope.service.nomService
     		     
     		   }).then(function (response){
     			  $scope.mois=response.data;
     			  $scope.moisPaye=10-$scope.mois;
     		      $scope.displayMonth($scope.mois);
     		      $scope.paiement.mois=$scope.moisLettre;
     		      $scope.myFunction("myPopup");
     		 
     		   },function (error){
     			    console.log(err);
     		   });
     		}
        
        $scope.displayMonth=function(x){ 
        	if(x==10)     {$scope.moisLettre="septembre"}
        	else if(x==9){$scope.moisLettre="occtobre"}
        	else if(x==8){$scope.moisLettre="novembre"}
        	else if(x==7){$scope.moisLettre="decembre"}
        	else if(x==6){$scope.moisLettre="janvier"}
        	else if(x==5){$scope.moisLettre="fevrier"}
        	else if(x==4){$scope.moisLettre="mars"}
        	else if(x==3){$scope.moisLettre="avril"}
        	else if(x==2){$scope.moisLettre="mai"}
        	else if(x==1){$scope.moisLettre="juin"}
            }
        
        $scope.getServicesPareleve=function(x){
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/servicees/'+x
     		     
     		   }).then(function (response){
     			  $scope.services=response.data;
     		   
     	           
     		   },function (error){
     			    console.log(err);
     		   });
     		}
        
        
        $scope.myFunction=function (x) {
            var popup = document.getElementById(x);
            popup.classList.toggle("show");
        }
        
//________________fin________________________________________________________________________________
         

         
}]);