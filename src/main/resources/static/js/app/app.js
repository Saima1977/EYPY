'use strict'

var testApp = angular.module('test', [ 'ui.bootstrap', 'test.controllers',
		'test.services' ]);
testApp.constant("CONSTANTS", {
	getSubscriptionByIdUrl : "/subscription/getSubscription/",
	getAllSubscriptions : "/subscription/getAllSubscriptions",
	saveSubscription : "/subscription/saveSubscription"
});