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
		<c:when test="${requestScope.role==null}">新增角色</c:when>
		<c:otherwise>修改角色 <span style="color: red">${requestScope.role.id}</span></c:otherwise>
	</c:choose>
</h1>
<input type="hidden" id="mypath" value="${path}">

<form method="post" action="${path}/manager/roleServlet">
	<input type="hidden" name="action" value="updateRole" />
	<input type="hidden" name="curPage"  value="${curPage}" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="lastUpdateId" value="${SESSION_USER_KEY.id}" />
	<table style="width: 30%;margin: 0 auto" border="1">
		<tr>
			<td>ID</td>
			<td>
				<input id="myid" name="id" type="text" value="${requestScope.role.id}" style="width: 400px;height: 40px;" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>角色编码</td>
			<td>
				<input id="code" name="code" type="text" value="${requestScope.role.code}" style="width: 400px;height: 40px;">
				<span id="codeTip"></span>
			</td>
		</tr>
		<tr>
			<td>角色名称</td>
			<td><input id="name" name="name" type="text" value="${requestScope.role.name}" style="width: 400px;height: 40px;"></td>
			<span id="nameTip"></span>
		</tr>
		<c:choose>
			<c:when test="${requestScope.role==null}">
				<tr>
					<td>创建人Id</td>
					<td><input id="createUserId" name="createUserId" type="text" value="${SESSION_USER_KEY.id}" style="width: 400px;height: 40px;" readonly="readonly"></td>
					<span id="createUserIdTip"></span>
				</tr>
			</c:when>

			<c:otherwise>

				<tr>
					<td>创建时间</td>
					<td>
						<input id="createDate" name="createDate" type="text"  value="${requestScope.role.createDate}" style="width: 400px;height: 40px;" readonly="readonly">
						<span id="createDateTip"></span>
					</td>
				</tr>
				<tr>
					<td>创建人Id</td>
					<td><input id="createUserId1" name="createUserId1" type="text" value="${requestScope.role.createUserId}" style="width: 400px;height: 40px;" readonly="readonly"></td>
					<span id="createUserIdTip1"></span>
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
