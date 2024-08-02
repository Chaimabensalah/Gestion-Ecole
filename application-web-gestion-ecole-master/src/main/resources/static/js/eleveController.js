angular.module('ecole').controller('eleveController', ['$scope', '$http', function($scope, $http) {
//app.controller('profController',function($scope,$http){
   
	 
	$scope.absencesList=null;
	
	
	$scope.matieresList=null;
    $scope.classesList=null;
    $scope.examensList=null;
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
    $scope.examen={};
    
       
//________________absence et retard ___________________________________________________________
		
      
    
  //liste des absences:
	$scope.getAbsencesEleve=function(){
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/absences/eleve/bou56623'
		   }).then(function (response){
	               $scope.absencesList = response.data;

	  
		   },function (error){
			    console.log(err);
		   });
		}	
	 $scope.getAbsencesEleve();
//=========================================================================================
	
	//________________notes_______________________________________________________________________________
     
     //obtenir les note par eleve
     $scope.getNotesParEleveAndMatiere=function(){
     	 
  		$http({
  		      method: 'GET',
  		      url: 'http://localhost:8080/notes/eleve/bou56623/'+$scope.matiere.nomMatiere
  		     
  		        
  		   }).then(function (response){
  			   $scope.notesList=response.data;
  	  
  		   },function (error){
  			    console.log(err);
  		   });
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
     
//_____________________________________fin_______________________________________________________________

	 
	 
//-----------------------------------------------------------------------------------------
//		
		
 
//
		//display the pop
		$scope.myFunction=function(x) {
		    var popup = document.getElementById(x);
		    popup.classList.toggle("show");
		}
 
//________________devoir______________________________________________________________________________
		
		 
		//classer les  devoirs par eleve
		$scope.getDevoirsParEleve=function(){
	     	 
	     		$http({
	     		      method: 'GET',
	     		      url: 'http://localhost:8080/devoirs/eleve/bou56623'
	     		     
	     		        
	     		   }).then(function (response){
	     			   $scope.devoirsList=response.data;
	     	  
	     		   },function (error){
	     			    console.log(err);
	     		   });
	     		}
		 
		
//________________fin________________________________________________________________________________
		
		
		
//_______________________observations:____________________________________________________________________
       
		
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
         
 //___________________________________examen ______________________________________
         
         
         $scope.getcontrolesParEleve=function(){
   			
   			$http.get('http://localhost:8080/examens/bou56623')
   			.then(function (response){
   				 
   				$scope.examensList=response.data;
   				
   			   },function (error){
   				    console.log(err);
   			   });
   			
   			}
              
       //________________fin______________________________________
//__________________________gardes_________________________________________________________________________________________      
         $scope.getGardes=function(){
    			
    			$http.get('http://localhost:8080/gardes/')
    			.then(function (response){
    				 
    				$scope.gardes=response.data._embedded.gardes;
    				
    			   },function (error){
    				    console.log(err);
    			   });
    			
    			}
         // $scope.getGardes();
         
}]);