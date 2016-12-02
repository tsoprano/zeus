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
	if (empty($doe)){
	header("Location: ../upbl.php?error=empty");
	exit();}
	
	else{
		$sql = "SELECT blname FROM bl$f WHERE blname = '$name'";
					$result= mysqli_query($conn,$sql);
					if(mysqli_num_rows($result)>0){
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


					