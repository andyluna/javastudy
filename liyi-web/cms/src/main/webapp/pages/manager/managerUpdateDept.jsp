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

<form method="post" action="${path}/manager/userServlet">
	<input type="hidden" name="action" value="update" />
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
		<tr>
			<td>创建时间</td>
			<td>
				<input id="createDate" name="createDate" type="text"  value="${requestScope.dept.createDate}" style="width: 400px;height: 40px;">
				<span id="createDateTip"></span>
			</td>
		</tr>
		<tr>
			<td>最后修改时间</td>
			<td>
				<input id="lastUpdateDate" name="lastUpdateDate" type="text"  value="${requestScope.dept.lastUpdateDate}" style="width: 400px;height: 40px;">
				<span id="lastUpdateDateTip"></span>
			</td>
		</tr>

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
$(function (){
	var path = $('#mypath').val();
	$('#username').blur(function (){
		$('#usernameTip').text('');
		var id = $('#myid').val();
		var username = $(this).val();
		if($.trim(username) != ''){
			var url = path+'/manager/userServlet';
			$.post(url,{action:'ajaxExistsUsername',id:id,username:username},function (data){
				console.log(data);
				if (data.code==0){//成功 用户名不存在
					$('#usernameTip').css('color','blue');
				}else{//失败 用户名不存在
					$('#usernameTip').css('color','red');
				}
				$('#usernameTip').text(data.define);
			},'json');
		}
	});
});

</script>
</body>
</html>
