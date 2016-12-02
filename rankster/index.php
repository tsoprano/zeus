<?php
include 'header.php';
?>	
	<?php
	if(isset($_SESSION['id'])){
		echo "<br><br><br><center><font size='25' face='AR BONNIE' color='white'>WELCOME TO RANKSTER: NO.1 CRICKET RANKING PORTAL</font></center>
		<br><br><br><br>
			
			<style>
				bav input[type=text] {
					margin: 45px 440px;
				width: 250px;
				box-sizing: border-box;
				border: 2px solid #ccc;
				border-radius: 4px;
				font-size: 16px;
				background-color: white;
				background-image: C:\xampp\htdocs\project\search.png;
				background-position: 10px 10px; 
				background-repeat: no-repeat;
				padding: 12px 20px 12px 40px;
				-webkit-transition: width 0.4s ease-in-out;
				transition: width 0.4s ease-in-out;
			}

			bav input[type=text]:focus {
				width: 50%;
			}
			bav input[type=submit] {
				width: 10%;
				background-color: #4CAF50;
				color: white;
				padding: 5px 5px;
				margin: 02px 500px ;
				border: none;
				border-radius: 35px;
				cursor: pointer;
			}
			</style>
				
		";
		echo $_SESSION['id'];
	}
		else{
		
			echo "<br><br><br><br><br><br><br><br><center><font size='25' face='AR BONNIE' color='white'>WELCOME TO RANKSTER: NO.1 CRICKET RANKING PORTAL</font></center>";
			Echo "<br><br><br><center><font size='15' face='KabobBlack' color='white'>LOGIN FIRST!</font></center><br><br><br><br>
			
			<style>
				bav input[type=text] {
					margin: 45px 440px;
				width: 250px;
				box-sizing: border-box;
				border: 2px solid #ccc;
				border-radius: 4px;
				font-size: 16px;
				background-color: white;
				background-image: C:\xampp\htdocs\project\search.png;
				background-position: 10px 10px; 
				background-repeat: no-repeat;
				padding: 12px 20px 12px 40px;
				-webkit-transition: width 0.4s ease-in-out;
				transition: width 0.4s ease-in-out;
			}

			bav input[type=text]:focus {
				width: 50%;
			}
						bav input[type=submit] {
				width: 10%;
				background-color: #4CAF50;
				color: white;
				padding: 5px 5px;
				margin: 0px 500px ;
				border: none;
				border-radius: 35px;
				cursor: pointer;
			}
			</style>
				
							
			
			
			
			
			
			
			
			
			
			
			
			
			
			";
			
			//echo '<br><center><font size='3' color='green'></font></center>';
		}
	?>
	
	
	  
    </body>
</html>