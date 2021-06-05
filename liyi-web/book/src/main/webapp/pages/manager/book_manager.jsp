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
				var s =  "是否确认删除【"+name+"】?";
				return confirm(s);
			})

			//跳到指定的页码
			$("#searchPageBtn").click(function () {
				var pageNo=$("#pn_input").val();
				location.href="${pageScope.basePath}manager/bookServlet?action=page&pageNo="+pageNo;
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

		 <c:forEach items="${requestScope.page.items}" var="book" varStatus="mystatus">
				<tr>
					<td>${mystatus.count}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td colspan="2">
					                                                         <%--&method=update--%>
						<a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a>&nbsp;&nbsp;&nbsp;
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
				<td></td>                                        <%--?method=add--%>
				<td><a href="<%=basePath%>pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>

		<div id="page_nav">

			<c:if test="${requestScope.page.pageNo>1}">
				<a href="manager/bookServlet?action=page&pageNo=1">首页</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
            <%--页码输出的开始--%>
			<c:choose>
            <%--情况1：如果总页码小于等于5的时候，页码的范围是：1-总页码--%>
			<c:when test="${requestScope.page.pageTotal<=5}">

				<c:set var="begin" value="1"/>
				<c:set var="end" value="${requestScope.page.pageTotal}"/>

			</c:when>

   			<%--情况2：总页码大于5--%>
			<c:when test="${requestScope.page.pageTotal>5}">
				<%--小情况1:当前页码为前面3个：1、2、3的情况，页码范围是1-5--%>
				<c:choose>
					<c:when test="${requestScope.page.pageNo<=3}">

						<c:set var="begin" value="1"/>
						<c:set var="end" value="5"/>

					</c:when>
					<%--小情况2：当前页码为最后3个 8、9、10，页码范围是:总页码减4-总页码--%>
					<c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">

						<c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
						<c:set var="end" value="${requestScope.page.pageTotal}"/>

					</c:when>
				<%--小情况3：4、5、6、7，页码范围是：当前页码减2-当前页码加2--%>
					<c:otherwise>

						<c:set var="begin" value="${requestScope.page.pageNo-2}"/>
						<c:set var="end" value="${requestScope.page.pageNo+2}"/>


					</c:otherwise>
				</c:choose>
			</c:when>
			</c:choose>

			<c:forEach begin="${begin}" end="${end}" var="i">
				<%--判断是否是当前页码，是则不可点击--%>
				<c:if test="${i==requestScope.page.pageNo}">
					【${i}】
				</c:if>
				<c:if test="${i !=requestScope.page.pageNo}">
					<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
				</c:if>
			</c:forEach>

			 <%--当前页--%>
<%--			【${requestScope.page.pageNo}】--%>

			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>

			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
			到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
			<input type="button" id="searchPageBtn" value="确定">
		</div>

	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>