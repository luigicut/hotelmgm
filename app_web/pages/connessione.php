<?php
// hostname
$nomehost = "localhost";   
// utente per la connessione a MySQL  
$nomeuser = "root";
// password per l'autenticazione dell'utente 
$password = "";
// nome database
$dbname = "hotelmgm";

// Create connection
$conn = new mysqli($nomehost, $nomeuser, $password, $dbname);

// Check connection
if (!$conn) {die("Connection failed: " . mysqli_connect_error());}

?>