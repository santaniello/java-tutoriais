angular.module("twfApplication").factory("produtosAPI", function ($http, config) {
	
	var _saveProduto = function (produto) {
		return $http.post(config.baseUrl+"/produtos",produto);
	};	
	
	var _updateProduto = function (produto) {
		return $http.put(config.baseUrl+"/produtos/"+produto.id,produto);
	};	
	
	
	var _getProdutos = function () {
		return $http.get(config.baseUrl+"/produtos");
	};
	
	var _getProdutoById = function (id) {
		return $http.get(config.baseUrl+"/produtos/"+id);
	};	
	
	var _deleteProduto = function (id) {
		return $http.delete(config.baseUrl+"/produtos/"+id);
	};

	return {
		saveProduto:    _saveProduto,
		updateProduto:  _updateProduto,
		getProdutos:    _getProdutos,
		getProdutoById: _getProdutoById,
		deleteProduto:  _deleteProduto
	};
});