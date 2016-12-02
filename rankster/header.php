<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
  
  <script href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/core.js"></script>
  
<meta charset='UTF-8'>
        <title>RANKSTER</title>
		
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico.png" >		
		
<style>

nav
{
 margin-top:15px;
 

}

nav ul
{
	width:100%;
 float:left;
height: auto;
    list-style-type: none;
position:relative;
    margin: 0;
    padding: 0;
    background-color: #F1C40F;
}

nav ul a
{
 display:block;
 color:white;
 text-decoration:none;
 font-size:22px;
 line-height:32px;
 padding: 24px 16px;
    font-family: AR ESSENCE;
}

nav ul li
{
 position:relative;
 float:left;
 margin:0;
 padding:0
}

nav ul li.current-menu-item
{
 background:#B3B6B7;
}
nav ul li.current-menu-item1
{
 background:#F1C40F;
}

nav ul li:hover
{
 background-color: grey; 
}

nav ul a:hover{
font-size: 160%;
    font-family: AR Julian;
    color: #212F3D;}

nav ul ul
{
 display:none;
 position:absolute;
 top:100%;
 left:0;
 background:#F1C40F;
 padding:0
}

nav ul ul li
{
 float:none;
 width:200px
}

nav ul ul a
{
 line-height:32px;
 padding:10px 15px
}

nav ul ul ul
{
 top:0;
 left:100%
}

nav ul li:hover > ul
{
 display:block
}

</style>
</head>
        <body background= 'cric1.jpg'>
		
 
 <header>
<nav id="nav">
<ul>
  <li class="current-menu-item"><a href="index.php"><font size='6'>HOME</font></a></li>

 <li><a href='odi.php'><font size='6'>ODI</font></a><li>
 <li><a href='test.php'><font size='6'>TEST</font></a><li>
 <li><a href='t20.php'><font size='6'>T20</font></a><li>
   <li><a href="#"><font size='6'>MEMBER AREA</font></a>
    <ul>
      <li><a href="#"><font size='6'>ADD NEW</font></a>
	  <ul><li><a href="addnewbm.php"><font size='6'>BATSMAN</font></a></li>
	  <li><a href="addnewbl.php"><font size='6'>BOWLER</font></a></li>
	  <li><a href="addnewal.php"><font size='6'>ALL-ROUNDER</font></a></li></ul>
	  </li>

      <li><a href="#"><font size='6'>UPDATE</font></a>
	  <ul><li><a href="upbm.php"><font size='6'>BATSMAN</font></a></li>
	  <li><a href="upbl.php"><font size='6'>BOWLER</font></a></li>
	  <li><a href="upal.php"><font size='6'>ALL-ROUNDER</font></a></li></ul></li>
</ul></li>
<li><a href='signup.php'><font size='6'>SIGN UP</font></a><li>
	<?php
	if(isset($_SESSION['id'])){
		
	   echo "<li><a href='includes/logout.inc.php'><font size='6'>LOG OUT</font></a><li>";
	}
		else{
			echo "<form action='includes/login.inc.php' method='POST'>
			<fieldset>
    <legend>LOGIN:</legend>
    
		<input type='text' name='uid' placeholder='USERNAME'>
		
    
        <input type='password' name='password' placeholder='PASSWORD'>
		
        <button type='submit'>LOG IN</button>
		</fieldset>
	</form>";
		}
	
	?>
  
</ul>
</nav>
</header>