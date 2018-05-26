<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/form1.css" type="text/css" />
<style type="text/css">
body {  
    margin: 0;  
    background-image: url('image/background4.jpg');    
    background-repeat:repeat;  
	background-position:0% 0%;  
	background-size:cover;  
    background-color: #22C3AA;  
}
</style>
<title>修改信息</title>
</head>
<body>

<form method="post">
<table style="height:180px;top:15%;
position: absolute;left:35%;width:600px;font-size:25px;border-Spacing:30px">
<tr><td colspan="2"><h2 style="color:blue">您的id:1000000001</h2></td></tr>
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
<td><input type="text" name="mail"style="height:30px;width:250px" placeholder="请输入邮箱"></td>
</tr>
<tr style="text-align:center">
<td class="td">手机号码</td>
<td><input type="text" name="phoneNumber" style="height:30px;width:250px" placeholder="请输入手机号码"></td>
</tr>
<tr class="td">
<td colspan="2" style="height:60px">
<input type="submit" name="registing" value="提交" style="height:50px;width:100px;font-size:18px;" class="button">
</td>
</tr>

</table>

</form>
</body>
</html>