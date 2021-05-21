<%--
  Created by IntelliJ IDEA.
  User: xiangdan
  Date: 2021/5/21
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","123");
    %>
    表达式脚本输出key的值：<%=request.getAttribute("key")%><br/>
    EL表达式输出k=key的值：${key}
</body>
</html>
