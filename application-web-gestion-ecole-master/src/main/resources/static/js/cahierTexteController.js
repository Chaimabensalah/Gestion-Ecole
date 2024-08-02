 

angular.module('ecole').controller('cahierTexteController', ['$scope', '$http', function($scope, $http) {
//app.controller('profController',function($scope,$http){
    
    $scope.matiersList=null;
    $scope.classesList=null;
 
    $scope.cahierTextesList=null;

    $scope.matiere={}
	$scope.type={}
    $scope.classe={}
    $scope.cahierTexte={};
	
    
    $scope.cahierTexte={};
    var x=$scope.cahierTexte.idCahierTexte;    
       
   
         
 //________________cahier de text ;debut_____________________________________________________________
        
         $scope.saveCahierText=function(){
        	 if (x!=null) {
 				$scope.updateCahierTexte(x);
 				   }
 			else{
 			$http.post('http://localhost:8080/cahierTextes/'+$scope.matiere.nomMatiere+'/'+$scope.classe.nomClasse,$scope.cahierTexte)
 			.then(function (response){
 				 
 				$scope.cahierTexte=response.data;
 				
 			   },function (error){
 				    console.log(err);
 			   });
 			}}
         
         //recuperer le cahier de texte dun classe 
         $scope.getCahierTextesParClasse=function(){
           $scope.cahierTextesList=null;
        	 
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/cahierTextes/classe/'+$scope.classe.nomClasse
     		     
     		        
     		   }).then(function (response){
     			   $scope.cahierTexte=response.data;
     	              // $scope.getEmpedded($scope.emp.type,response);
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
         
         //recuperer les cahiers de texte par matiere
         $scope.getCahierTextesParMatiere=function(){
          // $scope.cahierTextesList=null;
        	 
     		$http({
     		      method: 'GET',
     		      url: 'http://localhost:8080/cahierTextes/matiere/'+$scope.matiere.nomMatiere
     		     
     		        
     		   }).then(function (response){
     			   $scope.cahierTextesList=response.data;
     	              // $scope.getEmpedded($scope.emp.type,response);
     	  
     		   },function (error){
     			    console.log(err);
     		   });
     		}
         //obtenir tout les cahier de texte
         $scope.getAllCahierTextes=function(){
         	 
      		$http({
      		      method: 'GET',
      		      url: 'http://localhost:8080/cahierTextes'
      		     
      		        
      		   }).then(function (response){
      			   $scope.cahierTextesList=response.data;
      	  
      		   },function (error){
      			    console.log(err);
      		   });
      		}
      //   $scope.getAllCahierTextes();
         

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
 		
 		//change value for te button :
         $scope.changeValue=function()
         {
             document.getElementById('button').innerHTML = "Enregistrer la modification";
             document.getElementById('titre').innerHTML =  "Modification d'un cahier de texte";
         }
         
         
       //recuperer un seul cahier de texte
 		$scope.recupererCahierTexte=function(x){
    			
 			$http({
 			      method: 'GET',
 			      url:'http://localhost:8080/cahierTextes/'+x
 			        
 			   }).then(function (response){
 				   $scope.cahierTexte=response.data;
 	   				$scope.changeValue();
 	   				
 			   },function (error){
 				    console.log(err);
 			   });
    			
    			}
 		
 		//modifier un cahier de texte
         $scope.updateCahierTexte=function(x){
 			
 			 
 			$http.put('http://localhost:8080/cahierTextes/'+x,$scope.cahierTexte)
 			.then(function (response){
 				 
 				$scope.cahierTexte=response.data;
 				//$route.reload();
 				
 			   },function (error){
 				    console.log(err);
 			   });
 		
 			}
         
         
         //supprimer un cahierTexte 
	      
         $scope.deleteCahierTexte=function(x,param){
         	//$scope.recupererObservation(x);
         	var r = confirm("Are you sure?");
     	    if (r == true) { 
 			$http.delete('http://localhost:8080/cahierTextes/'+x)
 			.then(function (response){
 				 
 				//$scope.observation=response.data;
 				
 			   },function (error){
 				    console.log(err);
 			   });}
 		
 			}
//________________fin________________________________________________________________________________
         

         
}]);