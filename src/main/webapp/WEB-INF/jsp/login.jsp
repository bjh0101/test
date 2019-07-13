<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登录页</title>

	<link href="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/res/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/res/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/res/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/res/css/login.css" rel="stylesheet"/>
	<script src="${pageContext.request.contextPath}/res/plugins/jquery.1.12.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/plugins/waves-0.7.5/waves.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/plugins/checkbix/js/checkbix.min.js"></script>

	<script src="${pageContext.request.contextPath}/res/js/login.js"></script>
	<script>

		Checkbix.init();
		$(function() {
			// 点击登录按钮
			$('#login').click(function() {
				login();
			});
			// 回车事件
			$('#username, #password').keypress(function (event) {
				if (13 == event.keyCode) {
					login();
				}
			});
		});
		// 登录
		function login() {
			$.ajax({
				url:  'login',
				type: 'POST',
				data: {
					username: $('#username').val(),
					password: $('#password').val(),
					rememberMe: $('#rememberMe').is(':checked'),

				},
				beforeSend: function() {

				},
				success: function(json){
					if (json == "1") {
						location.href = 'index';
					} else {
						alert(json.data);
						if (10101 == json.code) {
							$('#username').focus();
						}
						if (10102 == json.code) {
							$('#password').focus();
						}
					}
				},
				error: function(error){
					console.log(error);
				}
			});
		}
	</script>

</head>
<body>
<div id="login-window">
	<div class="input-group m-b-20">
		<span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
		<div class="fg-line">
			<input id="username" type="text" class="form-control" name="username" placeholder="帐号" required autofocus value="111">
		</div>
	</div>
	<div class="input-group m-b-20">
		<span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
		<div class="fg-line">
			<input id="password" type="password" class="form-control" name="password" placeholder="密码" required value="111">
		</div>
	</div>
	<div class="clearfix">
	</div>
	<div class="checkbox">
		<input id="rememberMe" type="checkbox" class="checkbix" data-text="自动登录" name="rememberMe">
	</div>
	<a id="login" href="javascript:;" class="waves-effect waves-button waves-float"><i class="zmdi zmdi-arrow-forward"></i></a>
</div>

<script type="text/javascript">
	Checkbix.init();
</script>
</body>
</html>