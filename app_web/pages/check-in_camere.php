<?php
include "connessione.php"; 

if (isset($_POST["check-submit"])) {
	                                $n=$_POST['camera'];
									
									$sql = "UPDATE camera SET Stato='1' WHERE Numero='$n'";
                                    $result=mysqli_query($conn, $sql);
	
	                                if (!$result) {
            									   echo "<script LANGUAGE='JavaScript'>
                                                           window.alert('Errore Trasmissione Dati!');
                                                           window.location.href='index.php';
                                                         </script>";
													}
	                                         else {
                                                   echo "<script LANGUAGE='JavaScript'>
                                                           window.alert('Camera $n Occupata!');
                                                           window.location.href='index.php';
                                                         </script>";
												    }	 						
									}

    //Camere Libere
    $sql = "SELECT * FROM camera WHERE Stato='0'";
    $result = mysqli_query($conn, $sql);
	$n_camere=mysqli_num_rows($result);
mysqli_close($conn); 
?>     
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Check-In Camere</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Check-In Camere
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
                                                        <tr> <th>N° Camera</th> <th>Piano</th> <th>Posti Letto</th> <th>Tipo</th> <th>Esegui Check-In</th> </tr>
                                                      </thead>
                                                      <tbody>";
					 
					                             while($row=mysqli_fetch_assoc($result)){
                            
                        							$numero=$row['Numero'];
						                            $piano=$row['Piano'];
						                            $n_letti=$row['NumLetti'];
						                            $tipo=$row['Tipo'];
													
						                            echo"<tr> <td>$numero</td> <td>$piano</td> <td>$n_letti</td> <td>$tipo</td> <td align='center'>"; 
									?> 
													                            <form name='<?php echo"form-$numero"; ?>"' method='post' action="<?php echo $_SERVER['PHP_SELF']; ?>"'> 
																				
																				<?php       
																				echo"  <input type='hidden' name='camera' value='$numero'> 
																					   <button type='submit' class='btn btn-success' name='check-submit'>Check-In</button> 
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