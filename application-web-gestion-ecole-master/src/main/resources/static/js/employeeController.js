
angular.module('ecole').controller('NewEmpController', ['$scope', '$http','$rootScope', function($scope, $http,$rootScope) {

    
	$scope.perso={}
	$scope.test={};
	$scope.employees=null;
	$rootScope.empt=null;
	$scope.empEnabled=null;
	//$rootScope.personnel=null;
	//var x=null;  
	
//=================save an employee======================================
	$scope.saveEmp=function(){
		$scope.perso.active=true;
		
//		 if ($rootScope.x !=null) {
//				$scope.updateEmployee($rootScope.x);
//				   }
//		 else{
		$http.post('http://localhost:8080/'+$scope.test.type,$scope.perso)
	    .then(function (response){
			 
			$scope.perso=response.data;
			
		   },function (error){
			    console.log(err);
		   });
		
		}
	
	 

	
	$scope.getEmployeeParType=function(){
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/'+$scope.emp.type
		      
		   }).then(function (response){
			   $scope.employees= response.data
			//   $rootScope.salarie=$scope.emp.type;
			   
			   
			   
//	
	  
		   },function (error){
			    console.log(err);
		   });
		}
	
	$scope.getempTest=function(){
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/professeurs/6'
		   }).then(function (response){
			   
			   $scope.empt=response.data;
	
	  
		   },function (error){
			    console.log(err);
		   });
		}
	
	
	//get elemets with empedded:
	$scope.getEmpedded=function(x,response){
		
		   if (x == "professeurs") {
               $scope.employees= response.data._embedded.professeurs;
			} 
		   
		   else if (x == "gestionnaires") {
               $scope.employees= response.data._embedded.gestionnaires;
			}
		   
		   else if (x == "femmeDeMenages") {
               $scope.employees= response.data._embedded.femmeDeMenages;
               $rootScope.typePersonne="femmeDeMenages"
		   }
		   
		   else if (x == "secretaires") {
               $scope.employees= response.data._embedded.secretaires;
		   }
		   
		   else if (x == "directeurs") {
               $scope.employees= response.data._embedded.directeurs;
           }
		   
		   else if (x== "chauffeurs") {
               $scope.employees= response.data._embedded.chauffeurs;
               
           }else if (x== "gardiens") {
               $scope.employees= response.data._embedded.gardiens;
           }
		   
           else {
               $scope.employees= response.data._embedded.aides;
               $rootScope.typePersonne="aides";
           }
		   
//		   angular.forEach($scope.employees, function(value, key) {
//		       console.log(value.active=true);
//		       
//		    });
		
		}
	//list of mployee
	$scope.getEmp=function(id){
		$rootScope.url=id;
		$rootScope.salarie=$scope.emp.type;
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/'+$scope.emp.type+'/'+id
		      
		        
		   }).then(function (response){
			   $rootScope.empt=response.data;
	  
		   },function (error){
			    console.log(err);
		   });
		}
	 
	
	$scope.delete = function(param){
       
	    var r = confirm("Are you sure?");
	    if (r == true) {
	    	
	       // your delete code
	    	
	    	$http({
			      method: 'get',
			      url: 'http://localhost:8080/'+$rootScope.salarie+'/'+$rootScope.url+'/desable'
			     
			     // data:
			   }).then(function (response){
				 //  $rootScope.empt=response.data;
		              // $scope.getEmpedded($scope.emp.type,response);
		  
			   },function (error){
				    console.log(err);
			   });
	    } else {

	    }

	}
	$scope.recupererEmp=function(){
		$http({
		      method: 'get',
		      url: 'http://localhost:8080/'+$rootScope.salarie+'/'+$rootScope.url
			     
		      
		   }).then(function (response){
			   $scope.perso=response.data
			   $rootScope.personnel=$scope.perso;
			   $rootScope.personnel.type=$rootScope.salarie;
			   $scope.perso=$rootScope.personnel;
			   $scope.changeValue();
	  
		   },function (error){
			    console.log(err);
		   });
		
	}
	//change value for te button :
    $scope.changeValue=function()
    {
        document.getElementById('button').innerHTML = "Enregistrer la modification";
        document.getElementById('titre').innerHTML =  "Modification d'un employee";
    }
 
    
  //modifier un employee
    $scope.updateEmployee=function(x){
		
		 
		$http.put('http://localhost:8080/professeurs',$scope.perso)
		.then(function (response){
			 
			$scope.perso=response.data;
			//$route.reload();
			
		   },function (error){
			    console.log(err);
		   });
	
		}
    
    //=====================export pdf 
    
  
        $scope.data=  [{"agence":"CTM","secteur":"Safi","statutImp":"operationnel"}];
        
        $scope.export = function(){
           html2canvas(document.getElementById('exportthis'), {
               onrendered: function (canvas) {
                   var data = canvas.toDataURL();
                   var docDefinition = {
                       content: [{
                           image: data,
                           width: 500,
                       }]
                   };
                   pdfMake.createPdf(docDefinition).download("test.pdf");
               }
           });
        }
}]);