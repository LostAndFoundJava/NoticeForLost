$(document).ready(function(){
	$('#send').click(function() {	
  		var that = this;
		var content = $('#content').val();
		var object_type = $('textarea').attr('name');
		var post_type;
		if(object_type==POST)
			post_type="0";
		
		$.ajax({
			url: basePath + '/post/uploadpost',
			type: 'POST',
			dataType: "json", 
			data: {
				content:content,
				post_type:post_type
			},
			success:function(data){
				alert(data.status);
				
			}
		})
		
		
			
	});
      
	
	
	
})