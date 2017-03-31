angular.module("twfApplication").controller("fornecedorCtrl", function ($scope, config, correiosAPI,fornecedoresAPI,twfAPI, $location) {	
	
	//-------------------Inicializando variaveis e componentes----------------------------------
	
	$scope.fornecedor = {};	
	$scope.fornecedores = [];	
	
	//-------------------CRUD e Operações--------------------------------------------------------
	
	$scope.getEndereco = function () {
		correiosAPI.getEndereco($scope.fornecedor.cep).success(function (data,status) {
			$scope.fornecedor.logradouro = data.logradouro;
			$scope.fornecedor.bairro = data.bairro;
			$scope.fornecedor.cidade = data.localidade;
			$scope.fornecedor.uf 	  = data.uf;			
		}).error(function (data, status,headers,config,statusText) {
			swal({title: "Atenção!", 
				  text: "Não foi encontrado nenhum endereço através do cep informado, por favor preencha os campos de endereço manualmente.",   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};
	
	var getFornecedores = function () {
       	fornecedoresAPI.getFornecedores().success(function (data,status) {
       		$scope.fornecedores = data;   	
       	}).error(function (data, status,headers,config,statusText) {
			swal({title: "Erro ao tentar listar os fornecedores!", 
				  text: "Erro " + status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};
	
	var getFornecedorById = function (id) {
		fornecedoresAPI.getFornecedorById(id).success(function (data,status) {
       		$scope.fornecedor  = data;       		       		
       	}).error(function (data, status,headers,config,statusText) {
       		swal({title: "Erro ao tentar obter o fornecedor por ID!", 
				  text: "Erro "+ status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	}
	
	
	$scope.deleteFornecedor = function(fornecedor){
		swal({title: "Você deseja realmente deletar esse fornecedor?",  
			  text: "Esse fornecedor será permanente apagado do sistema!", 
			  type: "warning",   
			  showCancelButton: true,   
			  confirmButtonColor: "#DD6B55", 
			  confirmButtonText: "Sim, delete esse fornecedor!", 
			  cancelButtonText: "Não, cancele a operação!", 
			  closeOnConfirm: false,  
			  closeOnCancel: false 
			},
			function(isConfirm){
		    	if (isConfirm) {
		    		fornecedoresAPI.deleteFornecedor(fornecedor.id).success(function(data,status) {
		        	    getFornecedores();
		        	    swal("Sucesso!", "Fornecedor deletado com sucesso.", "success");
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
	   twfAPI.forceFormBind(fornecedorForm);		
	   if($scope.fornecedor.id==null){
	      fornecedoresAPI.saveFornecedor($scope.fornecedor).success(function (data) {
	    	  swal("Sucesso!", "Fornecedor cadastrado com sucesso!", "success");
	    	  $scope.reset();
	    	  $("input[name='nome']").focus();
	      }).error(function (data, status,headers,config,statusText) {
	    	  //listBeanValidationMessages(data.fieldErrors);
		      swal({title: "Erro ao tentar cadastrar o fornecedor!", 
				    text: "Erro " + status,   
					type: "warning",   
					confirmButtonColor: "#DD6B55", 
		      });
	      });
	   }else{
	   	   fornecedoresAPI.updateFornecedor($scope.fornecedor).success(function (data) {
	   	   	   swal({title: "Sucesso!",  
		             text: "Fornecedor alterado com sucesso!", 
		   		     type: "success",   
		    	     confirmButtonColor: "#DD6B55", 
		    		 confirmButtonText: "OK", 
		    		 closeOnConfirm: false,  
		    		 closeOnCancel: false 
		       },function(isConfirm){
		    	  if (isConfirm) {
		    		  twfAPI.changePage("/list/fornecedores");
		    	  }	
		       });	 
	       }).error(function (data, status,headers,config,statusText) {
		  		swal({title: "Erro ao tentar alterar o fornecedor!", 
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
		
	$scope.redirectToFormUpdate = function(fornecedor){
		twfAPI.changePage("/form/fornecedores/"+fornecedor.id);		
	}

	if($location.absUrl().indexOf("/list/fornecedores") > -1){

	    getFornecedores();
	}
	
	if($location.absUrl().indexOf("/form/fornecedores") > -1){
		
		$("input[name='nome']").focus();
	    
		// Se o form não possuir Id, significa que o usuário quer fazer um update...
	    if($("#idFornecedor").val()!=""){
			getFornecedorById($("#idFornecedor").val());		
		}else{
			$scope.fornecedor = {status: 'Ativo', tipoFornecedor: 'Loja_Fisica' };
			$scope.fornecedor.dataCadastro = moment($scope.fornecedor.dataCadastro = new Date()).format('DD/MM/YYYY');
		}	
	}
	
	$scope.reset = function(){
        $scope.fornecedor = {};
        $scope.fornecedorForm.$setPristine();
        $scope.fornecedor = {status: 'Ativo', tipoFornecedor: 'Loja_Fisica' };
        $scope.fornecedor.dataCadastro = moment($scope.fornecedor.dataCadastro = new Date()).format('DD/MM/YYYY');
    };	
});