<?php
session_start();
include '../dbh.php';

$name= $_POST['bmname'];
$dob= $_POST['dob'];
$team= $_POST['tname'];
$hand= $_POST['handed'];
$f= $_POST['format'];

$inn= $_POST['innings'];
$runs= $_POST['runs'];
$avg= $_POST['avg'];
$sr= $_POST['sr'];
$fs= $_POST['50s'];

$inn1= $_POST['innings1'];
$wickets= $_POST['wickets'];
$avg1= $_POST['avg1'];
$sr1= $_POST['sr1'];
$econ= $_POST['econ'];


		$doe= $_POST['doe'];
		$type= $_POST['bmtype'];
		$bltype=$_POST['bltype'];
		
											if (empty($name)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($dob)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($team)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($hand)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($f)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($inn)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($wickets)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($avg)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($sr)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($econ)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($inn1)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($runs)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($avg1)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($sr1)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($fs)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($doe)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($bltype)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($type)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											else{
												
												
								$sql = "SELECT name FROM bm$f WHERE bmname = '$name'";
										$result= mysqli_query($conn,$sql);
										$uidcheck= mysqli_num_rows($result);
										$sqla = "SELECT name FROM bl$f WHERE blname = '$name'";
										$resulta= mysqli_query($conn,$sqla);
										$uidchecka= mysqli_num_rows($resulta);
								
										if($uidcheck>0){if($uidchecka<=0){echo '1';
											header("Location: ../addnewbm.php?error=alal");
											exit();}} 
											
										
										if($uidcheck<=0){if($uidchecka>0){echo '2';
											header("Location: ../addnewbm.php?error=alal");
											exit();}} 
										if($uidcheck>0){if($uidchecka>0){echo '3';
											header("Location: ../addnewbm.php?error=same");
											exit();}} 
										else{
											
												$sql="INSERT INTO player(pname,dob,tid) VALUES('$name','$dob',(select tid from team where tname = '$team'))";
										$result= mysqli_query($conn,$sql);
										
										$sql="INSERT INTO type(pid,role,bmtype,bltype,handed) VALUES((select pid FROM player WHERE pname='$name'),'all-rounder','$type','$bltype','$hand')";
										$result= mysqli_query($conn,$sql);
										
										$sql="INSERT INTO batsman(pid,name) VALUES((select pid FROM player WHERE pname='$name'),'$name')";
										$result= mysqli_query($conn,$sql);
										if($f=='odi' or $f=='test'){
											$hs= $_POST['100s'];
											if (empty($hs)){
											header("Location: ../addnewal.php?error=empty");
											exit();}
											$sql="INSERT INTO bm$f(bmname,innings,runs,avg,sr,50s,100s,doe)
										VALUES('$name','$inn','$runs','$avg','$sr','$fs','$hs','$doe')";
										$result= mysqli_query($conn,$sql);
										
										}
										else{
											$fours= $_POST['fours'];
											$sixes= $_POST['sixes'];
											if (empty($fours)){
											header("Location: ../addnewal.php?error=empty");
											exit();}
											if (empty($sixes)){
											header("Location: ../addnewal.php?error=empty");
											exit();}
											$sql="INSERT INTO bmt20(bmname,innings,runs,avg,sr,50s,fours,sixes,doe)
										VALUES('$name','$inn','$runs','$avg','$sr','$fs','$fours','$sixes','$doe')";
										$result= mysqli_query($conn,$sql);
										}
										$sql="INSERT INTO bowler(pid,name) VALUES((select pid FROM player WHERE pname='$name'),'$name')";
										$result= mysqli_query($conn,$sql);
										
										$sql="INSERT INTO bl$f(blname,innings1,wickets,avg1,sr1,econ,doe)
										VALUES('$name','$inn','$wickets','$avg','$sr','$econ','$doe')";
										$result= mysqli_query($conn,$sql);
													header("Location: ../addnewal.php?report=success");
						
										}
									
									
									
									
											
								
										
										
											}
	