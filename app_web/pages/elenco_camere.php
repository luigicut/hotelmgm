<?php
include "connessione.php"; 

    //Numero Camere
    $sql = "SELECT * FROM camera";
    $result = mysqli_query($conn, $sql);
	$n_camere=mysqli_num_rows($result);

?>                 
				
				<div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Visualizza Elenco Camere</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Elenco Camere
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
								
								<?php
								
								if ($n_camere==0){
                                              echo'<div class="alert alert-info">
                                                   Nessun Elemento Trovato!
                                                 </div>';
								                  }
								            else{					
					                             echo'<table class="table table-striped table-bordered table-hover">';
				                                 echo"<thead>
                                                        <tr> <th>N° Camera</th> <th>Piano</th> <th>Posti Letto</th> <th>Tipo</th> <th>Stato</th> </tr>
                                                      </thead>
                                                      <tbody>";
					 
					                             while($row=mysqli_fetch_assoc($result)){
                            
                        							$numero=$row['Numero'];
						                            $piano=$row['Piano'];
						                            $n_letti=$row['NumLetti'];
						                            $tipo=$row['Tipo'];
						                            $stato=$row['Stato'];
													
													if($stato==1) $s="Occupata";
													         else $s="Libera";
													
						                            echo"<tr> <td>$numero</td> <td>$piano</td> <td>$n_letti</td> <td>$tipo</td> <td>$s</td> </tr>";
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