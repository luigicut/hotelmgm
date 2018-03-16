<?php
include "connessione.php"; 

    //Numero Prodotti
    $sql = "SELECT * FROM extra";
    $result = mysqli_query($conn, $sql);
	$n_prodotti=mysqli_num_rows($result);

?>                 
				
				<div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Visualizza Elenco Prodotti</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Elenco Prodotti
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
								
								<?php
								
								if ($n_prodotti==0){
                                              echo'<div class="alert alert-info">
                                                   Nessun Elemento Trovato!
                                                 </div>';
								                  }
								            else{					
					                             echo'<table class="table table-striped table-bordered table-hover">';
				                                 echo"<thead>
                                                        <tr> <th>N°</th> <th>Descrizione</th> <th>Prezzo</th></tr>
                                                      </thead>
                                                      <tbody>";
					 
					                             while($row=mysqli_fetch_assoc($result)){
                            
                        							$numero=$row['Cod'];
						                            $nome=$row['Nome'];
						                            $prezzo=$row['Prezzo'];
													$padded = sprintf('%0.2f', $prezzo);
													
						                            echo"<tr> <td>$numero</td> <td>$nome</td> <td align='center'>$padded €</td> </tr>";
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