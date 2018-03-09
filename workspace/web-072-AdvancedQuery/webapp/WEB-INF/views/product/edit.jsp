<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="/product?cmd=saveOrUpdate" method="post">
			<input type="hidden" name="id" value="${p.uid}"/><br>
	商品名: <input type="text" name="productName" value="${p.uproductName}"/><br>
	商品类型: <select name="dir_id">
				<option value="1" ${p.udir_id == 1 ? 'selected' : ''}>鼠标</option>
				<option value="2" ${p.udir_id == 2 ? 'selected' : ''}>无线鼠标</option>
				<option value="3" ${p.udir_id == 3 ? 'selected' : ''}>有线鼠标</option>
				<option value="4" ${p.udir_id == 4 ? 'selected' : ''}>游戏鼠标</option>
			</select><br>
	销售价: <input type="text" name="salePrice" value="${p.usalePrice}"/><br>
	供应商: <input type="text" name="supplier" value="${p.usupplier}"/><br>
	品牌: <input type="text" name="brand" value="${p.ubrand}"/><br>
	折扣: <input type="text" name="cutoff" value="${p.ucutoff}"/><br>
	成本价: <input type="text" name="costPrice" value="${p.ucostPrice}"/><br>
		<input type="submit" value="提交"/>
</form>
</body>
</html>