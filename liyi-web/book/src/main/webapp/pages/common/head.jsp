<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/6/2
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath",basePath);
%>

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/style.css" >
<script type="text/javascript"          src="<%=basePath%>static/script/jquery-1.7.2.js"></script>