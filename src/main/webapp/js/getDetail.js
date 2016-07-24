$(document).ready(function(){
	
		var postId = $('#postId').val();
		$.ajax({
			url: basePath + '/post/getPostDetail/'+postId,
			type: 'get',
			dataType: "json", 
			data: {
				
			},
			success:function(data){
				alert(JSON.stringify(data));
				
			}
		})
})