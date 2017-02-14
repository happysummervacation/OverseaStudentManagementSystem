<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录(Login)</title>

        <!-- css -->
        <link rel="stylesheet" href="assets/css/reset.css">
         <link rel="stylesheet" href="assets/css/style.css">
         <link rel="stylesheet" href="assets/css/supersized.css">
         
</head>
<body>





	<div class="page-container">
	<div id="contents" class="contents">${err_msg}</div>
		<form name="LoginForm" id="login_ID" action="${pageContext.request.contextPath }/<%=response.encodeURL("login.html")%>" method="post">
			 <input type="text" id="username_ID" name="username" class="username" placeholder="请输入您的用户名">
       	 	 <input type="password" id="password_ID" name="password" class="password" placeholder="请输入您的用户密码">
        	 <button type="submit" id="btn_ID" style="width: 382px;" class="submit_button">登录</button>
		</form>
	</div>






   <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js" ></script>
        <script src="assets/js/supersized.3.2.7.min.js" ></script>
        <script src="assets/js/supersized-init.js" ></script>
        <script src="assets/js/scripts.js" ></script>
        <!-- ajax 测试 -->
        <script type="text/javascript" src="assets/js/test.js"></script>
      
</body>
</html>