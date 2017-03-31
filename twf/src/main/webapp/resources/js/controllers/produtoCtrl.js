angular.module("twfApplication").controller("produtoCtrl", function ($scope, config, produtosAPI,marcasAPI,categoriasAPI,
																	 twfAPI, $location) {	
	
	//-------------------Inicializando variaveis e componentes----------------------------------
	
	$scope.produto = {};	
	$scope.produtos = [];	
	$scope.marcas = [];
	$scope.categorias = [];
	
	//-------------------CRUD e Operações--------------------------------------------------------
	
	
	var getProdutos = function () {
       	produtosAPI.getProdutos().success(function (data,status) {
       		$scope.produtos = data;   	
       	}).error(function (data, status,headers,config,statusText) {
			swal({title: "Erro ao tentar listar os produtos!", 
				  text: "Erro " + status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};
	
	var getProdutoById = function (id) {
		produtosAPI.getProdutoById(id).success(function (data,status) {
       		$scope.produto  = data;       		       		
       	}).error(function (data, status,headers,config,statusText) {
       		swal({title: "Erro ao tentar obter o produto por ID!", 
				  text: "Erro "+ status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	}
	
	
	$scope.deleteProduto = function(produto){
		swal({title: "Você deseja realmente deletar esse produto?",  
			  text: "Esse produto será permanente apagado do sistema!", 
			  type: "warning",   
			  showCancelButton: true,   
			  confirmButtonColor: "#DD6B55", 
			  confirmButtonText: "Sim, delete esse produto!", 
			  cancelButtonText: "Não, cancele a operação!", 
			  closeOnConfirm: false,  
			  closeOnCancel: false 
			},
			function(isConfirm){
		    	if (isConfirm) {
		    		produtosAPI.deleteProduto(produto.id).success(function(data,status) {
		        	    getProdutos();
		        	    swal("Sucesso!", "Produto deletado com sucesso.", "success");
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
	   twfAPI.forceFormBind(produtoForm);		  	
	   if($scope.produto.id==null){
		  produtosAPI.saveProduto($scope.produto).success(function (data) {
	    	  swal("Sucesso!", "Produto cadastrado com sucesso!", "success");
	    	  $scope.reset();
	    	  $("input[name='nome']").focus();
	      }).error(function (data, status,headers,config,statusText) {
	    	  //listBeanValidationMessages(data.fieldErrors);
		      swal({title: "Erro ao tentar cadastrar o produto!", 
				    text: "Erro " + status,   
					type: "warning",   
					confirmButtonColor: "#DD6B55", 
		      });
	      });
	   }else{
		   produtosAPI.updateProduto($scope.produto).success(function (data) {
	   	   	   swal({title: "Sucesso!",  
		             text: "Produto alterado com sucesso!", 
		   		     type: "success",   
		    	     confirmButtonColor: "#DD6B55", 
		    		 confirmButtonText: "OK", 
		    		 closeOnConfirm: false,  
		    		 closeOnCancel: false 
		       },function(isConfirm){
		    	  if(isConfirm) {
		    		  twfAPI.changePage("/list/produtos");
		    	  }	
		       });	 
	       }).error(function (data, status,headers,config,statusText) {
		  		swal({title: "Erro ao tentar alterar o produto!", 
					  text: "Erro " + status,   
					  type: "warning",   
					  confirmButtonColor: "#DD6B55", 
				});
	       });        	 
	   }     
	};         	
	
	//------------------- Marcas --------------------------------------------------------
	
	$scope.saveMarca = function() {		
		swal({title: "Cadastro de marcas!", 
			  text: "Digite o nome da marca a ser cadastrada:",   
			  type: "input",  
			  showCancelButton: true, 
			  closeOnConfirm: false, 
			  animation: "slide-from-top", 
			  inputPlaceholder: "Marca"
			 },function(inputValue){   
				 if (inputValue === false) return false; 
				 if (inputValue === "") {     
					 swal.showInputError("Por favor, informe uma marca!");     
					 return false   
				  }
				 
				 marca = {};
				 marca = {nome: inputValue,
						  dataCadastro: moment($scope.produto.dataCadastro = new Date()).format('DD/MM/YYYY'),
	    			 	  status: 'Ativo' 
						 };
				 
				 marcasAPI.saveMarca(marca).success(function (data) {
			    	  swal("Sucesso!", "Marca cadastrada com sucesso!", "success");
			    	  $scope.marcas.push(angular.copy(marca));
					  delete marca;
					  $scope.produtoForm.$setPristine();
					  if($("#idProduto").val()==""){
						  $scope.produto.dataCadastro = moment($scope.produto.dataCadastro = new Date()).format('DD/MM/YYYY');
					  }else{
						  $scope.produto.dataCadastro = moment($scope.produto.dataCadastro).format('DD/MM/YYYY');
					  }
			      }).error(function (data, status,headers,config,statusText) {
			        swal({title: "Erro ao tentar cadastrar a marca!", 
						    text: "Erro " + status,   
							type: "warning",   
							confirmButtonColor: "#DD6B55", 
				      });
			      });				 
		});		   
	};
	
	
	var getMarcas = function () {
		marcasAPI.getMarcas().success(function (data,status) {
       		$scope.marcas = data;   	
       	}).error(function (data, status,headers,config,statusText) {
			swal({title: "Erro ao tentar listar os produtos!", 
				  text: "Erro " + status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};

	
	//-------------------Categorias Produtos--------------------------------------------------------
		
	$scope.saveCategoriaProduto = function() {		
		swal({title: "Cadastro de categorias!", 
			  text: "Digite o nome da categoria a ser cadastrada:",   
			  type: "input",  
			  showCancelButton: true, 
			  closeOnConfirm: false, 
			  animation: "slide-from-top", 
			  inputPlaceholder: "Categoria"
			 },function(inputValue){   
				 if (inputValue === false) return false; 
				 if (inputValue === "") {     
					 swal.showInputError("Por favor, informe uma categoria!");     
					 return false   
				  }
				 
				 categoria = {};
				 categoria = {nome: inputValue,
						 	  dataCadastro: moment($scope.produto.dataCadastro = new Date()).format('DD/MM/YYYY'),
	    			 	       status: 'Ativo' 
						     };
				 
				 categoriasAPI.saveCategoriaProduto(categoria).success(function (data) {
			    	  swal("Sucesso!", "Categoria cadastrada com sucesso!", "success");
			    	  $scope.categorias.push(angular.copy(categoria));
					  delete categoria;
					  $scope.produtoForm.$setPristine();
					  // Obtem a data se o formulário for o de gravação....
					  if($("#idProduto").val()==""){
						  $scope.produto.dataCadastro = moment($scope.produto.dataCadastro = new Date()).format('DD/MM/YYYY');
					  }else{
						  $scope.produto.dataCadastro = moment($scope.produto.dataCadastro).format('DD/MM/YYYY');
					  }
			      }).error(function (data, status,headers,config,statusText) {
			        swal({title: "Erro ao tentar cadastrar a categoria!", 
						    text: "Erro " + status,   
							type: "warning",   
							confirmButtonColor: "#DD6B55", 
				      });
			      });				 
		});		   
	};
	
	
	var getCategoriasProduto = function () {
		categoriasAPI.getCategoriasProduto().success(function (data,status) {
       		$scope.categorias = data;   	
       	}).error(function (data, status,headers,config,statusText) {
			swal({title: "Erro ao tentar listar as categorias!", 
				  text: "Erro " + status,   
				  type: "warning",   
				  confirmButtonColor: "#DD6B55", 
			});
		});
	};
	
	
	
	//-------------------Funções de Plugins de terceiros--------------------------------------------------------
		
	// Função para ordenação da tabela de listagem através dos heraders das colunas...
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}
	
	//-------------------Funções para inicialização e redirecionamento das páginas  -----------------------
		
	$scope.redirectToFormUpdate = function(produto){
		twfAPI.changePage("/form/produtos/"+produto.id);		
	}
	
	$scope.isFormProdutoUpdate = function(){
	    if($("#idProduto").val()!=""){
	    	return true;
	    }else{
	    	return false;
	    }
	}

	if($location.absUrl().indexOf("/list/produtos") > -1){
	    getProdutos();
	}
	
	if($location.absUrl().indexOf("/form/produtos") > -1){
		
		getMarcas();
		getCategoriasProduto();
		
		$("input[name='nome']").focus();
	    
		// Se o form não possuir Id, significa que o usuário quer fazer um update...
	    if($("#idProduto").val()!=""){
			getProdutoById($("#idProduto").val());	    	    	
		}else{
			$scope.produto = {status: 'Ativo'};
			$scope.produto.dataCadastro = moment($scope.produto.dataCadastro = new Date()).format('DD/MM/YYYY');
		}	
	}
	
	$scope.reset = function(){
        $scope.produto = {};
        $scope.produtoForm.$setPristine();
        $scope.produto = {status: 'Ativo'};
        $scope.produto.dataCadastro = moment($scope.produto.dataCadastro = new Date()).format('DD/MM/YYYY');
    };	
});