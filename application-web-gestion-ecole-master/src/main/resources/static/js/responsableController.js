angular.module('ecole').controller('responsableController', ['$scope', '$http','$rootScope',function($scope, $http,$rootScope) {
//app.controller('profController',function($scope,$http){
   
	$scope.elevesList=null;
	$scope.absencesList=null;
	$scope.matieresList=null;
	//$$rootScope.eleve=null
	
    $scope.classesList=null;
    $scope.examensList=null;
    $scope.absencesList=null;
    $scope.matieresAbsencesList=null;
    
    $scope.devoirsList=null;
    $scope.notesList=null;
    $scope.retardsList=null;
 
   
    
    $scope.eleve={}
    
    $scope.matiereAbsence={};
    $scope.eleveAbsent={};
    $scope.matiere={}
	$scope.type={}
    $scope.classe={}
	$scope.absence={};
    $scope.devoir={};
    $scope.observation={};
    $scope.note={};
    $scope.cahierTexte={};
    $scope.examen={};
    
    
    $scope.getResponsableConnected=function(){
        
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/responsables/one/38'
		        
		   }).then(function (response){
			   $rootScope.empt=response.data;
	  
		   },function (error){
			    console.log(err);
		   });
		}
    $scope.getResponsableConnected();
       
//________________absence et retard ___________________________________________________________
		
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
//		
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
//		
		//save absence et retard
		 
//
		//display the pop
		$scope.myFunction=function(x) {
		    var popup = document.getElementById(x);
		    popup.classList.toggle("show");
		}
//

		//liste des absences:
		$scope.getAbsencesParEleve=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/absences/eleve/'+$scope.eleve.matricule
			   }).then(function (response){
		               $scope.absencesList = response.data;
 
		  
			   },function (error){
				    console.log(err);
			   });
			}
		
		$scope.justifier=function(x){
			
			 
			$http.get('http://localhost:8080/absences/justifier/'+x)
			.then(function (response){
				 
				$scope.absence=response.data;
				
			   },function (error){
				    console.log(err);
			   });
			
			}
		 
//		
//		//get matiere form labsence :
//		$scope.getMatiereFromAbsence=function(id){
//		 
//			$http({
//			      method: 'GET',
//			      url: id
//			   }).then(function (response){
//		               $scope.matiereAbsence= response.data;
//		               
//		  
//			   },function (error){
//				    console.log(err);
//			   });
//			$scope.myFunction("matiere");
//			return $scope.matiereAbsence.nomMatiere;
//			}	
////		
//		//get eleve from absence
//		$scope.getEleveFromAbsence=function(id){
//			$http({
//			      method: 'GET',
//			      url: id
//			   }).then(function (response){
//		               $scope.eleveAbsent= response.data;
//		              // $scope.myFunction();
//		               
//		  
//			   },function (error){
//				    console.log(err);
//			   });
//			$scope.myFunction("eleve");
//			
//			}	
	 
//________________fin_______________________________________________________________________________
		
 
//________________devoir______________________________________________________________________________
		
		 
		//classer les  devoirs par eleve
		$scope.getDevoirsParEleve=function(){
	     	 
	     		$http({
	     		      method: 'GET',
	     		      url: 'http://localhost:8080/devoirs/eleve/'+$scope.eleve.matricule
	     		     
	     		        
	     		   }).then(function (response){
	     			   $scope.devoirsList=response.data;
	     	              // $scope.getEmpedded($scope.emp.type,response);
	     	  
	     		   },function (error){
	     			    console.log(err);
	     		   });
	     		}
		 
		
//________________fin________________________________________________________________________________
		
		
		
//_______________________observations:____________________________________________________________________
      
		//save observations:
		$scope.saveObservation=function(){
			
			$http.post('http://localhost:8080/observations/'+$scope.matiere.nomMatiere+'/'+$scope.eleve.matricule,$scope.observation)
			.then(function (response){
				 
				$scope.observation=response.data._embedded.observations;
				
			   },function (error){
				    console.log(err);
			   });
			
			}
		
		//get observations par eleve:
		 $scope.getObservationsParEleve=function(){
			 $scope.observationsList=null;
	     		$http({
	     		      method: 'GET',
	     		      url: 'http://localhost:8080/observations/'+$scope.eleve.matricule
	     		     
	     		        
	     		   }).then(function (response){
	     			   $scope.observationsList=response.data;
	     	              // $scope.getEmpedded($scope.emp.type,response);
	     	  
	     		   },function (error){
	     			    console.log(err);
	     		   });
	     		}
//________________fin_______________________________________________________________________________
         
         
  
         
//________________notes_______________________________________________________________________________
          
         //obtenir les note par eleve
         $scope.getNotesParEleveAndMatiere=function(){
         	 
      		$http({
      		      method: 'GET',
      		      url: 'http://localhost:8080/notes/eleve/'+$scope.eleve.matricule+'/'+$scope.matiere.nomMatiere
      		     
      		        
      		   }).then(function (response){
      			   $scope.notesList=response.data;
      	              // $scope.getEmpedded($scope.emp.type,response);
      	  
      		   },function (error){
      			    console.log(err);
      		   });
      		}
         
         
         
//_____________________________________fin_______________________________________________________________
       
 //___________________________________examen ______________________________________
         
         
         $scope.getcontrolesParEleve=function(){
   			
   			$http.get('http://localhost:8080/examens/'+$scope.eleve.matricule)
   			.then(function (response){
   				 
   				$scope.examensList=response.data._embedded.examens;
   				
   			   },function (error){
   				    console.log(err);
   			   });
   			
   			}
              
       //________________fin______________________________________
//__________________________gardes_________________________________________________________________________________________      
         $scope.getGardes=function(){
    			
    			$http.get('http://localhost:8080/gardes/')
    			.then(function (response){
    				 
    				$scope.gardes=response.data;
    				
    			   },function (error){
    				    console.log(err);
    			   });
    			
    			}
          $scope.getGardes();
         
}]);