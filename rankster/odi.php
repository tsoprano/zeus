<?php
include 'header.php';
?>	
<style>
    .reveal-if-active {
  opacity: 0;
  max-height: 0;
  overflow: hidden;
  font-size: 16px;
  -webkit-transform: scale(1.0);
          transform: scale(1.0);
  -webkit-transition: 0.5s;
  transition: 0.5s;
}
.reveal-if-active label {
  display: block;
  margin: 0 0 3px 0;
}
.reveal-if-active input[type=text] {
  width: 100%;
}

input[type="radio"]:checked  ~ .reveal-if-active{
	
  opacity: 1;
  max-height: 2500px;
  padding: 10px 20px;
  -webkit-transform: scale(1);
          transform: scale(1);
  overflow: visible;
}

input[type="checkbox"]:checked ~ .reveal-if-active  {
  opacity: 1;
  max-height: 25000px;
  padding: 10px 20px;
  -webkit-transform: scale(1);
          transform: scale(1);
  overflow: visible;
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
#rotate {
    display: block;
margin: 20px;
}

#rotate {
-webkit-transition-duration: 10s;
    -moz-transition-duration: 10s;
    -o-transition-duration: 10s;
    transition-duration: 1s;
    -webkit-transition-property: -webkit-transform;
    -moz-transition-property: -moz-transform;
    -o-transition-property: -o-transform;
    transition-property: transform;
}

#rotate:hover {
transform: rotate(360deg);
-webkit-transform: rotate(360deg);
-ms-transform: rotate(360deg);

}



  </style>
  
  <br><br><br>
  <center><font size='25' face='AR BONNIE' color='white'>SEE THE BEST OF ODI CRICKET IN:</font></center>
  <?php
  
  //if(isset($_SESSION['id'])){
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
<center>
<form action='includes/odi.inc.php' method='POST' id='myform'>

<section id='first' class='section1'>
     <div class='container'>
				  <input type='radio' value='bl' name='choice-player' id='choice-player-bowler' required>
				  <label for='choice-player-bowler'><span class='radio'><h4>Bowler</h4></span></label>
				
   
				<div class='reveal-if-active' data-require-pair='#choice-player-bowler'>

						 <qav>
									

								  <h3>Further down to positions?</h3>
								 <section id='first' class='section'> 	
												 
											<div class='container'>
											<input type='radio' name='bltype' id='fast1' value='fast'>
											<label for='fast1'><span class='radio'>Fast</span></label>
											</div>
															
															<div class='container'>
											  <input type='radio' name='bltype' id='fast-medium1' value='fast-medium'>
											  <label for='fast-medium1'><span class='radio'>Fast-medium</span></label>
											
															</div>
											
											
											<div class='container'>
											  <input type='radio' name='bltype' id='medium1' value='medium'>
											  <label for='medium1'><span class='radio'>Medium</span></label>
											</div>
											<div class='container'>
											  <input type='radio' name='bltype' id='slow-finger-spin1' value='slow-finger-spin'>
											  <label for='slow-finger-spin1'><span class='radio'>Slow finger spin</span></label>
											</div>
											<div class='container'>
											  <input type='radio' name='bltype' id='slow-wrist-spin1' value='slow-wrist-spin'>
											  <label for='slow-wrist-spin1'><span class='radio'>Slow wrist spin</span></label>
											</div>
								</section>
						</qav>
			 
				</div>
					  
	 </div>
					
				


      <div class='container'>
        <input type='radio' name='choice-player' value='bm' id='choice-player-batsman' required>
        <label for='choice-player-bowler'><span class='radio'><h4>Batsman</h4></span></label>

				<div class='reveal-if-active' data-require-pair='#choice-player-batsman'>

						 <qav>
						  
						 
							  <h3>Further down to positions?</h3>
								<div>
								  
											<section id='first' class='section1'>
												
												 <div class='container'>
											
													  <input type='radio' name='bmtype' id='opener1' value='opener'>
													  <label for='opener1'><span class='radio'>Opener</span></label>
												 
												  </div>
												  
													<div class='container'>
													  <input type='radio' name='bmtype' id='top-order1' value='top-order'>
													  <label for='top-order1'><span class='radio'>Top-Order</span></label>
													</div>


													<div class='container'>
													
													  <input type='radio' name='bmtype' id='middle-order1' value='middle-order'>
													  <label for='middle-order1'><span class='radio'>Middle-Order</span></label>
													 
													</div>
													</section>
												

								  
								</div>
							  
						</qav>
				  
				</div>
      </div>
	</section>
    
	
	
	<qav>
	<h3>Further down to playing hand?</h3>
	<div class='contain1'>	
			  
				
				<div class='container' class='fixed'>
				  <input type='radio' name='handed' id='left' value='left'>
				<label for='left'><span class='radio'>Left</span></label>
				</div>
				<div class='container'  class='flex-item'>
				  <input type='radio' name='handed' id='right' value='right'>
			    <label for='right'><span class='radio'>Right</span></label>
				</div>
			 
			  </div>
	
	
	</qav>
	
<button type='reset' value='Reset'>Reset</button>
</form>
</center>

<br><br>
<div id='rotate'>
<center><input type='image' src='favicon.ico.png' alt='Submit'  form='myform' width='148' height='148'>	</center>		  
</div>	
		  
			  
			  
			  
			  
			  
  ";
?>
