<?php
session_start();
include '../dbh.php';

$name= $_POST['bmname'];

$f= $_POST['format'];
$inn= $_POST['innings'];
$runs= $_POST['runs'];
$avg= $_POST['avg'];
$sr= $_POST['sr'];
$fs= $_POST['50s'];
$hs= $_POST['100s'];
$doe= $_POST['doe'];
$sixes= $_POST['sixes'];
$fours= $_POST['fours'];
echo "bm$f";
	if (empty($name)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	if (empty($f)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	if (empty($inn)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	if (empty($runs)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	if (empty($sr)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	if (empty($fs)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	
	if (empty($doe)){
	header("Location: ../upbm.php?error=empty");
	exit();}
	
	else{
		$sql = "SELECT bmname FROM bm$f WHERE bmname = '$name'";
					$result= mysqli_query($conn,$sql);
					if(mysqli_num_rows($result) >0){
						if($f=='odi' or $f=='test'){
							if (empty($hs)){
							header("Location: ../upbm.php?error=empty");
							exit();}
							$sql="UPDATE bm$f 
						SET innings = '$inn',runs = '$runs', avg = '$avg', sr = '$sr', 50s = '$fs', 100s = '$hs', doe = '$doe' 
						WHERE bmname = '$name'";
						$result= mysqli_query($conn,$sql);
						if(mysqli_num_rows($result)>0)
							{
							echo "You have successfully updated your record";
							}
							else
							{
							echo "Operation Failure please re-attempt (Recheaack the name)";
							}
						}
						else{
							if (empty($sixes)){
							header("Location: ../upbm.php?error=empty");
							exit();}
							if (empty($fours)){
							header("Location: ../upbm.php?error=empty");
							exit();}
							$sql="UPDATE bmt20 
						SET innings = '$inn',runs = '$runs', avg = '$avg', sr = '$sr', 50s = '$fs', sixes = '$sixes', fours='$fours' doe = '$doe' 
						WHERE bmname = '$name'";
						$result= mysqli_query($conn,$sql);
						
						}
						
					}
					else{
						header("Location: ../upbm.php?error=not");
						exit();
					}
					
			header("Location: ../upbm.php?report=success");		

		
	}
	


					