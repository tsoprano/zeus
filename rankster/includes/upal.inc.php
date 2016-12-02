<?php
session_start();
include '../dbh.php';

$name= $_POST['blname'];
$f= $_POST['f'];
$inn1= $_POST['innings1'];
$wickets= $_POST['wickets'];
$avg1= $_POST['avg1'];
$sr1= $_POST['sr1'];
$econ= $_POST['econ'];
$doe= $_POST['doe'];
$inn= $_POST['innings'];
$runs= $_POST['runs'];
$avg= $_POST['avg'];
$sr= $_POST['sr'];
$fs= $_POST['50s'];
$hs= $_POST['100s'];
$sixes= $_POST['sixes'];
$fours= $_POST['fours'];
echo "bl$f";

	if (empty($name)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	if (empty($f)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	if (empty($inn1)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	if (empty($wickets)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	if (empty($sr1)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	if (empty($avg1)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	if (empty($econ)){
	header("Location: ../upbl.php?error=empty");
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
	header("Location: ../upbl.php?error=empty");
	exit();}
	
	else{
					$sql = "SELECT blname FROM bl$f WHERE blname = '$name'";
					$result= mysqli_query($conn,$sql);
					$sqla = "SELECT bmname FROM bm$f WHERE bmname = '$name'";
					$resulta= mysqli_query($conn,$sqla);
					if(mysqli_num_rows($result)>0 and mysqli_num_rows($resulta)>0){
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
							echo "Operation Failure please re-attempt (Recheck the name)";
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
							if(mysqli_num_rows($result) >0)
							{
							echo "You have successfully updated your record";
							}
							else
							{
							echo "Operation Failure please re-attempt (Recheck the name)";
							}
						}
						$sql="UPDATE bl$f 
						SET innings1 = '$inn1',wickets = '$wickets', avg1 = '$avg1', sr1 = '$sr1', econ = '$econ',doe = '$doe' 
						WHERE blname = '$name'";
						$result= mysqli_query($conn,$sql);
						if($result>0)
							{
							header("Location: ../upbm.php?report=success");		
							}
							else
							{
							header("Location: ../upbm.php?report=fail");		
							}
					}
					else{
						header("Location: ../upbl.php?error=not");
						exit();
					}

		
	}


					