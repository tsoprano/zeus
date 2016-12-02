<?php
session_start();

include '../dbh.php';
$uid= $_POST['uid'];
$password= $_POST['password'];

$sql="SELECT * FROM user WHERE uid='$uid' AND password='$password'";
$result= mysqli_query($conn,$sql);

if(!$row=mysqli_fetch_assoc($result))
{
	echo "Login Failed";
}
	else{
		$_SESSION['id']=$row['id'];
		echo "<p align='right'>Hello</p> ";
		echo $_SESSION['id'];
		}

header("Location: ../index.php");
