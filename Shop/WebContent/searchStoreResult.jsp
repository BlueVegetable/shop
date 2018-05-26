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
<title>搜索结果</title>
</head>
<body>
<h1 style="color:blue;">搜索结果</h1>
<h3><a href="mainShow.jsp">回到主页</a></h3>
<table border="2" style="width:100%;" >
<tr>
<th>商店id</th><th>商店名</th><th>商家名</th><th>操作</th>
</tr>

<c:forEach items="${sessionScope.searchResult }" var="shop">
<tr>
<td>1</td><td>都是饭的餐厅</td><td>蜡笔小新</td>
<td><input type="submit" name="" value="进入商店" class="button"></td>
</tr>
</c:forEach>

<c:if test="${sessionScope.searchResult.length<=0 }">
<tr><td colspan="9">无结果</td></tr>
</c:if>

</table>

</body>
</html>