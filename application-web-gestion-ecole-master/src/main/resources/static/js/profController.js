 

angular.module('ecole').controller('profController', ['$scope', '$http', function($scope, $http) {
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
    
       
   
 //___________________________________examen ______________________________________
         $scope.saveExamen=function(){
  			
        	 if (x!=null) {
 				$scope.updateexamen(x);
 				   }
 			else{
  			$http.post('http://localhost:8080/examens/'+$scope.matiere.nomMatiere+'/'+$scope.classe.nomClasse,$scope.examen)
  			.then(function (response){
  				 
  				$scope.examen=response.data._embedded.examens;
  				
  			   },function (error){
  				    console.log(err);
  			   });
  			
  			}
         }
         
         $scope.getExamensParMatiere=function(){
   			
   			$http.get('http://localhost:8080/examens/matiere/'+$scope.matiere.nomMatiere)
   			.then(function (response){
   				 
   				$scope.examensList=response.data;
   				
   			   },function (error){
   				    console.log(err);
   			   });
   			
   			}
       //  $scope.getExamens();
         
     	//recuperer un  examen 
 		$scope.recupererExamen=function(x){
    			
 			$http({
 			      method: 'GET',
 			      url:'http://localhost:8080/examens/id/'+x
 			        
 			   }).then(function (response){
 				   $scope.examen=response.data;
 	   				$scope.changeValue();
 	   				
 			   },function (error){
 				    console.log(err);
 			   });
    			
    			}
       //modifier une examen
         $scope.modifierExamen=function(x){
   			
   			$http.get('http://localhost:8080/examen/'+x)
   			.then(function (response){
   				 
   				$scope.examen=response.data;
   				$scope.changeValue();
   				
   			   },function (error){
   				    console.log(err);
   			   });
   			
   			}
         
         //change value for te button :
         $scope.changeValue=function()
         {
             document.getElementById('button').innerHTML = "Enregistrer la modification";
             document.getElementById('titre').innerHTML =  "modification d'un examen";
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
    		
    	    
            //supprimer un controle
    	      
            $scope.deleteExamen=function(x,param){

            	var r = confirm("Are you sure?");
        	    if (r == true) { 
    			$http.delete('http://localhost:8080/examens/'+x)
    			.then(function (response){
    				 
    				//$scope.observation=response.data;
    				
    			   },function (error){
    				    console.log(err);
    			   });}
    		
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
          $scope.getGardes();
          
//_______________________________classes________________________
          

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
    		
    		 //get leves par classe (parametre)
            
            $scope.getElevesParClasse2=function(x){
            	 
           		$http({
           		      method: 'GET',
           		      url: 'http://localhost:8080/eleves/'+x
           		     
           		        
           		   }).then(function (response){
           			   $scope.elevesList=response.data;
           	              // $scope.getEmpedded($scope.emp.type,response);
           	  
           		   },function (error){
           			    console.log(err);
           		   });
           		}
         
}]);