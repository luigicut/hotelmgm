        <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Ricerca Clienti</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Ricerca Clienti
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                            <tr>
											    <td>
                                                   <label>Numero Camera</label>
                                                      <select class="form-control">
                                                        <option>101</option>
                                                        <option>201</option>
                                                        <option>301</option>
                                                      </select>
												</td>
											    <td>
                                                   <label>Codice Extra</label>
                                                      <select class="form-control">
                                                        <option>01</option>
                                                        <option>02</option>
                                                      </select>
												</td>
                                            </tr>
                                            <tr>
											    <td>
                                                   <label>Quantità</label>
                                                   <input class="form-control">
												</td>
											    <td>
                                                   <label>Data di Consumo</label>
                                                   <input class="form-control">
												</td>
                                            </tr>
                                            <tr>
											    <td colspan="2" align="right">
                                                      <button type="button" class="btn btn-primary">Esegui</button>
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
						
                </div>
                <!-- /.container-fluid -->


				
<form name="form" onSubmit="javascript:xmlhttpPost('home1.php'); return false;">
     <input name="nome" type="hidden">
</form>				