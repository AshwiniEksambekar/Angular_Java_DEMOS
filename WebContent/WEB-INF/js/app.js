var app = angular.module("SellerConsumerApp",[]);
var renderButton = function() {
	  window.initGapi();
	};

app.controller("SellerConsumerAppCtrl",function($scope, $window){
	
	 $window.initGapi = function() {
		 gapi.signin2.render('my-signin2', {
				'scope' : 'profile email',
				'width' : 240,
				'height' : 50,
				'longtitle' : true,
				'theme' : 'dark',
				'onsuccess' : $scope.signIn,
				'onfailure' : $scope.onFailure
			});
		     }
	 $scope.onGSignInSuccess = false;
	$scope.user = {"role":"CONSUMER","username":"dummy"};
	
	$scope.signIn = function(googleUser) {
		var xhr = new XMLHttpRequest();
		var postObj = {
			"authToken" : googleUser.getAuthResponse().id_token,
					}
		xhr.open('POST', '/SellerConsumerApp/tokensignin',
				true);
		xhr.setRequestHeader('Content-Type', 'application/json; charset=utf8');
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				$scope.onGSignInSuccess = true;
				var object = JSON.parse(xhr.responseText);
				$scope.user.username = object.username;
				$scope.$apply();
			}
		};
		
		xhr.send(JSON.stringify(postObj));
	}
	$scope.onFailure = function(error) {
		console.log(error);
	}

	 $scope.signOut = function() {
		 var self = this;
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	     self.logout();

	    });
	  }
	 $scope.logout = function(){
		 $scope.onGSignInSuccess = false;
		 $scope.user = null;
		 $scope.$apply();
	 }
	 
	 $scope.changeMyRole = function(){
		 var xhr = new XMLHttpRequest();
			var postObj = {
				"username" : $scope.user.username,
				"role" : $scope.user.role
			}
			xhr.open('POST', '/SellerConsumerApp/changeRole',
					true);
			xhr.setRequestHeader('Content-Type', 'application/json; charset=utf8');
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
				
					var resp = JSON.parse(xhr.responseText);
					$scope.userrole = resp.role;
					$scope.$apply();
				}
			};
			
			xhr.send(JSON.stringify(postObj));
		
	 }

});
