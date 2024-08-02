 

angular.module('ecole').controller('notesController', ['$scope', '$http', function($scope, $http) {
//app.controller('profController',function($scope,$http){
    $scope.elevesList=null;
    $scope.matiersList=null;
    $scope.classesList=null;
    $scope.examensList=null;
    $scope.absencesList=null;
    $scope.matieresAbsencesList=null;
    $scope.cahierTextesList=null;
    $scope.devoirsList=null;
    $scope.notesList=null;
    $scope.retardsList=null;
    
    
    
   // $scope.matiereAbsence=null;
    $scope.matiereAbsence={};
    $scope.eleveAbsent={};
    $scope.note={};
    
    
    
    $scope.eleve={}
    $scope.matiere={}
	$scope.type={}
    $scope.classe={}
	$scope.absence={};
    $scope.devoir={};
    $scope.observation={};
    
    $scope.cahierTexte={};
    $scope.examen={};
    
    var x=$scope.examen.idExamen
    
       
   
 
         
//________________notes_______________________________________________________________________________
         $scope.saveNote=function(){
  			
  			$http.post('http://localhost:8080/notes/'+$scope.matiere.nomMatiere+'/'+$scope.eleve.matricule,$scope.note)
  			.then(function (response){
  				 
  				$scope.note=response.data._embedded.notes;
  				
  			   },function (error){
  				    console.log(err);
  			   });
  			
  			}
         //obtenir les notes par classe
         $scope.getNotesParClasseAndMatiere=function(){
         	 
      		$http({
      		      method: 'GET',
      		      url: 'http://localhost:8080/notes/'+$scope.classe.nomClasse+'/'+$scope.matiere.nomMatiere
      		     
      		        
      		   }).then(function (response){
      			   $scope.notesList=response.data;
      	              // $scope.getEmpedded($scope.emp.type,response);
      			   
      	  
      		   },function (error){
      			    console.log(err);
      		   });
      		}
         //get eleve par classe (scope)
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
         
        
         //modifier une note
         $scope.modifierNote=function(x){
   			
   			$http.get('http://localhost:8080/notes/'+x)
   			.then(function (response){
   				 
   				$scope.note=response.data;
   				$scope.getEleveParNote(x);
   				$scope.changeValue();
   				
   			   },function (error){
   				    console.log(err);
   			   });
   			
   			}
         
         $scope.getEleveParNote=function(x){
    			
    			$http.get('http://localhost:8080/notes/'+x+'/eleve')
    			.then(function (response){
    				 
    				$scope.eleve=response.data;
    				
    			   },function (error){
    				    console.log(err);
    			   });
    			
    			}
         //change value for te button :
         $scope.changeValue=function()
         {
             document.getElementById('button').innerHTML = "Enregistrer la modification";
             document.getElementById('titre').innerHTML =  "modification d'une note";
         }
         

         //liste des classes
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
		
		 //supprimer une note
	      
        $scope.deleteNote=function(x,param){
        	//$scope.recupererObservation(x);
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.delete('http://localhost:8080/notes/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
//_____________________________________fin_______________________________________________________________
       
         
}]);