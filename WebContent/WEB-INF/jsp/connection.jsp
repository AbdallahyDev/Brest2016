<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html ng-app="monApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<title>Accueil</title>
<script type="text/javascript" src="angular.js"></script>
 
 <script type="text/javascript">

var monApp = angular.module("monApp", []).
controller('AnimationControl', ['$scope', '$http', function ($scope, $http) {
	$scope.ticket = {};
	$scope.listerAnimation = function () {
		//alert("creerClient");
	      $http({
	          method: 'GET',
	          url: 'connection.htm',
	          headers: {'Content-Type': 'application/json'},
	          data:  $scope.ticket
	        }).success(function (data) 
	          {
	        	//alert("nb clients "+data.length);
	        	$scope.erreurs = data;
	        	if (data.res == "SUCCESS") {
	     			//alert("success");
	     			$scope.mess = "Client " + $scope.ticket.nom + " enregistré";
	     			$scope.ticket.id = "";
	     			$http({
	    	          method: 'GET',
	    	          url: 'connection.htm',
	    	          headers: {'Content-Type': 'application/json'},
	    	     	}).success(function (data) 
	    	        {
	    	        	//alert("nb clients "+data.length);
	    	        	$scope.ticket = data;
	    	      	});

	        	}
	          });

	};


}]);

</script>
 
</head>
<body>
 
<form name="form" ng-controller="AnimationControl" ng-submit="listerAnimation()" >
 
 CODE TICKET :  
			 <input id="ticket" name="ticket" type="text" value=" " 
			        ng-model="ticket.id"
					ng-model-options="{ updateOn: 'blur' }"
			 		ng-required="true" 
			 		ng-pattern="/^[0-9]{1,8}$/" /> 
           <span ng-show="form.ticket.$error.pattern">Not a valid number!</span>
           <span ng-show="form.ticket.$error.required">This field is required!</span>
        
			 <button>Ajouter client</button> 
		</tr>
	</table>

<br />

</form>
 
</body>
</html>