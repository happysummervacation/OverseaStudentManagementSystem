/**
 * 页面准备完成
 */ 

$(document).ready(function test(){
//	var usrflag;
//	var pwdflag;
//	
//	 if($('#username_ID').onfocus(function(){
//		 usrflag=check();
//		 }));
//	 $('#password_ID').onblur(function(){
//		 pwdflag=check();
//	 });
//	 
//	 if(('#btn_ID').onclick(function (){
//			 if(usrflag&pwdflag){
//				 putDate();
//			 }else{
//				 $('#contents').html('用户名或密码格式不正确');
//				 document.getElementById("login_ID").action = "/LoginTest/login.jsp";
//			 }
//		 }));
	
//	check();
	
});
 

$(document).ready(
		function() {

			/*  账号、密码初始状态 开始  */
			$("#tid").focus(function() {
				if ($(this).val() == '请输入您的用户名')
					$(this).val("");
				$(this).css("color", "#333333");
			}).blur(function() {
				if ($(this).val() == '') {
					$(this).val("请输入您的用户名");
					$(this).attr("style", "");
				}
			});
			$("#pwd").focus(function() {
				if ($(this).val() == '请输入您的用户密码') {
					$(this).val("");
					$(this).attr("type", "password");
				}
				$(this).css("color", "#333333");
			}).blur(function() {
				if ($(this).val() == '') {
					$(this).val("请输入您的用户密码");
					$(this).attr("style", "");
					$(this).attr("type", "text");
				}
			});
		})

/**
 * 检查用户名和密码
 * @returns
 */
function check(){
	
	var username=$('#username_ID').val();
	if(username=="请输入您的用户名"||username==" "){
		$('#contents').html('<h3 style="color:red">用户名不能为空</h3>');
		//document.getElementById("username_ID").focus()
		return false;
	}

	var password=$('#password_ID').val();
	if(password="请输入您的用户密码"||password==" "){
		$('#contents').html('<h3 style="color:red">密码格式不正确</h3>');
		//document.getElementById("password_ID").focus()
		return false;
	}

	
}
 
/** 
 *提交登录表单的数据
 */
 function putData(){
	 $.ajax({
			type:"POST",
			url:"index.jsp",
			data:$('#login_ID').serialize(),
			success:function(){
				alert("OK");
			},
			error:function(){
				alert("ERROR");
			}
		});
 }