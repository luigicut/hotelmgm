        <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Ricerca Prenotazione</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Ricerca Prenotazione
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                            <tr>
											    <td>
                                                   <label>N° Camera</label>
                                                   <input class="form-control">
												</td>
											    <td>
                                                   <label>Nominativo</label>
                                                   <input class="form-control">
												</td>
                                            </tr>
                                            <tr>
											    <td colspan="2" align="right">
                                                      <button type="button" class="btn btn-primary">Ricerca</button>
                                                      <button type="button" class="btn btn-default">Cancel</button> 
									            </td>
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
						
						
                        <div class="col-lg-12" id="risultato">

                        <div class="panel panel-default">
                            <div class="panel-heading">Risultati Ricerca Disponibilità
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>N° Camera</th>
                                                <th>Nominativo</th>
                                                <th>Dal</th>
                                                <th>Al</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>101</td>
                                                <td>Rossi Mario</td>
                                                <td>20/08/2018</td>
                                                <td>30/08/2018</td>
                                            </tr>
                                            <tr>
                                                <td>201</td>
                                                <td>Esposito Gennaro</td>
                                                <td>19/07/2018</td>
                                                <td>22/07/2018</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                              </div><!-- /.panel -->								
                        </div>
						
						
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->


				
<form name="form" onSubmit="javascript:xmlhttpPost('home1.php'); return false;">
     <input name="nome" type="hidden">
</form>				