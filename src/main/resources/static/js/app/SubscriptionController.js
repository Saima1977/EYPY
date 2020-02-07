'use strict'

var module = angular.module('test.controllers', []);
module.controller("SubscriptionController", [ "$scope", "SubscriptionService",
		function($scope, SubscriptionService) {

      $scope.frequency= [
        { name: 'DAILY'},
        { name: 'WEEKLY' },
        { name: 'MONTHLY' }
      ];

      $scope.dayWeek = [
           { weekday: 'SUNDAY'},
           { weekday: 'MONDAY'},
           { weekday: 'TUESDAY'},
           { weekday: 'WEDNESDAY'},
           { weekday: 'THURSDAY'},
           { weekday: 'FRIDAY' },
           { weekday: 'SATURDAY' }
          ];

      $scope.dayDate= [
        { day: '1'},
        { day: '2'},
        { day: '3'},
        { day: '4'},
        { day: '5'},
        { day: '6'},
        { day: '7'},
        { day: '8'},
        { day: '9'},
        { day: '10'},
        { day: '11'},
        { day: '12'},
        { day: '13'},
        { day: '14'},
        { day: '15'},
        { day: '16'},
        { day: '17'},
        { day: '18'},
        { day: '19'},
        { day: '20'},
        { day: '21'},
        { day: '22'},
        { day: '23'},
        { day: '24'},
        { day: '25'},
        { day: '26'},
        { day: '27'},
        { day: '28'},
        { day: '29'},
        { day: '30'},
        { day: '31'}
       ];


			$scope.subscriptionDto = {
				subscriptionId : null,
				chargeAmount : null,
				frequency : null,
				day : null,
				invoiceDate: null,
				startDate : null,
				endDate : null
			};

			SubscriptionService.getSubscriptionById(1).then(function(value) {
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.saveSubscription = function() {
				SubscriptionService.saveSubscription($scope.subscriptionDto).then(function() {
					console.log("works");
					SubscriptionService.getAllSubscriptions().then(function(value) {
						$scope.allSubscriptions= value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.subscriptionDto = {
				    subscriptionId : null,
				    chargeAmount : null,
				    frequency : null,
				    day : null,
				    invoiceDate: null,
				    startDate : null,
				    endDate : null
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);