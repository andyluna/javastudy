<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>用户管理</title>
	<script src="${path}/pages/manager/js/jquery-2.1.1.min.js"></script>
</head>
<body>
<h1>
	<c:choose>
		<c:when test="${requestScope.menu==null}">新增菜单</c:when>
		<c:otherwise>修改菜单 <span style="color: red">${requestScope.menu.id}</span></c:otherwise>
	</c:choose>
</h1>
<input type="hidden" id="mypath" value="${path}">

<form method="post" action="${path}/manager/menuServlet">
	<input type="hidden" name="action" value="updateMenu" />
	<input type="hidden" name="curPage"  value="${curPage}" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<table style="width: 30%;margin: 0 auto" border="1">
		<tr>
			<td>ID</td>
			<td>
				<input id="myid" name="id" type="text" value="${requestScope.menu.id}" style="width: 400px;height: 40px;" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>菜单名称</td>
			<td>
				<input id="name" name="name" type="text" value="${requestScope.menu.name}" style="width: 400px;height: 40px;">
				<span id="nameTip"></span>
			</td>
		</tr>
		<tr>
			<td>访问路径</td>
			<td><input id="url" name="url" type="text" value="${requestScope.menu.url}" style="width: 400px;height: 40px;"></td>
			<span id="urlTip"></span>
		</tr>
		<tr>
			<td>打开方式</td>
			<td>
				<input id="openType" name="openType" type="text"  value="${requestScope.menu.openType}" style="width: 400px;height: 40px;">
				<span id="openTypeTip"></span>
			</td>
		</tr>
		<tr>
			<td>父菜单ID</td>
			<td>
				<input id="parentId" name="parentId" type="text"  value="${requestScope.menu.parentId}" style="width: 400px;height: 40px;">
				<span id="parentIdTip"></span>
			</td>
		</tr>
		<c:choose>
			<c:when test="${requestScope.menu==null}">

			</c:when>

			<c:otherwise>

				<tr>
					<td>创建时间</td>
					<td>
						<input id="createDate" name="createDate" type="text"  value="${requestScope.menu.createDate}" style="width: 400px;height: 40px;" readonly="readonly">
						<span id="createDateTip"></span>
					</td>
				</tr>
			</c:otherwise>

		</c:choose>


		<tr id="errorTr">
			<td id="errorTd" colspan="2" align="center" style="color: red">

			</td>
		</tr>
		<tr >
			<td colspan="2" align="center">
				<button id="submit"   > 提交</button>
			</td>
		</tr>

	</table>
</form>
<script type="text/javascript">



</script>
</body>
</html>
