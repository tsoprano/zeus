<?php
session_start();
include '../dbh.php';

$first= $_POST['first'];
$last= $_POST['last'];
$uid= $_POST['uid'];
$password= $_POST['password'];


if (empty($first)){
	header("Location: ../signup.php?error=empty");
	exit();
}
if (empty($last)){
	header("Location: ../signup.php?error=empty");
	exit();
}
if (empty($uid)){
	header("Location: ../signup.php?error=empty");
	exit();
}
if (empty($password)){
	header("Location: ../signup.php?error=empty");
	exit();
}

else{
		$sql = "SELECT uid FROM user WHERE uid = '$uid'";
		$result= mysqli_query($conn,$sql);
		$uidcheck= mysqli_num_rows($result);	
		if($uidcheck>0){
			header("Location: ../signup.php?error=same");
			exit();
	    }
			else{
				$sql="INSERT INTO user(first,last,uid,password)
				VALUES('$first','$last','$uid','$password')";
				$result= mysqli_query($conn,$sql);
				if($result>0)
				{
				echo "<center><p style='color:red'>You have successfully Inserted your new record</p></center>";
				}
				else
				{
				echo "<center><p style='color:red'>Operation Failure please re-attempt</p></center>";
				}
		
				//<br><center><p style='color:black'><a href="../main.php">BACK</a></p></center>
				header("Location: ../main.php");
			}
			
	}
	
