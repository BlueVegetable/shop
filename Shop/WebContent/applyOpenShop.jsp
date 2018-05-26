<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户开店</title>
<style type="text/css">
body {  
    margin: 0;  
    background-image: url('image/background12.jpg');    
    background-repeat:repeat;  
	background-position:0% 0%;  
	background-size:cover;  
    background-color: #22C3AA;  
}
</style>
</head>
<body>

<table style="height:180px;margin-top:-100px;top:50%;
position: absolute;left:50%;margin-left:-250px;width:450px;font-size:20px;border-Spacing:10px">
<tr style="font-size:20px">
<td>请输入店名</td>
<td class="td"><input type="text" name="id" style="height:30px;width:250px"></td>
</tr>
<tr>
<td>请输入验证码</td>
<td class="td"><input type="text" name="verifyNumber" style="height:30px;width:250px"></td>
</tr>
<tr style="text-align:center">
<td colspan="2"><input type="submit" name="getVerifyNumber" value="获取验证码" 
style="font-size:15px;width:140px" class="button">
<input type="submit" name="confirm" value="确认验证码" style="font-size:15px;width:120px" class="button" >
</td>
</tr>
<tr>
<td colspan="2">${sessionScope.msg}</td>
</tr>
</table>
</body>

</html>