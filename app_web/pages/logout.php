<?php	 
     session_start();
	 session_destroy();
	 header("Location: ../index.php"); //torna al form di autenticazione
	 exit;
?>	 