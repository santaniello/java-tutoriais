  
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   <jsp:include page="../includes/header.jsp"></jsp:include>		
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" ng-controller="clienteCtrl">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Clientes
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Clientes</li>
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
        <form ng-submit="submit()" name="clienteForm" method="post">
        <input type="hidden" id="idCliente" ng-model="cliente.id" value="${id}"/>
          <div class="box-body">          
	          <div class="row form-linha">	            
	              <div class="col-sm-6">
	                <label>Nome <strong style="color: red;">*</strong></label>
	                <input type="text" name="nome" ng-model="cliente.nome" ng-required="true"  class="erro form-control" >
	                <div ng-messages="clienteForm.nome.$error" ng-if='clienteForm.nome.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo nome!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-6">
	                <label>CNPJ</label>
	                <input type="text" name="cnpj"   ng-model="cliente.cnpj" class="form-control">
	              </div>
	          </div>	          
	          <div class="row form-linha">	            
	              <div class="col-sm-6">
	                <label>Telefone Comercial <strong style="color: red;">*</strong></label>
	                <input type="text" name="telefoneComercial"  ng-model="cliente.telefoneComercial" ng-required="true"  ui-mask="(99) 9999-9999"  ui-mask-placeholder ui-mask-placeholder-char="_"class="erro form-control">
	                <div ng-messages="clienteForm.telefoneComercial.$error" ng-if='clienteForm.telefoneComercial.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo telefone comercial!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-6">
	                <label>Telefone Celular</label>
	                <input type="text" name="telefoneCelular"  ng-model="cliente.telefoneCelular" ui-mask="(99) 99999-9999"  ui-mask-placeholder ui-mask-placeholder-char="_" class="form-control my-colorpicker1">
	              </div>	                            
	          </div>	      
	          <div class="row form-linha">	            
	              <div class="col-sm-6">
	                <label>E-mail</label>
	                <input type="text" name="email" ng-model="cliente.email"  class="erro form-control"  ng-pattern='/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/'>
	                <div ng-messages="clienteForm.email.$error" >
						<label ng-message="pattern" style="color:red;">
							Por favor, insira um e-mail válido!
						</label>											
					</div>
	              </div>	              
	              <div class="col-sm-6">
	                <label>Site</label>
	                <input type="text" ng-model="cliente.site" name="site"  class="form-control my-colorpicker1">
	              </div>	              
	          </div>	      
	          <div class="row form-linha">	            
	              <div class="col-sm-4">
	                <label>Cep <strong style="color: red;">*</strong></label>
	                 <div class="input-group">
                	    <input type="text" name="cep"  ng-model="cliente.cep"  ui-mask="99999-999"   ng-required="true" class="erro form-control">
						<div class="input-group-btn">
                  	   	  <button ng-click="getEndereco();" type="button" class="btn btn-primary">Pesquisar</button>
                	    </div>             		
             		 </div>	                	                
	                <div ng-messages="clienteForm.cep.$error" ng-if='clienteForm.cep.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo cep!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Logradouro <strong style="color: red;">*</strong></label>
	                <input type="text" name="logradouro" ng-model="cliente.logradouro"  ng-required="true"  class="erro form-control">
	                <div ng-messages="clienteForm.logradouro.$error" ng-if='clienteForm.logradouro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo logradouro!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Numero <strong style="color: red;">*</strong></label>
	                <input type="text" name="numero" ng-model="cliente.numero" ng-required="true"  class="erro form-control">
	                <div ng-messages="clienteForm.numero.$error" ng-if='clienteForm.numero.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo numero!
						</label>											
					</div>
	              </div>
	          </div>	         
	          <div class="row form-linha">	            
	              <div class="col-sm-4">
	                <label>Bairro <strong style="color: red;">*</strong></label>
	                <input type="text" name="bairro" ng-model="cliente.bairro"  ng-required="true" class="erro form-control">
	                 <div ng-messages="clienteForm.bairro.$error" ng-if='clienteForm.bairro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo bairro!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>Cidade <strong style="color: red;">*</strong></label>
	                <input type="text" name="cidade" ng-model="cliente.cidade" ng-required="true"  class="erro form-control">
	                <div ng-messages="clienteForm.cidade.$error" ng-if='clienteForm.cidade.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo cidade!
						</label>											
					</div>
	              </div>
	              <div class="col-sm-4">
	                <label>UF <strong style="color: red;">*</strong></label>
	                <input type="text" name="uf" ng-model="cliente.uf"   ng-required="true" class="erro form-control" >
	                <div ng-messages="clienteForm.uf.$error" ng-if='clienteForm.uf.$dirty' >
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
	                  	<input type="text" name="dataCadastro" class="erro form-control pull-right"  ng-required="true" ng-model="cliente.dataCadastro" id="datepicker">
	                 </div>
	                 <div ng-messages="clienteForm.dataCadastro.$error" ng-if='clienteForm.dataCadastro.$dirty' >
						<label ng-message="required" style="color:red;">
							Por favor, preencha o campo de data de cadastro!
						</label>
	                 </div>       	                 
		          </div>
		          <div class="col-sm-8">						
					<fieldset>
					<legend>Status <strong style="color: red;">*</strong></legend>
						<label class="control control--radio">Ativo
							<input type="radio" name="status" ng-model="cliente.status"  value="Ativo" />
							<div class="control__indicator"></div>
						</label>&nbsp;&nbsp;&nbsp;&nbsp;
						<label class="control control--radio">Inativo
							<input type="radio" name="status" ng-model="cliente.status"  value="Inativo" />
							<div class="control__indicator"></div>
						</label>
					</fieldset>    
		          </div>	 	
	          </div>
	      </div>    	                
	      <!-- /.box-body -->
	      <div class="box-footer">
	          <button type="submit"  value="{{!cliente.id ? 'Add' : 'Update'}}" class="btn btn-app btn-app-save" ng-disabled="clienteForm.$invalid"><i class="fa fa-play"></i>${tituloBotao}</button>
	          <button type="button" ng-click="reset();" class="btn btn-app btn-app-limpar"><i class="fa fa-repeat"></i>Limpar</button>
	      </div>
        </form>
      </div>
     
      <!-- /.box -->	    
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script src="${pageContext.request.contextPath}/resources/js/controllers/clienteCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/correiosAPIService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/clientesAPIService.js"></script>  
 <jsp:include page="../includes/footer.jsp"></jsp:include> 
  
  