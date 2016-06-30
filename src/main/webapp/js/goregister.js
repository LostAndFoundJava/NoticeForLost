$(document).ready(function(){
	$('#goregisterbtn').live('click', function() {
/*		$.ajax({
			url: basePath+'/account/register',
			type: 'GET',
		})*/
		alert("xxx");
		location.href = basePath+'/account/register';
	});
	
})