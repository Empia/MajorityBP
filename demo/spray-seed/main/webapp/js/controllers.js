'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('MyCtrl1', [function() {

  }])
  .controller('MyCtrl2', [function() {

  }]);

var gabblerControllers =
angular.module(
  'myApp.controllers',
  [
    'myApp.services'
  ]
);
gabblerControllers.controller('MyCtrl1', ['$scope', 'Message', function($scope, Message) {

//$scope.messages = [{'username': "lol", "text":"textss", "value": false, "type": "Block"}, $scope.mess];
$scope.messages = []
$scope.getMessages = function() {

   var messages = Message.query(function() {
    $scope.messages = messages.concat($scope.messages);

//    $scope.getMessages();
  });

        console.log(messages);
};

$scope.message = new Message({ 'username': '' });

$scope.sendMessage = function() {
  $scope.message.$save(); // POST Request
  console.log($scope.message);
  $scope.message = new Message({ 'username': '' });
};
}]);

