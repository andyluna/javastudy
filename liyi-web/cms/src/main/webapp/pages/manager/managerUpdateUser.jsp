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
		<c:when test="${requestScope.user==null}">新增用户</c:when>
		<c:otherwise>修改用户 <span style="color: red">${requestScope.user.id}</span></c:otherwise>
	</c:choose>
</h1>
<input type="hidden" id="mypath" value="${path}">

<form method="post" action="${path}/manager/userServlet">
	<input type="hidden" name="action" value="update" />
	<input type="hidden" name="curPage"  value="${curPage}" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<table style="width: 30%;margin: 0 auto" border="1">
		<tr>
			<td>Id</td>
			<td>
				<input id="myid" name="id" type="text" value="${requestScope.user.id}" style="width: 400px;height: 40px;" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>用户名</td>
			<td>
				<input id="username" name="username" type="text" value="${requestScope.user.username}" style="width: 400px;height: 40px;">
				<span id="usernameTip"></span>
			</td>
		</tr>
		<tr>
			<td>密  码</td>
			<td><input id="password" name="password" type="text"  value="${requestScope.user.password}" style="width: 400px;height: 40px;"></td>
			<span id="pas1Tip"></span>
		</tr>
		<tr>
			<td>电话号码</td>
			<td>
				<input id="phone" name="phone" type="text"  value="${requestScope.user.phone}" style="width: 400px;height: 40px;">
				<span id="phoneTip"></span>
			</td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td>
				<input id="name" name="name" type="text"  value="${requestScope.user.name}" style="width: 400px;height: 40px;">
				<span id="nameTip"></span>
			</td>
		</tr>
		<tr>
			<td>地  址</td>
			<td>
				<input id="address" name="address" type="text"  value="${requestScope.user.address}" style="width: 400px;height: 40px;">
				<span id="addressTip"></span>
			</td>
		</tr>
		<tr>
			<td>性  别</td>
			<td>
		<select name="sex" id="sex">
			<option value="1" <c:if test="${sex=='1'}"> selected="selected"</c:if> >男</option>
			<option value="0" <c:if test="${sex=='0'}"> selected="selected"</c:if>>女</option>
		</select>
			</td>
		</tr>
		<tr>
			<td>所属部门</td>
			<td>
				<select name="dept_id" id="dept_id">
					<c:forEach items="${requestScope.allDept}" var="dept" varStatus="mystatus">
						<option value="${dept.id}" <c:if test="${dept.id==user.dept_id}"> selected="selected"</c:if> >${dept.name}</option>
					</c:forEach>
				</select>
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
	/**$('#submit').click(function (){
		var url = path+'/manager/userServlet';
		$.post(url,{action:'update',
			id:$('#myid').val(),
			username:$('#username').val(),
			password:$('#password').val(),
			phone:$('#phone').val(),
			sex:$('#sex').val(),
			name:$('#name').val(),
			address:$('#address').val(),
			dept_id:$('#dept_id').val(),
		},function (data){



		},'json');
	});*/
});

</script>
</body>
</html>
