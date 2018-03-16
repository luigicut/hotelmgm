                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Modifica Dati Cliente</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Modifica Dati Cliente
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Cognome</th>
                                                <th>Nome</th>
                                                <th>Data Nascita</th>
                                                <th>Sesso</th>
                                                <th>Dettagli</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Rossi</td>
                                                <td>Mario</td>
                                                <td>20/08/1957</td>
                                                <td>M</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Modifica</button></td>
                                            </tr>
                                            <tr>
                                                <td>Bianchi</td>
                                                <td>Antonella</td>
                                                <td>15/12/1983</td>
                                                <td>F</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Modifica</button></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
						
						</div>
                        <!-- /.col-lg-12 -->
						
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->


				
<form name="form" onSubmit="javascript:xmlhttpPost('home1.php'); return false;">
     <input name="nome" type="hidden">
</form>				