$(document).ready(function(){
	$('#registerBtn').click( function() {
		var that = this;
		$(this).addClass('loading');
		//clear tips
		$('div.error').removeClass('error');
		$('span.tip').text('');

		var username = $.trim($('#ausername').val());
		var email = $.trim($('#aemail').val());
		var password = $('#apassword').val();
		var cfmPwd = $('#acfmPwd').val();
		var user={"userName":username, "userEmail":email, "userPwd":password, "confirmPwd":cfmPwd, };
		$.ajax({
			url: basePath+'/account/register',
			type: 'POST',
			dataType: 'json',
			contentType: "application/json",
			data: JSON.stringify(user),
			
			success: function(data) {
				alert(data.status)
				$(that).removeClass('loading');
				if(data.status == SUCCESS_ACCOUNT_REG) {
					alert("陈宫了");
					self.location = basePath + '/account/activation/mail/send?email='+email;
				} else { //error
					var status = data.status;
					switch(status.charAt(2)) {
						case '0':  //username error
							if(status == '000003') { //user name exist
								username = '';
								$('#usernameTip').text('用户名已存在');
							} else if(status == '000004') { //user name empty
								alert("没有用户名");
								$('#usernameTip').text('请输入用户名');
							}
							$('#ausername').parent('div.field:first').addClass('error');
							break;

						case '1':  //email error
							if(status == '001000') {
								$('#emailTip').text('邮箱已注册 <a href="#">登录</a>');
							} else if(status == '001001') {
								$('#emailTip').text('请输入邮箱地址');
							} else if(status == '001002') {
								$('#emailTip').text('请输入正确的邮箱地址');
							} 
							$('#aemail').parent('div.field:first').addClass('error');
							break;

						case '2':  //password error
							if(status == '002000') {  //password empty
								$('#passwordTip').text('请输入密码');
							}
							$('#apassword').parent('div.field:first').addClass('error');
							break;

						case '3':  //confirm password error
							if(status == '003000') {  
								$('#cfmPwdTip').text('请再次输入密码');
								$('#cfmPwdTip').parent('div.field:first').addClass('error');
							} else if(status == '003001') {
								$('#passwordTip').text('密码输入不一致');
								$('#apassword').parent('div.field:first').addClass('error');
								$('#acfmPwd').parent('div.field:first').addClass('error');
							}
							break;
						case '4': //注册成功，等待激活
							if(status == '004003') {
								var activationUrl = basePath + '/account/activation/mail/send?email='+email;
								$('#emailTip').html('<a href="'+activationUrl+'">已注册,请激活</a>');
							}
							$('#aemail').parent('div.field:first').addClass('error');
							break;
						default:
							break;
					}
				} 

			}
		})
		
	});
})