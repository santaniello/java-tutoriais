angular.module("twfApplication").controller("clienteCtrl", function ($scope, config, correiosAPI,clientesAPI,twfAPI, $location) {	
	
	//-------------------Inicializando variaveis e componentes----------------------------------
	
	$scope.cliente = {};	
	$scope.clientes = [];	
	
	//-------------------CRUD e Operações--------------------------------------------------------
	
	$scope.getEndereco = function () {
		correiosAPI.getEndereco($scope.cliente.cep).success(function (data,status) {
			$scope.cliente.logradouro = data.logradouro;
			$scope.cliente.bairro = data.bairro;
			$scope.cliente.cidade = data.localidade;
			$scope.cliente.uf 	  = data.uf;			
		}).error(function (data, status,headers,config,statusText) {
			swal({title: "Atenção!", 
				  text: "Não foi encontrado nenhum endereço através do cep informado, por favor preencha os campos de endereço manualmente.",   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};
	
	var getClientes = function () {
       	clientesAPI.getClientes().success(function (data,status) {
       		$scope.clientes = data;   	
       	}).error(function (data, status,headers,config,statusText) {
			swal({title: "Erro ao tentar listar os clientes!", 
				  text: "Erro " + status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};
	
	var getClienteById = function (id) {
		clientesAPI.getClienteById(id).success(function (data,status) {
       		$scope.cliente  = data;       		       		
       	}).error(function (data, status,headers,config,statusText) {
       		swal({title: "Erro ao tentar obter o cliente por ID!", 
				  text: "Erro "+ status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	}
	
	
	$scope.deleteCliente = function(cliente){
		swal({title: "Você deseja realmente deletar esse cliente?",  
			  text: "Esse cliente será permanente apagado do sistema!", 
			  type: "warning",   
			  showCancelButton: true,   
			  confirmButtonColor: "#DD6B55", 
			  confirmButtonText: "Sim, delete esse cliente!", 
			  cancelButtonText: "Não, cancele a operação!", 
			  closeOnConfirm: false,  
			  closeOnCancel: false 
			},
			function(isConfirm){
		    	if (isConfirm) {
		    		clientesAPI.deleteCliente(cliente.id).success(function(data,status) {
		        	    getClientes();
		        	    swal("Sucesso!", "Cliente deletado com sucesso.", "success");
		    		}).error(function (data, status,headers,config,statusText) {
		    			swal({title: "Erro ao tentar deletar o registro!", 
		    				  text: "Erro "+ status,   
		    				  type: "warning",   
		    				  confirmButtonColor: "#DD6B55", 
		    			});
		    		});					
				} else {
					swal("Atenção!", "A operação foi cancelada pelo usuário", "error"); 
				} 
			});		
	}
	
	$scope.submit = function() {
	   twfAPI.forceFormBind(clienteForm);		  	
	   if($scope.cliente.id==null){
	      clientesAPI.saveCliente($scope.cliente).success(function (data) {
	    	  swal("Sucesso!", "Cliente cadastrado com sucesso!", "success");
	    	  $scope.reset();
	    	  $("input[name='nome']").focus();
	      }).error(function (data, status,headers,config,statusText) {
	    	  //listBeanValidationMessages(data.fieldErrors);
		      swal({title: "Erro ao tentar cadastrar o cliente!", 
				    text: "Erro " + status,   
					type: "warning",   
					confirmButtonColor: "#DD6B55", 
		      });
	      });
	   }else{
	   	   clientesAPI.updateCliente($scope.cliente).success(function (data) {
	   	   	   swal({title: "Sucesso!",  
		             text: "Cliente alterado com sucesso!", 
		   		     type: "success",   
		    	     confirmButtonColor: "#DD6B55", 
		    		 confirmButtonText: "OK", 
		    		 closeOnConfirm: false,  
		    		 closeOnCancel: false 
		       },function(isConfirm){
		    	  if (isConfirm) {
		    		  twfAPI.changePage("/list/clientes");
		    	  }	
		       });	 
	       }).error(function (data, status,headers,config,statusText) {
		  		swal({title: "Erro ao tentar alterar o cliente!", 
					  text: "Erro " + status,   
					  type: "warning",   
					  confirmButtonColor: "#DD6B55", 
				});
	       });        	 
	   }     
	};         	
	
	//-------------------Funções de Plugins de terceiros--------------------------------------------------------
		
	// Função para ordenação da tabela de listagem através dos heraders das colunas...
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}
	
	//-------------------Funções para inicialização e redirecionamento das páginas  -----------------------
		
	$scope.redirectToFormUpdate = function(cliente){
		twfAPI.changePage("/form/clientes/"+cliente.id);		
	}

	if($location.absUrl().indexOf("/list/clientes") > -1){
	    getClientes();
	}
	
	if($location.absUrl().indexOf("/form/clientes") > -1){
		
		$("input[name='nome']").focus();
	    
		// Se o form não possuir Id, significa que o usuário quer fazer um update...
	    if($("#idCliente").val()!=""){
			getClienteById($("#idCliente").val());		
		}else{
			$scope.cliente = {status: 'Ativo'};
			$scope.cliente.dataCadastro = moment($scope.cliente.dataCadastro = new Date()).format('DD/MM/YYYY');
		}	
	}
	
	$scope.reset = function(){
        $scope.cliente = {};
        $scope.clienteForm.$setPristine();
        $scope.cliente = {status: 'Ativo'};
        $scope.cliente.dataCadastro = moment($scope.cliente.dataCadastro = new Date()).format('DD/MM/YYYY');
    };	
});