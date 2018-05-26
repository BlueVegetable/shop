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
<title>收到的订单</title>
</head>
<body>
<h1 style="color:blue;">收到的订单</h1>
<h3><a href="mainShow.jsp">回到主页</a></h3>
<table border="2" style="width:100%;" >
<tr>
<th>订单id</th><th>订单内容</th><th>订单合计</th><th>买家id</th><th>买家名称</th><th>买家地址</th>
<th>操作</th>
</tr>
<c:forEach items="${sessionScope.searchResult }" var="shop">
<tr>
<td>1</td>

<td>
<table>
<tr><td>蛋炒饭</td><td>商品数量</td></tr>
</table>
</td>

<td>750</td>
<td>1000000001</td><td>蔡荣镔</td><td>广东工业大学</td>
<td><input type="submit" name="" value="确认订单" class="button">
<input type="submit" name="" value="修改订单" class="button"></td>
</tr>
</c:forEach>

</table>

</body>
</html>