<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			//给删除的a标签绑定单击事件,用于删除的确认操作
			$("a.deleteClass").click(function (){
				var name  = $(this).parent().parent().children('td')[1].innerText;
				var name1 = $(this).parent().parent().children('td.myname').text();

				var s =  "是否确认删除【"+name+"】?";
				console.log("liyi =  "+s1);

				return false;
				return confirm(s);
			})
		})
	</script>
</head>
<body>


	<div id="header">
			<img class="logo_img" alt="" src="<%=basePath%>static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>序号</td>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

		 <c:forEach items="${books}" var="book" varStatus="mystatus">
				<tr>
					<td>${mystatus.count}</td>
					<td class="myname">${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td colspan="2">
						<a href="book_edit.jsp">修改</a>&nbsp;&nbsp;&nbsp;
						<a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a>
					</td>
				</tr>
			</c:forEach>


			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>