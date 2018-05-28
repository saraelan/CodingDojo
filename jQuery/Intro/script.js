$(document).ready(function()
{	
	$('h3').click(function()
	
	{
		alert('hello');
	})

	$( '.gets' ).click(function() 
	{
 		$( '#take' ).slideToggle( "slow" );
			
	})

	$( '.para' ).click(function() 
	{
		var myText=$('#my').text();
		alert(myText);
	})

});