<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="SellerConsumerApp">
<head>
<title>Seller Consumer App</title>
<meta charset="ISO-8859-1" name="google-signin-client_id"
	content="793050458250-qgigieiamh5u4agsfahinmtt2n6a86g1.apps.googleusercontent.com">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script src="/SellerConsumerApp/js/app.js" type="text/javascript"></script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton"
	async defer></script>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body ng-controller="SellerConsumerAppCtrl">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      SellerConsumerApp
    </div>

	<div ng-if="onGSignInSuccess">
		<h2>
			Welcome </h2> &nbsp; &nbsp; {{userrole}}</br>
			<i class="fa fa-user fa-lg-2px"></i><a href="#"
				ng-click="signOut();">Sign out</a> {{user.username}}

		</h3>

		<div class="container">
			<div class="jumbotron">
				<span style="color: red">Select role(*)</span> 
				<select ng-model="user.role" name="role" class="form-control"><option value="SELLER">SELLER</option><option value="CONSUMER">CONSUMER</option></select>
					<button class="btn btn-success pull-right" ng-click="changeMyRole()">Change Role</button>
			</div>
		</div>
	</div>
	<br />
	<div class="container" ng-if="!onGSignInSuccess" id="my-signin2"></div>
	
</body>
</html>
