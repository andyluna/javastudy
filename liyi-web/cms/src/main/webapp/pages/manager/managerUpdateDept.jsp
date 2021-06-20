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
		<c:when test="${requestScope.dept==null}">新增部门</c:when>
		<c:otherwise>修改部门 <span style="color: red">${requestScope.dept.id}</span></c:otherwise>
	</c:choose>
</h1>
<input type="hidden" id="mypath" value="${path}">

<form method="post" action="${path}/manager/deptServlet">
	<input type="hidden" name="action" value="updateDept" />
	<input type="hidden" name="curPage"  value="${curPage}" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<table style="width: 30%;margin: 0 auto" border="1">
		<tr>
			<td>I d</td>
			<td>
				<input id="myid" name="id" type="text" value="${requestScope.dept.id}" style="width: 400px;height: 40px;" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>部门名称</td>
			<td>
				<input id="name" name="name" type="text" value="${requestScope.dept.name}" style="width: 400px;height: 40px;">
				<span id="nameTip"></span>
			</td>
		</tr>
		<tr>
			<td>部门编码</td>
			<td><input id="code" name="code" type="text" value="${requestScope.dept.code}" style="width: 400px;height: 40px;"></td>
			<span id="codeTip"></span>
		</tr>
		<tr>
			<td>父部门编码</td>
			<td>
				<input id="parentCode" name="parentCode" type="text"  value="${requestScope.dept.parentCode}" style="width: 400px;height: 40px;">
				<span id="parentCodeTip"></span>
			</td>
		</tr>
		<c:choose>
			<c:when test="${requestScope.dept==null}">

			</c:when>

			<c:otherwise>

				<tr>
					<td>创建时间</td>
					<td>
						<input id="createDate" name="createDate" type="text"  value="${requestScope.dept.createDate}" style="width: 400px;height: 40px;" readonly="readonly">
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
