angular.module("twfApplication").config(function ($httpProvider) {
	$httpProvider.interceptors.push("errorInterceptor");
	$httpProvider.interceptors.push("loadingInterceptor");
});