 

angular.module('ecole').controller('devoirController', ['$scope', '$http' , function($scope, $http,$route) {
//app.controller('profController',function($scope,$http){
    $scope.matiersList=null;
    $scope.classesList=null;
    
    $scope.devoirsList=null;

    $scope.matiere={}
	 
    $scope.classe={}
	 
    $scope.devoir={};
    
    var x=$scope.devoir.idDevoir;
  
    
       
 
//________________devoir______________________________________________________________________________
		
		//save un devoir
		$scope.saveDevoir=function(){
			
			if (x!=null) {
				$scope.updateDevoir(x);
				   }
			else{
			$http.post('http://localhost:8080/devoirs/'+$scope.matiere.nomMatiere+'/'+$scope.classe.nomClasse,$scope.devoir)
			.then(function (response){
				 
				$scope.devoir=response.data;
				
			   },function (error){
				    console.log(err);
			   });
			
			}}
		
		
		
//
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
//		
		//classer les  devoirs par matiere
		$scope.getDevoirParMatiere=function(){
	     	 
	     		$http({
	     		      method: 'GET',
	     		      url: 'http://localhost:8080/devoirs/matiere/'+$scope.matiere.nomMatiere
	     		     
	     		        
	     		   }).then(function (response){
	     			   $scope.devoirsList=response.data;
	     	              // $scope.getEmpedded($scope.emp.type,response);
	     	  
	     		   },function (error){
	     			    console.log(err);
	     		   });
	     		}
		
		//recuperer un  devoir
		$scope.recupererDevoir=function(x){
   			
			$http({
			      method: 'GET',
			      url:'http://localhost:8080/devoirs/'+x
			        
			   }).then(function (response){
				   $scope.devoir=response.data;
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
        
        //supprimer une observation
	      
        $scope.delete=function(x,param){
        	//$scope.recupererObservation(x);
        	var r = confirm("Are you sure?");
    	    if (r == true) { 
			$http.delete('http://localhost:8080/devoirs/sup/'+x)
			.then(function (response){
				 
				//$scope.observation=response.data;
				
			   },function (error){
				    console.log(err);
			   });}
		
			}
//________________fin________________________________________________________________________________
		
		
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
            document.getElementById('titre').innerHTML =  "modification d'un devoir";
        }
//        //loading the page
//        $scope.myLoadingFunction=function() {
//            $state.reload();
//        };
}]);	
 