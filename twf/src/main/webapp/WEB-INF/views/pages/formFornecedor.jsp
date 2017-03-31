  
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   <jsp:include page="../includes/header.jsp"></jsp:include>		
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" ng-controller="fornecedorCtrl">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Fornecedores
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Fornecedores</li>
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
        <form ng-submit="submit()" name="fornecedorForm" method="post">
        <input type="hidden" id="idFornecedor" ng-model="fornecedor.id" value="${id}"/>
          <div class="box-body">          
	          <div class="row form-linha">	            
	              <div class="col-sm-6">
	                <label>Nome <strong style="color: red;">*</strong></label>
	                <input type="text" name="nome" ng-model="fornecedor.nome" ng-required="true"  class="erro form-control" >
	                <div ng-messages="fornecedorForm.nome.$error" ng-if='fornecedorForm.nome.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo nome!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-6">
	                <label>CNPJ</label>
	                <input type="text" name="cnpj"   ng-model="fornecedor.cnpj" class="form-control">
	              </div>
	          </div>	          
	              
	          <div class="row form-linha">
	          	  <div class="col-sm-4">
	                <label>Telefone Comercial <strong style="color: red;">*</strong></label>
	                <input type="text" name="telefoneComercial"  ng-model="fornecedor.telefoneComercial" ng-required="true"  ui-mask="(99) 9999-9999"  ui-mask-placeholder ui-mask-placeholder-char="_"class="erro form-control">
	                <div ng-messages="fornecedorForm.telefoneComercial.$error" ng-if='fornecedorForm.telefoneComercial.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo telefone comercial!
						</label>											
					</div>
	              </div>	  	            
	              <div class="col-sm-4">
	                <label>E-mail</label>
	                <input type="text" name="email" ng-model="fornecedor.email"  class="erro form-control"  ng-pattern='/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/'>
	                <div ng-messages="fornecedorForm.email.$error" >
						<label ng-message="pattern" style="color:red;">
							Por favor, insira um e-mail válido!
						</label>											
					</div>
	              </div>	              
	              <div class="col-sm-4">
	                <label>Site</label>
	                <input type="text" ng-model="fornecedor.site" name="site"  class="form-control my-colorpicker1">
	              </div>	              
	          </div>	      
	          <div class="row form-linha">	            
	              <div class="col-sm-4">
	                <label>Cep <strong style="color: red;">*</strong></label>
	                 <div class="input-group">
                	    <input type="text" name="cep"  ng-model="fornecedor.cep"  ui-mask="99999-999"   ng-required="true" class="erro form-control">
						<div class="input-group-btn">
                  	   	  <button ng-click="getEndereco();" type="button" class="btn btn-primary">Pesquisar</button>
                	    </div>             		
             		 </div>	                	                
	                <div ng-messages="fornecedorForm.cep.$error" ng-if='fornecedorForm.cep.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo cep!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Logradouro <strong style="color: red;">*</strong></label>
	                <input type="text" name="logradouro" ng-model="fornecedor.logradouro"  ng-required="true"  class="erro form-control">
	                <div ng-messages="fornecedorForm.logradouro.$error" ng-if='fornecedorForm.logradouro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo logradouro!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Numero <strong style="color: red;">*</strong></label>
	                <input type="text" name="numero" ng-model="fornecedor.numero" ng-required="true"  class="erro form-control">
	                <div ng-messages="fornecedorForm.numero.$error" ng-if='fornecedorForm.numero.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo numero!
						</label>											
					</div>
	              </div>
	          </div>	         
	          <div class="row form-linha">	            
	              <div class="col-sm-4">
	                <label>Bairro <strong style="color: red;">*</strong></label>
	                <input type="text" name="bairro" ng-model="fornecedor.bairro"  ng-required="true" class="erro form-control">
	                 <div ng-messages="fornecedorForm.bairro.$error" ng-if='fornecedorForm.bairro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo bairro!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Cidade <strong style="color: red;">*</strong></label>
	                <input type="text" name="cidade" ng-model="fornecedor.cidade" ng-required="true"  class="erro form-control">
	                <div ng-messages="fornecedorForm.cidade.$error" ng-if='fornecedorForm.cidade.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo cidade!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>UF <strong style="color: red;">*</strong></label>
	                <input type="text" name="uf" ng-model="fornecedor.uf"   ng-required="true" class="erro form-control" >
	                <div ng-messages="fornecedorForm.uf.$error" ng-if='fornecedorForm.uf.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo UF!
						</label>
	                </div>                  
		          </div>
		      </div>   
		      <div class="row form-linha">	        
		          <div class="col-sm-4">
		          	 <label>Data de Cadastro <strong style="color: red;">*</strong></label>
		             <div class="input-group date">
	                 	<div class="input-group-addon">
	                      <i class="fa fa-calendar"></i>
	                  	</div>
	                  	<input type="text" name="dataCadastro" class="erro form-control pull-right"  ng-required="true" ng-model="fornecedor.dataCadastro" id="datepicker">
	                 </div>
	                 <div ng-messages="fornecedorForm.dataCadastro.$error" ng-if='fornecedorForm.dataCadastro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo de data de cadastro!
						</label>
	                 </div>       	                 
		          </div>
		          <div class="col-sm-4">					
					<fieldset>
					<legend>Status <strong style="color: red;">*</strong></legend>
						<label class="control control--radio" >Ativo
							<input type="radio" name="status" ng-model="fornecedor.status"  value="Ativo" />
							<div class="control__indicator"></div>
						</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<label class="control control--radio" >Inativo
							<input type="radio" name="status" ng-model="fornecedor.status"  value="Inativo" />
							<div class="control__indicator"></div>
						</label>
					</fieldset>
				   </div>
				   
				   <div class="col-sm-4">
				   <fieldset style="padding-right:o; padding-left:0;">
				   <legend>Tipo do Fornecedor <strong style="color: red;">*</strong></legend>	
						<label class="control control--radio" >Site
							<input type="radio" name="tipoFornecedor" ng-model="fornecedor.tipoFornecedor"  value="Site" />
							<div class="control__indicator"></div>
						</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<label class="control control--radio" >Loja Fisíca
							<input type="radio" name="tipoFornecedor" ng-model="fornecedor.tipoFornecedor"  value="Loja_Fisica" />
							<div class="control__indicator"></div>
						</label>
					</fieldset>
					    
		          </div>	 	
	          </div>
	      </div>    	                
	      <!-- /.box-body -->
	      <div class="box-footer">
	          <button type="submit"  value="{{!fornecedor.id ? 'Add' : 'Update'}}" class="btn btn-app btn-app-save" ng-disabled="fornecedorForm.$invalid"><i class="fa fa-play"></i>${tituloBotao}</button>
	          <button type="button" ng-click="reset();" class="btn btn-app btn-app-limpar"><i class="fa fa-repeat"></i>Limpar</button>
	      </div>
        </form>
      </div>
     
      <!-- /.box -->	    
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script src="${pageContext.request.contextPath}/resources/js/controllers/fornecedorCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/correiosAPIService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/fornecedoresAPIService.js"></script>  
 <jsp:include page="../includes/footer.jsp"></jsp:include> 
  
  