  
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
        Tabela de Fornecedores
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Tabela de Fornecedores</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content" >
	    <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title"></h3>
              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 300px;">
                  <input type="text" name="table_search" class="form-control pull-right" ng-model="search" placeholder="Search">
                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>                
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-bordered table-hover">
                <tr>
                  <th ng-click="sort('id')">ID<span class="glyphicon sort-icon" ng-show="sortKey=='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th ng-click="sort('nome')">Nome<span class="glyphicon sort-icon" ng-show="sortKey=='nome'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th ng-click="sort('telefoneComercial')">Tel. Comercial<span class="glyphicon sort-icon" ng-show="sortKey=='telefoneComercial'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th ng-click="sort('cidade')">Cidade<span class="glyphicon sort-icon" ng-show="sortKey=='cidade'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th ng-click="sort('bairro')">Bairro<span class="glyphicon sort-icon" ng-show="sortKey=='bairro'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th style="text-align: center" ng-click="sort('status')">Status<span class="glyphicon sort-icon" ng-show="sortKey=='status'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span></th>
                  <th></th>
                  <th></th>                  	
                </tr>
                <tr dir-paginate="fornecedor in fornecedores|orderBy:sortKey:reverse|filter:search|itemsPerPage:9">
                  <td>{{fornecedor.id}}</td>
                  <td>{{fornecedor.nome}}</td>
                  <td>{{fornecedor.telefoneComercial}}</td>
                  <td>{{fornecedor.cidade}}</td>
                  <td>{{fornecedor.bairro}}</td>
                  <td style="text-align: center"><span class="label" ng-class="{labelDanger: fornecedor.status == 'Inativo', labelSuccess: fornecedor.status == 'Ativo' }">{{fornecedor.status}}</span></td>
                  <td style="text-align: center"><a href="#" style="display: block;"  data-toggle="tooltip" data-placement="bottom" ng-click="redirectToFormUpdate(fornecedor)" ><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
                  <td style="text-align: center"><a href="#" style="display: block;"  data-toggle="tooltip"  ng-click="deleteFornecedor(fornecedor)"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
                </tr>
              </table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <dir-pagination-controls
					max-size="100"
					direction-links="true"
					boundary-links="true" >
				</dir-pagination-controls>
            </div>           
          </div>
          <!-- /.box -->
        </div>
      </div> 
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script src="${pageContext.request.contextPath}/resources/js/controllers/fornecedorCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/correiosAPIService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/fornecedoresAPIService.js"></script>  
<jsp:include page="../includes/footer.jsp"></jsp:include> 
  
  