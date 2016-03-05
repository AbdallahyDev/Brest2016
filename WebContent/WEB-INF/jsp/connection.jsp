<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html ng-app="monApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<title>Accueil</title>

<script type="text/javascript" src="angular.js"></script>
 
 <script type="text/javascript" src="jscript/cntrl.js"></script>

 
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