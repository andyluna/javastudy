<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/23
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope2.jsp页面</h1>
    pageContext域是否有值：<%=pageContext.getAttribute("key1")%> <br>
    request域是否有值：<%=request.getAttribute("key2")%> <br>
    session域是否有值：<%=session.getAttribute("key3")%> <br>
    application域是否有值：<%=application.getAttribute("key4")%> <br>
</body>
</html>
