                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Visualizza Elenco Prodotti</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Visualizza Elenco Prodotti
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Codice</th>
                                                <th>Nome</th>
                                                <th>Prezzo</th>
                                                <th>Modifica</th>
                                                <th>Cancella</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>01</td>
                                                <td>Caffè</td>
                                                <td>0,80 €</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Modifica</button></td>
                                                <td align="center"><button type="button" class="btn btn-primary">Cancella</button></td>
                                            </tr>
                                            <tr>
                                                <td>02</td>
                                                <td>Cornetto</td>
                                                <td>1,00 €</td>
                                                <td align="center"><button type="button" class="btn btn-primary">Modifica</button></td>
                                                <td align="center"><button type="button" class="btn btn-primary">Cancella</button></td>
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