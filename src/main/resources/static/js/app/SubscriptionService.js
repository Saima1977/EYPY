'use strict'

angular.module('test.services', []).factory('SubscriptionService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getSubscriptionById = function(subscriptionId) {
				var url = CONSTANTS.getSubscriptionByIdUrl + subscriptionId;
				return $http.get(url);
			}
			service.getAllSubscriptions= function() {
				return $http.get(CONSTANTS.getAllSubscriptions);
			}
			service.saveSubscription = function(subscriptionDto) {
				return $http.post(CONSTANTS.saveSubscription, subscriptionDto);
			}
			return service;
		} ]);