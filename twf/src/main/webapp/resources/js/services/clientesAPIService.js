angular.module("twfApplication").factory("clientesAPI", function ($http, config) {
	
	var _saveCliente = function (cliente) {
		return $http.post(config.baseUrl+"/clientes",cliente);
	};	
	
	var _updateCliente = function (cliente) {
		return $http.put(config.baseUrl+"/clientes/"+cliente.id,cliente);
	};	
	
	
	var _getClientes = function () {
		return $http.get(config.baseUrl+"/clientes");
	};
	
	var _getClienteById = function (id) {
		return $http.get(config.baseUrl+"/clientes/"+id);
	};	
	
	var _deleteCliente = function (id) {
		return $http.delete(config.baseUrl+"/clientes/"+id);
	};

	return {
		saveCliente:    _saveCliente,
		updateCliente:  _updateCliente,
		getClientes:    _getClientes,
		getClienteById: _getClienteById,
		deleteCliente:  _deleteCliente
	};
});