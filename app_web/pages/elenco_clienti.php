<?php
include "connessione.php"; 

    //Numero Camere
    $sql = "SELECT * FROM cliente";
    $result = mysqli_query($conn, $sql);
	$n_clienti=mysqli_num_rows($result);

?>                       
				<div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Visualizza Elenco Clienti</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Elenco Clienti
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    
									<?php
								
								if ($n_clienti==0){
                                              echo'<div class="alert alert-info">
                                                   Nessun Elemento Trovato!
                                                 </div>';
								                  }
								            else{					
					                             echo'<table class="table table-striped table-bordered table-hover">';
				                                 echo"<thead>
                                                        <tr> <th>Cognome</th> <th>Nome</th> <th>Data di Nascita</th> <th>Sesso</th> <th>Dettagli</th> </tr>
                                                      </thead>
                                                      <tbody>";
					 
					                             while($row=mysqli_fetch_assoc($result)){
                                                    
													$cod=$row['Cod'];
                        							$nome=$row['Nome'];
						                            $cognome=$row['Cognome'];
						                            $data_nascita=$row['DataNascita'];
						                            $sesso=$row['Sesso'];
													
						                            echo"<tr> <td>$cognome</td> <td>$nome</td> <td>$data_nascita</td> <td>$sesso</td> <td align='center'>"; 
									?> 
													                            <form name='<?php echo"form-$numero"; ?>"' method='post' action="<?php echo $_SERVER['PHP_SELF']; ?>"'> 
																				
																				<?php       
																				echo"  <input type='hidden' name='cliente' value='$cod'> 
																					   <button type='submit' class='btn btn-primary' name='dettagli-submit'>Dettagli</button> 
																			    </form>
																				</td> </tr>";
					                                }//fine while
						                    
											echo"  </tbody>
                                                 </table>"; 	
											}
								    ?>
									
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