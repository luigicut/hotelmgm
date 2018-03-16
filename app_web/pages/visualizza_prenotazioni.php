                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Visualizza Prenotazioni</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Visualizza Prenotazioni
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>N° Camera</th>
                                                <th>Tipo Camera</th>
                                                <th>Dal</th>
                                                <th>Al</th>
                                                <th>Nominativo</th>
                                                <th>Cancella</th>
                                                <th>Modifica</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>101</td>
                                                <td>Matrimoniale</td>
                                                <td>20/08/2018</td>
                                                <td>30/08/2018</td>
                                                <td>Rossi Mario</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Cancella</button></td>
                                                <td align="center"><button type="button" class="btn btn-primary">Modifica</button></td>
                                            </tr>
                                            <tr>
                                                <td>201</td>
                                                <td>singola</td>
                                                <td>19/07/2018</td>
                                                <td>22/07/2018</td>
                                                <td>Esposito Gennaro</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Cancella</button></td>
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