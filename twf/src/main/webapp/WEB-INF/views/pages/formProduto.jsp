  
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   <jsp:include page="../includes/header.jsp"></jsp:include>		
  <!-- Content Wrapper. Contains page content -->
  
<div ng-controller="ModalCotacaoCtrl">
  <script type="text/ng-template" id="modalCotacaoContent.html">
  	<div class="modal-header">
   	    <h3 class="modal-title" id="modal-title">Cotações para este produto.</h3>
  	</div>
    <form name="cotacaoForm" ng-submit="submit()"> 
		<input type="hidden"  ng-model="cotacao.produto" />
  		<div class="modal-body" id="modal-body">
			<div class="row">
				<div class="col-sm-4">
					<label>Fornecedor<strong style="color: red;">*</strong></label>
	               	<select class="form-control erro" ng-required="true"  name="fornecedor" ng-model="cotacao.fornecedor" ng-options="fornecedor.nome for fornecedor in fornecedores">
						<option value="">Selecione um fornecedor</option>
					</select>
					<div ng-messages="cotacaoForm.fornecedor.$error" ng-if='cotacaoForm.fornecedor.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo fornecedor!
						</label>											
					</div>
				</div>
				<div class="col-sm-4">
					<label>Custo <strong style="color: red;">*</strong></label>
	                <input type="text" name="custo" ng-model="cotacao.custo" ng-required="true"  class="erro form-control" >
					<div ng-messages="cotacaoForm.custo.$error" ng-if='cotacaoForm.custo.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo custo!
						</label>											
					</div>					
				</div>
				<div class="col-sm-4">
					<label>Data de Atualização <strong style="color: red;">*</strong></label>
		             <div class="input-group date">
	                 	<div class="input-group-addon">
	                      <i class="fa fa-calendar"></i>
	                  	</div>
	                  	<input type="text" name="dataAtualizacao" class="erro form-control pull-right"  ng-required="true" ng-model="cotacao.dataAtualizacao" ui-mask="99/99/9999"  ui-mask-placeholder ui-mask-placeholder-char="_" >
	                 </div>
					 <div ng-messages="cotacaoForm.dataAtualizacao.$error" ng-if='cotacaoForm.dataAtualizacao.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo data de atualização!
						</label>											
					 </div>		
				</div>						
			</div>
			<br />
			<div class="row">
			   <div class="col-sm-12">
	      		   <table class="table table-bordered table-hover">
		   			  <thead> 	
			 			 <tr>
			   		   	   <th>ID</th>
			          	   <th>Fornecedor</th>
			               <th>Custo</th>
 			               <th>Data de Atualização</th>
						   <th></th>
						   <th></th>			
		         	     </tr>
		              </thead>		
		              <tbody>
			             <tr dir-paginate="cotacao in cotacoes|itemsPerPage:4">
			               <td>{{cotacao.fornecedor.nome}}</td>
			               <td>{{cotacao.produto.nome}}</td>
			               <td>{{cotacao.custo}}</td>
 			   		       <td>{{cotacao.dataAtualizacao}}</td>
						   <td style="text-align: center"><a href="#" style="display: block;"  data-toggle="tooltip" data-placement="bottom" ng-click="redirectToFormUpdate(produto)" ><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
	                       <td style="text-align: center"><a href="#" style="display: block;"  data-toggle="tooltip"  ng-click="deleteProduto(produto)"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>	
			 		     </tr>
		  		      </tbody>			
		 	       </table>
 				</div>
   		 	</div>
        <div class="modal-footer">
			<dir-pagination-controls
			   max-size="100"
			   direction-links="true"
			   boundary-links="true" >
			</dir-pagination-controls>	
   	        <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
			<button class="btn btn-primary" type="submit" ng-disabled="cotacaoForm.$invalid">Gravar</button>
 	    </div>
	</form>
	

  </script>
  <div class="content-wrapper" ng-controller="produtoCtrl">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Produtos
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Produtos</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content" >
	  <div class="box box-default">
        <div class="box-header with-border">
          <h3 class="box-title">${tituloForm}</h3>
          <div class="box-tools pull-right">            
          </div>
        </div>
        <!-- /.box-header -->
        <form ng-submit="submit()" name="produtoForm" method="post">
        <input type="hidden" id="idProduto" name="idProduto" ng-model="produto.id" value="${id}"/>
        <div class="box-body">          
	          <div class="row form-linha">	            
	              <div class="col-sm-4">
	                <label>Nome <strong style="color: red;">*</strong></label>
	                <input type="text" name="nome" ng-model="produto.nome" ng-required="true"  class="erro form-control" >
	                <div ng-messages="produtoForm.nome.$error" ng-if='produtoForm.nome.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo nome!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Marca <strong style="color: red;">*</strong></label>
	                 <div class="input-group">
	                 	<div class="input-group-btn">
                  	   	  <button  type="button" ng-click="saveMarca();" class="btn btn-primary"><i class="fa fa-play"></i></button>
                	    </div>   
	                	<select class="form-control erro" ng-required="true"  name="marca" ng-model="produto.marca" ng-options="marca.nome for marca in marcas track by marca.id">
							<option value="">Selecione uma marca</option>
						</select>
					</div>
					<div ng-messages="produtoForm.marca.$error" ng-if='produtoForm.marca.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo marca!
						</label>											
					</div>
	              </div>
	             
	              <div class="col-sm-4">
	                <label>Categoria <strong style="color: red;">*</strong></label>
	                <div class="input-group">
	                 	<div class="input-group-btn">
                  	   	  <button  type="button" ng-click="saveCategoriaProduto();" class="btn btn-primary"><i class="fa fa-play"></i></button>
                	    </div>   
	                	<select class="form-control erro" ng-required="true" name="categoriaProduto" ng-model="produto.categoriaProduto" ng-options="categoriaProduto.nome for categoriaProduto in categorias track by categoriaProduto.id">
							<option value="">Selecione uma categoria</option>
						</select>
					</div>	                
	                <div ng-messages="produtoForm.categoriaProduto.$error" ng-if='produtoForm.categoriaProduto.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo categoria!
						</label>											
				  	</div>	                
	              </div>	              
	          </div>	          	              
	          <div class="row form-linha">
	          	  <div class="col-sm-4">
	                <label>Estoque Minimo <strong style="color: red;">*</strong></label>
	                <input type="text" name="estoqueMinimo"  ng-model="produto.estoqueMinimo" ng-required="true"  class="erro form-control">
	                <div ng-messages="produtoForm.estoqueMinimo.$error" ng-if='produtoForm.estoqueMinimo.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo estoque minimo!
						</label>											
					</div>
	              </div>	  	            
	              <div class="col-sm-4">
	                <label>Estoque Atual <strong style="color: red;">*</strong></label>
	                <input type="text" name="estoqueAtual" ng-model="produto.estoqueAtual" ng-required="true" class="erro form-control" > 
	                <div ng-messages="produtoForm.estoqueAtual.$error" ng-if='produtoForm.estoqueAtual.$dirty'>
						<label ng-message="required" style="color:red;">
							Por favor, insira um estoque atual válido!
						</label>											
					</div>
	              </div>	              
	              <div class="col-sm-4">
	                 <label>Estoque Máximo <strong style="color: red;">*</strong></label>
	                 <input type="text" ng-model="produto.estoqueMaximo" name="estoqueMaximo" ng-required="true" class="form-control erro">
	              	 <div ng-messages="produtoForm.estoqueMaximo.$error" ng-if='produtoForm.estoqueMaximo.$dirty' >
					   <label ng-message="required" style="color:red;">
					  	 Por favor, insira um estoque máximo válido!
				       </label>											
				     </div>
	              </div>	                            
	          </div>	      
	          <div class="row form-linha">	            
	              <div class="col-sm-4">
	                <label>Preço de Venda <strong style="color: red;">*</strong></label>
	                   <input type="text" name="precoVenda"  ng-model="produto.precoVenda"   ng-required="true" class="erro form-control">
					<div ng-messages="produtoForm.precoVenda.$error" ng-if='produtoForm.precoVenda.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo preço de venda!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
		          	 <label>Data de Cadastro <strong style="color: red;">*</strong></label>
		             <div class="input-group date">
	                 	<div class="input-group-addon">
	                      <i class="fa fa-calendar"></i>
	                  	</div>
	                  	<input type="text" name="dataCadastro" class="erro form-control pull-right"  ng-required="true" ng-model="produto.dataCadastro" id="datepicker">
	                 </div>
	                 <div ng-messages="produtoForm.dataCadastro.$error" ng-if='produtoForm.dataCadastro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo de data de cadastro!
						</label>
	                 </div>       	                 
		          </div>
		           <div class="col-sm-4">					
					<fieldset>
					<legend>Status <strong style="color: red;">*</strong></legend>
						<label class="control control--radio" >Ativo
							<input type="radio" name="status" ng-model="produto.status"  value="Ativo" />
							<div class="control__indicator"></div>
						</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<label class="control control--radio" >Inativo
							<input type="radio" name="status" ng-model="produto.status"  value="Inativo" />
							<div class="control__indicator"></div>
						</label>
					</fieldset>
				   </div>		          
	          </div>	      
	      </div>    	                
	      <!-- /.box-body -->
	      <div class="box-footer">
	          <button type="submit" value="{{!produto.id ? 'Add' : 'Update'}}" class="btn btn-app btn-app-save" ng-disabled="produtoForm.$invalid"><i class="fa fa-play"></i>${tituloBotao}</button>
	          <button type="button" ng-click="reset();" class="btn btn-app btn-app-limpar"><i class="fa fa-repeat"></i>Limpar</button>
	          <button type="button" ng-click="open(produto)" class="btn btn-app btn-app-ghostwhite" ng-if="isFormProdutoUpdate()"><i class="fa fa-usd"></i>Cotação</button>
	      </div>
        </form>
      </div>     
      <!-- /.box -->	    
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</div>  
  <!-- /.Modal --> 
<script src="${pageContext.request.contextPath}/resources/js/controllers/produtoCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controllers/cotacaoCtrl.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/services/produtosAPIService.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/services/marcasAPIService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/fornecedoresAPIService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/cotacoesAPIService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/categoriasProdutoAPIService.js"></script>   
<jsp:include page="../includes/footer.jsp"></jsp:include> 
  
  