<?php
session_start();
include '../dbh.php';

$name= $_POST['blname'];
$dob= $_POST['dob'];
$team= $_POST['tname'];
$hand= $_POST['handed'];
$f= $_POST['format'];

$inn= $_POST['innings'];
$wickets= $_POST['wickets'];
$avg= $_POST['avg'];
$sr= $_POST['sr'];
$econ= $_POST['econ'];


		$doe= $_POST['doe'];
		$bltype= $_POST['bltype'];
		$type='-';
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
											if (empty($doe)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
											if (empty($bltype)){
											header("Location: ../addnewbm.php?error=empty");
											exit();}
										
										
										$sql = "SELECT name FROM bl$f WHERE blname = '$name'";
										$result= mysqli_query($conn,$sql);
								
										
										
										if(mysqli_num_rows($result)>0){
											
											header("Location: ../addnewbl.php?error=same");
											exit();
										}
										else{
											$sql = "SELECT name FROM batsman WHERE name = '$name'";
											$result= mysqli_query($conn,$sql);
										if(mysqli_num_rows($result)>0){
											
											header("Location: ../addnewbl.php?error=albl");
											exit();
										}
										else{
												$sql="INSERT INTO player(pname,dob,tid) VALUES('$name','$dob',(select tid from team where tname = '$team'))";
										$result= mysqli_query($conn,$sql);
										
										$sql="INSERT INTO type(pid,role,bmtype,bltype,handed) VALUES((select pid FROM player WHERE pname='$name'),'bowler','$type','$bltype','$hand')";
										$result= mysqli_query($conn,$sql);
										
										$sql="INSERT INTO bowler(pid,name) VALUES((select pid FROM player WHERE pname='$name'),'$name')";
										$result= mysqli_query($conn,$sql);
										
										$sql="INSERT INTO bl$f(blname,innings1,wickets,avg1,sr1,econ,doe)
										VALUES('$name','$inn','$wickets','$avg','$sr','$econ','$doe')";
										$result= mysqli_query($conn,$sql);
										
										}
									
									header("Location: ../addnewbl.php?report=success");
									}
									
											