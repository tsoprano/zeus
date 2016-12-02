<?php
include '../header.php';
?>	
<?php

include '../dbh.php';
?>
<br><br><br>

<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
table.sortable thead {
    background-color:#eee;
    color:#666666;
    font-weight: bold;
    cursor: default;
}

</style>



<?php

 if (empty($_POST['bltype'])){$blt='-';}else{$blt= $_POST['bltype'];}
if (empty($_POST['bmtype'])){$bmt='-';}else{$bmt= $_POST['bmtype'];}
if (empty($_POST['handed'])){$hand='-';}else{$hand= $_POST['handed'];}
$cp= $_POST['choice-player'];




echo"<script>
$(function(){
  $('#keywords').tablesorter(); 
});
</script>";



if ($hand=='-'){
	if($cp=='bl'){
		if($blt=='-'){
			
							$sql="SELECT blt20.*,player.pid,type.*
							FROM type
							left JOIN player
							ON type.pid=player.pid
							right join blt20 ON player.pname=bltest.blname
							 ";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
										$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
										echo "<tbody><tr>";
										echo "<td>" . $row['blname'] . "</td>";
										echo "<td>" . $row['innings1'] . "</td>";
										echo "<td>" . $row['role'] . "</td>";
										echo "<td>" . $pts. "</td>";
										echo "</tr></tbody>";
								}
							echo "</table></div>";
								
					
						} else {
							echo "0 results";
				}
			
			}
		elseif($blt!=='-'){
			if($blt=='fast'){
				$sql="SELECT blt20.*,player.pid,type.*
			FROM type
			left JOIN player
			ON type.pid=player.pid
			right join blt20 ON player.pname=bltest.blname
			WHERE bltype='fast'
			 ";
$result= mysqli_query($conn,$sql);

if (mysqli_num_rows($result) > 0) {
    echo "<h1>T20 RANKINGS</h1>";
    echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
    // output data of each row
    while($row=mysqli_fetch_assoc($result)) {
		$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
        echo "<tbody><tr>";
echo "<td>" . $row['blname'] . "</td>";
echo "<td>" . $row['innings1'] . "</td>";
echo "<td>" . $row['role'] . "</td>";
echo "<td>" . $pts. "</td>";
echo "</tr></tbody>";
    }
    echo "</table></div>";
	
	
} else {
    echo "0 results";
}
			
			
		}
		if($blt=='fast-medium'){
			$sql="SELECT blt20.*,player.pid,type.*
			FROM type
			left JOIN player
			ON type.pid=player.pid
			right join blt20 ON player.pname=bltest.blname
			WHERE bltype='fast-medium'
			 ";
$result= mysqli_query($conn,$sql);

if (mysqli_num_rows($result) > 0) {
    echo "<h1>T20 RANKINGS</h1>";
    echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
    // output data of each row
    while($row=mysqli_fetch_assoc($result)) {
		$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
        echo "<tbody><tr>";
echo "<td>" . $row['blname'] . "</td>";
echo "<td>" . $row['innings1'] . "</td>";
echo "<td>" . $row['role'] . "</td>";
echo "<td>" . $pts. "</td>";
echo "</tr></tbody>";
    }
    echo "</table></div>";
	
	
} else {
    echo "0 results";
}
			
		}
		if($blt=='medium'){
			$sql="SELECT blt20.*,player.pid,type.*
			FROM type
			left JOIN player
			ON type.pid=player.pid
			right join blt20 ON player.pname=bltest.blname
			WHERE bltype='medium'
			 ";
$result= mysqli_query($conn,$sql);

if (mysqli_num_rows($result) > 0) {
    echo "<h1>T20 RANKINGS</h1>";
    echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
    // output data of each row
    while($row=mysqli_fetch_assoc($result)) {
		$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
        echo "<tbody><tr>";
echo "<td>" . $row['blname'] . "</td>";
echo "<td>" . $row['innings1'] . "</td>";
echo "<td>" . $row['role'] . "</td>";
echo "<td>" . $pts. "</td>";
echo "</tr></tbody>";
    }
    echo "</table></div>";
	
	
} else {
    echo "0 results";
}
			
		}
		if($blt=='slow-finger-spin'){
			
			$sql="SELECT blt20.*,player.pid,type.*
			FROM type
			left JOIN player
			ON type.pid=player.pid
			right join blt20 ON player.pname=bltest.blname
			WHERE bltype='slow-finger-spin'
			 ";
$result= mysqli_query($conn,$sql);

if (mysqli_num_rows($result) > 0) {
    echo "<h1>T20 RANKINGS</h1>";
    echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
    // output data of each row
    while($row=mysqli_fetch_assoc($result)) {
		$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
        echo "<tbody><tr>";
echo "<td>" . $row['blname'] . "</td>";
echo "<td>" . $row['innings1'] . "</td>";
echo "<td>" . $row['role'] . "</td>";
echo "<td>" . $pts. "</td>";
echo "</tr></tbody>";
    }
    echo "</table></div>";
	
	
} else {
    echo "0 results";
}
		}
		if($blt=='slow-wrist-spin'){
			
			$sql="SELECT blt20.*,player.pid,type.*
			FROM type
			left JOIN player
			ON type.pid=player.pid
			right join blt20 ON player.pname=bltest.blname
			WHERE bltype='slow-wrist-spin'
			 ";
$result= mysqli_query($conn,$sql);

if (mysqli_num_rows($result) > 0) {
    echo "<h1>T20 RANKINGS</h1>";
    echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
    // output data of each row
    while($row=mysqli_fetch_assoc($result)) {
		$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
        echo "<tbody><tr>";
echo "<td>" . $row['blname'] . "</td>";
echo "<td>" . $row['innings1'] . "</td>";
echo "<td>" . $row['role'] . "</td>";
echo "<td>" . $pts. "</td>";
echo "</tr></tbody>";
    }
    echo "</table></div>";
	
	
} else {
    echo "0 results";
}
		}
		
		
			
	}}
		
	
	elseif($cp=='bm'){
								if($bmt=='-'){
									
									$sql="SELECT bmt20.*,player.pid,type.*
									FROM type
									left JOIN player
									ON type.pid=player.pid
									right join bmt20 ON player.pname=bmt20.bmname
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
								echo "<tbody><tr>";
						echo "<td>" . $row['bmname'] . "</td>";
						echo "<td>" . $row['innings'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
									
									
								}
								elseif($bmt!=='-'){
									if($bmt=='opener'){
										$sql="SELECT bmt20.*,player.pid,type.*
						FROM type
						left JOIN player
						ON type.pid=player.pid
						right join bmt20 ON player.pname=bmt20.bmname
						WHERE bmtype='opener'";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "
						  <h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
								echo "<tbody><tr>";
						echo "<td>" . $row['bmname'] . "</td>";
						echo "<td>" . $row['innings'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
									
									
								}
								if($bmt=='top-order'){
									$sql="SELECT bmt20.*,player.pid,type.*
						FROM type
						left JOIN player
						ON type.pid=player.pid
						right join bmt20 ON player.pname=bmt20.bmname
						WHERE bmtype='top-order'";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "
						  <h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
								echo "<tbody><tr>";
						echo "<td>" . $row['bmname'] . "</td>";
						echo "<td>" . $row['innings'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
									
								}
								if($bmt=='middle-order'){
									
									$sql="SELECT bmt20.*,player.pid,type.*
						FROM type
						left JOIN player
						ON type.pid=player.pid
						right join bmt20 ON player.pname=bmt20.bmname
						WHERE bmtype='middle-order'";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "
						  <h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
								echo "<tbody><tr>";
						echo "<td>" . $row['bmname'] . "</td>";
						echo "<td>" . $row['innings'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
								}
									
									
								}
		
				}
	
	
}
	
	else{
		
		if($hand=='left'){
			if($cp=='bm'){if($bmt=='opener'){$sql="SELECT bmt20.*,player.pid,type.*
							FROM type
							left JOIN player
							ON type.pid=player.pid
							right join bmt20 ON player.pname=bmt20.bmname
							WHERE handed='left'
							AND bmtype='opener'";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "
							  <h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
									echo "<tbody><tr>";
							echo "<td>" . $row['bmname'] . "</td>";
							echo "<td>" . $row['innings'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
							}
			if($bmt=='top-order'){$sql="SELECT bmt20.*,player.pid,type.*
								FROM type
								left JOIN player
								ON type.pid=player.pid
								right join bmt20 ON player.pname=bmt20.bmname
								WHERE handed='left'
								AND bmtype='top-order'";
								$result= mysqli_query($conn,$sql);

								if (mysqli_num_rows($result) > 0) {
									echo "
								  <h1>T20 RANKINGS</h1>";
									echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
									// output data of each row
									while($row=mysqli_fetch_assoc($result)) {
										$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
										echo "<tbody><tr>";
								echo "<td>" . $row['bmname'] . "</td>";
								echo "<td>" . $row['innings'] . "</td>";
								echo "<td>" . $row['role'] . "</td>";
								echo "<td>" . $pts. "</td>";
								echo "</tr></tbody>";
									}
									echo "</table></div>";
									
									
								} else {
									echo "0 results";
								}
								}
			if($bmt=='middle-order'){$sql="SELECT bmt20.*,player.pid,type.*
								FROM type
								left JOIN player
								ON type.pid=player.pid
								right join bmt20 ON player.pname=bmt20.bmname
								WHERE handed='left'
								AND bmtype='middle-order'";
								$result= mysqli_query($conn,$sql);

								if (mysqli_num_rows($result) > 0) {
									echo "
								  <h1>T20 RANKINGS</h1>";
									echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
									// output data of each row
									while($row=mysqli_fetch_assoc($result)) {
										$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
										echo "<tbody><tr>";
								echo "<td>" . $row['bmname'] . "</td>";
								echo "<td>" . $row['innings'] . "</td>";
								echo "<td>" . $row['role'] . "</td>";
								echo "<td>" . $pts. "</td>";
								echo "</tr></tbody>";
									}
									echo "</table></div>";
									
									
								} else {
									echo "0 results";
								}
							}
			if($bmt=='-'){$sql="SELECT bmt20.*,player.pid,type.*
							FROM type
							left JOIN player
							ON type.pid=player.pid
							right join bmt20 ON player.pname=bmt20.bmname
							WHERE handed='left'";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "
							  <h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
									echo "<tbody><tr>";
							echo "<td>" . $row['bmname'] . "</td>";
							echo "<td>" . $row['innings'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
						}
						
						}
			
			elseif($cp=='bl'){
				if($blt=='fast'){$sql="SELECT blt20.*,player.pid,type.*
									FROM type
									left JOIN player
									ON type.pid=player.pid
									right join blt20 ON player.pname=bltest.blname
									WHERE handed='left' AND
									WHERE bltype='fast'
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
								echo "<tbody><tr>";
						echo "<td>" . $row['blname'] . "</td>";
						echo "<td>" . $row['innings1'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
						
					}
			if($blt=='fast-medium'){$sql="SELECT blt20.*,player.pid,type.*
										FROM type
										left JOIN player
										ON type.pid=player.pid
										right join blt20 ON player.pname=bltest.blname
										WHERE handed='left' AND
										WHERE bltype='fast-medium'
										 ";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "<h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
									echo "<tbody><tr>";
							echo "<td>" . $row['blname'] . "</td>";
							echo "<td>" . $row['innings1'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
							}
			if($blt=='medium'){
									$sql="SELECT blt20.*,player.pid,type.*
								FROM type
								left JOIN player
								ON type.pid=player.pid
								right join blt20 ON player.pname=bltest.blname
								WHERE handed='left' AND
								WHERE bltype='medium'
								 ";
					$result= mysqli_query($conn,$sql);

					if (mysqli_num_rows($result) > 0) {
						echo "<h1>T20 RANKINGS</h1>";
						echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
						// output data of each row
						while($row=mysqli_fetch_assoc($result)) {
							$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
							echo "<tbody><tr>";
					echo "<td>" . $row['blname'] . "</td>";
					echo "<td>" . $row['innings1'] . "</td>";
					echo "<td>" . $row['role'] . "</td>";
					echo "<td>" . $pts. "</td>";
					echo "</tr></tbody>";
						}
						echo "</table></div>";
						
						
					} else {
						echo "0 results";
					}
			}
			if($blt=='slow-finger-spin'){$sql="SELECT blt20.*,player.pid,type.*
									FROM type
									left JOIN player
									ON type.pid=player.pid
									right join blt20 ON player.pname=bltest.blname
									WHERE handed='left' AND
									WHERE bltype='slow-finger-spin'
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
								echo "<tbody><tr>";
						echo "<td>" . $row['blname'] . "</td>";
						echo "<td>" . $row['innings1'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
						}
			if($blt=='slow-wrist-spin'){$sql="SELECT blt20.*,player.pid,type.*
										FROM type
										left JOIN player
										ON type.pid=player.pid
										right join blt20 ON player.pname=bltest.blname
										WHERE handed='left' AND
										WHERE bltype='slow-wrist-spin'
										 ";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "<h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
									echo "<tbody><tr>";
							echo "<td>" . $row['blname'] . "</td>";
							echo "<td>" . $row['innings1'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
							}
			if($blt=='-'){$sql="SELECT blt20.*,player.pid,type.*
									FROM type
									left JOIN player
									ON type.pid=player.pid
									right join blt20 ON player.pname=bltest.blname
									WHERE handed='left'
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
								echo "<tbody><tr>";
						echo "<td>" . $row['blname'] . "</td>";
						echo "<td>" . $row['innings1'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
						}
			}
			
			
			
		}
		
		elseif($hand=='right'){
								if($cp=='bm'){if($bmt=='opener'){$sql="SELECT bmt20.*,player.pid,type.*
							FROM type
							right JOIN player
							ON type.pid=player.pid
							right join bmt20 ON player.pname=bmt20.bmname
							WHERE handed='right'
							AND bmtype='opener'";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "
							  <h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
									echo "<tbody><tr>";
							echo "<td>" . $row['bmname'] . "</td>";
							echo "<td>" . $row['innings'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
							}
			if($bmt=='top-order'){$sql="SELECT bmt20.*,player.pid,type.*
								FROM type
								right JOIN player
								ON type.pid=player.pid
								right join bmt20 ON player.pname=bmt20.bmname
								WHERE handed='right'
								AND bmtype='top-order'";
								$result= mysqli_query($conn,$sql);

								if (mysqli_num_rows($result) > 0) {
									echo "
								  <h1>T20 RANKINGS</h1>";
									echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
									// output data of each row
									while($row=mysqli_fetch_assoc($result)) {
										$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
										echo "<tbody><tr>";
								echo "<td>" . $row['bmname'] . "</td>";
								echo "<td>" . $row['innings'] . "</td>";
								echo "<td>" . $row['role'] . "</td>";
								echo "<td>" . $pts. "</td>";
								echo "</tr></tbody>";
									}
									echo "</table></div>";
									
									
								} else {
									echo "0 results";
								}
								}
			if($bmt=='middle-order'){$sql="SELECT bmt20.*,player.pid,type.*
								FROM type
								right JOIN player
								ON type.pid=player.pid
								right join bmt20 ON player.pname=bmt20.bmname
								WHERE handed='right'
								AND bmtype='middle-order'";
								$result= mysqli_query($conn,$sql);

								if (mysqli_num_rows($result) > 0) {
									echo "
								  <h1>T20 RANKINGS</h1>";
									echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
									// output data of each row
									while($row=mysqli_fetch_assoc($result)) {
										$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
										echo "<tbody><tr>";
								echo "<td>" . $row['bmname'] . "</td>";
								echo "<td>" . $row['innings'] . "</td>";
								echo "<td>" . $row['role'] . "</td>";
								echo "<td>" . $pts. "</td>";
								echo "</tr></tbody>";
									}
									echo "</table></div>";
									
									
								} else {
									echo "0 results";
								}
							}
			if($bmt=='-'){$sql="SELECT bmt20.*,player.pid,type.*
							FROM type
							right JOIN player
							ON type.pid=player.pid
							right join bmt20 ON player.pname=bmt20.bmname
							WHERE handed='right'";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "
							  <h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['runs']*1.1+$row['avg']*0.8+$row['sr']*3.0+$row['50s']*1.7+$row['sixes']*2.0+$row['fours']*1.3)/$row['innings'];
									echo "<tbody><tr>";
							echo "<td>" . $row['bmname'] . "</td>";
							echo "<td>" . $row['innings'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
						}
						
						}
			
			elseif($cp=='bl'){
				if($blt=='fast'){$sql="SELECT blt20.*,player.pid,type.*
									FROM type
									right JOIN player
									ON type.pid=player.pid
									right join blt20 ON player.pname=bltest.blname
									WHERE handed='right' AND
									WHERE bltype='fast'
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
								echo "<tbody><tr>";
						echo "<td>" . $row['blname'] . "</td>";
						echo "<td>" . $row['innings1'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
						
					}
			if($blt=='fast-medium'){$sql="SELECT blt20.*,player.pid,type.*
										FROM type
										right JOIN player
										ON type.pid=player.pid
										right join blt20 ON player.pname=bltest.blname
										WHERE handed='right' AND
										WHERE bltype='fast-medium'
										 ";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "<h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
									echo "<tbody><tr>";
							echo "<td>" . $row['blname'] . "</td>";
							echo "<td>" . $row['innings1'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
							}
			if($blt=='medium'){
									$sql="SELECT blt20.*,player.pid,type.*
								FROM type
								right JOIN player
								ON type.pid=player.pid
								right join blt20 ON player.pname=bltest.blname
								WHERE handed='right' AND
								WHERE bltype='medium'
								 ";
					$result= mysqli_query($conn,$sql);

					if (mysqli_num_rows($result) > 0) {
						echo "<h1>T20 RANKINGS</h1>";
						echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
						// output data of each row
						while($row=mysqli_fetch_assoc($result)) {
							$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
							echo "<tbody><tr>";
					echo "<td>" . $row['blname'] . "</td>";
					echo "<td>" . $row['innings1'] . "</td>";
					echo "<td>" . $row['role'] . "</td>";
					echo "<td>" . $pts. "</td>";
					echo "</tr></tbody>";
						}
						echo "</table></div>";
						
						
					} else {
						echo "0 results";
					}
			}
			if($blt=='slow-finger-spin'){$sql="SELECT blt20.*,player.pid,type.*
									FROM type
									right JOIN player
									ON type.pid=player.pid
									right join blt20 ON player.pname=bltest.blname
									WHERE handed='right' AND
									WHERE bltype='slow-finger-spin'
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
								echo "<tbody><tr>";
						echo "<td>" . $row['blname'] . "</td>";
						echo "<td>" . $row['innings1'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
						}
			if($blt=='slow-wrist-spin'){$sql="SELECT blt20.*,player.pid,type.*
										FROM type
										right JOIN player
										ON type.pid=player.pid
										right join blt20 ON player.pname=bltest.blname
										WHERE handed='right' AND
										WHERE bltype='slow-wrist-spin'
										 ";
							$result= mysqli_query($conn,$sql);

							if (mysqli_num_rows($result) > 0) {
								echo "<h1>T20 RANKINGS</h1>";
								echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
								// output data of each row
								while($row=mysqli_fetch_assoc($result)) {
									$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
									echo "<tbody><tr>";
							echo "<td>" . $row['blname'] . "</td>";
							echo "<td>" . $row['innings1'] . "</td>";
							echo "<td>" . $row['role'] . "</td>";
							echo "<td>" . $pts. "</td>";
							echo "</tr></tbody>";
								}
								echo "</table></div>";
								
								
							} else {
								echo "0 results";
							}
							}
			if($blt=='-'){$sql="SELECT blt20.*,player.pid,type.*
									FROM type
									right JOIN player
									ON type.pid=player.pid
									right join blt20 ON player.pname=bltest.blname
									WHERE handed='right'
									 ";
						$result= mysqli_query($conn,$sql);

						if (mysqli_num_rows($result) > 0) {
							echo "<h1>T20 RANKINGS</h1>";
							echo "<table id='keywords' class='sortable'><thead><tr><th>Name</th><th>innings</th><th>role</th><th>pts</th></tr></thead>";
							// output data of each row
							while($row=mysqli_fetch_assoc($result)) {
								$pts=($row['wickets']*4.0+$row['avg1']*0.7+$row['sr1']*1.5+$row['econ']*3.8)/$row['innings1'];
								echo "<tbody><tr>";
						echo "<td>" . $row['blname'] . "</td>";
						echo "<td>" . $row['innings1'] . "</td>";
						echo "<td>" . $row['role'] . "</td>";
						echo "<td>" . $pts. "</td>";
						echo "</tr></tbody>";
							}
							echo "</table></div>";
							
							
						} else {
							echo "0 results";
						}
						}
			}
			
			
			
							}
	}
	?>