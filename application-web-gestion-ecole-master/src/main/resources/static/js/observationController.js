 

angular.module('ecole').controller('observationController', ['$scope', '$http', function($scope, $http) {
//app.controller('profController',function($scope,$http){
	// load
    $scope.elevesList=null;
    $scope.classesList=null;
    $scope.observationsList=null;
    $scope.matieresList=null;
    
   // store
    $scope.eleve={}
 
    $scope.classe={}
 
    $scope.observation={};
    
    var x=$scope.observation.idObservation;
    
       
 
  //list des eleves
	$scope.getEleves=function(){
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/eleves'
		   }).then(function (response){
	               $scope.elevesList = response.data;
	  
		   },function (error){
			    console.log(err);
		   });
		}	
	$scope.getEleves();
		
//_______________________observations:____________________________________________________________________
      
		//save observations:
		$scope.saveObservation=function(){
			if (x!=null) {
				$scope.updateObservation(x);
				   }
			else{
			$http.post('http://localhost:8080/observations/'+$scope.matiere.nomMatiere+'/'+$scope.eleve.matricule,$scope.observation)
			.then(function (response){
				 
				$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
			
			}
		
		//get classe:
		
		$scope.getClasses=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/classes'
			   }).then(function (response){
		               $scope.classesList = response.data._embedded.classes;
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		$scope.getClasses();
		
		//get eleves par classe
		$scope.getElevesParClasse=function(){
        	 
       		$http({
       		      method: 'GET',
       		      url: 'http://localhost:8080/eleves/'+$scope.classe.nomClasse
       		     
       		        
       		   }).then(function (response){
       			   $scope.elevesList=response.data;
       	              // $scope.getEmpedded($scope.emp.type,response);
       	  
       		   },function (error){
       			    console.log(err);
       		   });
       		}
		
		//get observations par eleve:
		 $scope.getObservationsParEleve=function(){
			 
	     		$http({
	     		      method: 'GET',
	     		      url: 'http://localhost:8080/observations/eleve/'+$scope.eleve.matricule
	     		     
	     		        
	     		   }).then(function (response){
	     			   $scope.observationsList=response.data;
	     	              // $scope.getEmpedded($scope.emp.type,response);
	     	  
	     		   },function (error){
	     			    console.log(err);
	     		   });
	     		}
		 
		//recuperer une observation
			$scope.recupererObservation=function(x){
	   			
				$http({
				      method: 'GET',
				      url:'http://localhost:8080/observations/'+x
				        
				   }).then(function (response){
					   $scope.observation=response.data;
		   			   $scope.changeValue();
		   				
				   },function (error){
					    console.log(err);
				   });
	   			
	   			}
			
			//modifier observation
	        $scope.updateObservation=function(x){
				
				 
				$http.put('http://localhost:8080/observtions/'+x,$scope.observation)
				.then(function (response){
					 
					$scope.observation=response.data;
					
				   },function (error){
					    console.log(err);
				   });
			
				}
	        //supprimer une observation
	      
	        $scope.deleteObservation=function(x,param){
	        	//$scope.recupererObservation(x);
	        	var r = confirm("Are you sure?");
	    	    if (r == true) { 
				$http.delete('http://localhost:8080/observations/'+x)
				.then(function (response){
					 
					//$scope.observation=response.data;
					
				   },function (error){
					    console.log(err);
				   });}
			
				}
	        
	      //liste des matieres:
			$scope.getMatieres=function(){
				$http({
				      method: 'GET',
				      url: 'http://localhost:8080/matieres'
				   }).then(function (response){
			               $scope.matieresList = response.data._embedded.matieres;
			  
				   },function (error){
					    console.log(err);
				   });
				}	
			$scope.getMatieres();
			
			
			
			//change value for te button :
	        $scope.changeValue=function()
	        {
	            document.getElementById('button').innerHTML = "Enregistrer la modification";
	            document.getElementById('titre').innerHTML =  "Modification d'une observation";
	        }
	        
	        
//________________fin_______________________________________________________________________________
         
         
  
}]);