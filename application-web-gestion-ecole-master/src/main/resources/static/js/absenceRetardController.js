 

angular.module('ecole').controller('absenceRetardController', ['$scope', '$http', function($scope, $http) {
//app.controller('profController',function($scope,$http){
    $scope.elevesList=null;
    $scope.matiersList=null;
    $scope.classesList=null;
     
    $scope.absencesList=null;
    $scope.matieresAbsencesList=null;
   
    $scope.retardsList=null;
    
    
    
   // $scope.matiereAbsence=null;
    $scope.matiereAbsence={};
    $scope.eleveAbsent={};
    
   
    $scope.matiere={}
	$scope.type={}
    $scope.classe={}
	$scope.absence={};
     
    
    
    
       
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
		$scope.saveAbsenceRetard=function(){
		
			$http.post('http://localhost:8080/'+$scope.type.a+'/'+$scope.eleve.matricule+'/'+$scope.matiere.nomMatiere,$scope.absence)
			.then(function (response){
				if($scope.type.a=="absences"){
				$scope.absence=response.data._embedded.absences;} 
			
				else{
				$scope.absence=response.data._embedded.retards;} 
				
			   },function (error){
				    console.log(err);
			   });
			
			}
//
		//display the pop
		$scope.myFunction=function(x) {
		    var popup = document.getElementById(x);
		    popup.classList.toggle("show");
		}
//

		//liste des absences:
		$scope.getAbsences=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/absences'
			   }).then(function (response){
		               $scope.absencesList = response.data._embedded.absences;
 
		  
			   },function (error){
				    console.log(err);
			   });
			}	
		//$scope.getAbsences();
		//absence par classe
		$scope.getAbsencesParClasse=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/absences/classe/'+$scope.classe.nomClasse
			   }).then(function (response){
		               $scope.absencesList = response.data;
 
		  
			   },function (error){
				    console.log(err);
			   });
			}	
//		
		//get matiere form absence :
		$scope.getMatiereFromAbsence=function(id){
		 
			$http({
			      method: 'GET',
			      url: id
			   }).then(function (response){
		               $scope.matiereAbsence= response.data;
		               
		  
			   },function (error){
				    console.log(err);
			   });
			$scope.myFunction("matiere");
			return $scope.matiereAbsence.nomMatiere;
			}	
//		
		//get eleve from absence
		$scope.getEleveFromAbsence=function(id){
			$http({
			      method: 'GET',
			      url: id
			   }).then(function (response){
		               $scope.eleveAbsent= response.data;
		              // $scope.myFunction();
		               
		  
			   },function (error){
				    console.log(err);
			   });
			$scope.myFunction("eleve");
			
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
		
		//recuperer un  absence
		$scope.recupererabsence=function(x){
   			
			$http({
			      method: 'GET',
			      url:'http://localhost:8080/absence/'+x
			        
			   }).then(function (response){
				   $scope.absence=response.data;
	   				$scope.changeValue();
	   				
			   },function (error){
				    console.log(err);
			   });
   			
   			}
		
		//modifier devoir 
        $scope.updateDevoir=function(x){
			
			 
			$http.put('http://localhost:8080/devoirs/'+x,$scope.devoir)
			.then(function (response){
				 
				$scope.devoir=response.data;
				$route.reload();
				
			   },function (error){
				    console.log(err);
			   });
		
			}
        
        //supprimer un absence
	      
        $scope.deleteAbsence=function(x,param){
        	//$scope.recupererObservation(x);
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.delete('http://localhost:8080/absences/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
        
        //supprimer un retard
	      
        $scope.deleteRetard=function(x,param){
        	//$scope.recupererObservation(x);
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.delete('http://localhost:8080/retards/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
        
      //retard par classe
		$scope.getRetardsParClasse=function(){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/retards/classe/'+$scope.classe.nomClasse
			   }).then(function (response){
		               $scope.retardList = response.data;
 
		  
			   },function (error){
				    console.log(err);
			   });
			}	
        
//        $scope.getEleveFromRetard=function(id){
//			$http({
//			      method: 'GET',
//			      url'http://localhost:8080/retards/'+id
//			   }).then(function (response){
//		               $scope.eleve= response.data;
//		               
//		  
//			   },function (error){
//				    console.log(err);
//			   });
//			$scope.myFunction("eleve");
			
//			}	
		
	 
//________________fin_______________________________________________________________________________
		
           
    
}]);