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
<script>
function judge(){
	var goodsNumber=document.getElementById("goodsNumber").value;
	var amount=document.getElementById("amount").value;
	var pattern=/^[0-9]{1,8}$/;
	
	alert(goodsNumber);
	alert(amount);
	if(pattern.test(goodsNumber)==false)
	{
		alert("商品数量格式输入错误");
		return false;
	}
	amount=parseInt(amount);
	goodsNumber=parseInt(goodsNumber);
	
	if(goodsNumber>amount)
	{
		alert("库存不足，请重新输入");
		return false;
	}
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
</head>
<body>
<h1 style="color:blue;">搜索结果</h1>
<h3><a href="mainShow.jsp">回到主页</a></h3>
<table border="2" style="width:100%;" >
<tr>
<th>商品id</th><th>商品名</th><th>价格</th><th>商品图片</th><th>购买量</th>
<th>库存量</th><th>种类</th><th>商品详情</th><th>操作</th>
</tr>

<c:forEach items="${sessionScope.searchResult }" var="shop">
<tr>
<td>${shop.key.id}</td><td><c:out value="${shop.key.name }"></c:out></td>
<td>${shop.key.price}元</td>
<td><img src="${shop.key.picture}" width="150px" height="150px"></td>
<td>${shop.key.buyNumber}</td>
<td>${shop.key.amount}</td>
<td>${shop.key.variety}</td><td><c:out value="${shop.key.info }"></c:out></td>
<td>
<form onsubmit="return judge();">
<input type="hidden" id="amount" value="${shop.key.amount}">
<input type="hidden" name="goodsID" value="${shop.key.id}">
<input type="hidden" name="shopID" value="${shop.value.id}">
<input type="hidden" name="method" value="addGoods">
<input type="text" id="goodsNumber" name="goodsNumber" value="0">
<input type="submit" value="加入购物车">
</form>
</td>
</tr>
</c:forEach>

<c:if test="${sessionScope.searchResult.length<=0 }">
<tr><td colspan="9">无结果</td></tr>
</c:if>

</table>

</body>
</html>