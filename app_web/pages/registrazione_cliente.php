<?php
include "connessione.php"; 

if (isset($_POST["inserisci"])) {
	                             $nome=$_POST['nome'];
								 $cognome=$_POST['cognome'];
								 $data_nascita=$_POST['datanascita'];
								 $sesso=$_POST['sesso'];
								 $luogo_nascita=$_POST['luogonascita'];
								 $provincia=$_POST['provincia'];
								 $data_nascita=$_POST['datanascita'];
								 $carta_identita=$_POST['cartaidentita'];
								 $codice_fiscale=$_POST['codicefiscale'];
								 $nazionalita=$_POST['nazionalita'];
								 
									
							     $sql = "INSERT INTO cliente (Cod, Nome, Cognome, LuogoNascita, Provincia, DataNascita, NumCartaID, CodFiscale, Nazionalita, Sesso) VALUES (NULL, '$nome', '$cognome', '$luogo_nascita', '$provincia', '$data_nascita','$carta_identita', '$codice_fiscale', '$nazionalita', '$sesso')";
                                 $result=mysqli_query($conn, $sql);
	
	                             if (!$result) {
            									   echo "<script LANGUAGE='JavaScript'>
                                                           window.alert('Errore Trasmissione Dati!');
                                                           window.location.href='index.php';
                                                         </script>";
													}
	                                      else {
                                                   echo "<script LANGUAGE='JavaScript'>
                                                           window.alert('Nuovo Cliente Inserito!');
                                                           window.location.href='index.php';
                                                         </script>";
												    }	 						
									}
mysqli_close($conn); 
?>        
		
		
		<div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Registrazione Nuovo Cliente</h3>		
                        </div>
                        <!-- /.col-lg-12 -->
						
						
						<div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Registrazione Nuovo Cliente
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
								
								
								<form name='form-registrazione' method='post' action="<?php echo $_SERVER['PHP_SELF']; ?>">
                                    <table class="table table-striped table-bordered table-hover">
                                            <tr>
											    <td>
                                                   <label>Nome</label>
                                                   <input class="form-control" name="nome">
												</td>
											    <td>
                                                   <label>Cognome</label>
                                                   <input class="form-control" name="cognome">
												</td>
                                            </tr>
                                            <tr>
											    <td>
                                                   <label>Data di Nascita</label>
                                                   <input class="form-control" name="datanascita">
												</td>
											    <td>
                                                   <label>Sesso</label>
                                                     <select class="form-control" name="sesso">
                                                       <option>M</option>
                                                       <option>F</option>
                                                     </select>
												</td>
                                            </tr>
                                            <tr>
											    <td>
                                                   <label>Luogo di Nascita</label>
                                                   <input class="form-control" name="luogonascita">
												</td>
											    <td>
                                                   <label>Provincia</label>
                                                   <input class="form-control" name="provincia">
												</td>
                                            </tr>
                                            <tr>
											    <td>
                                                   <label>N° Carta Identità</label>
                                                   <input class="form-control" name="cartaidentita">
												</td>
											    <td>
                                                   <label>Codice Fiscale</label>
                                                   <input class="form-control" name="codicefiscale">
												</td>
                                            </tr>
                                            <tr>
											    <td colspan="2">
                                                   <label>Nazionalità</label>
                                                   <input class="form-control" name="nazionalita">
												</td>
                                            </tr>
                                            <tr>
											    <td colspan="2" align="right">
                                                      <button type="submit" class="btn btn-primary" name="inserisci">Inserisci</button>
                                                      <button type="button" class="btn btn-default">Cancel</button> 
									             </td>
                                            </tr>
                                        </tbody>
                                    </table>
									</form>
									
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
						
						</div>
                        <!-- /.col-lg-12 -->
						
					</div>	
                </div>
                <!-- /.container-fluid -->


				
<form name="form" onSubmit="javascript:xmlhttpPost('home1.php'); return false;">
     <input name="nome" type="hidden">
</form>				