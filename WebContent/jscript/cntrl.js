
var monApp = angular.module("monApp", []).
controller('TicketControl', ['$scope', '$http', '$window'  , function ($scope, $http, $window) {
	$scope.ticket={};
	//alert("creerClient");
	$scope.connection = function ($location) {
		  alert("rentrer en process");
	      $http({
	          method: 'POST',
	          url: 'connection.htm', 
	          headers: {'Content-Type': 'application/json'},
	          data:  $scope.ticket	
	          
	        }).success(function (data)  
	          {
	        	$scope.erreurs = data;
	        	if (data.res == "SUCCESS") {
	     			alert("connexion établie ");
		        	$window.location.href = 'listerAnimation.htm';
	        	}else{

	        		$scope.mess = "code incorret";
	        	}
	        	
	        	
	          })
	          .error(function (data) 
	          {
		        	alert("failure");
	          });
	      
	};



}]);

