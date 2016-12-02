 <?php
include 'header.php';
?>

  <style>
  .reveal-if-active {
 
  opacity: 0;
  transform: scale(0.9);
  max-height: 100px;
  
  transition: 0.5s;
   position:absolute;
  top: 750px;
  left: 650px;
 
}
.reveal-if-active2 {
 
  opacity: 0;
  transform: scale(0.9);
  max-height: 100px;
  
  transition: 0.5s;
   position:absolute;
  top: 850px;
  left: 650px;
 
}
  .reveal-if-active1 {
 
  opacity: 0;
  transform: scale(0.9);
  max-height: 100px;
  
  transition: 0.5s;
   position:absolute;
  top: 650px;
  left: 650px;
 
}
input#test:checked ~ div#test,

input#t20:checked ~ div#t20,

input#odi:checked ~ div#odi {
  color: #f00;
  font-style: normal;
  transform: scale(1);
  opacity: 1;
  max-height: 1500px;
}

  form {
  max-width: 500px;
  margin: 20px auto;
}
form > div {
  margin: 0 0 20px 0;
}
form > div label {
  font-weight: bold;
}
form > div > div {
  padding: 5px;
}
form > h4 {
  color:#82E0AA;
  font-size: 24px;
  margin: 0 0 10px 0;
  border-bottom: 2px solid green;
}
h4 {
  color: white;
  font-size: 24px;
  margin: 0 0 10px 0;
  border-bottom: 2px solid green;
}

body {
  font-size: 20px;
}

* {
  box-sizing: border-box;
}

body {
  margin: 0;
  padding: 0;
  font-family: Arial;
  color: #fff;
  font-size: 1.3em;
  font-weight: bold;
  
}
qav input[type=text], select {
    border: none;
    border-bottom: 2px solid red;
    width: 50%;
    padding: 12px 20px;
    margin: 6px 0px;
    display: inline-block;
   
    box-sizing: border-box;
}
qav input[type=float], select {
    border: none;
    border-bottom: 2px solid red;
    width: 50%;
    padding: 12px 20px;
    margin: 6px 0px;
    display: inline-block;
   
    box-sizing: border-box;
}

qav input[type=integer], select {
    border: none;
    border-bottom: 2px solid red;
    width: 50%;
    padding: 12px 20px;
    margin: 6px 0;
    display: inline-block;
   
    box-sizing: border-box;
}
qav input[type=date], select {
    border: none;
    border-bottom: 2px solid red;
    width: 50%;
    padding: 12px 20px;
    margin: 6px 0;
    display: inline-block;
   
    box-sizing: border-box;
}


qav input[type=submit] {
    width: 50%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 35px;
    cursor: pointer;
}

qav input[type=submit]:hover {

    background-color: #45a049;
}
qav input[type=text]:focus {
    background-color: #FADBD8;
}
qav input[type=integer]:focus {
    background-color: #FADBD8;
}
qav input[type=float]:focus {
    background-color: #FADBD8;
}
qav input[type=date]:focus {
    background-color: #FADBD8;
}
qav div {
    border-radius: 5px;
   
    padding: 20px;
}
 .section {
  
  padding-left: 150px;
}

 .section input[type='radio']
{
  display: none;
}
.section1 input[type='radio']
{
  display: none;
}
 .container label {
	 
  position: relative;
}

/* Base styles for spans */
 .container span::before,
 .container span::after {
  content: '';
  position: absolute;
  top: 0;
  bottom: 0;
  margin: auto;
}

/* Radio buttons */
.container span.radio:hover {
  cursor: pointer;
}
.container span.radio::before {
  left: -52px;
  width: 45px;
  height: 25px;
  background-color: lightgreen;
  border-radius: 50px;
}
.container span.radio::after {
  left: -49px;
  width: 17px;
  height: 17px;
  border-radius: 10px;
  background-color: red;
  transition: left .25s, background-color .25s;
}
input[type='radio']:checked + label span.radio::after {
	
  left: -27px;
  background-color:green;
}

.contain{

    display:flex;
}
.fixed{
    background-color:#4F628E;
    width: 200px;
}
.flex-item{
    background-color:#7887AB;
    flex-grow: 1;
}

  </style>
  

  <br><br><br>
  
  <?php
	$url = 'http://'.$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
if(strpos($url,'error=empty')!==false){
		echo 'FILL OUT ALL FIELDS!';
	}
	
	if(strpos($url,'report=success')!==false){
		echo 'PLAYER SUCCESSFULLY ADDED!';
	}
	
	
	if(strpos($url,'error=same')!==false){
		echo 'PLAYER ALREADY EXISTS!';
	}
	if(strpos($url,'error=albm')!==false){
		echo 'PLAYER IS ALREADY A BOWLER. PLAYER IS EITHER A BOWLER, OR A BATSMAN, OR AN ALLROUNDER!';
	}
	if(isset($_SESSION['id'])){
		echo"
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script type= 'text/javascript' >
var FormStuff = {
  
  init: function() {
    this.applyConditionalRequired();
    this.bindUIActions();
  },
  
  bindUIActions: function() {
    $('input[type='radio'], input[type='checkbox']').on('change', this.applyConditionalRequired);
  },
  
  applyConditionalRequired: function() {
   
    $('.require-if-active').each(function() {
      var el = $(this);
      if ($(el.data('require-pair')).is(':checked')) {
        el.prop('required', true);
      } else {
        el.prop('required', false);
      }
    });
    
  }
  
};

FormStuff.init();

</script>
	<form action='includes/addnewbm.inc.php' method='POST'>

  <h4>Who is your batsman?</h4>
  <div>
  
		<qav>
			  Batsman Name
			  <input type='text' name='bmname' placeholder='Don Bradman'><br> Date of Birth
			  <input type='date' name='dob' placeholder='yyyy-mm-dd'><br> Country
			  <input type='text' name='tname' placeholder='Australia'><br> Handed
			  <div class='contain'>	
			  <section id='first' class='section'>
				
				<div class='container' class='fixed'>
				  <input type='radio' name='handed' id='left' value='left'>
				<label for='left'><span class='radio'>Left</span></label>
				</div>
				<div class='container'  class='flex-item'>
				  <input type='radio' name='handed' id='right' value='right'>
			    <label for='right'><span class='radio'>Right</span></label>
				</div>
			  </section>
			  </div>
		  </qav>
    </div>
	<h4>Game format?</h4>
											<qav>
														<div class='container'>
															<input type='radio' name='format' id='odi' value='odi'>
															<label for='odi'><span class='radio'>ODI</span></label>
															<div class='container reveal-if-active' id='odi' ><input type='integer' name='100s' placeholder='100s'><br></div>
														&ensp;&ensp;&ensp;&ensp;&ensp;
														  <input type='radio' name='format' id='test' value='test'>
														  <label for='test'><span class='radio'>TEST</span></label>
														  <div class='container reveal-if-active2' id='test' ><input type='integer' name='100s' placeholder='100s'><br></div>
														&ensp;&ensp;&ensp;&ensp;&ensp;
														  <input type='radio' name='format' id='t20' value='t20'>
														  <label for='t20'><span class='radio'>T20</span></label>
														  <div class='container reveal-if-active1' id='t20' ><input type='integer' name='fours' placeholder='FOURS'>&ensp;
														  <input type='integer' name='sixes' placeholder='SIXES'><br></div>
		</div>
		</qav>
	<h4>Batting Details</h4>	
	<qav>													
	<input type='integer' name='innings' placeholder='INNINGS'><br>
           <input type='integer' name='runs' placeholder='RUNS'><br>
            <input type='float' name='avg' placeholder='AVERAGE'><br>
             <input type='float' name='sr' placeholder='STRIKE-RATE'><br>
			 <input type='integer' name='50s' placeholder='50s'><br>
			 
			  Batsman Type:
			  <section id='first' class='section'>
    <div class='container'>
      <input type='radio' name='bmtype' id='opener' value='opener'>
      <label for='opener'><span class='radio'>Opener</span></label>
    </div>
	<div class='container'>
      <input type='radio' name='bmtype' id='top-order' value='top-order'>
      <label for='top-order'><span class='radio'>Top-order</span></label>
    </div>
    <div class='container'>
      <input type='radio' name='bmtype' id='middle-order' value='middle-order'>
      <label for='middle-order'><span class='radio'>Middle-order</span></label>
    </div>
</section>
			 </qav> 
			  <qav>
Date of entry
			<input type='date' name='doe' placeholder='yyyy-mm-dd'><br>
    <div>
      <input type='submit' value='Submit'>
    </div>
</qav>
    </form>";
	

	
	}
		else{
			echo 'You are not logged in yet';
		}
	?>