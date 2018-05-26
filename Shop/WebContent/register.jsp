<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="css/form1.css" type="text/css" />
</head>

<body>

<div id="background" style="position:absolute;z-index:-1;width:100%;
height:100%;top:0px;left:0px;">
<img src="image/background2.jpg" width="100%" height="100%"/>
</div>


<form method="post">
<table style="height:180px;top:15%;
position: absolute;left:35%;width:600px;font-size:25px;border-Spacing:30px">
<tr>
<td class="td">用户id</td><td><input type="text" name="id"
style="height:30px;width:250px" placeholder="请输入用户id"></td>
</tr>
<tr>
<td class="td">用户名</td>
<td><input type="text" name="name"
style="height:30px;width:250px" placeholder="请输入用户名"></td>
</tr>
<tr>
<td class="td">密码</td><td><input type="password" name="password"
style="height:30px;width:250px" placeholder="请输入密码"></td>
</tr>
<tr>
<td>确认密码</td><td><input type="password" name="isPassword"
style="height:30px;width:250px" placeholder="请再次确认密码"></td>
</tr>
<tr>
<td>性别</td>
<td>
<input type="radio" class="raido1" name="gender" value="boy" style="width:20px;height:20px" checked/>欧莱雅男士
<input type="radio" class="raido1" name="gender" value="girl" style="width:20px;height:20px" />神秘美少女
</td>
</tr>
<tr style="text-align:center">
<td class="td">邮箱</td>
<td><input type="text" name="email"style="height:30px;width:250px" placeholder="请输入邮箱"></td>
</tr>
<tr style="text-align:center">
<td class="td">手机号码</td>
<td><input type="text" name="phoneNumber" style="height:30px;width:250px" placeholder="请输入手机号码"></td>
</tr>
<tr class="td">
<td colspan="2" style="height:60px">
<input type="submit" name="registing" value="提交" class="button">
</td>
</tr>

</table>
</form>


</body>
</html>