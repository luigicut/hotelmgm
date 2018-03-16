        <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Inserisci Nuova Prenotazione</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Inserisci Nuova Prenotazione
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                            <tr>
											    <td>
                                                   <label>Data Inizio Prenotazione</label>
                                                   <input class="form-control">
												</td>
											    <td>
                                                   <label>Data Fine Prenotazione</label>
                                                   <input class="form-control">
												</td>
                                            </tr>
                                            <tr>
											    <td>
                                                   <label>Cognome</label>
                                                   <input class="form-control">
												</td>
											    <td>
                                                   <label>Nome</label>
                                                   <input class="form-control">
												</td>
                                            </tr>
                                            <tr>
											    <td colspan="2" align="right">
                                                      <button type="button" class="btn btn-primary">Ricerca Disponibilità</button>
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
                                                <th>Tipologia</th>
                                                <th>N° Letti</th>
                                                <th>Esegui Prenotazione</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>101</td>
                                                <td>Matrimoniale</td>
                                                <td>2</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Prenota</button></td>
                                            </tr>
                                            <tr>
                                                <td>201</td>
                                                <td>Singola</td>
                                                <td>1</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Prenota</button></td>
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