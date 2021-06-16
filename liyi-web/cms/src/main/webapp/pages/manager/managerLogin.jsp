<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>登录页面</title>
	<script src="${path}/pages/manager/js/jquery-2.1.1.min.js"></script>
</head>
<body>
<h1>登录页面</h1>
<input type="hidden" id="mypath" value="${path}">
<table style="width: 30%;margin: 0 auto" border="1">
	<tr>
		<td>登录名</td>
		<td>
			<input id="username" name="username" type="text" style="width: 400px;height: 40px;">
		</td>
	</tr>
	<tr>
		<td>密  码</td>
		<td><input id="password" name="password" type="password" style="width: 400px;height: 40px;"></td>
	</tr>
	<tr id="errorTr">
		<td id="errorTd" colspan="2" align="center" style="color: red">

		</td>
	</tr>
	<tr >
		<td colspan="2" align="center">
			<button id="submit"   > 登录</button>
		</td>
	</tr>
</table>
<script type="text/javascript">

$(function(){
	$('#errorTr').hide();
	$('#submit').click(function(){
		var mypath = $("#mypath").val();
		//点击了登录
		var username = $('#username').val();
		var password = $('#password').val();

		var uri = mypath+"/manager/login";
		$.post(uri,{
			username:username,
			password:password
		},function (data){
			if(data.code==0){
				window.location.href=mypath+"/manager/index";
			}else{//登录失败
				$('#errorTd').text(data.define);
				$('#errorTr').show();
			}
		},'json');


	});
})

</script>
</body>
</html>
