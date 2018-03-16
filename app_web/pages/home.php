<?php
include "connessione.php"; 

    //Numero Camere
    $sql = "SELECT * FROM camera";
    $result = mysqli_query($conn, $sql);
	$n_camere=mysqli_num_rows($result);

	//Numero Clienti
	$sql = "SELECT * FROM cliente";
    $result = mysqli_query($conn, $sql);
	$n_clienti=mysqli_num_rows($result);

	//Numero Prenotazioni 
    $sql = "SELECT * FROM calendario";
    $result = mysqli_query($conn, $sql);
	$n_prenotazioni=mysqli_num_rows($result);
	
	//Numero Extra
	$sql = "SELECT * FROM extra";
    $result = mysqli_query($conn, $sql);
	$n_extra=mysqli_num_rows($result);
?>               
			   
			   <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Home</h3>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
					
					 <!-- /.row -->
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-hotel fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><?php echo"$n_camere"; ?></div>
                                        <div>Camere</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
								    <a href="elenco_camere.php" onClick="javascript:xmlhttpPost('elenco_camere.php'); return false;"> 
                                    <span class="pull-left">Visualizza Dettagli</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    </a>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-street-view fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><?php echo"$n_clienti"; ?></div>
                                        <div>Clienti</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
								    <a href="elenco_clienti.php" onClick="javascript:xmlhttpPost('elenco_clienti.php'); return false;">
                                    <span class="pull-left">Visualizza Dettagli</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    </a>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-calendar fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><?php echo"$n_prenotazioni"; ?></div>
                                        <div>Prenotazioni</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
								    <a href="visualizza_prenotazioni.php" onClick="javascript:xmlhttpPost('visualizza_prenotazioni.php'); return false;">
                                    <span class="pull-left">Visualizza Dettagli</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    </a>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-coffee fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><?php echo"$n_extra"; ?></div>
                                        <div>Extra</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
								    <a href="visualizza_elenco_prodotti.php" onClick="javascript:xmlhttpPost('visualizza_elenco_prodotti.php'); return false;">
                                    <span class="pull-left">Visualizza Dettagli</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    </a>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
				
				
				
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-calendar fa-fw"></i> Calendario Prenotazioni
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                sdfsdgdsfds
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-8 -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bell fa-fw"></i> Ultime operazioni
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="list-group">
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-comment fa-fw"></i> New Comment
                                            <span class="pull-right text-muted small"><em>4 minutes ago</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                            <span class="pull-right text-muted small"><em>12 minutes ago</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-envelope fa-fw"></i> Message Sent
                                            <span class="pull-right text-muted small"><em>27 minutes ago</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-tasks fa-fw"></i> New Task
                                            <span class="pull-right text-muted small"><em>43 minutes ago</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                            <span class="pull-right text-muted small"><em>11:32 AM</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-bolt fa-fw"></i> Server Crashed!
                                            <span class="pull-right text-muted small"><em>11:13 AM</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-warning fa-fw"></i> Server Not Responding
                                            <span class="pull-right text-muted small"><em>10:57 AM</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-shopping-cart fa-fw"></i> New Order Placed
                                            <span class="pull-right text-muted small"><em>9:49 AM</em>
                                            </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-money fa-fw"></i> Payment Received
                                            <span class="pull-right text-muted small"><em>Yesterday</em>
                                            </span>
                                    </a>
                                </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
						
                    </div>
                    <!-- /.col-lg-4 -->
					
	           </div>

	
	<form name="form" onSubmit="javascript:xmlhttpPost('home1.php'); return false;">
      <input name="nome" type="hidden">
    </form>
	
	
	</div>	