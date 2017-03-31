angular.module("twfApplication").factory("fornecedoresAPI", function ($http, config) {
	
	var _saveFornecedor = function (fornecedor) {
		return $http.post(config.baseUrl+"/fornecedores",fornecedor);
	};	
	
	var _updateFornecedor = function (fornecedor) {
		return $http.put(config.baseUrl+"/fornecedores/"+fornecedor.id,fornecedor);
	};	
	
	
	var _getFornecedores = function () {
		return $http.get(config.baseUrl+"/fornecedores");
	};
	
	var _getFornecedorById = function (id) {
		return $http.get(config.baseUrl+"/fornecedores/"+id);
	};	
	
	var _deleteFornecedor = function (id) {
		return $http.delete(config.baseUrl+"/fornecedores/"+id);
	};

	return {
		saveFornecedor:    _saveFornecedor,
		updateFornecedor:  _updateFornecedor,
		getFornecedores:    _getFornecedores,
		getFornecedorById: _getFornecedorById,
		deleteFornecedor:  _deleteFornecedor
	};
});