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
<title>购物车</title>
</head>
<body>
<h1 style="color:blue;">我的购物车</h1>
<h3><a href="mainShow.jsp">回到主页</a></h3>
<table border="2" style="width:100%;" >
<tr>
<th>商品id</th><th>商品名</th><th>商品数目</th><th>商品单价</th><th>商品小计</th><th>操作</th>
</tr>
<c:forEach items="${sessionScope.searchResult }" var="shop">
<tr>
<td>1</td><td>蛋炒饭</td><td>100</td><td>7.5元</td><td>750</td>
<td><input type="submit" name="" value="删除商品" class="button"></td>
</tr>
</c:forEach>
<tr>
<td colspan="4">
地址:
<input type="text" name="address" placeholder="请输入地址" value="广东工业大学中环西路" style="width:80%;height:30px;font-size:18px;">
<input type="submit" name="" value="提交" class="button">
</td>
<td colspan="2">总计:750元</td>
</tr>
</table>

</body>
</html>