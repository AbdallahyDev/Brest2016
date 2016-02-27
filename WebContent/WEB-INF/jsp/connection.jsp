<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html ng-app="monApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<title>Accueil</title>
<script type="text/javascript" src="angular.js"></script>
 
 <script type="text/javascript">

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

</script>
 
</head>
<body>
 
<form name="form" ng-controller="TicketControl" ng-submit="connection()" >
 
 CODE TICKET :  
			 <input id="id" name="id" type="text" value="" 
			        ng-model="ticket.ticketId"
					ng-model-options="{ updateOn: 'blur' }"
			 		ng-required="true" 
			 		ng-pattern="/[0-9]{1,}$/" />  {{mess}}
			 		
			 		 
			 	<br/>	
           <div ng-show="form.id.$error.pattern">Not a valid number!</div>
          
           <br/>
			<button> Se connecter </button> 
			
		 

<br />
<br/>



</form>
 
</body>
</html>