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
		<input type="hidden" name="id" value="${p.id}"/>
	手机型号: <input type="text" name="name" value="${p.name }"/><br>
	价格: <input type="text" name="price" value="${p.price }"/><br>
	xx: <input type="text" name="info" value="${p.info }"/><br>
		<input type="submit" value="保存"/>
</form>
</body>
</html>