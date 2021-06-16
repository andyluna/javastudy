<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
	<!--写base标签，永远固定相对路径跳转的结果-->
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
<div id="header">


<%--	方式1：
	<img class="logo_img" alt="" src="/book/static/img/logo.gif" >
	方式1-智能变化版本：
	<img class="logo_img" alt="" src="<%=request.getContextPath()%>/static/img/logo.gif" >
	方式2：
	<img class="logo_img" alt="" src="http://localhost:8080/book/static/img/logo.gif" >
	方式2-智能变化版本：--%>
	<img class="logo_img" alt="" src="<%=basePath%>static/img/logo.gif" >

	<%@include file="/pages/common/login_sucess_menu.jsp"%>
</div>

<div id="main">

	<h1>欢迎回来 <a href="<%=basePath%>index.jsp">转到主页</a></h1>

</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>