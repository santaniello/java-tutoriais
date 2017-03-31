angular.module("twfApplication").factory("loadingInterceptor", function ($q, $rootScope, $timeout) {
	return {
		request: function (config) {
			//$rootScope.loading = true;
			$("#mySpinner").modal('show');
			return config;
		},
		requestError: function (rejection) {
			//$rootScope.loading = false;
			  $("#mySpinner").modal('hide');
			return $q.reject(rejection);
		},
		response: function (response) {
			$timeout(function () {
			//$rootScope.loading = false;
			  $("#mySpinner").modal('hide');
			}, 500);
			return response;
		},
		responseError: function (rejection) {
			//$rootScope.loading = false;
			$("#mySpinner").modal('hide');
			return $q.reject(rejection);
		}
	};
});