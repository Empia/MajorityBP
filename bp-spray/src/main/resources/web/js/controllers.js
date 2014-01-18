'use strict';

var gabblerControllers =
  angular.module(
    'gabbler.controllers',
    [
      'gabbler.services'
    ]
  );

gabblerControllers.controller('HomeCtrl', ['$scope', 'Message', function($scope, Message) {

  $scope.messages = [];

  $scope.getMessages = function() {
    var messages = Message.query(function() {
      $scope.messages = messages.concat($scope.messages);

      $scope.getMessages();
    });
          console.log(messages);
  };

  $scope.message = new Message({ 'username': '' });

  $scope.sendMessage = function() {
    $scope.message.$save();
    $scope.message = new Message({ 'username': '' });
  };
}]);
