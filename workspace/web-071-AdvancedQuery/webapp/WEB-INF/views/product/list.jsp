<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table align="center" border="1" width="88%" cellpadding="0" cellspacing="0">
	<tr align="center">
		<td colspan="9">
			<a href="/product?cmd=edit">添加商品</a>
		</td>
	</tr>
	<tr>
		<td colspan="9">
			商品名<input type="text" name="productName" value="${qo.productName}"/>
			售价<input type="text" name="minSalePrice" value="${qo.minSalePrice}"/> - 
				<input type="text" name="maxSalePrice" value="${qo.maxSalePrice}"/>
			品牌<input type="text" name="brand" value="${qo.brand}"/>
			商品分类<select name="dir_id">
						<option value="">--请选择--</option>
						<option value="1" ${qo.dir_id == 1 ? 'selected' : ''}>--鼠标--</option>
						<option value="2" ${qo.dir_id == 2 ? 'selected' : ''}>--无线鼠标--</option>
						<option value="3" ${qo.dir_id == 3 ? 'selected' : ''}>--有线鼠标--</option>
						<option value="4" ${qo.dir_id == 4 ? 'selected' : ''}>--游戏鼠标--</option>
				   </select>
			<input type="button" value="查询" onclick="goPage(1)"/>
		</td>
	</tr>
	<tr align="center">
		<th>编号</th>
		<th>商品名</th>
		<th>商品类型</th>
		<th>销售价</th>
		<th>供应商</th>
		<th>品牌</th>
		<th>折扣</th>
		<th>成本价</th>
		<th>操作</th>
	</tr>
	
<C:forEach items="${result.list}" var="p" varStatus="ps">
	<tr align="center" style="background-color: ${ps.count % 2 == 0 ? '' : 'yellow'}">
		<td>${p.uid}</td>
		<td>${p.uproductName}</td>
		<td>
			<C:choose>
				<C:when test="${p.udir_id == 1}">鼠标</C:when>
				<C:when test="${p.udir_id == 2}">无线鼠标</C:when>
				<C:when test="${p.udir_id == 3}">有线鼠标</C:when>
				<C:when test="${p.udir_id == 4}">游戏鼠标</C:when>
			</C:choose>
		</td>
		<td>${p.usalePrice}</td>
		<td>${p.usupplier}</td>
		<td>${p.ubrand}</td>
		<td>${p.ucutoff}</td>
		<td>${p.ucostPrice}</td>
		<td>
			<a href="/product?cmd=edit&id=${p.uid}">编辑</a>
			<a href="/product?cmd=delete&id=${p.uid}">删除</a>
		</td>
	</tr>
</C:forEach>
	<tr>
		<td colspan="9">
			<C:choose>
				<C:when test="${result.currentPage != 1}">
					<a href="javascript:goPage(1)">首页</a>
					<a href="javascript:goPage(${result.prevPage})">上一页</a>
				</C:when>
				<C:otherwise>首页  上一页</C:otherwise>
			</C:choose>
			<C:choose>
				<C:when test="${result.currentPage != result.endPage}">
					<a href="javascript:goPage(${result.nextPage})">下一页</a>
					<a href="javascript:goPage(${result.endPage})">尾页</a>
				</C:when>
				<C:otherwise>下一页  尾页</C:otherwise>
			</C:choose>
			当前${result.currentPage}/${result.endPage} 
			共${result.totalCount}条
			每页<select name="pageSize" onchange="goPage(1)">
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