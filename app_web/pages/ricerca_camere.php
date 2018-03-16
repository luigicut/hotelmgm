		<!-- Elementi per text-datapicker -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
</script>

        <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Ricerca Camere</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Ricerca Camere Libere
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                            <tr>
											   <td>
                                                <label>Numero</label>
                                                <select class="form-control">
                                                    <option>101</option>
                                                    <option>201</option>
                                                    <option>301</option>
                                                    <option>401</option>
                                                    <option>502</option>
                                                </select>
											   </td>
											   <td>
                                                <label>Letti</label>
                                                <select class="form-control">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                </select>
											   </td>
											   <td>
                                                <label>Piano</label>
                                                <select class="form-control">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
											   </td>
											   <td>
                                                <label>Tipologia</label>
                                                <select class="form-control">
                                                    <option>Singola</option>
                                                    <option>Doppia</option>
                                                    <option>Matrimoniale</option>
                                                    <option>Tripla</option>
                                                    <option>Quadrupla</option>
                                                    <option>Multipla</option>
                                                    <option>Suite</option>
                                                </select>
											   </td>	
                                            </tr>
                                            <tr>
											    <td colspan="2">
                                                   <label>Data Inizio</label>
                                                   <input class="form-control" id="datepicker">
												</td>
											       <td colspan="2">
                                                   <label>Data Fine</label>
                                                   <input class="form-control">
												</td>
                                            </tr>
                                            <tr>
											    <td colspan="4" align="right">
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
                            <div class="panel-heading">Risultati
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>Piano</th>
                                                <th>Posti Letto</th>
                                                <th>Tipo</th>
                                                <th>Stato</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>101</td>
                                                <td>1</td>
                                                <td>1</td>
                                                <td>Singola</td>
                                                <td>Occupata</td>
                                            </tr>
                                            <tr>
                                                <td>201</td>
                                                <td>2</td>
                                                <td>2</td>
                                                <td>Matrimoniale</td>
                                                <td>Libera</td>
                                            </tr>
                                            <tr>
                                                <td>301</td>
                                                <td>3</td>
                                                <td>4</td>
                                                <td>Quadrupla</td>
                                                <td>Libera</td>
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