angular.module("twfApplication").factory("categoriasAPI", function ($http, config) {
	
	var _saveCategoriaProduto = function (categoria) {
		return $http.post(config.baseUrl+"/categoriasProduto",categoria);
	};
	
	var _getCategoriasProduto = function () {
		return $http.get(config.baseUrl+"/categoriasProduto");
	};
	
	return {
		saveCategoriaProduto: _saveCategoriaProduto,
		getCategoriasProduto: _getCategoriasProduto	
	};
});