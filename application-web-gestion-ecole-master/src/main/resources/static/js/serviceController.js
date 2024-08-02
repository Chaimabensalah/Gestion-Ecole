angular.module('ecole').controller('serviceController', ['$scope', '$http', function($scope, $http) {

    $scope.professeursList=null;
    $scope.chauffeursList=null;
    $scope.aidesList=null;
    $scope.transportsList=null;
    $scope.gardesList=null;
    $scope.voituresList=null;
    
    
    $scope.transport={};
    $scope.chauffeur={};
    $scope.garde={}
	$scope.prof={};
    $scope.aide={};
    $scope.vehicule={};
    var x=$scope.vehicule.idVehicule;
    
    //---------list of prof ------------      
		$scope.getProfesseurs=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/professeurs'
			   }).then(function (response){
		               $scope.professeursList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getProfesseurs();
		
    //---------list of aides------------    
		$scope.getAides=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/aides'
			   }).then(function (response){
		               $scope.aidesList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getAides();
	
    //---------enregstrer une garde ------------    
		$scope.saveGarde=function(){
			$scope.garde.active=true;
		   $http.post('http://localhost:8080/gardes/'+$scope.prof.cin+'/'+$scope.aide.cin,$scope.garde)
 				
			   .then(function (response){
					 $scope.garde=response.data._embedded.gardes;  
		  
			   },function (error){
				    console.log(err);
			   });
			}
		
		//---------list of gardes------------    
		$scope.getGardes=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/gardes'
			   }).then(function (response){
		               $scope.gardesList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getGardes();
		
		
		$scope.deleteGarde = function(param){
		       
		    var r = confirm("Are you sure?");
		    if (r == true) {
		    	
		       // your delete code
		    	
		    	$http({
				      method: 'get',
				      url: 'http://localhost:8080/gardes/'+param+'/desable'
				     
				   }).then(function (response){
			  
				   },function (error){
					    console.log(err);
				   });
		    } else {

		    }

		}
		
		$scope.recupererGarde=function(x){
			
 			$http({
 			      method: 'GET',
 			      url:'http://localhost:8080/gardes/'+x
 			        
 			   }).then(function (response){
 				   $scope.garde=response.data;
 				   $scope.getProf($scope.garde.idGarde);
 	   				$scope.changeValue();
 	   				
 			   },function (error){
 				    console.log(err);
 			   });
    			
    			}
		
       $scope.getProf=function(x){
			
 			$http({
 			      method: 'GET',
 			      url:'http://localhost:8080/gardes/prof/'+x
 			        
 			   }).then(function (response){
 				   $scope.prof=response.data;
 				   $scope.garde.professeur=$scope.prof;
 				   
 	   				
 			   },function (error){
 				    console.log(err);
 			   });
    			
    			}
		//change value for te button :
	    $scope.changeValue=function(x)
	    {
	        document.getElementById('button').innerHTML = "Enregistrer la modification";
	        document.getElementById('titre').innerHTML =  "Modification "+x;
	    }
//==============================transport======================================
	
	 //'''''''''''''''''''''''''''voitures '''''''''''''''''''' ''''''''''''''''''''''''''''''
	 //---------enregistrer une vehicule ------------    
		$scope.saveVehicule=function(){
			 if (x!=null) {
	 				$scope.updateVehicule(x);
	 				   }
	 		 else{
			   $http.post('http://localhost:8080/vehicules/',$scope.vehicule)
	 				
				   .then(function (response){
						 $scope.vehicule=response.data;  
			  
				   },function (error){
					    console.log(err);
				   });
				}}	
		
		//---------list of voiture------------    
		$scope.getVoitures=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/vehicules'
			   }).then(function (response){
		               $scope.voituresList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getVoitures();
		
		 //supprimer une voiture
        $scope.deleteVehicule=function(x,param){
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.get('http://localhost:8080/vehicules/desable/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
		//recuperer une voiture
         $scope.recupererVoiture=function(x){
			
 			$http({
 			      method: 'GET',
 			      url:'http://localhost:8080/vehicules/'+x
 			        
 			   }).then(function (response){
 				   $scope.vehicule=response.data;
 				    x=$scope.vehicule.idVehicule;
 				 
 	   				$scope.changeValue("d'une vehicule");
 	   				
 			   },function (error){
 				    console.log(err);
 			   });
    			
    			}
		

  		//modifier un vehicule
          $scope.updateVehicule=function(x){
  			
  			 
  			$http.put('http://localhost:8080/vehicules/'+x,$scope.vehicule)
  			.then(function (response){
  				 
  				$scope.vehicule=response.data;
  				//$route.reload();
  				
  			   },function (error){
  				    console.log(err);
  			   });
  		
  			}
          
   //'''''''''''''''''''''''chauffeurs'''''''''''''''''''''''''''''''''''''''''''''''''''''
		
	//---------list of  chauffeurs------------    
		$scope.getChauffeurs=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/chauffeurs'
			   }).then(function (response){
		               $scope.chauffeursList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getChauffeurs();
		
	//---------enregister un transport ------------    
		$scope.saveTransport=function(){
			$scope.transport.active=true;
			   $http.post('http://localhost:8080/transports/'+$scope.chauffeur.cin+'/'+$scope.aide.cin+'/'+$scope.vehicule.matricule,$scope.transport)
	 				
				   .then(function (response){
						 $scope.transport=response.data._embedded.transports;  
			  
				   },function (error){
					    console.log(err);
				   });
				}
		
	//---------list of transport ------------    
		$scope.getTransports=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/transports'
			   }).then(function (response){
		               $scope.transportsList = response.data;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getTransports();
		
	
		
		
        
        $scope.deleteTransport = function(param){
		       
		    var r = confirm("Are you sure?");
		    if (r == true) {
		    	
		       // your delete code
		    	
		    	$http({
				      method: 'get',
				      url: 'http://localhost:8080/transports/'+param+'/desable'
				     
				   }).then(function (response){
			  
				   },function (error){
					    console.log(err);
				   });
		    } else {

		    }

		}
		

		//$scope.professeursList=Object.keys($scope.professeursList);
}]);