<?php
include "pages/connessione1.php";


if(isset($_POST['login'])){

    $username=$_POST['username'];
    //$pass=md5($_POST['password']);
    $pass=$_POST['password'];

    $sql = "SELECT * FROM account WHERE (Login='$username' AND Password='$pass')";
    $result = mysqli_query($conn, $sql);
	$righe=mysqli_num_rows($result);
	
	if ($righe<=0) {echo "<script>alert('Credenziali Errate!');</script>";} 
	                              else{
		                               //RECUPERO I DATI DELLA QUERY
					                   $row=mysqli_fetch_assoc($result);
                                       //CREO LA SESSIONE
						               session_start();
                                       // Creo le variabili di sessione
                                       $_SESSION["username"]=$row['Login'];
                                       $_SESSION["password"]=$row['Password'];
						               $_SESSION["nome"]=$row['Nome'];
						               $_SESSION["cognome"]=$row['Cognome'];
						               $_SESSION["datanascita"]=$row['DataNascita'];
						               $_SESSION["ruolo"]=$row['Ruolo'];
						
						               header( "Location:pages/index.php" );
					                } 		
		
	}	
		
mysqli_close($conn);   
?>

<html>
<head>
	<title>Login - HotelMgM</title>
	<meta charset="UTF-8">
<!--========================================================================== ICON -->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>

<!--========================================================================== FONTS -->	
	<link rel="stylesheet" type="text/css" href="fonts/fonts-login/font-awesome-4.7.0/css/font-awesome.min.css">
	
<!--========================================================================== STYLE-->
	<link rel="stylesheet" type="text/css" href="css/login/util.css">
	<link rel="stylesheet" type="text/css" href="css/login/main.css">
</head>

<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" name="form1" method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
					<span class="login100-form-title">
						User Login
					</span>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit" name="login">
							Login
						</button>
					</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>