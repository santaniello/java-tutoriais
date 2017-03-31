angular.module("twfApplication").factory("correiosAPI", function ($http,config) {
	var _getEndereco = function (cep) {
		return $http.get(config.baseUrlCorreio+"/"+cep+"/json/");
	};

	return {
		getEndereco: _getEndereco		
	};
});