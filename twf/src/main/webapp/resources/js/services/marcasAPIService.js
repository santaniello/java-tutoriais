angular.module("twfApplication").factory("marcasAPI", function ($http, config) {
	
	var _saveMarca = function (marca) {
		return $http.post(config.baseUrl+"/marcas",marca);
	};
	
	var _getMarcas = function () {
		return $http.get(config.baseUrl+"/marcas");
	};
	
	return {
		saveMarca: _saveMarca,
		getMarcas: _getMarcas	
	};
});