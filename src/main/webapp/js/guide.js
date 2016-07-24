$(document).ready(function(){
	$('#ok').live('click', function(){
		$(this).addClass('loading');
		$.ajax({
			url: basePath + '/flow/ok',
			type: 'GET',
			dataType: 'json'
		})
		.success(function(data){
			self.location = basePath;
		});
	});


})