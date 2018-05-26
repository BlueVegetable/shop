<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/form1.css">
<style type="text/css">
body {  
    margin: 0;  
    background-image: url('image/background15.jpg');    
    background-repeat:repeat;  
	background-position:0% 0%;  
	background-size:cover;  
    background-color: #22C3AA;  
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
</head>
<body>
<h1 style="color:blue;">我的订单</h1>
<h3><a href="mainShow.jsp">回到主页</a></h3>
<table border="2" style="width:70%;" align="center">
<tr>
<th>订单编号</th><th>订单条目</th><th>订单总价</th><th>操作</th>
</tr>
<c:forEach items="${sessionScope.searchResult }" var="shop">
<tr>
<td>1</td>
<td>
<table>
<tr><td></td><td></td></tr>
</table>
</td>
<td>100</td>
<td width="10%">
<a href="#">取消订单</a><br>
<a href="#">确认订单</a><br>
<a href="#">删除订单</a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>