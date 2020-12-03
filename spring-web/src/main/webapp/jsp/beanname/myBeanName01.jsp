<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <base href="<%=basepath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>myBeanName01.jsp</title>
</head>
<body>
<h1>我的第一个BeanName01Controller</h1>
<h2>hello:${hello}</h2>
<h2>now:${now}</h2>
<h2>now:${requestScope.hello}</h2>

</body>
</html>