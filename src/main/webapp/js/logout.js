$(document).ready(function(){
	$('#logoutbtn').click(function() {
		$.ajax({
			url: basePath+'/account/logout',
			type: 'GET',
			success: function(data) {
				if(data.status==ERROR_ACCOUNT_NOTLOGIN){
					//self.location = basePath + '/';
					self.location = basePath + '/welcome';
				}
			}
		});
	
	});
});