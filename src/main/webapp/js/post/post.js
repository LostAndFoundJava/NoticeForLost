$(document).ready(function(){
	$('#send').click(function() {	
  		var that = this;
		var content = $('#content').val();
		var object_type = $('textarea').attr('name');
		var checkValue=$("#post_status").val();  //获取Select选择的Value 
		alert(checkValue);
		var post_type;
		if(object_type==POST)
			post_type="0";
		
		$.ajax({
			url: basePath + '/post/uploadpost',
			type: 'POST',
			dataType: "json", 
			data: {
				content:content,
				post_type:post_type,
				post_status:checkValue
			},
			success:function(data){
				//TODO 显示“发送成功的字样，并跳转到显示页面”
				//TODO 如果失败了应该怎么显示
				//TODO 回显
				alert(data.status);
				
			}
		})
		
		
			
	});
      
	
	
	
})