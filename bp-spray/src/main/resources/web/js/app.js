'use strict';

var gabbler =
  angular.module(
    'gabbler',
    [
      'gabbler.services',
      'gabbler.controllers',
      'ngRoute'
    ]
  );

gabbler.config(['$routeProvider', function($routeProvider) {
  $routeProvider
    .when('/', { templateUrl: 'partials/home.html', controller: 'HomeCtrl' })
    .otherwise({ redirectTo: '/' });
}]);
