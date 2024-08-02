 

angular.module('ecole').controller('loginController', ['$scope','$http','$rootScope','$location', function($scope, $http,$rootScope,$location) {
 

	 var authenticate = function(callback){
			$http({
			      method: 'GET',
			      url: 'http://localhost:8080/user'
			   }).then(function (response){
				   if (response.data.name) {
				        $rootScope.authenticated = true;
				      } else {
				        $rootScope.authenticated = false;
				      }
				      callback && callback();
		  
			   },function (error){
				    console.log(err);
				    $rootScope.authenticated = false;
				    callback && callback();
			   });
			}	
		 
			  
			  authenticate();
			  $scope.credentials = {};
			  
			  
			  
			  $scope.login=function(){
					
					$http.post('login',$scope.credentials)
					.then(function (response){
						 authenticate(function() {
						        if ($rootScope.authenticated) {
						          $location.path("/");
						          $scope.error = false;
						        } else {
						          $location.path("/login");
						          $scope.error = true;
						        }
						      });
					   },function (error){
						    console.log(err);
						    $location.path("/login");
						      $scope.error = true;
						      $rootScope.authenticated = false;
					   });
					
					}
			  
			  
			  
         
}]);