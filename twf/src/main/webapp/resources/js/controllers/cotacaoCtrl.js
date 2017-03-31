angular.module('twfApplication').controller('ModalCotacaoCtrl', function ($scope,$uibModal, $log) {
	
	$scope.animationsEnabled = true;
	$scope.cotacao = {};
	$scope.cotacoes = [];
	$scope.fornecedores = [];


	$scope.open = function (produto) {
		$scope.cotacao.produto = produto;
	    var modalInstance = $uibModal.open({
	      animation: $scope.animationsEnabled,
	      ariaLabelledBy: 'modal-title',
	      ariaDescribedBy: 'modal-body',
	      templateUrl: 'modalCotacaoContent.html',
	      controller: 'ModalCotacaoInstanceCtrl',
	      size: 'lg',
	      resolve: {
	        cotacao: function () {
	          return $scope.cotacao;
	        },
	        fornecedores: function(){
	        	return $scope.fornecedores;
	        }
	      }
	    });
	    
	    modalInstance.result.then(function (selectedItem) {
	       selected = selectedItem;
	    }, function () {
	      $log.info('Modal dismissed at: ' + new Date());
	    });
	  };

	  toggleAnimation = function () {
	  animationsEnabled = !$scope.animationsEnabled;
	  };
});


//Please note that $uibModalInstance represents a modal window (instance) dependency.
//It is not the same as the $uibModal service used above.

angular.module('twfApplication').controller('ModalCotacaoInstanceCtrl', function ($scope,$uibModalInstance, cotacao, fornecedoresAPI,cotacoesAPI) {

	$scope.cotacao = cotacao;


var  getFornecedores = function () {
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


var  getCotacoesByProdutoId = function () {
	console.log($scope.cotacao.produto.id);
	cotacoesAPI.getCotacoesByProdutoId($scope.cotacao).success(function (data,status) {
		console.log(data);
		$scope.cotacoes = data;   	
   	}).error(function (data, status,headers,config,statusText) {
		swal({title: "Erro ao tentar listar as cotações!", 
			  text: "Erro " + status,   
			  type: "warning",   
			  confirmButtonColor: "#DD6B55", 
		});
	});
};	

getFornecedores();
getCotacoesByProdutoId();

$scope.submit = function() {
	cotacoesAPI.saveCotacao($scope.cotacao).success(function (data) {
	    	  swal("Sucesso!", "Cotação cadastrada com sucesso!", "success");	    	
	      }).error(function (data, status,headers,config,statusText) {
	    	  //listBeanValidationMessages(data.fieldErrors);
		      swal({title: "Erro ao tentar cadastrar a cotação!", 
				    text: "Erro " + status,   
					type: "warning",   
					confirmButtonColor: "#DD6B55", 
		      });
	      });
	  
	};         	

	
$scope.ok = function () {
 $uibModalInstance.close();
};

$scope.cancel = function () {
 $uibModalInstance.dismiss('cancel');
};
});




