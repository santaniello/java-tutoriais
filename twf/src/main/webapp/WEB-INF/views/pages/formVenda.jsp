  
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   <jsp:include page="../includes/header.jsp"></jsp:include>		
   <style>
   	.form-linha{
   		margin-top: 7px;   	
   	}
   </style>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="row">
        <div class="col-md-12">
           <!-- SELECT2 EXAMPLE -->
	      <div class="box box-default">
	        <div class="box-header with-border">
	          <h3 class="box-title">Dados da Venda</h3>
	
	          <!-- tools box -->
              <div class="pull-right box-tools">
                <button type="button" class="btn btn-default btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fa fa-minus"></i></button>                
              </div>
              <!-- /. tools -->
	        </div>
	        <!-- /.box-header -->
	        <form action="">
	          <div class="box-body">          
		          <div class="row form-linha">	            
		              <div class="col-sm-6">
		                <label>Nome</label>
		                <input type="text" name="nome" class="form-control my-colorpicker1">
		              </div>
		              <div class="col-sm-6">
		                <label>CNPJ</label>
		                <input type="text" name="cnpj" class="form-control my-colorpicker1">
		              </div>
		          </div>	          
		          <div class="row form-linha">	            
		              <div class="col-sm-6">
		                <label>Telefone Comercial</label>
		                <input type="text" name="nome" class="form-control my-colorpicker1">
		              </div>
		              <div class="col-sm-6">
		                <label>Telefone Celular</label>
		                <input type="text" name="cnpj" class="form-control my-colorpicker1">
		              </div>	                            
		          </div>	      
		               
		          <div class="row form-linha">	            
		              <div class="col-sm-4">
		                <label>Bairro</label>
		                <input type="text" name="nome" class="form-control my-colorpicker1">
		              </div>
		              <div class="col-sm-4">
		                <label>Cidade</label>
		                <input type="text" name="cnpj" class="form-control my-colorpicker1">
		              </div>
		              <div class="col-sm-4">
		                <label>UF</label>
		                <input type="text" name="cnpj" value="SP" class="form-control my-colorpicker1" disabled>
		              </div>	              
		          </div>	          
		      </div>
	        </form>
	        <!-- /.box-body -->
	        <div class="box-footer">
	          <button class="btn btn-primary">Gravar</button>
	        </div>
	      </div>
	      <!-- /.box -->	    

          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Itens da Venda</h3>
<!--               <div class="box-tools"> -->
<!--                 <div class="input-group input-group-sm" style="width: 150px;"> -->
<!--                   <input type="text" name="table_search" class="form-control pull-right" placeholder="Search"> -->
<!--                   <div class="input-group-btn"> -->
<!--                     <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button> -->
<!--                   </div> -->
<!--                 </div>                 -->
<!--               </div> -->
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>ID</th>
                  <th>User</th>
                  <th>Date</th>
                  <th>Status</th>
                  <th>Reason</th>
                </tr>
                <tr>
                  <td>183</td>
                  <td>John Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="label label-success">Approved</span></td>
                  <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                </tr>
                <tr>
                  <td>219</td>
                  <td>Alexander Pierce</td>
                  <td>11-7-2014</td>
                  <td><span class="label label-warning">Pending</span></td>
                  <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                </tr>
                <tr>
                  <td>657</td>
                  <td>Bob Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="label label-primary">Approved</span></td>
                  <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                </tr>
                <tr>
                  <td>175</td>
                  <td>Mike Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="label label-danger">Denied</span></td>
                  <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                </tr>
              </table>
                <div class="box-footer clearfix">
	              <ul class="pagination pagination-sm no-margin pull-right">
	                <li><a href="#">&laquo;</a></li>
	                <li><a href="#">1</a></li>
	                <li><a href="#">2</a></li>
	                <li><a href="#">3</a></li>
	                <li><a href="#">&raquo;</a></li>
	              </ul>
                </div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col-->
      </div>
      <!-- ./row -->
	</section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->  
 <jsp:include page="../includes/footer.jsp"></jsp:include> 
  
  