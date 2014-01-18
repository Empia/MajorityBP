'use strict';

var gabblerServices =
  angular.module(
    'gabbler.services',
    [
      'ngResource'
    ]
  );

gabblerServices.factory(
  'Message',
  function($resource) {
    return $resource('api/messages');
  });
