<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/form1.css" type="text/css" />
<style>
a{
	font-size:12px;
	text-decoration-style: none;
	color:purple;
}
</style>
<title>登录首页</title>
</head>
<body>

<div id="background" style="position:absolute;z-index:-1;width:100%;
height:100%;top:0px;left:0px;">
<img src="image/background1.jpg" width="100%" height="100%"/>
</div>

<form method="post">
<table style="height:180px;margin-top:-100px;top:40%;border:1;
position: absolute;left:35%;width:500px;font-size:25px;border-Spacing:30px">
<tr>
<td>用户id
</td><td><input type="text" name="name" style="height:30px;width:250px" placeholder="请输入用户id"></td>
</tr>
<tr>
<td>密码</td><td><input type="password" name="password" style="height:30px;width:250px" placeholder="请输入用户密码"></td>
</tr>
<tr>
<td>
</td>
<td>
<input type="text" name="yanzhengma" style="height:30px;width:250px" placeholder="请输入验证码"></td>
</tr>
<tr>
<td colspan="2" style="height:60px">
<input type="submit" name="login" value="登录" class="button">
<input type="submit" name="register" value="注册" class="button">
<a href="#">忘记密码</a>
</td>
</tr>
</table>
</form>

</body>
</html>