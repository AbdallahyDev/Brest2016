<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html ng-app="monApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<title>Accueil</title>
<script type="text/javascript" src="angular.js"></script>
 
 <script type="text/javascript">

var monApp = angular.module("monApp", []).
controller('TicketControl', ['$scope', '$http', function ($scope, $http) {
	$scope.ticket={};
	//alert("creerClient");
	$scope.connection = function () {
		  alert("creerClient");
	      $http({
	          method: 'POST',
	          url: 'connection.htm', 
	          headers: {'Content-Type': 'application/json'},
	          data:  $scope.ticket	
	        }).success(function (data)  
	          {
	        	alert("success ticket id: "+$scope.ticket.ticketId);
	        	//$scope.erreurs = data;
	        	//alert("ticket id: "+$scope.erreurs);
	        	$scope.erreurs = data;
	        	if (data.res == "SUCCESS") {
	     			//alert("success");
	     			$scope.mess = "Client " + $scope.ticket.ticketId + " identifie";
	     			$scope.ticket.ticketId = "";
	     			
	     			$http({
	    	          method: 'GET',
	    	          url: 'listerAnimation.htm',
	    	          headers: {'Content-Type': 'application/json'},
	    	     	}).success(function (data) 
	    	        {
	    	        	//alert("nb clients "+data.length);
	    	        	$scope.programs = data;
	    	      	})
	    	      	.error(function (data) 
	    	  	          {
			        	alert("failure");
		          });

	        	} 
	        	
	          })
	          .error(function (data) 
	          {
		        	alert("failure");
	          });
	      
	};

	
//	 		ng-pattern="/^[0-9]{1,8}$/" 

}]);

</script>
 
</head>
<body>
 
<form name="form" ng-controller="TicketControl" ng-submit="connection()" >
 
 CODE TICKET :  
			 <input id="id" name="id" type="text" value=" " 
			        ng-model="ticket.ticketId"
					ng-model-options="{ updateOn: 'blur' }"
			 		ng-required="true" 
			 		ng-pattern="/^[0-9]{2,}$/" /> 
			 		
			 		 
			 	<br/>	
           <div ng-show="form.id.$error.pattern">Not a valid number!</div>
           <div ng-show="form.id.$error.required">This field is required!</div>
           <br/>
			<button> Se connecter </button> 
			
		 

<br />
Voici le code : {{id}}


<br/>
<h1>The program today</h1> 
   <ul>

		<li ng-repeat="x in programs">{{x.animation.name}} {{x.animation.type}}</li>
	
	
	</ul>


</form>
 
</body>
</html>