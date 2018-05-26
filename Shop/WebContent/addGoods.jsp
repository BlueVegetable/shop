<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link rel="stylesheet" href="css/form1.css" type="text/css" />
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
</head>

<body>

<form method="post">
<table style="height:600px;width:600px;top:50%;left:50%;margin-top:-310px;
margin-left:-300px;position: absolute;font-size:25px;border-Spacing:30px">
<tr>
<td colspan="2"><h3>商品信息填写</h3></td>
</tr>
<tr>
<td class="td">商品名</td>
<td><input type="text" name="goodsName"
style="height:30px;width:250px" placeholder="请输入商品名"></td>
</tr>
<tr>
<td class="td">商品价格</td><td><input type="text" name="goodsPrice"
style="height:30px;width:250px" placeholder="请输入商品价格"></td>
</tr>
<tr>
<td>商品信息</td><td><input type="text" name="goodsInfo"
style="height:30px;width:250px" placeholder="请输入商品信息"></td>
</tr>
<tr>
<td>商品种类</td>
<td><input type="text" name="goodsVariety"
style="height:30px;width:250px" placeholder="请决定商品呢种类"></td>
</td>
</tr>
<tr style="text-align:center">
<td class="td">商品数量</td>
<td>
<input type="text" name="goodsAmount"style="height:30px;width:250px" placeholder="请输入商品的数量"></td>
</tr>
<tr style="text-align:center">
<td class="td">商品图片</td>
<td><input type="file" name="goodsPicture"></td>
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