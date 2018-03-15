<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function goPage(pageNum){
			var form = document.getElementById("f1");
			form.currentPage.value = pageNum;
			form.submit();
		}
	</script>
</head>
<body>
<form action="/product" method="post" id="f1">
	<table align="center" border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr align="center">
			<td colspan="5">
				<a href="/product?cmd=edit">增加</a>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				关键字:<input type="text" name="keyWord" value="${qo.keyWord}"/>
				价格:<input type="number" name="minPrice" valus="${qo.minPrice}"/> - 
					<input type="number" name="maxPrice" valus="${qo.maxPrice}"/>
					<input type="button" value="查询" onclick="goPage(1)"/>
			</td>
		</tr>
		<tr align="center">
			<th>编号</th>
			<th>手机型号</th>
			<th>价格</th>
			<th>xxx</th>
			<th>操作</th>
		</tr>
	<c:forEach items="${result.data}" var="p" varStatus="vs">
		<tr align="center" style="background-color: ${vs.count % 2 == 0 ? '' : 'red'}">
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.price}</td>
			<td>${p.info}</td>
			<td>
				<a href="/product?cmd=edit&id=${p.id}">编辑</a>
				<a href="/product?cmd=delete&id=${p.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5"> 
				<c:choose>
					<c:when test="${result.currentPage != 1}">
						<a href="javascript:goPage(1)">首页</a>
						<a href="javascript:goPage(${result.prevPage})">上一页</a>
					</c:when>
					<c:otherwise>首页 上一页</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${result.currentPage < result.endPage}">
						<a href="javascript:goPage(${result.nextPage})">下一页</a>
						<a href="javascript:goPage(${result.endPage})">尾页</a>
					</c:when>
					<c:otherwise>下一页 尾页</c:otherwise>
				</c:choose>
			当前${result.currentPage}/${result.endPage} 
			共${result.pageCount}条
			每页<select name="pageSize" onchange="goPage(1)"">
					<option ${result.pageSize == 3 ? 'selected' : ''}>3</option>
					<option ${result.pageSize == 6 ? 'selected' : ''}>6</option>				
					<option ${result.pageSize == 9 ? 'selected' : ''}>9</option>			
			</select>条
			跳转<input type="text" name="currentPage" value="${result.currentPage}"/>页
			<input type="submit" value="GO" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>