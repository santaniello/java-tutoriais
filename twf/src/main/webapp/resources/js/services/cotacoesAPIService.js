angular.module("twfApplication").factory("cotacoesAPI", function ($http, config) {
	
	var _saveCotacao = function (cotacao) {
		return $http.post(config.baseUrl+"/cotacoes",cotacao);
	};
	
	var _getCotacoesByProdutoId = function (cotacao) {
		return $http.get(config.baseUrl+"/cotacoes/"+cotacao.produto.id);
	};	
	
	var _getCotacoes = function () {
		return $http.get(config.baseUrl+"/cotacoes");
	};
	
	return {
		saveCotacao: _saveCotacao,
		getCotacoesByProdutoId : _getCotacoesByProdutoId,
		getCotacoes: _getCotacoes,
		
	};
});