<?php
session_start();

//CONTROLLO ESISTENZA VARIABILE DI SESSIONE ID
if (!isset($_SESSION["username"])) {
	      //Se non esiste la variabile di sessione ID ritorna al form di Login  
                          header("Location: logout.php");
                          exit;
		                 }
          else{
	           //Recupero i dati dell'utente dalle variabili di sessione
               $username=$_SESSION["username"];
			   $password=$_SESSION["password"];
			   $cognome=$_SESSION["cognome"];
			   $nome=$_SESSION["nome"];
			   $datanascita=$_SESSION["datanascita"];
			   $ruolo=$_SESSION["ruolo"];
		       }
					
include "connessione.php";    
?>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>HotelMgM - Home1</title>

        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../css/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../css/startmin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
		
		
  </script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
		
    </head>
    <body>
    
	<script type="text/javascript" src="funzioni_ajax.js"></script>
        
	
		<div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			
			    <div class="navbar-header">
                    <a class="navbar-brand" href="#">Hotel MgM</a>
                </div>
				
                <div class="navbar-header">
                    <img src="../images/logo/logo25.png">
                </div>


                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <?php echo"$nome $cognome"; ?><b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> Profilo Utente</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Impostazioni</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="logout.php"><i class="fa fa-sign-out fa-fw"></i> Esci</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
					
					      <!-- Sidebar user panel -->
                                <div class="table-responsive">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td rowspan="3"> <img src="../images/user/user_m.png" class="img-circle" height="70" width="70" alt="User Image"> </td>
                                                <td><b><?php echo"$nome $cognome"; ?></b></td>
                                            </tr>
                                            <tr> <td style="font-size:10px"><b>Tipo Profilo:</b> <?php echo"$ruolo"; ?></td> </tr>
                                            <tr> <td style="font-size:10px"><i class="fa fa-circle text-success"></i> Online</td> </tr>
                                        </tbody>
                                    </table>
                                </div>
                          <!-- /.table-responsive -->
					 
					 <ul class="nav" id="side-menu">
                            <li class="active">
                                <a class="active" href="home.php" onClick="javascript:xmlhttpPost('home.php'); return false;"><i class="fa fa-home fa-fw"></i> Home</a>
                            </li>		
							<li>
                                <a href="#"><i class="fa fa-hotel fa-fw"></i> Camere<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
								<!--
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Aggiungi Nuova Camera</a></li>
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Modifica Dati Camera</a></li>
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Cancella Camera</a></li>
								-->
                                    <li> <a href="ricerca_camere.php" onClick="javascript:xmlhttpPost('ricerca_camere.php'); return false;"><i class="fa fa-angle-double-right"></i> Ricerca Camera</a></li>
                                    <li> <a href="elenco_camere.php" onClick="javascript:xmlhttpPost('elenco_camere.php'); return false;"><i class="fa fa-angle-double-right"></i> Visualizza Elenco Camere</a></li>
                                    <li> <a href="check-in_camere.php" onClick="javascript:xmlhttpPost('check-in_camere.php'); return false;"><i class="fa fa-angle-double-right"></i> Check-In Camera</a></li>
                                    <li> <a href="check-out_camere.php" onClick="javascript:xmlhttpPost('check-out_camere.php'); return false;"><i class="fa fa-angle-double-right"></i> Check-Out Camera</a></li>
                                </ul>
                            </li>     <!-- Fine Menu CAMERE -->		
							<li>
                                <a href="#"><i class="fa fa-street-view fa-fw"></i> Clienti<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="ricerca_cliente.php" onClick="javascript:xmlhttpPost('ricerca_cliente.php'); return false;"><i class="fa fa-angle-double-right"></i> Ricerca Cliente</a></li>
                                    <li> <a href="elenco_clienti.php" onClick="javascript:xmlhttpPost('elenco_clienti.php'); return false;"><i class="fa fa-angle-double-right"></i> Visualizza Elenco Clienti</a></li>
                                    <li> <a href="registrazione_cliente.php" onClick="javascript:xmlhttpPost('registrazione_cliente.php'); return false;"><i class="fa fa-angle-double-right"></i> Registrazione Nuovi Clienti</a></li>
                                    <li> <a href="modifica_clienti.php" onClick="javascript:xmlhttpPost('modifica_clienti.php'); return false;"><i class="fa fa-angle-double-right"></i> Modifica Dati Cliente</a></li>
                                    <li> <a href="contabilita.php" onClick="javascript:xmlhttpPost('contabilita.php'); return false;"><i class="fa fa-angle-double-right"></i> Contabilità Cliente</a></li>
                                </ul>
                            </li>     <!-- Fine Menu CLIENTI -->		
							<li>
                                <a href="#"><i class="fa fa-calendar fa-fw"></i> Prenotazioni<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="ricerca_prenotazione.php" onClick="javascript:xmlhttpPost('ricerca_prenotazione.php'); return false;"><i class="fa fa-angle-double-right"></i> Ricerca Prenotazione</a></li>
                                    <li> <a href="visualizza_prenotazioni.php" onClick="javascript:xmlhttpPost('visualizza_prenotazioni.php'); return false;"><i class="fa fa-angle-double-right"></i> Visualizza Prenotazioni</a></li>
                                    <li> <a href="inserisci_nuova_prenotazione.php" onClick="javascript:xmlhttpPost('inserisci_nuova_prenotazione.php'); return false;"><i class="fa fa-angle-double-right"></i> Inserisci Nuova Prenotazione</a></li>
                                </ul>
                            </li>     <!-- Fine Menu PRENOTAZIONI -->		
							<li>
                                <a href="#"><i class="fa fa-coffee fa-fw"></i> Servizi Extra<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="elenco_prodotti.php" onClick="javascript:xmlhttpPost('elenco_prodotti.php'); return false;"><i class="fa fa-angle-double-right"></i> Visualizza Elenco Prodotti</a></li>
                                    <li> <a href="inserisci_extra.php" onClick="javascript:xmlhttpPost('inserisci_extra.php'); return false;"><i class="fa fa-angle-double-right"></i> Inserisci Prodotto Extra</a></li>
                                    <li> <a href="associa_prodotto.php" onClick="javascript:xmlhttpPost('associa_prodotto.php'); return false;"><i class="fa fa-angle-double-right"></i> Associa Prodotto</a></li>
                                </ul>
                            </li>     <!-- Fine Menu SERVIZI EXTRA -->
							<li>
                                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Statistiche<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li><a href="flot.html">Flot Charts</a></li>
                                    <li><a href="morris.html">Morris.js Charts</a></li>
                                </ul>
                            </li>     <!-- Fine Menu STATISTICHE -->	

							<!--
							<li>
                                <a href="#"><i class="fa fa-users fa-fw"></i> Utenti Sistema<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Inserisci Nuovo Profilo</a></li>
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Modifica Profilo Esistente</a></li>
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Cancella Profilo</a></li>
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Ricerca Profilo</a></li>
                                    <li> <a href="#"><i class="fa fa-angle-double-right"></i> Visualizza Elenco Utenti</a></li>
                                </ul>
                            </li> 
							-->    
							<!-- Fine Menu UTENTI DEL SISTEMA -->
                            
							<li>
                                <a href="profilo_personale.php" onClick="javascript:xmlhttpPost('profilo_personale.php'); return false;"><i class="fa fa-user fa-fw"></i> Profilo Personale</a>
                            </li>
							
							<li>
                                <a href="impostazioni.php" onClick="javascript:xmlhttpPost('impostazioni.php'); return false;"><i class="fa fa-cogs fa-fw"></i> Impostazioni</a>
                            </li>
							
							<li>
                                <a href="documentazione.php" onClick="javascript:xmlhttpPost('documentazione.php'); return false;"><i class="fa fa-book fa-fw"></i> Documentazione</a>
                            </li>
							
							<li>
                                <a href="logout.php"><i class="fa fa-sign-out fa-fw"></i> Esci</a>
                            </li>						
                        </ul> <!-- Fine MENU LATERALE-->
					
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">

			
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header">Home1</h3>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->

<?php
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
								<p>Date: <input type="text" id="datepicker"></p>
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
					
                </div>
                <!-- /.row -->
				
				
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
			
                        <div style="text-align:right;font-size:10px;">
                           <br> Versione 1.0.0 &nbsp; &nbsp;
                        </div>
                        <!-- /.col-lg-12 -->
        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="../js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="../js/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="../js/startmin.js"></script>

    </body>
</html>
